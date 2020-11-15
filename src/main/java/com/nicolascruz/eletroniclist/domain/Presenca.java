package com.nicolascruz.eletroniclist.domain;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Presenca implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId //atributo composto, que é baseado em outra classe
	private PresencaPK id = new PresencaPK();
	
	private OffsetDateTime dataMarcacao;
	
	public Presenca() {
		
	}

	public Presenca(Treinamento treinamento, Usuario usuario, OffsetDateTime dataMarcacao) {
		super();
		id.setTreinamento(treinamento);
		id.setUsuario(usuario);
		this.dataMarcacao = dataMarcacao;
	}
	
	public Treinamento getTreinamento() {
		return this.id.getTreinamento();
	}
	
	public Usuario getUsuario() {
		return this.id.getUsuario();
	}

	public PresencaPK getId() {
		return id;
	}

	public void setId(PresencaPK id) {
		this.id = id;
	}

	public OffsetDateTime getDataMarcacao() {
		return dataMarcacao;
	}

	public void setDataMarcacao(OffsetDateTime dataMarcacao) {
		this.dataMarcacao = dataMarcacao;
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
		Presenca other = (Presenca) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
