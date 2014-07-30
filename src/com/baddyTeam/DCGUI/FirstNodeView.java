package com.baddyTeam.DCGUI;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by Cristobal on 27-07-2014.
 */
public class FirstNodeView extends NodeDCView {
    private Color color  = Color.black;
    private Rectangle2D rectangle;
    private static int HEIGHT = 30;
    private static int WIDTH  = 30;

    public FirstNodeView(FirstNode node) {
        super(200, 50, WIDTH, HEIGHT, node);
        rectangle = new Rectangle2D.Double(getXPosition(), getYPosition(), HEIGHT, WIDTH);

    }

    @Override
    public NodeDCView clone() {
        return super.clone();
    }

    @Override
    void updateView(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        rectangle.setFrame(getXPosition(),getYPosition(), WIDTH, HEIGHT);
        g2.setColor(color);
        g2.fill(rectangle);
    }

    @Override
    NodeDC getNode() {
        return this.node;
    }

    @Override
    void deleteNodeDC() {

    }

    @Override
    boolean imHere(double x, double y) {
        if(x<rectangle.getMaxX() && x>rectangle.getMinX() && y>rectangle.getMinY() && y<rectangle.getMaxY())
            return true;
        else
            return false;
    }

}
