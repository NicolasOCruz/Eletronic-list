package com.nicolascruz.eletroniclist.enums;

public enum Perfil {
	
	ADMIN(1, "ROLE_ADMIN"),
	TREINADOR(2, "ROLE_TREINADOR"),
	CONSULTOR(3, "ROLE_CONSULTOR");
	
	private int cod;
	private String descricao;
	
	private Perfil(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao () {
		return descricao;
	}
	
	public static Perfil toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (Perfil x : Perfil.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}
