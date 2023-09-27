package com.austine.bunde.model;

import com.austine.bunde.validation.ValidPatienType;

public class Patient {
	
private Long id;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private ValidPatienType identificationType;	
	private String identificationNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public ValidPatienType getIdentificationType() {
		return identificationType;
	}

	public void setIdentificationType(ValidPatienType identificationType) {
		this.identificationType = identificationType;
	}
	
	

}
