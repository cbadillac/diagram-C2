package com.baddyTeam.DCGUI;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by Cristóbal on 28-07-2014.
 */
public class WhileSentenceView extends NodeDCView {
    private Color color = Color.YELLOW;
    private Ellipse2D ellipse;
    private static int HEIGHT  = 50;
    private static int WIDTH   = 50;
    private static int RAD     = 50;

    public WhileSentenceView(WhileSentence node){
        super(50, 50, WIDTH,HEIGHT, node);

        ellipse = new Ellipse2D.Double(getXPosition(), getYPosition(), HEIGHT, WIDTH);
    }

    @Override
    void updateView(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        ellipse.setFrame(getXPosition(), getYPosition(), WIDTH, HEIGHT);
        g2.setColor(color);
        g2.fill(ellipse);

        if(node.getText() != null) {
            g2.setColor(Color.black);
            g2.setFont(new Font("Consolas", Font.BOLD, 10));
            g2.drawString(node.getText(), getXPosition()+10, getYPosition()+HEIGHT/2);
        }
    }

    @Override
    boolean imHere(double x, double y) {
        if(x<getXPosition() + WIDTH && x>getXPosition() && y>getYPosition() && y<getYPosition() + HEIGHT)
            return true;
        else
            return false;
    }

    @Override
    NodeDC getNode() {
        return node;
    }

}
