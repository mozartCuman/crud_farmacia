package com.crud_farmacia.crud_farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.crud_farmacia.crud_farmacia.model.Produtos;


public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
	
	public List <Produtos> findAllByNomeProdutoContainingIgnoreCase(@Param("nomeProduto") String produtos);
}
