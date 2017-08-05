package org.hrd.gui.maimform;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

import org.hrd.gui.callback.FormRregisterListener;
import org.hrd.gui.model.Expert;
import org.hrd.gui.resporsitiry.memory.Database;
import org.hrd.gui.resporsitiry.memory.ExpertMemoryReopistory;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddExpertForm extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfName;
	private JRadioButton rdbtnMale,rdbtnFemale;
	private JCheckBox chckbxJava, chckbxLaravel,chckbxAndroid, chckbxIos;
	private ButtonGroup genderGroup;
	private JComboBox<String> comboBox;
	private JTextArea taPersonalInfo;
	private ExpertMemoryReopistory expertRepo;
	private FormRregisterListener formRregisterListener;
	/**
	 * Create the dialog.
	 */
	public AddExpertForm() {
		setTitle("Add new expert");
		getContentPane().setLayout(new BorderLayout());
		setSize(new Dimension(400, 400));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		SpringLayout sl_contentPanel = new SpringLayout();
		contentPanel.setLayout(sl_contentPanel);
		
		this.expertRepo=Database.INSTANCE.getInstace();
		
		JPanel formPanel = new JPanel();
		formPanel.setBorder(new CompoundBorder(new EmptyBorder(10, 10, 10, 10), new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Add Expert", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))));
		sl_contentPanel.putConstraint(SpringLayout.NORTH, formPanel, -5, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, formPanel, -5, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, formPanel, -5, SpringLayout.SOUTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, formPanel, -5, SpringLayout.EAST, contentPanel);
		contentPanel.add(formPanel);
		formPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(99, 50, 46, 14);
		formPanel.add(lblNewLabel);
		
		tfName = new JTextField();
		tfName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfName.setBounds(175, 44, 144, 30);
		formPanel.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGender.setBounds(66, 92, 79, 14);
		formPanel.add(lblGender);
		
		this.genderGroup=new ButtonGroup();
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setSelected(true);
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnMale.setBounds(175, 90, 57, 23);
		formPanel.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnFemale.setBounds(247, 90, 72, 23);
		formPanel.add(rdbtnFemale);
		
		this.genderGroup.add(rdbtnMale);
		this.genderGroup.add(rdbtnFemale);
		
		JLabel lblSkill = new JLabel("Skill :");
		lblSkill.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSkill.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSkill.setBounds(66, 129, 79, 14);
		formPanel.add(lblSkill);
		
		chckbxJava = new JCheckBox("Java");
		chckbxJava.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxJava.setBounds(178, 127, 57, 23);
		formPanel.add(chckbxJava);
		
		chckbxLaravel = new JCheckBox("Laravel");
		chckbxLaravel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxLaravel.setBounds(260, 125, 82, 23);
		formPanel.add(chckbxLaravel);
		
		chckbxAndroid = new JCheckBox("Android");
		chckbxAndroid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxAndroid.setBounds(175, 159, 79, 23);
		formPanel.add(chckbxAndroid);
		
		chckbxIos = new JCheckBox("IOS");
		chckbxIos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxIos.setBounds(260, 159, 79, 23);
		formPanel.add(chckbxIos);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cambodia", "thailand", "Korea", "China", "Vitnam"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBounds(178, 200, 141, 20);
		formPanel.add(comboBox);
		
		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCountry.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCountry.setBounds(66, 197, 79, 23);
		formPanel.add(lblCountry);
		
		JLabel lblPersonalInformation = new JLabel("Personal information");
		lblPersonalInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonalInformation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPersonalInformation.setBounds(66, 231, 253, 14);
		formPanel.add(lblPersonalInformation);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 250, 274, 48);
		formPanel.add(scrollPane);
		
		taPersonalInfo = new JTextArea();
		taPersonalInfo.setMargin(new Insets(5, 5, 5, 5));
		taPersonalInfo.setFont(new Font("Monospaced", Font.PLAIN, 14));
		scrollPane.setViewportView(taPersonalInfo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String name=tfName.getText().toString();
						String gender="";
						if(rdbtnMale.isSelected()) gender=rdbtnMale.getText().toString();
						if(rdbtnFemale.isSelected()) gender=rdbtnFemale.getText().toString();
						
						String skill="";
						if(chckbxJava.isSelected()) skill+= chckbxJava.getText().toString()+ " ";
						if(chckbxLaravel.isSelected()) skill+= chckbxLaravel.getText().toString()+ " ";
						if(chckbxAndroid.isSelected()) skill+= chckbxAndroid.getText().toString()+ " ";
						if(chckbxIos.isSelected()) skill+= chckbxIos.getText().toString()+ " ";
					
						String country=comboBox.getItemAt(comboBox.getSelectedIndex());
						String personalInfo=taPersonalInfo.getText().toString();
						
						Expert expert=new Expert(
								expertRepo.getAll().size(),
								name,
								gender,
								skill,
								country,
								personalInfo
								);
						
						expertRepo.setExpert(expert);
						System.out.println(expert);
						formRregisterListener.addExpertListener();
						setEmpty();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int confirm=JOptionPane.showConfirmDialog(AddExpertForm.this, 
								"Are you sure to exit?",null,
								JOptionPane.OK_CANCEL_OPTION);
						if(confirm==0) {
							AddExpertForm.this.dispose();
						}
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void setContext(ExpertForm expertForm) {
		this.formRregisterListener=expertForm;
	}
	
	public void setEmpty() {
		this.tfName.setText("");
		this.taPersonalInfo.setText("");
	}
}
