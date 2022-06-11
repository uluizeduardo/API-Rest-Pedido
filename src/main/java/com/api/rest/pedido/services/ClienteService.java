package com.api.rest.pedido.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.pedido.model.Cliente;
import com.api.rest.pedido.repositories.ClienteRepository;
import com.api.rest.pedido.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repositorio;
	
	public Cliente buscarCliente(Integer idCliente) {
		Optional<Cliente> categoria = repositorio.findById(idCliente);
		
		return categoria.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + idCliente	+ ", Tipo: " + Cliente.class.getName()));
	}

}
