package com.baddyTeam.DCGUI;

import java.io.PrintWriter;
import java.util.Iterator;


public class Diagram implements Iterable<NodeDC>{

	private FirstNode firstNode;

	public Diagram() {
		this.firstNode = null;
	}
    public Diagram(FirstNode node) {
        this.firstNode = node;
    }

    @Override
    public Iterator<NodeDC> iterator(){
        return this.firstNode;
    }

    public static VarSentence createVarSentence(){
        return new VarSentence();
    }
    public static IfSentence createIfSentence(){
        return new IfSentence();
    }
    public static CSentence createCSentence(){
        return new CSentence();
    }
    public static WhileSentence createWhileSentence(){
        return new WhileSentence();
    }


    public FirstNode getNode(){
        return this.firstNode;
    }

    public void Run(){
        try{
            PrintWriter writer = new PrintWriter("main.c", "UTF-8");

            writer.println("#include <stdio.h>\n");
            writer.println(firstNode.toC()+"{");

            Iterator<NodeDC> it = firstNode;
            while(it.hasNext()){
                it = it.next();
                writer.println(((NodeDC)it).toC());
            }

            writer.println("return 0;");
            writer.println("}");

            writer.close();
        }catch (Exception e) {
            //...
        }

    }

}
