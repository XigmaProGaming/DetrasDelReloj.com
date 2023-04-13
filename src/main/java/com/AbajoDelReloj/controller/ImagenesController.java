package com.AbajoDelReloj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AbajoDelReloj.model.Imagenes;
import com.AbajoDelReloj.service.ImagenesService;

//No se utiliza cuando se trabaja en la nube, solo se usa para pruebas locales
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
//Controlador que soporta metodos HTTP
@RestController
@RequestMapping(path = "/abdr/imagenes/")	

public class ImagenesController {

	private final ImagenesService imagenesService;
	
	@Autowired	//Anotacion para relacionar e inyectar dependencia
	
	public ImagenesController(ImagenesService imagenesService) {
		this.imagenesService=imagenesService;
	}//constructor
	
	//Solicitudes HTTP para traer todos los productos
	
	//GET platillo
	@GetMapping 
	public List<Imagenes> getImagenes(){
		return imagenesService.leerImagenes();
	}//get
	
	
	//Solicitud HTTP para traer un producto por si Id
	@GetMapping(path="{Id}")
	//Con @PathVariable le decimos a nuestro metodo que la ruta que va a cambiar es el id,
	//con el tipo de dato Long
	public Imagenes getImagen(@PathVariable("Id")Long Id) {
		return imagenesService.leerImagene(Id);
	}
	
	

	//Solicitud HTTP POST para crear un usuario
	//POST usuario
	@PostMapping
	//Indicamos que los valores de los parametros se obtienen desde el Request Body
	//Los datos que pasemos como cuerpo de nuestra solicitud, seran utlizados como campos de nuestro constructor
	public void postImagen(@RequestBody Imagenes imagen) {
		imagenesService.crearImagen(imagen); 	//Disparamos la operacion del CRUD que modifica la base da datos
	}//Post

	
	

	//Solicitud HTTP PUT para modificar un usuario
	//PUT usuario
	@PutMapping(path="{Id}")
	//(Long Id, String name, String last_name, Long telephone, String password)
	public void updateUsuario(@PathVariable("Id")Long Id,
			@RequestParam (required = false) String name) {
		//Aqui abajo si importa el orden (en el constructor)
		imagenesService.actualizarImagen(Id, name);
	}//Put
	 
	
	//Solicitud HTTP DELETE para eliminar un usuario
	//DELETE usuario
	@DeleteMapping(path="{Id}")
	public void deletePlatillo(@PathVariable("Id")Long Id) {
		imagenesService.borrarImagen(Id);
	}//Delete
}