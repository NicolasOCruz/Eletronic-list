package com.nicolascruz.eletroniclist.domain;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.nicolascruz.eletroniclist.enums.Status;

@Entity
public class Treinamento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private OffsetDateTime dataInicio;
	private OffsetDateTime dataFinalizacao;
	private String tema;
	private String descricao;
	private Usuario treinador;
	private Status status;
	
	@OneToMany(mappedBy="id.treinamento")
	private Set<Presenca> presencas = new HashSet<>();
	
	public Treinamento() {
		
	}
	
	public Treinamento(Long id, OffsetDateTime dataInicio, OffsetDateTime dataFinalizacao, String tema,
			String descricao, Usuario treinador, Status status) {
		super();
		this.id = id;
		this.dataInicio = dataInicio;
		this.dataFinalizacao = dataFinalizacao;
		this.tema = tema;
		this.descricao = descricao;
		this.treinador = treinador;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OffsetDateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(OffsetDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	public OffsetDateTime getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(OffsetDateTime dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Usuario getTreinador() {
		return treinador;
	}

	public void setTreinador(Usuario treinador) {
		this.treinador = treinador;
	}
	
	public Set<Presenca> getPresencas() {
		return presencas;
	}

	public void setPresencas(Set<Presenca> presencas) {
		this.presencas = presencas;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Treinamento other = (Treinamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
