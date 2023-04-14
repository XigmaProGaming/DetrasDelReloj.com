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
	
	@Column(name="id_Order", unique=true, nullable=false)
	
	//Atributos
		private Long id_Order;		//class wrapper
		//@column name
		private Float order_Amount;
		//@columna last_name
		private String order_Ship_Name;
		//@column user_name
		private String order_Ship_Street;
		//@column correo
		private String order_Number_Outdoor;
		//@column user_name
		private String order_Number_Interior;
		//@column user_name
		private String order_Colonia;
		//@column precion
		private Integer order_Zip;
		//@column correo
		private String order_Alcaldia;
		//@column user_name
		private String order_Phone;
		//@column user_name
		private String order_Instruction;
		//@column user_name
		private Long products_idproducts;
		
		//Constructor vacio
		public Order() {
			
		}//constructor vacio

		//Constructor
		public Order(Long id_Order, Float order_Amount, String order_Ship_Name, String order_Ship_Street,
				String order_Number_Outdoor, String order_Number_Interior, Integer order_Zip, String order_Alcaldia,
				String order_Phone, String order_Instruction, Long products_idproducts) {
			this.id_Order = id_Order;
			this.order_Amount = order_Amount;
			this.order_Ship_Name = order_Ship_Name;
			this.order_Ship_Street = order_Ship_Street;
			this.order_Number_Outdoor = order_Number_Outdoor;
			this.order_Number_Interior = order_Number_Interior;
			this.order_Zip = order_Zip;
			this.order_Alcaldia = order_Alcaldia;
			this.order_Phone = order_Phone;
			this.order_Instruction = order_Instruction;
			this.products_idproducts = products_idproducts;
		}

		//Getters y setters
		public Long getId_Order() {
			return id_Order;
		}

		public Float getOrder_Amount() {
			return order_Amount;
		}

		public String getOrder_Ship_Name() {
			return order_Ship_Name;
		}

		public String getOrder_Ship_Street() {
			return order_Ship_Street;
		}

		public String getOrder_Number_Outdoor() {
			return order_Number_Outdoor;
		}

		public String getOrder_Number_Interior() {
			return order_Number_Interior;
		}

		public Integer getOrder_Zip() {
			return order_Zip;
		}

		public String getOrder_Alcaldia() {
			return order_Alcaldia;
		}

		public String getOrder_Phone() {
			return order_Phone;
		}

		public String getOrder_Instruction() {
			return order_Instruction;
		}

		public Long getProducts_idproducts() {
			return products_idproducts;
		}

		public String getOrder_Colonia() {
			return order_Colonia;
		}
		//toString

		@Override
		public String toString() {
			return "Order [id_Order=" + id_Order + ", order_Amount=" + order_Amount + ", order_Ship_Name="
					+ order_Ship_Name + ", order_Ship_Street=" + order_Ship_Street + ", order_Number_Outdoor="
					+ order_Number_Outdoor + ", order_Number_Interior=" + order_Number_Interior + ", order_Colonia="
					+ order_Colonia + ", order_Zip=" + order_Zip + ", order_Alcaldia=" + order_Alcaldia
					+ ", order_Phone=" + order_Phone + ", order_Instruction=" + order_Instruction
					+ ", products_idproducts=" + products_idproducts + "]";
		}
		
		
		
}

