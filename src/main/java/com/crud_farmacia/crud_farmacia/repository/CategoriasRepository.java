package com.crud_farmacia.crud_farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.crud_farmacia.crud_farmacia.model.Categorias;
//import com.crud_farmacia.crud_farmacia.model.Produtos;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long>  {
	public List <Categorias> findAllByNameContainingIgnoreCase(@Param("name") String categorias);
	
	//public List <Produtos> findByCategoriaId(@Param("id") Long categoriaId); 
}
