package com.baddyTeam.DCGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class RightPanel extends JPanel {

	private Diagram diagram;
	private ArrayList<NodeDCView> elements;
	private ArrayList<Line> lines;



    private NodeDCView selectedNode;


    public RightPanel(){
        super();
        FirstNode firstNode = new FirstNode();
        this.diagram = new Diagram(firstNode);

        this.elements = new ArrayList<NodeDCView>();
        this.lines    = new ArrayList<Line>();


        addViewNodes(new FirstNodeView(diagram.getNode()));

        MouseListener mListen = new MouseListener(this);
        addMouseListener(mListen);
        addMouseMotionListener(mListen);

    }
	public RightPanel(Diagram diagram) {
		super();
        this.elements = new ArrayList<NodeDCView>();
        this.lines    = new ArrayList<Line>();
        this.diagram  = diagram;


        addViewNodes(new FirstNodeView(diagram.getNode()));

		MouseListener mListen = new MouseListener(this);
		addMouseListener(mListen);
		addMouseMotionListener(mListen);

	}

	public NodeDCView isHere(double x, double y){
		for(NodeDCView e: elements){
			if(e.imHere(x, y)){
				return e;
			}
		}
		return null;
	}
	public void repaintView(){
		repaint();
	}
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g);

        for (NodeDCView e:elements)
           e.updateView(g2);

        for (Line e:lines)
        	e.updateView(g2);
	}

    public void addViewNodes(NodeDCView nd){
        elements.add(nd);
    }

	public Diagram getDiagram(){
        return diagram;
    }
    public ArrayList<Line> getLines() {
        return lines;
    }

    public void setDiagram(Diagram diagram){
        this.diagram = diagram;
    }

    public NodeDCView getSelectedNodeView() {
        return selectedNode;
    }
    public void setSelectedNode(NodeDCView selectedNode) {
        this.selectedNode = selectedNode;
    }

    public void deleteNodeDCView(NodeDCView nodeView){
        nodeView.deleteNodeDC();
        ArrayList<Line> toeraseLines = new ArrayList<Line>();

        for(Line l: lines){
            if(l.getAboveNodeView() == nodeView || l.getBelowNodeView() == nodeView ){
                if (l.getAboveNodeView() == nodeView){
                    l.getBelowNodeView().getNode().disconnect();
                }else if (l.getBelowNodeView() == nodeView){
                    if (l.getAboveNodeView().getNode().getType() == NodeDC.typeOne){
                        l.getAboveNodeView().getNode().setNext(null);
                    }else if (l.getAboveNodeView().getNode().getType() == NodeDC.typeTwo){
                        IfSentence ifNode =(IfSentence) l.getAboveNodeView().getNode();
                        if (l.getOriginType() == Line.nextTrue){
                            ifNode.getNext().setNext(null);
                        }else if(l.getOriginType() == Line.nextFalse){
                            ifNode.getNextFalse().setNext(null);
                        }else if (l.getOriginType() == Line.nextContinue){
                            ifNode.getNext().setNextSimple(null);
                        }
                        ifNode.getNext().setNext(null);
                    }

                }
                toeraseLines.add(l);
            }

        }
        for(Line l: toeraseLines){
            lines.remove(l);
        }
        elements.remove(nodeView);
        nodeView = null;
        repaintView();
    }

}
