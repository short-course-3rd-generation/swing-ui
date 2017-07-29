package org.hrd.gui.maimform;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import org.hrd.gui.datamodel.ExpertTableModel;
import org.hrd.gui.model.Expert;

public class ExpertTablePanel extends JPanel {
	
	private JTable ExpertTable;
	//private List<Expert> list;
	private ExpertTableModel tableModel;
	
	
	public ExpertTablePanel() {
		init();
		initializeVariable();
	}


	private void initializeVariable() {
		this.tableModel=new ExpertTableModel();
		this.ExpertTable=new JTable(this.tableModel);
		
		add(this.ExpertTable, BorderLayout.CENTER);
	}


	private void init() {
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(5, 10, 5, 10));
		
	}
	public void setDataModel(List<Expert> list) {
		this.tableModel.setDataModel(list);
		System.out.println("tablePanel list" +list.size());
	}
	public void updateDataModel() {
		this.tableModel.updateDataModel();
	}
}
