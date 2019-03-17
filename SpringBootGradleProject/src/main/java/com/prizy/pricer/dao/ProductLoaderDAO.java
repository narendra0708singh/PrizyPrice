package com.prizy.pricer.dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="productsloader")
@Table(name="productsloader")
public class ProductLoaderDAO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="reqid",updatable = false, nullable = false)
	private Long reqid;
	@Column(name="Store")
	private String store;
	@Column(name="BarCode")
	private int barCode;
	@Column(name="price")
	private int price;
	@Column(name="Notes")
	private String notes;
	
	public Long getReqid() {
		return reqid;
	}
	public void setReqid(Long reqid) {
		this.reqid = reqid;
	}
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
	@Override
	public String toString() {
		return "ProductLoaderDAO [store=" + store + ", barCode=" + barCode + ", price=" + price + ", notes=" + notes
				+ "]";
	}

}
