package com.AbajoDelReloj.model;


import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // la convertimos en una entidad JPA par amanejar una persistencia de datos 

@Table(name="products") // especificamos el nombre de la tabla de MySQL a donde llega la informacion

public class Producto {
	@Id// Especificamos que nuestra llave primaria es el campo id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_products",unique= false, nullable = true)
	
	//Atributos
	private Long id_productos;
	private String name;
	private String description;
	private String brand;
	private Double price;
	private Long inventory;
	private String state;
	private Long sku;
	private String visibility;
	private String publication_Date;
	private Long productcategories_id_category;
	private Long seller_id_seller;
	
	
	//Constructor vacio
	public Producto() {}//constructor vacio

	public Producto(Long id_productos, String name, String description, String brand, Double price, Long inventory, String state,
			Long sku, String visibility, String publication_Date, Long productcategories_id_category,
			Long seller_id_seller) {
		super();
		this.id_productos = id_productos;
		this.name = name;
		this.description = description;
		this.brand = brand;
		this.price = price;
		this.inventory = inventory;
		this.state = state;
		this.sku = sku;
		this.visibility = visibility;
		this.publication_Date = publication_Date;
		this.productcategories_id_category = productcategories_id_category;
		this.seller_id_seller = seller_id_seller;
	}
	//Getters y Setters

	


	public Long getId() {
		return id_productos;
	}
	


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Long getInventory() {
		return inventory;
	}


	public void setInventory(Long inventory) {
		this.inventory = inventory;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public Long getSku() {
		return sku;
	}


	public void setSku(Long sku) {
		this.sku = sku;
	}


	public String getVisibility() {
		return visibility;
	}


	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	

	public String getPublication_Date() {
		return publication_Date;
	}

	public void setPublication_Date(String publication_Date) {
		this.publication_Date = publication_Date;
	}

	public Long getSeller_id_seller() {
		return seller_id_seller;
	}

	public void setSeller_id_seller(Long seller_id_seller) {
		this.seller_id_seller = seller_id_seller;
	}

	public Long getProductcategories_id_category() {
		return productcategories_id_category;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id_productos + ", name=" + name + ", description=" + description + ", brand=" + brand
				+ ", price=" + price + ", inventory=" + inventory + ", state=" + state + ", sku=" + sku
				+ ", visibility=" + visibility + ", publication_Date=" + publication_Date
				+ ", productcategories_id_category=" + productcategories_id_category + ", seller_id_seller="
				+ seller_id_seller + "]";
	}

	
}