package com.AbajoDelReloj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

//Especificamos el nombre de la tabla de MySQL a donde llega esta informacion
@Table(name="images")
public class Imagenes {
	
	@Id //especificamos que nuestra llave primaria es el campo id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Indicamos a JAVA que vamos a utilizar una estrategia de generacion
														//de valores de indentidad de la base de datos (para generar valores
														//unicos e incrementables para nuestras llaves primarias)
	
	/*
		Especificamos que el campo donde se aplica la estrategia de generacion de valores autoincremetables es
		una columa llamada id, unica y no nula
	 */
	//Atributos
	@Column(name="id_Image")
	private Long id_Image;
	@Column(name = "image_Name")
	private String image_Name;
	@Column(name = "products_idproducts")
	private Long products_idproducts;
	
	public Imagenes() {
		
	}
	
	//Constructores
	public Imagenes(Long idImage, String imageName, Long products_idproducts) {
		this.id_Image = idImage;
		this.image_Name = imageName;
		this.products_idproducts = products_idproducts;
	}
	//Getters y Setters

	public String getImage_Name() {
		return image_Name;
	}

	public void setImage_Name(String imageName) {
		this.image_Name = imageName;
	}

	public Long getProducts_idproducts() {
		return products_idproducts;
	}

	public void setProducts_idproducts(Long products_idproducts) {
		this.products_idproducts = products_idproducts;
	}

	public Long getId_Image() {
		return id_Image;
	}

	//toString
	@Override
	public String toString() {
		return "Imagenes [IdImage=" + id_Image + ", imageName=" + image_Name + ", products_idproducts="
				+ products_idproducts + "]";
	}
	
	

	
	
	
	
}//cierre class

