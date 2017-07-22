package org.hrd.gui.maimform;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import org.hrd.gui.shared.Footer;

public class MainWindow extends JFrame implements ActionListener{

	private JPanel controlPanel;
	private Footer footerPanel;
	
	private JLabel headerLabel;
	private ImageIcon iconHeader;
	
	private JButton btnImageUpload;
	
	public MainWindow() {
		//initials all objects
		initializeVariables();
		//intials layout (mainWondow)
		initializeLayout();
		//add components to MainWindow
		constructLayout();
	}

	private void constructLayout() {
		
		//set border to mainWindow
		Border spaceBorder= BorderFactory.createEmptyBorder(20,20,20,20);
		Border titleBorder=BorderFactory.createTitledBorder("Main Form");
		this.controlPanel.setBorder(BorderFactory.createCompoundBorder(spaceBorder,titleBorder));
	
		this.headerLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
			
		add(this.headerLabel,BorderLayout.NORTH);
		add(this.controlPanel,BorderLayout.CENTER);
		add(this.footerPanel,BorderLayout.SOUTH);
		
		this.btnImageUpload.addActionListener(this);
	}

	private void initializeVariables() {
		this.iconHeader=new ImageIcon("src/main/java/resources/images/school.png");
		this.headerLabel= new JLabel("KHRD ",JLabel.CENTER);
		this.headerLabel.setIcon(this.iconHeader);
		this.headerLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		this.controlPanel=new JPanel();
		
		///body components
		ImageIcon imgBtnImageUplaod=new ImageIcon("src/main/java/resources/images/cloud-computing-1.png");
		Insets buttonPadding=new Insets(10, 3, 10, 3);
		this.btnImageUpload=new JButton("uplaod",imgBtnImageUplaod);
		this.btnImageUpload.setMargin(buttonPadding);
		//this.btnImageUpload.
		this.btnImageUpload.setHorizontalTextPosition(SwingConstants.LEFT);
		this.controlPanel.add(this.btnImageUpload);
		
		this.footerPanel=new Footer();
		
		
	}

	private void initializeLayout() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(790,450);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnImageUpload) {
			
			int number=JOptionPane.showConfirmDialog(MainWindow.this, "uploading ... ",
					"confrim "
					,JOptionPane.OK_CANCEL_OPTION);
			
			if(number==0) {
				System.out.println("Ok Clicked");
			}else if(number==2) {
				System.out.println("Cancel Clicked");
			}
			
			System.out.println(number);
		}
	}
	
}
