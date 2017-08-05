package org.hrd.gui.resporsitiry.memory;

import java.util.ArrayList;
import java.util.List;

import org.hrd.gui.model.Expert;

public class ExpertMemoryReopistory {

	private List<Expert> list =new ArrayList<Expert>();
	
	public ExpertMemoryReopistory() {
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
	}
	
	public List<Expert> getAll() {
		return list;
	}
	
	public void setExpert(Expert expert) {
		this.list.add(expert);
		System.out.println("List Size:" +list.size());
	}
	public Expert getOne(int id) {
		for( Expert e : this.list) {
			if(e.getId()==id) {
				return e;
			}
		}
		return null;
	}
	
}
