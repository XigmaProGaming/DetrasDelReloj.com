package com.AbajoDelReloj.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AbajoDelReloj.model.Imagenes;


public interface ImagenesRepository extends JpaRepository<Imagenes, Long>{
	
	//Query personalizada
	//	La anotacion @Query indica que vamos a utilizar una consulta personalizada en lugar de 
	//	un metodo ya especificado del JPA Repository usando JPQL
	
	//Metodo que realiza la consulta eprsonalizada definida anteriormente.
	//Retorna un Optional1 que puede contener un objete Platillo si se encuentra en la bas de datos
	//(Tiene que ser con el nombre especificado o un Optional vacio si no existe)
	@Query("SELECT imagen FROM Imagenes imagen WHERE imagen.image_Name=?1")	//Alia "p" ?1 = primer parametro como arguemnto de la consulta
	
	// 	"p" es un alias para especificar que despues de la palabra FROM en esta consulta, hacemos referencia a
	// 	un objeto dentro de esa tabla
	 
	Optional<Imagenes> findByName(String image_Name);

}