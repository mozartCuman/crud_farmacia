package com.crud_farmacia.crud_farmacia.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produtos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_produto;
	
	@NotBlank(message = "Por favor digite o nome do produto:")
	@Size(max = 257)
	private String nomeProduto;
	
	@NotBlank
	private Float preco;
	//TODO usar o método long ou Bigdécimal posteriormente.
	
	@NotBlank(message = "Digite a quantidade de Produtos:")
	private byte quantidade;
	
	@ManyToOne
	@JoinColumn(name = "id_categorias")
	@JsonIgnoreProperties("produtos")
	private Categorias categorias;

	public Long getId_produto() {
		return id_produto;
	}

	public void setId_produto(Long id_produto) {
		this.id_produto = id_produto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public byte getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(byte quantidade) {
		this.quantidade = quantidade;
	}

}
