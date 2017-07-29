package org.hrd.gui.maimform;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JTabbedPaneDemo extends JFrame{
	
	private JTabbedPane tab;
	private JPanel homePanel,loginPanel,RegisterPanel;
	
	private JLabel homeLabel,loginLabel,registerLabel;
	
	public JTabbedPaneDemo() {
		init();
		counstructLayout();
	}

	private void counstructLayout() {
		
		this.homePanel.add(this.homeLabel);
		this.loginPanel.add(this.loginLabel);
		this.RegisterPanel.add(this.registerLabel);
		
		ImageIcon homeIcon=new ImageIcon("src/main/java/resources/images/school.png");
		this.tab.addTab("Home",homeIcon, this.homePanel);
		this.tab.addTab("Login", this.loginPanel);
		this.tab.addTab("Register", this.RegisterPanel);
		
		add(this.tab);
	}

	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,400);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		this.tab=new JTabbedPane();
		this.homePanel=new JPanel();
		this.loginPanel=new JPanel();
		this.RegisterPanel=new JPanel();
		
		this.homeLabel=new JLabel("Home");
		this.loginLabel=new JLabel("Login");
		this.registerLabel=new JLabel("Register");
	
	}

}
