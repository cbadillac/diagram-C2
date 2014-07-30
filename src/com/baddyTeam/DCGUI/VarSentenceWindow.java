package com.baddyTeam.DCGUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VarSentenceWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private VarSentence varSentence;

	public VarSentenceWindow(VarSentence varSentence ) {
		this.varSentence = varSentence;
		setTitle("New Variable");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 227, 237);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 31, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		if(varSentence.getVarName() != null){
			textField.setText(varSentence.getVarName());
		}
		
		JLabel lblVariableName = new JLabel("New variable name:");
		lblVariableName.setBounds(10, 15, 134, 14);
		contentPane.add(lblVariableName);
		
		JLabel lblInitialValue = new JLabel("Initial Value:");
		lblInitialValue.setBounds(10, 55, 86, 14);
		contentPane.add(lblInitialValue);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 75, 86, 20);
		contentPane.add(textField_1);
		
		if(varSentence.getVarValue() != null){
			textField_1.setText(varSentence.getVarValue());
		}
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"int", "float", "double", "char"}));
		comboBox.setBounds(10, 117, 86, 20);
		contentPane.add(comboBox);
				
		if ( varSentence.getVarType() != null) {
            if(varSentence.getVarType().equals("int")) {
                comboBox.setSelectedItem(comboBox.getItemAt(0));
            }else if(varSentence.getVarType().equals("float")){
                comboBox.setSelectedItem(comboBox.getItemAt(1));
            }else if(varSentence.getVarType().equals("double")) {
                comboBox.setSelectedItem(comboBox.getItemAt(2));
            }else if(varSentence.getVarType().equals("char")){
                comboBox.setSelectedItem(comboBox.getItemAt(3));
            }else{
                comboBox.setSelectedItem(comboBox.getItemAt(0));
            }
		}
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sendText(textField.getText(), textField_1.getText(), comboBox.getSelectedItem().toString());
				setVisible(false);
			}
		});
		btnOk.setBounds(112, 165, 89, 23);
		contentPane.add(btnOk);
		
		JLabel lblDataType = new JLabel("Data type:");
		lblDataType.setBounds(10, 98, 86, 14);
		contentPane.add(lblDataType);
	}
	
	private void sendText(String varName, String varValue, String varType){
		varSentence.setVarName(varName);
		varSentence.setVarValue(varValue);
		varSentence.setVarType(varType);
	}
}
