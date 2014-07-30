package com.baddyTeam.DCGUI;

import javax.xml.soap.Node;
import java.awt.*;
import java.util.Iterator;


public class IfSentence extends NodeDC {
	private static int id = 0;

    private NodeDC nextFalse;
    private NodeDC nextContinue;

	private IfSentenceView view;
	private String conditionText;
	
	public IfSentence() {
		super(id++);
		this.view = new IfSentenceView(this);
		this.conditionText = new String();

        super.next        = new StringNode("{");
        this.nextFalse    = new StringNode("} else {");
        this.nextContinue = new StringNode("}");
        super.next.setNext(this.nextFalse);
        this.nextFalse.setNext(this.nextContinue);
        this.nextContinue.setNext(null);
	}

	@Override
	public String toC() {
		return "if( "+conditionText+" )";
	}
	@Override
	public String getType() {
		return typeTwo;
	}

    @Override
    public IfSentenceView getView(){
        return view;
    }
    @Override
    public void updateView(Graphics g){
        view.updateView(g);
    }
    @Override
    public String getText(){
        return this.conditionText;
    }
    public void setText(String txt){
        this.conditionText = txt;
    }

    @Override
    public NodeDC getNext(){
        return (super.next==null&&nextFalse==null&&nextContinue==null)? null: super.next;
    }
    public NodeDC getNextFalse() {
        return this.nextFalse;
    }
    public NodeDC getNextContinue(){
        return this.nextContinue;
    }

    @Override
    public void setNext(NodeDC nextTrue) {
        if(nextTrue == null) {
            this.next.setNextSimple(this.nextFalse);
            return;
        }

        NodeDC deepNode = nextTrue.getEnd();
        deepNode.setNextSimple(this.nextFalse);
        this.next.setNextSimple(nextTrue);
    }
    public void setNextFalse(NodeDC nextFalse) {
        this.nextFalse.setNext(nextFalse);
    }
    public void setNextContinue(NodeDC nextContinue){
        this.nextContinue.setNext(nextContinue);
    }

    public NodeDC getEnd(){
        Iterator<NodeDC> it = this.nextContinue;
        while(it.hasNext())
            it = it.next();

        return (NodeDC)it;
    }

}