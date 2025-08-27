package com.gabriel.draw.view;

import com.gabriel.draw.controller.DrawingWindowController;
import com.gabriel.drawfx.service.AppService;
import com.gabriel.drawfx.ShapeMode;

import javax.swing.*;
import java.awt.*;

public class DrawingFrame extends JFrame {

    public DrawingFrame(AppService appService){
        // Window controller
        DrawingWindowController drawingWindowController = new DrawingWindowController(appService);
        this.addWindowListener(drawingWindowController);
        this.addWindowFocusListener(drawingWindowController);
        this.addWindowStateListener(drawingWindowController);

        // Drawing panel
        DrawingView drawingView = new DrawingView(appService);

        // Toolbar with buttons
        JPanel toolbar = new JPanel();
        JButton lineButton = new JButton("Line");
        JButton rectButton = new JButton("Rectangle");
        JButton ellipseButton = new JButton("Ellipse");

        toolbar.add(lineButton);
        toolbar.add(rectButton);
        toolbar.add(ellipseButton);

        // Button actions
        lineButton.addActionListener(e -> appService.setShapeMode(ShapeMode.Line));
        rectButton.addActionListener(e -> appService.setShapeMode(ShapeMode.Rectangle));
        ellipseButton.addActionListener(e -> appService.setShapeMode(ShapeMode.Ellipse));

        // Layout
        this.setLayout(new BorderLayout());
        this.add(toolbar, BorderLayout.NORTH);
        this.add(drawingView, BorderLayout.CENTER);
    }
}