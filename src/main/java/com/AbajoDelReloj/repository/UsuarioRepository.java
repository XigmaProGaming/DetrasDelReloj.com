package com.AbajoDelReloj.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AbajoDelReloj.model.Usuario;
//Se necesita crear una interface para comunicar entre la clase de java y una base da datos
//Indicamos que extendemos (heredamos) de la interface JpaRepository, porque vamos a manejar
//la entidada llamada 'Platillo' y la vamos a relacionar ocn una base de datos en MySQL llamada
//de la misma forma.

/*
Cuando heredamos del JpaRepository, usamos los metodos definidos anteriormente, pasando como
atributo o parametro el tipo de dato sobre el que hacemos la consulta, y su referencia en la
base de datos (primary key)
*/
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	//Query personalizada
	//	La anotacion @Query indica que vamos a utilizar una consulta personalizada en lugar de 
	//	un metodo ya especificado del JPA Repository usando JPQL
	
	//Metodo que realiza la consulta eprsonalizada definida anteriormente.
	//Retorna un Optional1 que puede contener un objete Platillo si se encuentra en la bas de datos
	//(Tiene que ser con el nombre especificado o un Optional vacio si no existe)
	@Query("SELECT usuario FROM Usuario usuario WHERE usuario.username=?1")	//Alia "p" ?1 = primer parametro como arguemnto de la consulta
	
	// 	"p" es un alias para especificar que despues de la palabra FROM en esta consulta, hacemos referencia a
	// 	un objeto dentro de esa tabla
	 
	Optional<Usuario> findByName(String nombre);

}
