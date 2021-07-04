package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.type.ImageType;

@Entity
@Table(name="medicines")

public class Medicines {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="m_name")
	private String name;
	@Lob
	@Column(name="medicine_image")
	private String image;
	
	@Column(name="brand")
	private String brand;
	@Column(name="price")
	private float price;
	@Column(name="quantity")
	private int quantity;
	@Column(name="description")
	private String description;
	@Column(name="status")
	private String status;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Medicines() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	
	
	
	public Medicines(long id, String name,String image, String brand, float price, int quantity, String description,
			String status) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.brand = brand;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
		this.status = status;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
