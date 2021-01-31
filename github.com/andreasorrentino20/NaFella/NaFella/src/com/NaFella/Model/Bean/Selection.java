package com.NaFella.Model.Bean;

public class Selection {
	
	int productId;
	int purchaseId;
	String image;
	double realPrice;
	
	public Selection(int productId, int purchaseId, String image, double realPrice) {
		this.productId = productId;
		this.purchaseId = purchaseId;
		this.image = image;
		this.realPrice = realPrice;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getRealPrice() {
		return realPrice;
	}
	public void setRealPrice(double realPrice) {
		this.realPrice = realPrice;
	}
	
}
