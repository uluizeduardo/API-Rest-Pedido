package com.api.rest.pedido.controller.exception;

import java.io.Serializable;

public class ErroPadrao  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer status;
	private String mensagem;
	private Long horaDoErro;
	
	public ErroPadrao(Integer status, String mensagem, Long horaDoErro) {
		super();
		this.status = status;
		this.mensagem = mensagem;
		this.horaDoErro = horaDoErro;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Long getHoraDoErro() {
		return horaDoErro;
	}

	public void setHoraDoErro(Long horaDoErro) {
		this.horaDoErro = horaDoErro;
	}
	
}
