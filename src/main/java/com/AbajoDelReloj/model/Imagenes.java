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
	@Column(name="idImage")
	private Long idImage;
	@Column(name = "imageName")
	private String imageName;
	@Column(name = "products_idproducts")
	private Long products_idproducts;
	
	public Imagenes() {
		
	}
	
	//Constructores
	public Imagenes(Long idImage, String imageName, Long products_idproducts) {
		this.idImage = idImage;
		this.imageName = imageName;
		this.products_idproducts = products_idproducts;
	}
	//Getters y Setters

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Long getProducts_idproducts() {
		return products_idproducts;
	}

	public void setProducts_idproducts(Long products_idproducts) {
		this.products_idproducts = products_idproducts;
	}

	public Long getIdImage() {
		return idImage;
	}

	//toString
	@Override
	public String toString() {
		return "Imagenes [IdImage=" + idImage + ", imageName=" + imageName + ", products_idproducts="
				+ products_idproducts + "]";
	}
	
	

	
	
	
	
}//cierre class


