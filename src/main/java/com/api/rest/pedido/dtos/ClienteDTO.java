package com.api.rest.pedido.dtos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.api.rest.pedido.enums.TipoCliente;
import com.api.rest.pedido.model.Cliente;
import com.api.rest.pedido.model.Endereco;
import com.api.rest.pedido.model.Pedido;

public class ClienteDTO {
	
	private Integer id;
	private String nome;
	private String email;
	private String cpfOuCnpj;
	private TipoCliente tipo;
	
	private List<Pedido> pedidos = new ArrayList<>();
	
	private List<Endereco> enderecos = new ArrayList<>();
	
	private Set<String> telefones = new HashSet<>();

	public ClienteDTO() {
		super();
	}

	public ClienteDTO(Cliente cliente) {
		super();
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		this.cpfOuCnpj = cliente.getCpfOuCnpj();
		this.tipo = cliente.getTipo();
		this.pedidos = cliente.getPedidos();
		this.enderecos = cliente.getEnderecos();
		this.telefones = cliente.getTelefones();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public TipoCliente getTipo() {
		return tipo;
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}
	
}
