package com.api.rest.pedido.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.pedido.model.Categoria;
import com.api.rest.pedido.model.Pedido;
import com.api.rest.pedido.repositories.PedidoRepository;
import com.api.rest.pedido.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido buscarPedido(Integer idPedido) {
		Optional<Pedido> pedido = pedidoRepository.findById(idPedido);
		
		return pedido.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + idPedido	+ ", Tipo: " + Categoria.class.getName()));
	}
}
