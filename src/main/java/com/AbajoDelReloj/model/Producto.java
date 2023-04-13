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
	@Column(name="idproducts",unique= false, nullable = true)
	
	//Atributos
	private Long id;
	private String name;
	private String description;
	private String brand;
	private Double price;
	private String publicationDate;
	private Long inventory;
	private String state;
	private Long sku;
	private String visibility;	
	private Long productcategories_idCategory;
	private Long seller_idseller;
	
	
	//Constructor vacio
	public Producto() {}//constructor vacio

	
	//Getters y Setters

	


	public Long getId() {
		return id;
	}
	
	


	public Producto(Long id, String name, String description, String brand, Double price, String publicationDate,
			Long inventory, String state, Long sku, String visibility, Long productcategories_idCategory,
			Long seller_idseller) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.brand = brand;
		this.price = price;
		this.publicationDate = publicationDate;
		this.inventory = inventory;
		this.state = state;
		this.sku = sku;
		this.visibility = visibility;
		this.productcategories_idCategory = productcategories_idCategory;
		this.seller_idseller = seller_idseller;
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
	

	public Long getProductcategories_idCategory() {
		return productcategories_idCategory;
	}


	public Long getSeller_idseller() {
		return seller_idseller;
	}


	@Override
	public String toString() {
		return "Producto [id=" + id + ", name=" + name + ", description=" + description + ", brand=" + brand
				+ ", price=" + price + ", publicationDate=" + publicationDate + ", inventory=" + inventory + ", state="
				+ state + ", sku=" + sku + ", visibility=" + visibility + ", productcategories_idCategory="
				+ productcategories_idCategory + ", seller_idseller=" + seller_idseller + "]";
	}

	
	
}