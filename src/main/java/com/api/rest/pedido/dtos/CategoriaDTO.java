package com.api.rest.pedido.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.api.rest.pedido.model.Categoria;
import com.api.rest.pedido.model.Produto;

public class CategoriaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;

	private List<Produto> produtos = new ArrayList<>();

	public CategoriaDTO() {
		super();
	}
	
	public CategoriaDTO(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
		this.produtos = categoria.getProdutos();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
}
