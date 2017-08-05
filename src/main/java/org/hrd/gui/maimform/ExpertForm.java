package org.hrd.gui.maimform;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.hrd.gui.callback.FormRregisterListener;
import org.hrd.gui.model.Expert;
import org.hrd.gui.resporsitiry.memory.Database;
import org.hrd.gui.resporsitiry.memory.ExpertMemoryReopistory;

public class ExpertForm extends JFrame implements ActionListener,
	FormRregisterListener {

	private ExpertTablePanel expertTable;
	private ExpertMemoryReopistory expertMemoryRepo;
	private AddExpertForm addDialog;
	private JPanel headPanel;
	private JButton btnAdd;
	public ExpertForm() {
		init();
		initializeVariables();
		refreshTable();
		setCallBack();
	}

	private void setCallBack() {
		this.addDialog.setContext(this);
	}

	private void refreshTable() {
		this.expertTable.setDataModel(this.expertMemoryRepo.getAll());
		this.expertTable.updateDataModel();
		System.out.println("refresh");
	}

	private void initializeVariables() {

		this.expertTable=new ExpertTablePanel();
		this.expertMemoryRepo=Database.INSTANCE.getInstace();
		this.btnAdd=new JButton("Add");
		this.headPanel=new JPanel();
		this.addDialog=new AddExpertForm();
		
		this.headPanel.add(this.btnAdd);
		
		add(this.headPanel, BorderLayout.NORTH);
		add(this.expertTable,BorderLayout.CENTER);
		
		this.btnAdd.addActionListener(this);
	}

	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,400);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
	}
	
	public static void main(String[] args) {
		new ExpertForm().setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		addDialog.setVisible(true);
	}

	public void addExpertListener() {
		refreshTable();
	}
}
