package com.baddyTeam.DCGUI;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Created by Cristóbal on 28-07-2014.
 */
public class WhileSentenceWindow extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private WhileSentence whileSentence;

  public WhileSentenceWindow(WhileSentence node){
      setTitle("While Sentence");
      this.whileSentence = node;
      setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
      setBounds(100, 100, 452, 79);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);

      JLabel lblInsertYourCondition = new JLabel("Insert your condition here:");
      lblInsertYourCondition.setBounds(10, 11, 163, 14);
      contentPane.add(lblInsertYourCondition);
      textField = new JTextField();
      textField.setBounds(183, 8, 105, 20);
      contentPane.add(textField);
      textField.setColumns(10);
      if (textField.getText() != null){
          textField.setText(node.getText());
      }

      JButton btnNewButton = new JButton("OK");
      btnNewButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
             sendText(textField.getText());
             setVisible(false);
          }
      });
      btnNewButton.setBounds(318, 7, 89, 23);
      contentPane.add(btnNewButton);
  }

    private void sendText(String condition){
        whileSentence.setText(condition);
    }

}
