package com.gabriel.draw.service;

import com.gabriel.draw.model.Line;
import com.gabriel.drawfx.DrawMode;
import com.gabriel.drawfx.ShapeMode;
import com.gabriel.drawfx.model.Drawing;
import com.gabriel.drawfx.model.Shape;
import com.gabriel.drawfx.service.AppService;

import java.awt.*;

public class DrawingAppService implements AppService {

    private final Drawing drawing;
    private Color color;
    private Color fill;
    private ShapeMode shapeMode = ShapeMode.Line;
    private DrawMode drawMode = DrawMode.Idle;

    public DrawingAppService() {
        drawing = new Drawing();
    }

    @Override
    public ShapeMode getShapeMode() {
        return shapeMode;
    }

    @Override
    public void setShapeMode(ShapeMode shapeMode) {
        this.shapeMode = shapeMode;
    }

    @Override
    public DrawMode getDrawMode() {
        return drawMode;
    }

    @Override
    public void setDrawMode(DrawMode drawMode) {
        this.drawMode = drawMode;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getFill() {
        return fill;
    }

    @Override
    public void setFill(Color color) {
        this.fill = color;
    }

    @Override
    public void move(Shape shape, Point newLoc) {
        shape.setLocation(newLoc);
    }

    @Override
    public void scale(Shape shape, Point newEnd) {
        if (shape instanceof Line) {
            // Line: update end point dynamically
            shape.setEnd(newEnd);
        } else {
            // Rectangle / Ellipse: calculate width/height and adjust top-left corner
            int startX = shape.getLocation().x;
            int startY = shape.getLocation().y;

            int width = Math.abs(newEnd.x - startX);
            int height = Math.abs(newEnd.y - startY);

            int x = Math.min(newEnd.x, startX);
            int y = Math.min(newEnd.y, startY);

            shape.setLocation(new Point(x, y));
            shape.setWidth(width);
            shape.setHeight(height);
        }
    }

    @Override
    public void create(Shape shape) {
        this.drawing.getShapes().add(shape);
    }

    @Override
    public void close() {
        System.exit(0);
    }

    @Override
    public Object getModel() {
        return drawing;
    }
}