package com.algaworks.logapi.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

public class Problem {
	
	private Integer status;
	private LocalDateTime dataHota;
	private String titulo;
	private List<Campo> campos;
	
	public static class Campo {
		
		private String nome;
		private String mensagem;
		
		public Campo(String nome, String msg) {
			this.nome = nome;
			mensagem = msg;
		}
		
		public String getNome() {
			return nome;
		}
		
		public String getMensagem() {
			return mensagem;
		}
	}
	
	public List<Campo> getCampos() {
		return campos;
	}
	
	public void setCampos(List<Campo> campos) {
		this.campos = campos;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public LocalDateTime getDataHota() {
		return dataHota;
	}
	public void setDataHota(LocalDateTime dataHota) {
		this.dataHota = dataHota;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
