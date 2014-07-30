package com.baddyTeam.DCGUI;

import java.awt.*;


public class VarSentence extends NodeDC {
	
	private static int id = 0;
	
	private VarSentenceView view;
    private String varType  = null;
	private String varName  = null;
	private String varValue = null;


	public VarSentence() {
		super(id++);
		view = new VarSentenceView(this);
	}
	
	@Override
	public String toC() {
		return (varType==null || varName==null || varValue==null)? "": varType+" "+varName+" = "+varValue+";";
	}
    @Override
    public String getType() {
        return NodeDC.typeOne;
    }


	@Override
	public void updateView(Graphics g) {
		view.updateView(g);
	}
	@Override
	public VarSentenceView getView(){
		return view;
	}
    @Override
    public String getText(){
        return (varType==null || varName==null || varValue==null)? null: varName+" = "+varValue;
    }

    public String getVarType() {
        return varType;
    }
	public String getVarName() {
		return varName;
	}
    public String getVarValue() {
        return varValue;
    }
	public void setVarName(String varName) {
		this.varName = varName;
	}
	public void setVarValue(String varValue) {
		this.varValue = varValue;
	}
    public void setVarType(String varType) {
		this.varType = varType;
	}

}
