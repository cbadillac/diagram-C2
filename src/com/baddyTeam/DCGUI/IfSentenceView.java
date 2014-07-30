package com.baddyTeam.DCGUI;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.text.AttributedString;

//import sun.org.mozilla.javascript.internal.ast.WithStatement;

public class IfSentenceView extends NodeDCView {
	private Color color  = Color.RED;
	private Rectangle2D rectangle;
	private static int HEIGHT    = 50;
	private static int WIDTH     = 50;

	
	public IfSentenceView(IfSentence node) {
		super(50, 50, WIDTH, HEIGHT, node);
		rectangle = new Double(getXPosition(), getYPosition(), HEIGHT, WIDTH);
	}
	
	public void setXPosition(double xPosition){
		xPosition = new Integer((int) xPosition);
	}
	public void setYPosition(double yPosition){
		yPosition = new Integer((int) yPosition);
	}
	
	public void updateView(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		rectangle.setFrame(getXPosition(),getYPosition(), WIDTH, HEIGHT);
		g2.setColor(color);
		AffineTransform old = g2.getTransform();
        g2.rotate(Math.toRadians(45), rectangle.getCenterX(), rectangle.getCenterY());
        //draw shape/image (will be rotated)
        g2.fill(rectangle);
        g2.setTransform(old);

        if(node.getText() != null) {
            g2.setColor(Color.black);
            g2.setFont(new Font("Consolas", Font.BOLD, 10));
            g2.drawString(node.getText(), getXPosition()-10, getYPosition()+HEIGHT/2+5);
        }
	}
	
	public NodeDC getNode(){
		return node;
	}


    @Override
	boolean imHere(double x, double y) {
		if(x<rectangle.getMaxX() && x>rectangle.getMinX() && y>rectangle.getMinY() && y<rectangle.getMaxY())
			return true;
		else
			return false;
	}

}
