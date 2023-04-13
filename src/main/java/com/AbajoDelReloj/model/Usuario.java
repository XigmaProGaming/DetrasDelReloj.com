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
@Table(name="seller")

public class Usuario {

	@Id //especificamos que nuestra llave primaria es el campo id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Indicamos a JAVA que vamos a utilizar una estrategia de generacion
														//de valores de indentidad de la base de datos (para generar valores
														//unicos e incrementables para nuestras llaves primarias)
	
	/*
		Especificamos que el campo donde se aplica la estrategia de generacion de valores autoincremetables es
		una columa llamada id, unica y no nula
	 */
	@Column(name="idseller", unique=true, nullable=false)
	
	//Atributos
	private Long IdUsers;		//class wrapper
	//@column name
	private String name;
	//@columna last_name
	private String last_name;
	//@column user_name
	private String username;
	//@column correo
	private String email;
	//@column user_name
	private String password;
	//@column precion
	private Long telephone;	//o double?

	//Constructor vacio
	public Usuario() {
		
	}//constructor vacio
	
	
	//Constructores
	public Usuario(Long idUsers, String name, String last_name, String username, String email, String password, Long telephone) {
		this.IdUsers = idUsers;
		this.name = name;
		this.last_name = last_name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
	}


	//Getters y Setters
	public Long getIdUsers() {
		return IdUsers;
	}


	public void setIdUsers(Long idUsers) {
		IdUsers = idUsers;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getCorreo() {
		return email;
	}


	public void setCorreo(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Long getTelephone() {
		return telephone;
	}


	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}

	//toString

	@Override
	public String toString() {
		return "Usuario [IdUsers=" + IdUsers + ", name=" + name + ", last_name=" + last_name + ", username="
				+ username + ", email=" + email + ", password=" + password + ", telephone=" + telephone + "]";
	}
	
}
