package com.nicolascruz.eletroniclist.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicolascruz.eletroniclist.domain.Usuario;
import com.nicolascruz.eletroniclist.dto.UsuarioUpdateDTO;
import com.nicolascruz.eletroniclist.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario salvar(Usuario user) {
		
		Usuario existente = usuarioRepository.findByCpf(user.getCpf());
		
		if(existente != null && !existente.equals(user)) {
			throw new RuntimeException("Já existe um usuário cadastrado nesse CPF");
		}
		user.setId(null);
		user = usuarioRepository.save(user);
		return user;
	}
	
	public Usuario atualizar(Usuario user) {
		Usuario u = usuarioRepository.findById(user.getId()).orElse(null);
		updateData(u, user);
		return usuarioRepository.save(u);
	}

	private void updateData(Usuario u, Usuario user) {
		u.setNome(user.getNome());
		u.setDataNascimento(user.getDataNascimento());
	}

	public Usuario fromDTO(@Valid UsuarioUpdateDTO user) {
		return new Usuario(user.getId(), user.getNome(), null, user.getDataNascimento(), null);
	}
}
