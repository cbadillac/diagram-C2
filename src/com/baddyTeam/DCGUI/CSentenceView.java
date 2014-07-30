package com.baddyTeam.DCGUI;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.geom.RoundRectangle2D;
import java.text.AttributedString;


public class CSentenceView extends NodeDCView {

    private Color color = Color.blue;
    private RoundRectangle2D roundRect;
    private static int HEIGHT = 100;
    private static int WIDTH  = 70;



    public CSentenceView(CSentence node) {
        super(50, 50, WIDTH, HEIGHT, node);
    }

    @Override
    void updateView(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		g2.fillRoundRect(getXPosition(), getYPosition(), WIDTH, HEIGHT, 10, 10);

        if(node.getText() != null) {
            g2.setColor(Color.black);
            g2.setFont(new Font("Consolas", Font.BOLD, 10));
            g2.drawString(node.getText(), getXPosition()+10, getYPosition()+15);
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
