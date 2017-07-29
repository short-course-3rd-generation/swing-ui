package org.hrd.gui.maimform;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import org.hrd.gui.shared.Footer;

public class MainWindow extends JFrame implements ActionListener,
	ItemListener,KeyListener {

	private JPanel controlPanel;
	private Footer footerPanel;
	
	private JLabel headerLabel;
	private ImageIcon iconHeader;
	
	private JButton btnImageUpload,btnshowinfo;
	
	///checkBoxs
	private JCheckBox chJava,chC,chcPlusPlus;
	private ButtonGroup rdGroup;
	private JRadioButton rdMale,rdFemale;
	
	private JLabel lName,lPassword;
	private JTextField tfName;
	private JPasswordField tfPassword;
	
	private JTextArea tadesc;
	
	private JComboBox<String> country;
	private String[] countryModel= {"Cambodia","ThiaLand","China",
			"Japen","South Korea","USA","UK","North Korea","Vetnam","Malaysi"};
	
	private JList<String> countryList;
	
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
		
		this.controlPanel.add(this.chJava);
		this.controlPanel.add(this.chC);
		this.controlPanel.add(this.chcPlusPlus);
		
		//RadioButton
		this.rdGroup.add(this.rdMale);
		this.rdGroup.add(this.rdFemale);
		this.controlPanel.add(this.rdMale);
		this.controlPanel.add( this.rdFemale);
		
		//add TxtField 
		
		Insets tfPadding=new Insets(5, 0, 5, 0);
		this.tfName.setMargin(tfPadding);
		this.tfPassword.setMargin(tfPadding);
		this.tfName.setFont(new Font("Tahoma", Font.PLAIN,18));
		this.tfPassword.setFont(new Font("Tahoma", Font.PLAIN,25));
		
		
		this.controlPanel.add(this.lName);
		this.controlPanel.add(this.tfName);
		this.controlPanel.add(this.lPassword);
		this.controlPanel.add(this.tfPassword);
		
		//textArea
		this.tadesc.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		this.controlPanel.add(new JScrollPane(this.tadesc));
		
		this.controlPanel.add(this.country);
	
		this.countryList.setListData(this.countryModel);
		
		this.controlPanel.add(new JScrollPane(this.countryList));
		
		add(this.headerLabel,BorderLayout.NORTH);
		add(this.controlPanel,BorderLayout.CENTER);
		add(this.footerPanel,BorderLayout.SOUTH);
		
		this.btnImageUpload.addActionListener(this);
		this.btnshowinfo.addActionListener(this);
		//register event for checkBOx
		this.chJava.addItemListener(this);
		this.rdMale.addItemListener(this);
		this.rdFemale.addItemListener(this);
		
		//textField
		this.tfName.addKeyListener(this);
		
		
		
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
		this.btnshowinfo=new JButton("Show Info...");
		this.controlPanel.add(this.btnshowinfo);
		//checkBOxs
		this.chJava=new JCheckBox("Java");
		this.chC=new JCheckBox("C Program");
		this.chcPlusPlus=new JCheckBox("C ++");
		
		//RadioButtons
		this.rdMale=new JRadioButton("Male");
		this.rdFemale=new JRadioButton("Female");
		this.rdGroup=new ButtonGroup();
		
		//TextField and PasswordField
		this.lName=new JLabel("Name");
		this.lPassword=new JLabel("Password");
		this.tfName=new JTextField(10);
		this.tfPassword=new JPasswordField(10);
		
		//
		tadesc=new JTextArea(5,30);
		
		//comBoBox
		this.country=new JComboBox<String>(this.countryModel);
		Insets marginlist=new Insets(0, 10, 0, 10);
		this.countryList=new JList<String>();
		this.countryList.setVisibleRowCount(3);
		
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
			
			String chProgramming="";
			
			if(chJava.isSelected())chProgramming +=chJava.getText().toString();
			if(chC.isSelected()) chProgramming+= chC.getText().toString();
			if(chcPlusPlus.isSelected()) chProgramming+=chcPlusPlus.getText().toString();
			
			int number=JOptionPane.showConfirmDialog(MainWindow.this, chProgramming,
					"confrim "
					,JOptionPane.OK_CANCEL_OPTION);
			
			if(number==0) {
				System.out.println("Ok Clicked");
			}else if(number==2) {
				System.out.println("Cancel Clicked");
			}
			
			System.out.println(number);
		}else if(e.getSource()==this.btnshowinfo) {
			
			List<String> countryListselected=this.countryList.getSelectedValuesList();
			for(String s : countryListselected) {
				System.out.print(s+" ");
			}
			
		}
	}

	public void itemStateChanged(ItemEvent e) {
		
		if(e.getSource()==chJava) {
			if(chJava.isSelected())
			System.out.println(chJava.getText().toString());
			
			/*JOptionPane.showConfirmDialog(MainWindow.this, 
					chJava.isSelected()== true ? chJava.getText().toString()+
							" : checked" : chJava.getText().toString()  + ": unchecked");*/
		}
		
		if(rdMale.isSelected())
			System.out.println(rdMale.getText().toString());
			
		if(rdFemale.isSelected())
			System.out.println(rdFemale.getText().toString());
		
	}
	
	//KeyListener

	public void keyTyped(KeyEvent e) {
		System.out.println("typing");
		
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent e) {
		String userName=tfName.getText().toString();
		if(userName.length()>= 8) {
			JOptionPane.showConfirmDialog(MainWindow.this,null,
					"you can input text only less then 8 characters",
					JOptionPane.CANCEL_OPTION);
		}
	}
	
}
