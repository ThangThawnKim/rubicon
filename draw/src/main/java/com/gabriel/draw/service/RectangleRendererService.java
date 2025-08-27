package com.gabriel.draw.service;

import com.gabriel.draw.model.Rectangle;
import com.gabriel.drawfx.service.RendererService;
import com.gabriel.drawfx.model.Shape;

import java.awt.*;

public class RectangleRendererService implements RendererService {

    @Override
    public void render(Graphics g, Shape shape, boolean xor) {
        Rectangle rect = (Rectangle) shape;
        g.setXORMode(shape.getColor());
        int x = rect.getLocation().x;
        int y = rect.getLocation().y;
        int width = rect.getWidth();
        int height = rect.getHeight();
        g.drawRect(x, y, width, height);
    }
}