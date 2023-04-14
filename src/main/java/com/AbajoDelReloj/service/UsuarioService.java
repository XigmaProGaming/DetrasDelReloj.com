package com.AbajoDelReloj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AbajoDelReloj.model.Usuario;
import com.AbajoDelReloj.repository.UsuarioRepository;




//Le indicamos al application context 
@Service


public class UsuarioService {
	
	/*
 	Inyeccion de dependencias:
 	1. Que voy a relacionar
 	2. Como lo voy a relacionar - con el autowired
 	3. Cuando lo voy a utilizar - cuando se 
 */

	//Primero declaro una variable del tipo UsuarioRepository
	
	//Se crea un nuevo objeto usuario repository sin usar el new
	private final UsuarioRepository usuarioRepository;
	
	@Autowired
	
	//Uso ese objeto como parametro de mi constructor
	public UsuarioService (UsuarioRepository usuarioRepository) {
		this.usuarioRepository= usuarioRepository;
	}//constructor con la dependencia inyectada como parametro
	
	//Logica de nuestro negocio
	
	//Operaciones del CRUD
	
	//Crear usuarios (Create)
	public void crearUsuario(Usuario usuario) {
		//Necesitamos saber si el producto buscado existe
		//Almacenamos el dato en una variable platilloBuscando (variable temporal) como un filtro para no pasarlo directamente
		
	 	//1. Guardamos el dato en un Optional (true or false)
	 	//2. Si hay algo en el Optional(.isPresent()), mostrarmos un error
		
		Optional<Usuario> usuarioBuscado = 
				usuarioRepository.findByName(usuario.getUsername());
		if(usuarioBuscado.isPresent()) {	//Si el Optional contiene un objeto almecando, mostramos un error
			throw new IllegalStateException("El usuario con el nombre " + usuario.getName() + " ya existe.");
		} else {	//Si el Optional esta vacio, se guarda el platillo en mi base da datos usando el repository como interfaz
		 usuarioRepository.save(usuario);
		}
		//Si no existe, lo guardamos en la base de datos
	}
	
	
	//Leer usuarios (Read)
	
	public List<Usuario> leerUsuarios(){
		
		return usuarioRepository.findAll(); //regresa una lista de platillos con un metodo que viene del JPA
	}
	
	//Leer un platillo (Read)
	public Usuario leerUsuario(Long id_seller) {
		return usuarioRepository.findById(id_seller).orElseThrow(()-> new IllegalStateException("El Producto " + "con el id " + id_seller + " no existe.") );
	}
	
	//Actualizar usuarios (Upadte)
	//Necesitamos pasar todos los parametros, para contemplra todas las modificaciones posibles
		public void actualizarUsuario(Long id_seller, String name, String last_name, Long telephone, String password) {
			//Si existe el producto -> se modifica
			if(usuarioRepository.existsById(id_seller)) {
				Usuario usuarioABuscar = usuarioRepository.getById(id_seller);
				if (name!=null) usuarioABuscar.setName(name);
				if (last_name!=null) usuarioABuscar.setLast_name(last_name);
				if (telephone!=null) usuarioABuscar.setTelephone(telephone);
				if (password!=null) usuarioABuscar.setPassword(password);
				
				//Cuando terminamos de editar el objeto, guardamos la entidad en el id correspondiente
				usuarioRepository.save(usuarioABuscar);
			} else {
				System.out.println("El usuario con el Id: " + id_seller + " no existe.");
			}
			//Si no existe el producto -> no podemos modificar nada
		}
	
	 
	//Borrar usuario (Delete)
		public void borrarUsuario(Long id_seller) {
			//Buscamos un platillo por id, y si existe lo borramos por Id
			if(usuarioRepository.existsById(id_seller)) {
				//Metodo para borrar el elemento por id
				usuarioRepository.deleteById(id_seller);
			}else {
				System.out.println("El usuario con el Id: " + id_seller + " no existe.");
			}
			
		}
}//Fin de clase
