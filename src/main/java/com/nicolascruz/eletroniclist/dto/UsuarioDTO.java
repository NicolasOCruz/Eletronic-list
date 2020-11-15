package com.nicolascruz.eletroniclist.dto;


import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nicolascruz.eletroniclist.domain.Usuario;	


public class UsuarioDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty(message="Nome é obrigatório")
	private String nome;
	
	@NotEmpty(message="CPF é obrigatório")
	private String cpf;
	
	@NotEmpty(message="Data de nascimento é obrigatória")
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataNascimento;
	
	public UsuarioDTO() {
		
	}
	public UsuarioDTO(Usuario usuario) {
		this.nome = usuario.getNome();
		this.cpf = usuario.getCpf();
		this.dataNascimento = usuario.getDataNascimento();
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
