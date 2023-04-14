package com.AbajoDelReloj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AbajoDelReloj.model.Order;
import com.AbajoDelReloj.service.OrderService;


@RestController
@RequestMapping(path = "/abdr/ordenes/")	
public class OrderController {

	//Instancia del servicio
	//Inyeccion de dependencias
	
	private final OrderService orderService;


	//Constructor que usa el objeto UsuarioService como parametro
	
	@Autowired	//Anotacion para relacionar e inyectar dependencia
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	
	//Solicitudes HTTP para traer todos los productos
	
	//GET platillo
	@GetMapping 
	public List<Order> getOrders(){
		System.out.println("getOrders");
		return orderService.leerOrders();
	}//get
	
	
	//Solicitud HTTP para traer un producto por si Id
	@GetMapping(path="{Id}")
	//Con @PathVariable le decimos a nuestro metodo que la ruta que va a cambiar es el id,
	//con el tipo de dato Long
	public Order getOrder(@PathVariable("Id")Long id_Order) {
		System.out.println("getOrder con id");
		return orderService.leerOrder(id_Order);
	}
	

	//Solicitud HTTP POST para crear un usuario
	//POST usuario
	@PostMapping
	//Indicamos que los valores de los parametros se obtienen desde el Request Body
	//Los datos que pasemos como cuerpo de nuestra solicitud, seran utlizados como campos de nuestro constructor
	public void postOrder(@RequestBody Order order) {
		orderService.crearOrder(order); 	//Disparamos la operacion del CRUD que modifica la base da datos
	}//Post
	
	//Solicitud HTTP DELETE para eliminar un usuario
	//DELETE usuario
	@DeleteMapping(path="{Id}")
	public void deletePlatillo(@PathVariable("Id")Long id_Order) {
		orderService.borrarOrder(id_Order);
	}//Delete
	
}
