package com.baddyTeam.DCGUI;

import java.awt.*;
import java.awt.geom.Line2D;


public class Line {
	private Vector vect1;
	private Vector vect2;
	private Vector relativeVect1;
	private Vector relativeVect2;
	private Line2D line2D;
    private NodeDCView onObject;
    private NodeDCView underObject;
    public static String nextTrue = "True";
    public static String nextContinue = "Continue";
    public static String nextFalse = "False";



    private String originType;
	private Color color;
	
	public Line(Vector v1, Vector v2, Vector rV1, Vector rV2, NodeDCView onObject, NodeDCView underObject, String originType) {
        this.originType = new String(originType);
		this.onObject = onObject;
        this.underObject = underObject;
        this.vect1         = v1;
		this.vect2         = v2;
		this.relativeVect1 = rV1;
		this.relativeVect2 = rV2;
		line2D = new Line2D.Double(vect1.getX() + relativeVect1.getX() , vect1.getY() + relativeVect1.getY(), 
			    vect2.getX() + relativeVect1.getX() , vect2.getY() + relativeVect2.getY());
	}
	
	void updateView(Graphics g) {

        if (vect2 != null && vect1!=null){
            if (!vect2.isIgnore() && !vect1.isIgnore()){

                Graphics2D g2 = (Graphics2D) g;
                line2D.setLine(vect1.getX() + relativeVect1.getX() , vect1.getY() + relativeVect1.getY(),
                        vect2.getX() + relativeVect2.getX() , vect2.getY() + relativeVect2.getY());
                g2.setColor(color.BLACK);
                g2.setStroke(new BasicStroke(2f));
                g2.draw(line2D);

            }

            if (vect2.isIgnore()){
                onObject.getNode().setNext(null);
                vect2 = null;
            }

            if(vect1.isIgnore()){
                underObject.getNode().disconnect();
            }

        }



//		g2.drawLine(vect1.getX() + relativeVect1.getX() , vect1.getY() + relativeVect1.getY(), 
//				    vect2.getX() + relativeVect1.getX() , vect2.getY() + relativeVect2.getY());
//		g2.setColor(color.black);
	}

    public NodeDCView getAboveNodeView(){
        return this.onObject;
    }

    public NodeDCView getBelowNodeView(){
        return this.underObject;
    }
    public String getOriginType() {
        return originType;
    }
}
