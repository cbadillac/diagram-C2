package com.baddyTeam.DCGUI;

public class Vector {
	private int x;
	private int y;



    private boolean ignore;

	public Vector(int x, int y) {
		this.setX(x);
		this.setY(y);
        this.ignore = false;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

    public boolean isIgnore() {
        return ignore;
    }

    public void setIgnore(boolean ignore) {
        this.ignore = ignore;
    }
	
	public Vector Add(Vector vAdd){
		
		this.x = this.x + vAdd.getX();
		this.y = this.y + vAdd.getY();
		return this;
		
	}

}
