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

import com.AbajoDelReloj.model.Usuario;
import com.AbajoDelReloj.service.UsuarioService;

//No se utiliza cuando se trabaja en la nube, solo se usa para pruebas locales
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})

//Controlador que soporta metodos HTTP
@RestController
@RequestMapping(path = "/abdr/usuarios/")	//No se agrega el inicio del url para que sea dinamico y no dependa que se escriba el dominio
											//Se indica la ruta del endpoint para saber a donde se van a manejar esas solicitudes HTTP
public class UsuarioController {
	
		//Instancia del servicio
		//Inyeccion de dependencias
		
		private final UsuarioService usuarioService;
		
		//Constructor que usa el objeto UsuarioService como parametro
		
		@Autowired	//Anotacion para relacionar e inyectar dependencia
		
		public UsuarioController(UsuarioService usuarioService) {
			this.usuarioService=usuarioService;
		}//constructor
		
		//Solicitudes HTTP para traer todos los productos
		
		//GET platillo
		@GetMapping 
		public List<Usuario> getUsuario(){
			return usuarioService.leerUsuarios();
		}//get
		
		
		//Solicitud HTTP para traer un producto por si Id
		@GetMapping(path="{Id}")
		//Con @PathVariable le decimos a nuestro metodo que la ruta que va a cambiar es el id,
		//con el tipo de dato Long
		public Usuario getUusario(@PathVariable("Id")Long Id) {
			return usuarioService.leerUsuario(Id);
		}
		
		

		//Solicitud HTTP POST para crear un usuario
		//POST usuario
		@PostMapping
		//Indicamos que los valores de los parametros se obtienen desde el Request Body
		//Los datos que pasemos como cuerpo de nuestra solicitud, seran utlizados como campos de nuestro constructor
		public void postUsuario(@RequestBody Usuario usuario) {
			usuarioService.crearUsuario(usuario);; 	//Disparamos la operacion del CRUD que modifica la base da datos
		}//Post

		
		

		//Solicitud HTTP PUT para modificar un usuario
		//PUT usuario
		@PutMapping(path="{Id}")
		//(Long Id, String name, String last_name, Long telephone, String password)
		public void updateUsuario(@PathVariable("Id")Long Id,
				@RequestParam (required = false) String name,
				@RequestParam (required = false) String last_name,
				@RequestParam (required = false) Long telephone,
				@RequestParam (required = false) String password) {
			//Aqui abajo si importa el orden (en el constructor)
			usuarioService.actualizarUsuario(Id, name, last_name, telephone, password);
		}//Put
		 
		
		//Solicitud HTTP DELETE para eliminar un usuario
		//DELETE usuario
		@DeleteMapping(path="{Id}")
		public void deletePlatillo(@PathVariable("Id")Long Id) {
			usuarioService.borrarUsuario(Id);
		}//Delete
}
