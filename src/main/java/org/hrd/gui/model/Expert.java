package org.hrd.gui.model;

public class Expert {

	private int id;
	private String name;
	private String gender;
	private String skill;
	private String country;
	private String personalInfo;
	
	public Expert() {}
	
	public Expert(int id, String name, String gender, String skill, String country, String personalInfo) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.skill = skill;
		this.country = country;
		this.personalInfo = personalInfo;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPersonalInfo() {
		return personalInfo;
	}
	public void setPersonalInfo(String personalInfo) {
		this.personalInfo = personalInfo;
	}
	
	
}
