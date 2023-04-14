package com.AbajoDelReloj.service;

import java.util.List;
import java.util.Optional;

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
	public void crearOrder(Order order) {
		
		orderRepository.save(order);
	}
	
	//Leer ordenes (Read)
	
	public List<Order> leerOrders(){
		System.out.println("leerOrders");
		return orderRepository.findAll(); //regresa una lista de platillos con un metodo que viene del JPA
	}
	
	//Leer una orden (Read)
	
	public Order leerOrder(Long id_Order) {
		return orderRepository.findById(id_Order).orElseThrow(()-> new IllegalStateException("La orden con el id " + id_Order + " no existe.") );
	}
	
	//Actualizar ordenes (Update)
	
	//Borrar orden (Delete)
	public void borrarOrder(Long id_Order) {
		//Buscamos un platillo por id, y si existe lo borramos por Id
		if(orderRepository.existsById(id_Order)) {
			//Metodo para borrar el elemento por id
			orderRepository.deleteById(id_Order);
		}else {
			System.out.println("El usuario con el Id: " + id_Order + " no existe.");
		}
		
	}
	
	
}//Fin de clase
