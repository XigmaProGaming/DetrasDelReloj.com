package com.AbajoDelReloj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AbajoDelReloj.model.Imagenes;
import com.AbajoDelReloj.repository.ImagenesRepository;


@Service

public class ImagenesService {

	private final ImagenesRepository imagenesRepository;
	
	@Autowired
	
	//Uso ese objeto como parametro de mi constructor
		public ImagenesService (ImagenesRepository imagenesRepository) {
			this.imagenesRepository= imagenesRepository;
		}//constructor con la dependencia inyectada como parametro
	
	//Crear imagenes (Create)
		public void crearImagen(Imagenes imagen) {
			//Necesitamos saber si  existe
			//Almacenamos el dato en una variable (variable temporal) como un filtro para no pasarlo directamente
			
		 	//1. Guardamos el dato en un Optional (true or false)
		 	//2. Si hay algo en el Optional(.isPresent()), mostrarmos un error
			
			Optional<Imagenes> imagenBuscada = 
					imagenesRepository.findByName(imagen.getImageName());
			if(imagenBuscada.isPresent()) {	//Si el Optional contiene un objeto almecando, mostramos un error
				throw new IllegalStateException("La imagen con el nombre " + imagen.getImageName() + " ya existe.");
			} else {	//Si el Optional esta vacio, se guarda el platillo en mi base da datos usando el repository como interfaz
			 imagenesRepository.save(imagen);
			}
			//Si no existe, lo guardamos en la base de datos
		}
		

		//Leer imagenes (Read)
		
		public List<Imagenes> leerImagenes(){
			
			return imagenesRepository.findAll(); //regresa una lista de platillos con un metodo que viene del JPA
		}
		
		//Leer una imagen (Read)
		public Imagenes leerImagene(Long IdImage) {
			return imagenesRepository.findById(IdImage).orElseThrow(()-> new IllegalStateException("La imagen " + "con el id " + IdImage + " no existe.") );
		}
		
		//Actualizar usuarios (Upadte)
		//Necesitamos pasar todos los parametros, para contemplra todas las modificaciones posibles
			public void actualizarImagen(Long Id, String name) {
				//Si existe el producto -> se modifica
				if(imagenesRepository.existsById(Id)) {
					Imagenes imagenABuscar = imagenesRepository.getById(Id);
					if (name!=null) imagenABuscar.setImageName(name);
					
					
					//Cuando terminamos de editar el objeto, guardamos la entidad en el id correspondiente
					imagenesRepository.save(imagenABuscar);
				} else {
					System.out.println("El usuario con el Id: " + Id + " no existe.");
				}
				//Si no existe el producto -> no podemos modificar nada
			}
		
		 
		//Borrar usuario (Delete)
			public void borrarImagen(Long Id) {
				//Buscamos un platillo por id, y si existe lo borramos por Id
				if(imagenesRepository.existsById(Id)) {
					//Metodo para borrar el elemento por id
					imagenesRepository.deleteById(Id);
				}else {
					System.out.println("La imagen con el Id: " + Id + " no existe.");
				}
				
			}
	
}//cierre class