package com.api.rest.pedido.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.pedido.model.Categoria;
import com.api.rest.pedido.model.Produto;
import com.api.rest.pedido.repositories.ProdutoRepository;
import com.api.rest.pedido.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto buscarProduto(Integer idProduto) {
		Optional<Produto> produto = produtoRepository.findById(idProduto);
		
		return produto.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + idProduto	+ ", Tipo: " + Categoria.class.getName()));
	}
}
