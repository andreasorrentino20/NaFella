package com.NaFella.Model.Bean;

import java.util.ArrayList;
import java.util.HashMap;

import com.NaFella.Model.Bean.Product;

public class Cart {
	
	public Cart(){
		products = new ArrayList<>();
		images = new ArrayList<>();
	}
	
	public void addItem(Product product, String img) {
		products.add(product);
		images.add(img);
	}
	
	public void removeItem(int i) {
		products.remove(i);
		images.remove(i);
	}
	
	public void clearCart() {
		products.clear();
		images.clear();
	}
	
	public ArrayList<Product> getProducts() {
		return products;
	}
	public ArrayList<String> getImages() {
		return images;
	}
	
	ArrayList<Product> products;
	ArrayList<String> images;
}
