package org.hrd.gui.shared;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Footer extends JPanel{

	
	private JLabel bodyLabel;

	public Footer() {
		intializeVariables();
		
	}

	private void intializeVariables() {
		bodyLabel=new JLabel("HRD 2017",JLabel.CENTER);
		add(this.bodyLabel);
	}
	
	
	
}
