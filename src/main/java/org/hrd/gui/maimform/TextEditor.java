package org.hrd.gui.maimform;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class TextEditor extends JFrame implements ActionListener{

	private JTextArea jEditor;
	private JPanel headerPanel,bodyPanel;
	private JButton btnsave;
	
	public TextEditor() {
		//initials all objects
		initializeVariables();
		//intials layout (mainWondow)
		initializeLayout();
		//add components to MainWindow
		constructLayout();
	}

	private void constructLayout() {
		
		
		//header
		this.headerPanel.add(this.btnsave);
		
		
		
		this.jEditor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Border editerBOrder= BorderFactory.createLineBorder(Color.DARK_GRAY);	
		this.jEditor.setMargin(new Insets(5, 5, 5, 5));
		this.jEditor.setBorder(editerBOrder);
		this.bodyPanel.add(new JScrollPane(this.jEditor));
		
		
		add(this.headerPanel,BorderLayout.NORTH);
		add(this.bodyPanel,BorderLayout.CENTER);
		
		
		this.btnsave.addActionListener(this);
		
	}

	private void initializeLayout() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(790,450);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
	}

	private void initializeVariables() {
		this.jEditor=new JTextArea();
		this.btnsave=new JButton("Save");
		this.headerPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.bodyPanel=new JPanel();
		this.bodyPanel.setLayout(new GridLayout());
	
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(jEditor.getText().toString());
	}
	
	
	
	
}
