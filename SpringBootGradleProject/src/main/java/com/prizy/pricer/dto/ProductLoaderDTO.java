package com.prizy.pricer.dto;

import javax.validation.constraints.NotNull;

@NotNull
public class ProductLoaderDTO {
	@NotNull
	private String store;
	@NotNull
	private int barCode;
	@NotNull
	private int price;
	private String notes;
	
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public int getBarCode() {
		return barCode;
	}
	public void setBarCode(int barCode) {
		this.barCode = barCode;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
