package com.NaFella.Model.Bean;

public class Customer {
	
	
	public Customer(int id, String email, String firstName, String lastName, String birthdate, String phoneNumber, String psw) {
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.phoneNumber = phoneNumber;
		this.psw = psw;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}

	private int id;
	private String email;
	private String firstName;
	private String lastName;
	private String birthdate;
	private String phoneNumber;
	private String psw;
}
