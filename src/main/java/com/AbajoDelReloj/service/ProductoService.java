package com.AbajoDelReloj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AbajoDelReloj.model.Producto;
import com.AbajoDelReloj.repository.ProductoRepository;

// Le indicamos al Application COntext que esta clase es un Servicio

@Service
public class ProductoService {
	private final ProductoRepository productoRepository;
	
	// Creamos un cable para conectar entidades (ProductoRepository - ProductoService
	@Autowired	
	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}	
	
	//Create product (Create)
	public void crearProducto(Producto producto) {
		//We need to know if the product already exist, If is true, we save it in at optional
		Optional<Producto> productoBuscado =
				productoRepository.findByName(producto.getName());
		
		if(productoBuscado.isPresent()) {
			throw new IllegalStateException("El producto con el nombre "+producto.getName()+" ya existe.");
		}else {
			productoRepository.save(producto);
		}
	}
	
	//Leer platillo (Read)
	public List<Producto> leerProducto(){ //
		return productoRepository.findAll();
	}
	
	public Producto leerProducto(Long Id) {
		return productoRepository.findById(Id).orElseThrow(()-> new IllegalStateException("El Producto " + "con el id " + Id + " no existe.") );
	}// leer platillo
	
	// ActualizarProducto
	public void actualizarProducto(Long Id, String name, String description, String brand, Double price, Long inventory, String state, Long sku, String visibility,Long id_category, Long id_seller) {
		// We define if the product already exists , so we modify it
		if(productoRepository.existsById(Id)) {
			// Then I will modify it
			Producto productoABuscar = productoRepository.getById(Id);
			
			if(name != null) productoABuscar.setName(name);
			if(description != null) productoABuscar.setDescription(description);
			if(brand != null) productoABuscar.setBrand(brand);
			if(price > 0) productoABuscar.setPrice(price);
			if(inventory > 0 && inventory != null) productoABuscar.setInventory(inventory);
			if(state != null) productoABuscar.setState(state);
			if(sku > 0 && sku != null) productoABuscar.setSku(sku);
			if(visibility != null) productoABuscar.setVisibility(visibility);			
			
			
			productoRepository.save(productoABuscar);
		}else {
			System.out.println("El producto con el id "+Id+" no existe");
		}
	}
	
	// Borrar producto (DELETE)
	
	public void borrarProducto(Long Id) {
		if(productoRepository.existsById(Id)) {
			productoRepository.deleteById(Id);
		}
	}
	
}