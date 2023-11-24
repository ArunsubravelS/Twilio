package com.jsp.message.Dto;

import javax.persistence.Column;

public class StudentDto {
	private String name;

	
	private String phoneNumber;

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
