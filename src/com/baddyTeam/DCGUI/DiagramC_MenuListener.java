package com.baddyTeam.DCGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;


public class DiagramC_MenuListener implements ActionListener {
	private DiagramC_GUI window;

	public DiagramC_MenuListener(DiagramC_GUI window) {
		this.window = window;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JMenuItem menuItem = (JMenuItem)(event.getSource());
	    String text = menuItem.getText();
	    System.out.println(text);
	    
	    if(text.equals("Exit")){}
        else if(text.equals("Make")){
            Diagram diagram = window.rightPanel.getDiagram();
            System.out.println("Start C generation\n");

            diagram.Run();

            }else if (text.equals("Delete Node")) {
			if (window.getRightPanel().getSelectedNodeView() != null) {
				window.getRightPanel().deleteNodeDCView(window.getRightPanel().getSelectedNodeView());

			}
		}
    }
}
