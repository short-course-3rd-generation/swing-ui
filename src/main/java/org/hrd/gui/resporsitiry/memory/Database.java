package org.hrd.gui.resporsitiry.memory;

public enum Database {

	INSTANCE;
	private ExpertMemoryReopistory expertMemoryReopistory=new ExpertMemoryReopistory();
	
	public ExpertMemoryReopistory getInstace() {
		return expertMemoryReopistory;
	}
}
