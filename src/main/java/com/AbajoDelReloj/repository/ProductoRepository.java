package com.AbajoDelReloj.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AbajoDelReloj.model.Producto;

// Indicamos que extendemos de la interface del JpaRepositoryu, porque vamos a manejar la entidad llamada Product y la vamos a relacionar con una BD en MySQL llamada de la misma forma

public interface ProductoRepository extends JpaRepository<Producto,Long>{
	
	@Query("SELECT producto FROM Producto producto WHERE producto.name=?1")
	Optional<Producto> findByName(String name);
}