package com.api.rest.pedido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.api.rest.pedido.dtos.PedidoDTO;
import com.api.rest.pedido.model.Pedido;
import com.api.rest.pedido.services.PedidoService;

@Controller
@RequestMapping(value = "/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PedidoDTO> buscarPedido(@PathVariable Integer id){
		
		PedidoDTO pedidoDTO = new PedidoDTO(pedidoService.buscarPedido(id));
		return ResponseEntity.ok().body(pedidoDTO);
	}
}
