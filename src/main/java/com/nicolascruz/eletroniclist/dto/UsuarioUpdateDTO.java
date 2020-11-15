package com.nicolascruz.eletroniclist.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nicolascruz.eletroniclist.domain.Usuario;

public class UsuarioUpdateDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty(message="Nome é obrigatório")
	private String nome;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@NotEmpty(message="Data de nascimento obrigatória")
	private Date dataNascimento;
	
	
	public UsuarioUpdateDTO() {
		
	}
	
	public UsuarioUpdateDTO(Usuario user) {
		UsuarioUpdateDTO usuario = new UsuarioUpdateDTO();
		usuario.setDataNascimento(user.getDataNascimento());
		usuario.setId(user.getId());
		usuario.setNome(user.getNome());
	}

	public Long getId() {
		return id;
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
