package com.gabriel.draw.service;

import com.gabriel.draw.model.Ellipse;
import com.gabriel.drawfx.service.RendererService;
import com.gabriel.drawfx.model.Shape;

import java.awt.*;

public class EllipseRendererService implements RendererService {

    @Override
    public void render(Graphics g, Shape shape, boolean xor) {
        Ellipse ellipse = (Ellipse) shape;
        g.setXORMode(shape.getColor());
        int x = ellipse.getLocation().x;
        int y = ellipse.getLocation().y;
        int width = ellipse.getWidth();
        int height = ellipse.getHeight();
        g.drawOval(x, y, width, height);
    }
}