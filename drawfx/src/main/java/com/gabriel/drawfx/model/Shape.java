package com.gabriel.drawfx.model;

import com.gabriel.drawfx.service.RendererService;
import lombok.Data;

import java.awt.*;

@Data
public abstract class Shape {
    private Point location;
    private Point end; // for Line
    private Color color;
    private RendererService rendererService;

    private int width;   // for Rectangle/Ellipse
    private int height;  // for Rectangle/Ellipse

    public Shape(Point location) {
        this.location = location;
        this.end = location; // initialize end same as start
    }
}