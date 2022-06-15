package com.api.rest.pedido.enums;

public enum EstadoPagamento {
	
	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");

	private Integer codigo;
	private String descricao;
	
	private EstadoPagamento(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	//Operação que recebe um código e retorna um objeto TipoCliente já instânciado
	public static EstadoPagamento  converteInteiroParaEnum(Integer codigo) {
		
		if (codigo == null) {
			return null;
		}
		
		for (EstadoPagamento elemento : EstadoPagamento.values()) {
			if (codigo.equals(elemento.getCodigo())) {
				return elemento;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
}
