package com.nicolascruz.eletroniclist.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nicolascruz.eletroniclist.domain.Usuario;

public class UsuarioModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String cpf;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataNascimento;
	public Long getId() {
		return id;
	}
	public UsuarioModel() {
		
	}
	public UsuarioModel(Usuario usuario) {
		this.id = usuario.getId();
		this.cpf = usuario.getCpf();
		this.nome = usuario.getNome();
		this.dataNascimento = usuario.getDataNascimento();
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
