package com.demo.sales.models;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Sale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int quantity;
	private Date saleDate;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public Sale(int quantity, Date saleDate, Product product) {
		super();
		this.quantity = quantity;
		this.saleDate = saleDate;
		this.product = product;
	}

	public Sale() {
	}

}
