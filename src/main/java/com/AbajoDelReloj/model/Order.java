package com.AbajoDelReloj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity	//Esta clase se convierte en una entidad de JPA para manejar una persistencia de datos
//Que esta informacion se quede guardada en una BD

//Especificamos el nombre de la tabla de MySQL a donde llega esta informacion
@Table(name="orders")
public class Order {
	
	@Id //especificamos que nuestra llave primaria es el campo id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Indicamos a JAVA que vamos a utilizar una estrategia de generacion
														//de valores de indentidad de la base de datos (para generar valores
														//unicos e incrementables para nuestras llaves primarias)
	
	/*
		Especificamos que el campo donde se aplica la estrategia de generacion de valores autoincremetables es
		una columa llamada id, unica y no nula
	 */
	
	@Column(name="idOrder", unique=true, nullable=false)
	
	//Atributos
		private Long IdOrder;		//class wrapper
		//@column name
		private Float orderAmount;
		//@columna last_name
		private String orderShipName;
		//@column user_name
		private String orderShipStreet;
		//@column correo
		private String orderNumberOutdoor;
		//@column user_name
		private String orderNumberInterior;
		//@column precion
		private Integer orderZip;
		//@column correo
		private String orderAlcaldia;
		//@column user_name
		private String orderPhone;
		//@column user_name
		private String orderInstruction;
		//@column user_name
		private Long products_idproducts;
		
		
		

		//Constructor vacio
		public Order() {
			
		}//constructor vacio



		//Constructor
		public Order(Long idOrder, Float orderAmount, String orderShipName, String orderShipStreet,
				String orderNumberOutdoor, String orderNumberInterior, Integer orderZip, String orderAlcaldia,
				String orderPhone, String orderInstruction, Long products_idproducts) {
			this.IdOrder = idOrder;
			this.orderAmount = orderAmount;
			this.orderShipName = orderShipName;
			this.orderShipStreet = orderShipStreet;
			this.orderNumberOutdoor = orderNumberOutdoor;
			this.orderNumberInterior = orderNumberInterior;
			this.orderZip = orderZip;
			this.orderAlcaldia = orderAlcaldia;
			this.orderPhone = orderPhone;
			this.orderInstruction = orderInstruction;
			this.products_idproducts = products_idproducts;
		}


		//Getters y setters

		public Long getIdOrder() {
			return IdOrder;
		}

		public void setIdOrder(Long idOrder) {
			IdOrder = idOrder;
		}

		public Float getOrderAmount() {
			return orderAmount;
		}
		
		public void setOrderAmount(Float orderAmount) {
			this.orderAmount = orderAmount;
		}
		
		public String getOrderShipName() {
			return orderShipName;
		}

		public void setOrderShipName(String orderShipName) {
			this.orderShipName = orderShipName;
		}

		public String getOrderShipStreet() {
			return orderShipStreet;
		}

		public void setOrderShipStreet(String orderShipStreet) {
			this.orderShipStreet = orderShipStreet;
		}

		public String getOrderNumberOutdoor() {
			return orderNumberOutdoor;
		}
		
		public void setOrderNumberOutdoor(String orderNumberOutdoor) {
			this.orderNumberOutdoor = orderNumberOutdoor;
		}

		public String getOrderNumberInterior() {
			return orderNumberInterior;
		}

		public void setOrderNumberInterior(String orderNumberInterior) {
			this.orderNumberInterior = orderNumberInterior;
		}
		
		public Integer getOrderZip() {
			return orderZip;
		}

		public void setOrderZip(Integer orderZip) {
			this.orderZip = orderZip;
		}

		public String getOrderAlcaldia() {
			return orderAlcaldia;
		}

		public void setOrderAlcaldia(String orderAlcaldia) {
			this.orderAlcaldia = orderAlcaldia;
		}

		public String getOrderPhone() {
			return orderPhone;
		}

		public void setOrderPhone(String orderPhone) {
			this.orderPhone = orderPhone;
		}

		public String getOrderInstruction() {
			return orderInstruction;
		}

		public void setOrderInstruction(String orderInstruction) {
			this.orderInstruction = orderInstruction;
		}

		public Long getIdProducts() {
			return products_idproducts;
		}

		public void setIdProducts(Long idProducts) {
			this.products_idproducts = idProducts;
		}



		
		//toString
		@Override
		public String toString() {
			return "Order [IdOrder=" + IdOrder + ", orderAmount=" + orderAmount + ", orderShipName=" + orderShipName
					+ ", orderShipStreet=" + orderShipStreet + ", orderNumberOutdoor=" + orderNumberOutdoor
					+ ", orderNumberInterior=" + orderNumberInterior + ", orderZip=" + orderZip + ", orderAlcaldia="
					+ orderAlcaldia + ", orderPhone=" + orderPhone + ", orderInstruction=" + orderInstruction
					+ ", idProducts=" + products_idproducts + "]";
		}
		
}

