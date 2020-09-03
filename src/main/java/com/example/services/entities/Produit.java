package com.example.services.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data 
public class Produit implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String designation;
	private double price;
	private int quantite;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	
	
	Produit(){}
	
	public Produit(String designation, double price, int quantite){
		this.designation=designation;
		this.price=price;
		this.quantite=quantite;
	}
	
	@Override
	public String toString() {
		return "Produit [id=" + id + ", designation=" + designation + ", price=" + price + ", quantite=" + quantite
				+ ", getId()=" + getId() + ", getDesignation()=" + getDesignation() + ", getPrice()=" + getPrice()
				+ ", getQuantite()=" + getQuantite() + "]";
	}

}
