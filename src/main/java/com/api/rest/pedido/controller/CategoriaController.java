package com.api.rest.pedido.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.pedido.model.CategoriaModel;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaController {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<CategoriaModel> listar() {
		
		CategoriaModel cat1 = new CategoriaModel(1, "Informática");
		CategoriaModel cat2 = new CategoriaModel(2, "Escritório");
		
		List<CategoriaModel> lista = new ArrayList<>();
		
		lista.add(cat1);
		lista.add(cat2);
		
		return lista;
	}
}
