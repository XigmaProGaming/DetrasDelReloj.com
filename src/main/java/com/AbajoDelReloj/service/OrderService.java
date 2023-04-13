package com.AbajoDelReloj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AbajoDelReloj.model.Order;

import com.AbajoDelReloj.repository.OrderRepository;


//Le indicamos al application context 
@Service
public class OrderService {

	
	/*
 	Inyeccion de dependencias:
 	1. Que voy a relacionar
 	2. Como lo voy a relacionar - con el autowired
 	3. Cuando lo voy a utilizar - cuando se 
 */

	//Primero declaro una variable del tipo UsuarioRepository
	
	//Se crea un nuevo objeto usuario repository sin usar el new
	private final OrderRepository orderRepository;
	

	@Autowired
	
	//Uso ese objeto como parametro de mi constructor
	public OrderService (OrderRepository orderRepository) {
		this.orderRepository= orderRepository;
	}//constructor con la dependencia inyectada como parametro
	
	//Logica de nuestro negocio
	
	//Crear ordenes (Create)
	
	//Leer ordenes (Read)
	
	public List<Order> leerOrders(){
		System.out.println("leerOrders");
		return orderRepository.findAll(); //regresa una lista de platillos con un metodo que viene del JPA
	}
	
	//Leer una orden (Read)
	
	public Order leerOrder(Long Id) {
		return orderRepository.findById(Id).orElseThrow(()-> new IllegalStateException("La orden con el id " + Id + " no existe.") );
	}
	
	//Actualizar ordenes (Update)
	
	//Borrar orden (Delete)
	
	
	
}//Fin de clase
