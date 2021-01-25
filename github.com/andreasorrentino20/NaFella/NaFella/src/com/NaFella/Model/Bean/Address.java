package com.NaFella.Model.Bean;

public class Address {
	
	public Address(int id, String street, String postalCode, String city, String province, String country, int idCustomer) {
		this.id = id;
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
		this.province = province;
		this.country = country;
		this.idCustomer = idCustomer;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}


	int id;
	String street;
	String postalCode;
	String city;
	String province;
	String country;
	int idCustomer;
}
