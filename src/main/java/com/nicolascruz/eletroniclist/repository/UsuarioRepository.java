package com.nicolascruz.eletroniclist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nicolascruz.eletroniclist.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public Usuario findByCpf(String cpf);

}
