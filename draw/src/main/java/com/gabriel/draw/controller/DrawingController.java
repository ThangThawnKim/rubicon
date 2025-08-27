package com.gabriel.draw.controller;

import com.gabriel.draw.model.Ellipse;
import com.gabriel.draw.model.Rectangle;
import com.gabriel.draw.model.Line;
import com.gabriel.drawfx.DrawMode;
import com.gabriel.drawfx.ShapeMode;
import com.gabriel.draw.view.DrawingView;
import com.gabriel.drawfx.model.Shape;
import com.gabriel.drawfx.service.AppService;
import java.awt.*;
import java.awt.event.*;

public class DrawingController implements MouseListener, MouseMotionListener {

    private Point end;
    private final DrawingView drawingView;
    private Shape currentShape;
    private AppService appService;

    public DrawingController(AppService appService, DrawingView drawingView){
        this.appService = appService;
        this.drawingView = drawingView;
        drawingView.addMouseListener(this);
        drawingView.addMouseMotionListener(this);
        appService.setDrawMode(DrawMode.Idle);
        appService.setShapeMode(ShapeMode.Line); // default
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point start = e.getPoint();
        if(appService.getDrawMode() == DrawMode.Idle) {
            switch(appService.getShapeMode()) {
                case Line:
                    currentShape = new Line(start, start);
                    break;
                case Rectangle:
                    currentShape = new Rectangle(start, 100, 50);
                    break;
                case Ellipse:
                    currentShape = new Ellipse(start, 80, 120);
                    break;
            }
            currentShape.getRendererService().render(drawingView.getGraphics(), currentShape,false);
            appService.setDrawMode(DrawMode.MousePressed);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(appService.getDrawMode() == DrawMode.MousePressed) {
            switch(appService.getShapeMode()) {
                case Line:
                case Rectangle:
                case Ellipse:
                    end = e.getPoint();
                    appService.create(currentShape);
                    appService.setDrawMode(DrawMode.Idle);
                    break;
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(appService.getDrawMode() == DrawMode.MousePressed) {
            switch(appService.getShapeMode()) {
                case Line:
                case Rectangle:
                case Ellipse:
                    end = e.getPoint();
                    currentShape.getRendererService().render(drawingView.getGraphics(), currentShape,true);
                    appService.scale(currentShape, end);
                    currentShape.getRendererService().render(drawingView.getGraphics(), currentShape,true);
                    break;
            }
        }
    }

    // Unused MouseListener methods
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}
}