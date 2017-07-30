package org.hrd.gui.maimform;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.List;
import java.util.jar.JarOutputStream;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.hrd.gui.datamodel.ExpertTableModel;
import org.hrd.gui.model.Expert;
import org.hrd.gui.resporsitiry.memory.ExpertMemoryReopistory;

public class ExpertTablePanel extends JPanel {
	
	private JTable ExpertTable;
	private ExpertTableModel tableModel;
	private ExpertMemoryReopistory expertMemoryRepo;
	
	public ExpertTablePanel() {
		init();
		initializeVariable();
		
		registerEvent();
	}
	private void initializeVariable() {
		this.tableModel=new ExpertTableModel();
		this.ExpertTable=new JTable(this.tableModel);
		this.ExpertTable.setFont(new Font("SansSerif", Font.PLAIN, 16));
		this.ExpertTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16));
		add(new JScrollPane(this.ExpertTable), BorderLayout.CENTER);
		
		this.expertMemoryRepo=new ExpertMemoryReopistory();
	}
	
	private void init() {
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(5, 10, 5, 10));
	}
	
	private void registerEvent() {
		this.ExpertTable.getSelectionModel().addListSelectionListener(new RowListener());
		//this.ExpertTable.getColumnModel().getSelectionModel().
		//addListSelectionListener(new ColumnListener());
	}
	
	public void setDataModel(List<Expert> list) {
		this.tableModel.setDataModel(list);
		System.out.println("tablePanel list" +list.size());
	}
	public void updateDataModel() {
		this.tableModel.updateDataModel();
	}
	
	class RowListener implements ListSelectionListener{

		public void valueChanged(ListSelectionEvent e) {
			if(e.getValueIsAdjusting()) {
				return ;
			}
			
			Expert expert=expertMemoryRepo.getOne(ExpertTable.getSelectedRow());
			JOptionPane.showMessageDialog(ExpertTablePanel.this,
					"Name : "+expert.getName());

		}
		
	}
	
	class ColumnListener implements ListSelectionListener{
		
		public void valueChanged(ListSelectionEvent e) {
			if(e.getValueIsAdjusting()) {
				return;
			}
			JOptionPane.showMessageDialog(ExpertTablePanel.this,
					"Column : "+ExpertTable.getSelectedColumn());
		}
		
	}
}
