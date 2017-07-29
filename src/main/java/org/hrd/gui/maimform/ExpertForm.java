package org.hrd.gui.maimform;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.hrd.gui.model.Expert;

public class ExpertForm extends JFrame {

	private ExpertTablePanel expertTable;
	
	public ExpertForm() {
		init();
		initializeVariables();
		setDataModel();
		refreshTable();
	}

	private void refreshTable() {
		this.expertTable.updateDataModel();
	}

	private void setDataModel() {
		List<Expert> list= new ArrayList<Expert>();
		for(int i=0;i<10;i++) {
			list.add(new Expert(
					i,
					"Data"+ i,
					"male",
					"Java developer",
					"Cambodia",
					"your interest ....."
					));
		}
		
		this.expertTable.setDataModel(list);
		
	}

	private void initializeVariables() {
		add(this.expertTable,BorderLayout.CENTER);
	}

	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,400);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		this.expertTable=new ExpertTablePanel();
	}
	
	public static void main(String[] args) {
		new ExpertForm().setVisible(true);
	}
}
