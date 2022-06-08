package com.api.rest.pedido.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.pedido.model.Categoria;
import com.api.rest.pedido.repositories.CategoriaRepository;
import com.api.rest.pedido.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repositorio;
	
	public Categoria buscarCategoria(Integer idCategoria) {
		Optional<Categoria> categoria = repositorio.findById(idCategoria);
		
		return categoria.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + idCategoria	+ ", Tipo: " + Categoria.class.getName()));
	}

}
