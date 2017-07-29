package org.hrd.gui.datamodel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.hrd.gui.model.Expert;

public class ExpertTableModel extends AbstractTableModel{

	private List<Expert> expertList =new ArrayList<Expert>();
	private String[] COLUMNS={"Id","Name","Gender","Skill","Country","Personal Information"};
	
	public int getRowCount() {
		return this.expertList.size();
	}

	public int getColumnCount() {
		return COLUMNS.length;
	}

	public String getColumnName(int column) {
		return COLUMNS[column];
	}
	
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		Expert expert=expertList.get(rowIndex);
		
		switch (columnIndex) {
		case 0: return expert.getId();
		case 1: return expert.getName();
		case 2: return expert.getGender();
		case 3: return expert.getSkill();
		case 4: return expert.getCountry();
		case 5: return expert.getPersonalInfo();
		default:
			return null;
		}
	}
	
	public void updateDataModel() {
		fireTableDataChanged();
	}

	public void setDataModel(List<Expert> list) {
		this.expertList=list;
	}
}
