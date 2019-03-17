package com.prizy.pricer.dto;

public class ProductDetailsDTO {
	
	private int barCode;
	private String productDiscription;
	private Double avgPrice;
	private Double lowPrice;
	private Double highestPrice;
	private Double idealPrice;
	private int noOfPriceCollected;
	public int getBarCode() {
		return barCode;
	}
	public void setBarCode(int barCode) {
		this.barCode = barCode;
	}
	public String getProductDiscription() {
		return productDiscription;
	}
	public void setProductDiscription(String productDiscription) {
		this.productDiscription = productDiscription;
	}
	public Double getAvgPrice() {
		return avgPrice;
	}
	public void setAvgPrice(Double avgPrice) {
		this.avgPrice = avgPrice;
	}
	public Double getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(Double lowPrice) {
		this.lowPrice = lowPrice;
	}
	public Double getHighestPrice() {
		return highestPrice;
	}
	public void setHighestPrice(Double highestPrice) {
		this.highestPrice = highestPrice;
	}
	public Double getIdealPrice() {
		return idealPrice;
	}
	public void setIdealPrice(Double idealPrice) {
		this.idealPrice = idealPrice;
	}
	public int getNoOfPriceCollected() {
		return noOfPriceCollected;
	}
	public void setNoOfPriceCollected(int noOfPriceCollected) {
		this.noOfPriceCollected = noOfPriceCollected;
	}
	
}
