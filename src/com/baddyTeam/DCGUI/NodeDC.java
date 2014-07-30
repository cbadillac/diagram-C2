package com.baddyTeam.DCGUI;

import java.awt.*;
import java.util.Iterator;
import java.util.NoSuchElementException;


public abstract class NodeDC implements Iterator<NodeDC>{
    private final int myId; /* to identify each element within its category */

	public static String typeOne   = "typeOne";
	public static String typeTwo   = "typeTwo";
	public static String typeThree = "typeThree";


	protected NodeDC next;
    protected boolean connected;



    private boolean ignore;
	

	protected NodeDC( int id){
	    this.myId         = id;
        this.next         = null;
        this.connected = false;
        this.ignore = false;
    }

	protected int getId() {
	      return myId;
	   }

    @Override
    public NodeDC next (){
        if (this.next == null)
            throw new NoSuchElementException();

        return this.next;
    }
    @Override
    public boolean hasNext(){
        return (this.next == null)? false: true;
    }
    @Override
    public void remove(){
        // Not removable from iteration ???
        throw new UnsupportedOperationException("remove() not allowed.");
    }

	public abstract String toC();
	public abstract String getType();

	public abstract void updateView(Graphics g);
	public abstract NodeDCView getView();
    public abstract String getText();

	public NodeDC getNext() {
		return (this.next instanceof StringNode)? null: this.next;
	}
	public void setNext(NodeDC nextNode) {
        if(nextNode == null) {
            this.next = null;
            return;
        }

        NodeDC deepNode = nextNode.getEnd();
        deepNode.setNext(this.next);
		this.next = nextNode;
	}
    public void setNextSimple(NodeDC nextNode){
        this.next = nextNode;
    }

    public NodeDC getEnd(){
        return this;
    }

    public boolean isConnected(){
        return connected;
    }
    public void connect(){
        this.connected = true;
    }
    public void disconnect(){
        this.connected = false;
    }
    public boolean isIgnore() {
        return ignore;
    }

    public void setIgnore(boolean ignore) {
        this.ignore = ignore;
    }
}

