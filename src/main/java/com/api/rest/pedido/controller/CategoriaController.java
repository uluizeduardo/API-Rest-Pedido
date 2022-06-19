package com.api.rest.pedido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.pedido.dtos.CategoriaDTO;
import com.api.rest.pedido.model.Categoria;
import com.api.rest.pedido.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<CategoriaDTO> buscarCategoria(@PathVariable Integer id) {
		
		CategoriaDTO categoriaDTO = new CategoriaDTO(categoriaService.buscarCategoria(id));
		return ResponseEntity.ok().body(categoriaDTO);
	}
}
