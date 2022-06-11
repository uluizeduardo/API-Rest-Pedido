package com.api.rest.pedido.enums;

public enum TipoCliente {
	
	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private int cod;
	private String descricao;
	
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}
	
	public String getDesString() {
		return descricao;
	}
	
	//Operação que recebe um código e retorna um objeto TipoCliente já instânciado
	public static TipoCliente converteInteiroParaEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for (TipoCliente elemento : TipoCliente.values()) {
			if(cod.equals(elemento.getCod())){
				return elemento;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
