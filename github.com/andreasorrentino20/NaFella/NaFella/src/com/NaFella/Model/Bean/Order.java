package com.NaFella.Model.Bean;

public class Order {
	
	public Order(int id, String date, String tracking, String paymentState, int customerAddress, int customerId, double price) {
		this.id = -1;
		this.date = "";
		this.tracking = "";
		this.paymentState = "";
		this.customerAddress = -1;
		this.customerId = -1;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTracking() {
		return tracking;
	}
	public void setTracking(String tracking) {
		this.tracking = tracking;
	}
	public String getPaymentState() {
		return paymentState;
	}
	public void setPaymentState(String paymentState) {
		this.paymentState = paymentState;
	}
	public int getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(int customerAddress) {
		this.customerAddress = customerAddress;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	int id;
	String date;
	String tracking;
	String paymentState;
	int customerAddress;
	int customerId;
	double price;
}
