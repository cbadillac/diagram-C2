package com.baddyTeam.DCGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DiagramC_GUI extends JFrame {


    RightPanel rightPanel;
    LeftPanel leftPanel;
	
	public DiagramC_GUI() {
		
		setFont(new Font("Tahoma", Font.PLAIN, 11));
		setTitle("Diagram-C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(getExtendedState() | MAXIMIZED_BOTH);
		setBounds(100, 100, 600, 509);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JLabel label1 = new JLabel("Components");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(10, 9, 79, 14);
		
		this.leftPanel = new LeftPanel();
        leftPanel.setLayout(null);
        leftPanel.add(label1);

		this.rightPanel = new RightPanel(new Diagram(new FirstNode()));
		rightPanel.setPreferredSize(new Dimension(100, 100));
		
		final JScrollPane scroll = new JScrollPane(this.rightPanel);

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, scroll);
        splitPane.setDividerLocation(200);
        getContentPane().add(splitPane);


		JButton btnIf = new JButton("If");
        btnIf.setIcon(new ImageIcon(DiagramC_GUI.class.getResource("/if_sentence2.png")));
        btnIf.setBounds(10, 34, 100, 37);
		btnIf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IfSentence ifSentence = Diagram.createIfSentence();
				rightPanel.addViewNodes(ifSentence.getView());
				rightPanel.repaint();
			}
		});
		leftPanel.add(btnIf);


        JButton btnWhile = new JButton("While");
        btnWhile.setIcon(new ImageIcon(DiagramC_GUI.class.getResource("/while_sentence.png")));
        btnWhile.setBounds(10, 180, 100, 37);
        btnWhile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                WhileSentence whileSentence = Diagram.createWhileSentence();
                rightPanel.addViewNodes(whileSentence.getView());
                rightPanel.repaint();
            }
        });
        leftPanel.add(btnWhile);
		
		JButton btnVar = new JButton("Var");
		btnVar.setIcon(new ImageIcon(DiagramC_GUI.class.getResource("/var_sentence.png")));
        btnVar.setBounds(10, 82, 100, 37);
		btnVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VarSentence varSentence = Diagram.createVarSentence();
				rightPanel.addViewNodes(varSentence.getView());
				rightPanel.repaintView();
			}
		});
		leftPanel.add(btnVar);
		
		JButton btnCCode = new JButton("Code");
		btnCCode.setIcon(new ImageIcon(DiagramC_GUI.class.getResource("/cText.png")));
        btnCCode.setBounds(10, 131, 100, 37);
		btnCCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CSentence cText = Diagram.createCSentence();
				rightPanel.addViewNodes(cText.getView());
				rightPanel.repaintView();
			}
		});
        leftPanel.add(btnCCode);

		
		DiagramC_MenuListener menuListener = new DiagramC_MenuListener(this);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Tahoma", Font.PLAIN, 11));
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
        mntmExit.setFont(new Font("Tahoma", Font.PLAIN, 11));
        mntmExit.addActionListener(menuListener);
        mnFile.add(mntmExit);

        JMenuItem mntmDelete = new JMenuItem("Delete Node");
        mntmDelete.setFont(new Font("Tahoma", Font.PLAIN, 11));
        mntmDelete.addActionListener(menuListener);
        mnFile.add(mntmDelete);

		JMenuItem mntmCreateCCode = new JMenuItem("Make");
		mntmCreateCCode.setFont(new Font("Tahoma", Font.PLAIN, 11));
        mntmCreateCCode.addActionListener(menuListener);
		mnFile.add(mntmCreateCCode);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About...");
		mntmAbout.setFont(new Font("Tahoma", Font.PLAIN, 11));
		mntmAbout.addActionListener(menuListener);
		mnHelp.add(mntmAbout);
	}

    public RightPanel getRightPanel() {
        return rightPanel;
    }

}
