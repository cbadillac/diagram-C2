package com.baddyTeam.DCGUI;

import java.awt.*;


public abstract class NodeDCView implements Cloneable {




    private Vector vector;
	private int WIDTH;
	private int HEIGHT;
    NodeDC node;



    private Line line;

    public NodeDCView(int x, int y,int WIDTH,int HEIGHT, NodeDC node){
        this.node = node;
        vector = new Vector(x, y);
        this.HEIGHT = HEIGHT;
        this.WIDTH = WIDTH;
    }

    @Override
    public NodeDCView clone(){
        try {
            return (NodeDCView) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }


	abstract void updateView(Graphics g);

	abstract boolean imHere(double x, double y);
	abstract NodeDC getNode();


	
	public int getXPosition(){
		return vector.getX();
	}
    public int getYPosition(){
        return vector.getY();
    }
	public void setXPosition(int x){
		vector.setX(x);
	}
	public void setYPosition(int y){
		vector.setY(y);
	}

	public void setWIDTH(int WIDTH) {
		this.WIDTH = WIDTH;
	}
	public void setHEIGHT(int HEIGHT) {
		this.HEIGHT = HEIGHT;
	}
	public int getWIDTH(){
		return this.WIDTH;
	}
	public int getHEIGHT(){
		return this.HEIGHT;
	}

    public void dragTo(int x, int y){
        vector.setX(x - WIDTH/2);
        vector.setY(y - HEIGHT/2);
    }

    public Vector getVector(){
        return this.vector;
    }
    public void setVector(Vector vector) {
        this.vector = vector;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    void deleteNodeDC() {
        node.setIgnore(true);
        this.node = null;
    }

}
