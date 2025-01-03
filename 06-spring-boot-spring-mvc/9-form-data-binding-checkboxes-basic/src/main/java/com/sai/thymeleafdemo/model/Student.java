package com.sai.thymeleafdemo.model;

import java.util.List;

public class Student {
	
	private String firstName;
	
	private String lastName;
	
	private String country;
	
	private String programmingLangauage;
	
	private List<String> os;
	
	public List<String> getOs() {
		return os;
	}

	public void setOs(List<String> os) {
		this.os = os;
	}

	public String getProgrammingLangauage() {
		return programmingLangauage;
	}

	public void setProgrammingLangauage(String programmingLangauage) {
		this.programmingLangauage = programmingLangauage;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Student() {
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}

