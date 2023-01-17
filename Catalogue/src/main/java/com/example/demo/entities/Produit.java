package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Produit {

	 @Id @GeneratedValue
	long id;
	 
	String desg;
	double price;
	int quantity;
	@Column(name = "DescProduct")
	String descproduct;
	
	@ManyToOne()
	@JsonBackReference
	Categorie cat;
 

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getDesg() {
		return desg;
	}


	public void setDesg(String desg) {
		this.desg = desg;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Categorie getCat() {
		return cat;
	}


	public void setCat(Categorie cat) {
		this.cat = cat;
	}


	public String getDescproduct() {
		return descproduct;
	}


	public void setDescproduct(String descproduct) {
		this.descproduct = descproduct;
	}


	


	
	
	
}
