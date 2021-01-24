package com.NaFella.Model.Bean;

public class Product {

	
	public Product() {
		this.id = -1;
		this.name = "";
		this.img = "";
		this.type = "";
		this.description = "";
		this.size = "";
		this.price = 0;
		this.discount = 0;
		this.availability = 0;
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public double getReal_price() {
		return real_price;
	}

	public void setReal_price(double real_price) {
		this.real_price = real_price;
	}
	
	public String getImageCanvas() {
		return image_canvas;
	}
	
	public void setImageCanvas(String image_canvas) {
		this.image_canvas = image_canvas;
	}
	
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", img=" + img + ", type=" + type + ", sex=" + sex
				+ ", category=" + category + ", description=" + description + ", size=" + size + ", color=" + color
				+ ", price=" + price + ", real_price=" + real_price + ", discount=" + discount + ", availability="
				+ availability + ", image_canvas=" + image_canvas + "]";
	}


	private int id;
	private String name;
	private String img;
	private String type;
	private String sex;
	private String category;
	private String description;
	private String size;
	private String color;
	private double price;
	private double real_price;
	private double discount;
	private int availability;
	private String image_canvas;
}
