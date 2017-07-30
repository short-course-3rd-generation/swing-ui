package org.hrd.gui.maimform;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import org.hrd.gui.delegate.FormRregisterListener;

public class AddExpertForm extends JDialog implements ActionListener,
	
	FormRregisterListener{

	JButton btnClick;
	public AddExpertForm() {
		init();
		initializeVariables();
	}

	private void initializeVariables() {
		this.btnClick=new JButton("Cickl");
		add(btnClick,BorderLayout.CENTER);
		
		this.btnClick.addActionListener(this);
	}

	private void init() {
		setSize(new Dimension(300, 300));
		setLayout(new BorderLayout());
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("clicked");
	}

	public void addExpertListener() {
	
	}

	public Object setContext() {
		return this;
	}
}
