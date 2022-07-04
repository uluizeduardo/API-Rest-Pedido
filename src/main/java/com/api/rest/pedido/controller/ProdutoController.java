	package com.api.rest.pedido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.pedido.dtos.ProdutoDTO;
import com.api.rest.pedido.services.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProdutoDTO> buscarProduto(@PathVariable Integer id) {
		
		ProdutoDTO produtoDTO = new ProdutoDTO(produtoService.buscarProduto(id));
		return ResponseEntity.ok().body(produtoDTO);
	}
}
