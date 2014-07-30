
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
        super.next.setNext(this.nextContinue);
        this.nextContinue.setNext(null);
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
            this.next.setNextSimple(this.nextContinue);
            return;
        }

        NodeDC deepNode = nextTrue.getEnd();
        deepNode.setNextSimple(this.nextContinue);
        this.next.setNextSimple(nextTrue);
    }
    public void setNextContinue(NodeDC nextContinue){
        this.nextContinue.setNext(nextContinue);
    }

    @Override
    public NodeDC getEnd(){
        Iterator<NodeDC> it = this.nextContinue;
        while(it.hasNext())
            it = it.next();

        return (NodeDC)it;
    }
}
