package com.nicolascruz.eletroniclist.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nicolascruz.eletroniclist.domain.Usuario;
import com.nicolascruz.eletroniclist.dto.UsuarioDTO;
import com.nicolascruz.eletroniclist.dto.UsuarioUpdateDTO;
import com.nicolascruz.eletroniclist.model.UsuarioModel;
import com.nicolascruz.eletroniclist.repository.UsuarioRepository;
import com.nicolascruz.eletroniclist.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping("/criar")
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioModel criar(@Valid @RequestBody UsuarioDTO user) {
		Usuario usuario = fromDTO(user);
		return toModel(usuarioService.salvar(usuario));
	}
	
	@PutMapping("/atualizar/{usuarioId}")
	public ResponseEntity<UsuarioModel> editar(@Valid @RequestBody UsuarioUpdateDTO user, @PathVariable Long usuarioId) {
		if(!usuarioRepository.existsById(usuarioId)) {
			return ResponseEntity.notFound().build();
		}
		Usuario usuario = usuarioService.fromDTO(user);
		usuario.setId(usuarioId);
		usuario = usuarioService.atualizar(usuario);
		
		UsuarioModel uModel = toModel(usuario);
		return ResponseEntity.ok(uModel);
	}
	@GetMapping("/listar")
	public ResponseEntity<List<UsuarioModel>> listar(){
		List<Usuario> lista = usuarioRepository.findAll();
		List<UsuarioModel> listaModel = lista.stream().map(usuario -> new UsuarioModel(usuario)).collect(Collectors.toList());
		return ResponseEntity.ok(listaModel);
	}
	@GetMapping("/{usuarioId}")
	public ResponseEntity<UsuarioModel> buscar(@PathVariable Long usuarioId){
		Optional<Usuario> user = usuarioRepository.findById(usuarioId);
		if(user.isPresent()) {
			UsuarioModel model = toModel(user.get());
			return ResponseEntity.ok(model);
		} 
		return ResponseEntity.notFound().build();
	}

	private Usuario fromDTO(UsuarioDTO user) {
		Usuario usuario = new Usuario();
		usuario.setCpf(user.getCpf());
		usuario.setDataNascimento(user.getDataNascimento());
		usuario.setNome(user.getNome());
		usuario.setId(user.getId());
		return usuario;
	}
	private UsuarioModel toModel(Usuario user) {
		UsuarioModel usuario = new UsuarioModel();
		usuario.setCpf(user.getCpf());
		usuario.setDataNascimento(user.getDataNascimento());
		usuario.setNome(user.getNome());
		usuario.setId(user.getId());
		return usuario;
	}
}
