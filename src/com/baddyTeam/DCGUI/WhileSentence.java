
package com.baddyTeam.DCGUI;

import java.awt.*;
import java.util.Iterator;

/**
 * Created by Cristóbal on 28-07-2014.
 */
public class WhileSentence extends NodeDC {
    private WhileSentenceView view;
    private String text;
    private static int id = 0;

    private NodeDC nextContinue;

    public WhileSentence() {
        super(id++);
        view = new WhileSentenceView(this);
        setText(new String());

        super.next        = new StringNode("{");
        this.nextContinue = new StringNode("}");
        super.next.setNextSimple(this.nextContinue);
        this.nextContinue.setNextSimple(null);
    }

    @Override
    public String toC() {
        return "while("+text+")";
    }
    @Override
    public String getType() {
        return typeThree;
    }

    @Override
    public void updateView(Graphics g) {
        view.updateView(g);
    }
    @Override
    public NodeDCView getView() {
        return view;
    }
    @Override
    public String getText() {
        return text;
    }
    public void setText(String text){
        this.text = text;
    }

    @Override
    public NodeDC getNext(){
        return (super.next==null&&nextContinue==null)? null: super.next;
    }
    public NodeDC getNextContinue(){
        return this.nextContinue;
    }

    @Override
    public void setNext(NodeDC nextTrue) {
        if(nextTrue == null) {
            super.next.setNextSimple(this.nextContinue);
            return;
        }

        NodeDC deepNode = nextTrue.getEnd();
        deepNode.setNextSimple(this.nextContinue);
        super.next.setNextSimple(nextTrue);
    }
    public void setNextContinue(NodeDC nextContinue){
        if(nextContinue == null) {
            this.nextContinue.setNextSimple(null);
            return;
        }

        NodeDC deepNode = nextContinue.getEnd();
        deepNode.setNextSimple(this.nextContinue.getNextStr());
        this.nextContinue.setNextSimple(nextContinue);
    }

    @Override
    public NodeDC getEnd(){
        Iterator<NodeDC> it = this.nextContinue;
        while(it.hasNext())
            it = it.next();

        return (NodeDC)it;
    }

    public void killAll(){
        super.killAll();
        this.nextContinue = null;
        this.next = null;
        this.view = null;
        this.text = null;
    }
}
