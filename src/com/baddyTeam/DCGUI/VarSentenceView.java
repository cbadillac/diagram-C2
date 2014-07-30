package com.baddyTeam.DCGUI;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.geom.Rectangle2D;
import java.text.AttributedString;


public class VarSentenceView extends NodeDCView {
		
	private Color color  = Color.GREEN;
	private Rectangle2D rectangle;
	private static int HEIGHT    = 50;
	private static int WIDTH     = 80;

	public VarSentenceView(VarSentence node) {
		super(50, 50, WIDTH, HEIGHT, node);
		rectangle = new Rectangle2D.Double(getXPosition(), getYPosition(), HEIGHT, WIDTH);
	}

	@Override
	void updateView(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		rectangle.setFrame(getXPosition(),getYPosition(), WIDTH, HEIGHT);
		g2.setColor(color);
		g2.fill(rectangle);

        if(node.getText() != null) {
            g2.setColor(Color.black);
            g2.setFont(new Font("Consolas", Font.BOLD, 10));
            g2.drawString(node.getText(), getXPosition()+10, getYPosition()+HEIGHT/2);
        }
	}
	
	@Override
	boolean imHere(double x, double y) {
		if(x<rectangle.getMaxX() && x>rectangle.getMinX() && y>rectangle.getMinY() && y<rectangle.getMaxY())
			return true;
		else
			return false;
	}
	
	public NodeDC getNode(){
		return this.node;
	}


}
