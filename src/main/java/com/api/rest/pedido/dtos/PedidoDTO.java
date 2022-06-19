package com.api.rest.pedido.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.api.rest.pedido.model.Cliente;
import com.api.rest.pedido.model.Endereco;
import com.api.rest.pedido.model.ItemPedido;
import com.api.rest.pedido.model.Pagamento;
import com.api.rest.pedido.model.Pedido;

public class PedidoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date instante;
	private Pagamento pagamento;
	private Cliente cliente;
	private Endereco enderecoDeEntrega;
	private Set<ItemPedido> itens = new HashSet<>();
	
	public PedidoDTO() {
		super();
	}

	public PedidoDTO(Pedido pedido) {
		super();
		this.id = pedido.getId();
		this.instante = pedido.getInstante();
		this.pagamento = pedido.getPagamento();
		this.cliente = pedido.getCliente();
		this.enderecoDeEntrega = pedido.getEnderecoDeEntrega();
		this.itens = pedido.getItens();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEnderecoDeEntrega() {
		return enderecoDeEntrega;
	}

	public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
		this.enderecoDeEntrega = enderecoDeEntrega;
	}

	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}
	
}
