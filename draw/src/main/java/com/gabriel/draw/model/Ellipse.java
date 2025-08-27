package com.gabriel.draw.model;

import com.gabriel.draw.service.EllipseRendererService;
import lombok.Data;
import com.gabriel.drawfx.model.Shape;
import java.awt.*;

@Data
public class Ellipse extends Shape {

    private int width;
    private int height;

    public Ellipse(Point start, int width, int height) {
        super(start);
        this.width = width;
        this.height = height;
        this.setColor(Color.GREEN);
        this.setRendererService(new EllipseRendererService());
    }
}