package br.edu.positivo.scpe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String description;
	
	@Column(name = "unity_type")
	private String unityType;
	
	@Column(name = "unity_buy_value")
	private double unityBuyValue;
	
	@Column(name ="quantity")
	private double quantity;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUnityType() {
		return unityType;
	}

	public void setUnityType(String unityType) {
		this.unityType = unityType;
	}

	public double getUnityBuyValue() {
		return unityBuyValue;
	}

	public void setUnityBuyValue(double unitBuyValue) {
		this.unityBuyValue = unitBuyValue;
	}
	
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	public double getQuantity() {
		return this.quantity;
	}
}
