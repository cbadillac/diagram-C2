package com.baddyTeam.DCGUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WhileSentenceSetBranchWindow extends JFrame {
	WhileSentence node;
	NodeDC nextNode;
	RightPanel panel;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public WhileSentenceSetBranchWindow(WhileSentence node, NodeDC nextNode, RightPanel panel) {
		this.panel    = panel;
		this.node     = node;
		this.nextNode = nextNode;

		setTitle("Set Branch");
		setBounds(100, 100, 317, 81);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChooseTheBranch = new JLabel("Branch:");
		lblChooseTheBranch.setBounds(10, 11, 132, 14);
		contentPane.add(lblChooseTheBranch);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"True", "Continue"}));
		comboBox.setBounds(86, 8, 109, 20);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setOption(comboBox.getSelectedItem().toString());
				setVisible(false);
			}
		});
		btnNewButton.setBounds(205, 7, 89, 23);
		contentPane.add(btnNewButton);
	}
	
	private void setOption(String option){
        Vector r1;

        if(option.equals("True") && node.getNext().getNext() ==null){
            node.setNext(nextNode);

            r1 = new Vector(node.getView().getWIDTH(), node.getView().getHEIGHT() / 2);
        }else if(option.equals("Continue") && node.getNextContinue().getNext() == null) {
            node.setNextContinue(nextNode);

            r1 = new Vector(node.getView().getWIDTH()/2, node.getView().getHEIGHT() );
        }else{
            //System.out.println("ERROR: No se puede crear branch");
            return;
        }

        Vector v1 = node.getView().getVector();
        Vector v2 = nextNode.getView().getVector();
        Vector r2 = new Vector(nextNode.getView().getWIDTH()/2,0);

        Line line = new Line(v1, v2, r1, r2,node.getView(), nextNode.getView(), option);
        panel.getLines().add(line);
        panel.repaintView();
	}
}
