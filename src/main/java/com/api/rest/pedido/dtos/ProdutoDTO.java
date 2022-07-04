package com.api.rest.pedido.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.api.rest.pedido.model.Categoria;
import com.api.rest.pedido.model.ItemPedido;
import com.api.rest.pedido.model.Pedido;
import com.api.rest.pedido.model.Produto;

public class ProdutoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Double preco;
	
	private List<Categoria> categorias = new ArrayList<>();
	
	private Set<ItemPedido> itens = new HashSet<>();

	public ProdutoDTO() {
		
	}

	public ProdutoDTO(Produto produto) {
		super();
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.preco = produto.getPreco();
		this.categorias = produto.getCategorias();
		this.itens = produto.getItens();
	}
	
	//Método responsável por listar todos os pedidos 
	public List<Pedido> getPedidos (){
		List<Pedido> listaDePedidos = new ArrayList<>();
		
		for (ItemPedido itemPedido : itens) {
			listaDePedidos.add(itemPedido.getPedido());
		}
		return listaDePedidos;
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}

}
