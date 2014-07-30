package com.baddyTeam.DCGUI;

import java.awt.*;

/**
 * Created by Cristobal on 28-07-2014.
 */
public class StringNode extends NodeDC{
    private static int id = 0;
    private String text;

    public StringNode(){
        super(id++);
        this.text = new String("");
    }
    public StringNode(String s){
        super(id++);
        this.text = s;
    }

    @Override
    public String toC(){
        return this.text;
    }
    @Override
    public String getType(){
        return NodeDC.typeOne;
    }

    @Override
    public void updateView(Graphics g){}
    @Override
    public NodeDCView getView(){
        return null;
    }
    @Override
    public String getText(){
        return "";
    }

}
