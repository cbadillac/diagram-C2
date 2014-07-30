package com.baddyTeam.DCGUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class IfSentenceWindow extends JFrame {

	private JPanel contentPane;
	private IfSentence ifSentence;

	public IfSentenceWindow(IfSentence ifstc) {
		setTitle("If Sentence");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 271, 132);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.ifSentence = ifstc; 
		
		JLabel lblWriteYourCondition = new JLabel("Write your condition here:");
		lblWriteYourCondition.setBounds(5, 5, 203, 14);
		contentPane.add(lblWriteYourCondition);

		JButton btnOk = new JButton("OK");
		btnOk.setBounds(136, 60, 92, 23);
		contentPane.add(btnOk);
		
		final JFormattedTextField formattedTextField = new JFormattedTextField();
		if(ifSentence.getText() != null){
			formattedTextField.setText(ifstc.getText());
		}
		formattedTextField.setBounds(15, 24, 193, 20);
		contentPane.add(formattedTextField);
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Ok if apretado");
				setNodeText(formattedTextField.getText());
				setVisible(false);				
			}
		});
	}
	
	private void setNodeText(String txt){
		//System.out.print(txt);
		ifSentence.setText(txt);
	}
}
