package com.AbajoDelReloj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AbajoDelReloj.model.Producto;
import com.AbajoDelReloj.service.ProductoService;


@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,RequestMethod.PUT})
@RestController // anotacion para indicar que esta clase es un controlador

@RequestMapping(path = "/abdr/productos/") //indica la ruta de nuestro endpoint par saber a donde se van a manejar esas solicitudes HTTP

public class ProductoController {
	
	//Inyeccion de dependencias 
	private final ProductoService productoService;
	
	@Autowired
	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}
	
	@GetMapping
	public List<Producto> getProducto(){
		return productoService.leerProducto();
	}
	
	// Solicitu HTTP para traer todos los productos
	@GetMapping(path = "{Id}")
	public Producto getProducto(@PathVariable("Id")Long Id) {
		return productoService.leerProducto(Id);
	}
	
	// Solicitud HTTP POST para crear un producto
	@PostMapping
	public void postProducto(@RequestBody Producto producto) {
		productoService.crearProducto(producto);
	}
	
	//Solicitud HTTP PUT para modificar un platillo
	@PutMapping(path="{Id}")
	public void updateProducto(@PathVariable("Id")Long Id,
				@RequestParam (required = false) String name,
				@RequestParam (required = false) String description,
				@RequestParam (required = false) String brand,
				@RequestParam (required = false) Double price,
				@RequestParam (required = false) String publication_Date,
				@RequestParam (required = false) Long inventory,
				@RequestParam (required = false) String state,
				@RequestParam (required = false) Long sku,
				@RequestParam (required = false) String visibility,	
				@RequestParam (required = false) Long productcategories_id_category,
				@RequestParam (required = false) Long seller_id_seller
				) {
		productoService.actualizarProducto(Id, name, description, brand, price, publication_Date,inventory, state, sku, visibility,productcategories_id_category,seller_id_seller);			
	}
	
	// Solicitud HTTP DELETE para borrar un producto
	@DeleteMapping(path="{Id}")
	public void deletePlatillo(@PathVariable("Id") Long Id) {
		productoService.borrarProducto(Id);
	}
}