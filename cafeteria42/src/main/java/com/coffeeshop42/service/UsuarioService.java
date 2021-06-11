package com.coffeeshop42.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.coffeeshop42.dto.LoginResponse;
import com.coffeeshop42.exception.ResourceNotFoundException;
import com.coffeeshop42.model.Usuario;
import com.coffeeshop42.repository.UsuarioRepository;
import com.coffeeshop42.security.JWTService;



@Service
public class UsuarioService {
	
	private static final String headerPrefix = "caffee ";

	@Autowired
	private UsuarioRepository repositorioUsuario;
	
	@Autowired
	private JWTService jwtService;
	
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEnconder;
	
	public List<Usuario> obterTodos() {
		return repositorioUsuario.findAll();
	}
	
	public Optional<Usuario> obterPorId(Long id) {
		return repositorioUsuario.findById(id);
	}
	

	public Optional<Usuario> obterPorNome(String nome) {
		return repositorioUsuario.findByName(nome);
	}
	
	public Usuario adicionar(Usuario usuario) {
		usuario.setId(null);
		
		if(repositorioUsuario.findByUsername(usuario.getUsername()).isPresent()) {
			
		}
		
		String senha = passwordEnconder.encode(usuario.getSenha());
		usuario.setSenha(senha);
		
		return repositorioUsuario.save(usuario);
		
	}
	//PUT
	 public Usuario atualizar(Usuario usuario, Long id) {
		 Optional<Usuario> usuarioAtt = repositorioUsuario.findById(id);
		 
		if(repositorioUsuario.findById(usuario.getId()).isEmpty()) {
			throw new ResourceNotFoundException("Usuario não encontrado por id");
		}
		repositorioUsuario.deleteById(id);		
		return repositorioUsuario.save(usuario);
		
	}
//	//put
//    public Optional<Usuario> atualizar(Long id) {
//        Optional<Usuario> usuario = repositorioUsuario.findById(id);
//
//        if (usuario.isEmpty()) {
//            throw ResourceNotFoundException("Usuario não encontrado por id");
//        }
//        usuario.setId(id);
//        usuario.remove(usuario);
//        this.repositorioUsuario.save(usuario);
//        return usuarioAtt;
//    }
//	

	public void deletar(Long id) {
	 this.repositorioUsuario.deleteById(id);
}
	
	public LoginResponse logar(String username, String senha) {
		
		Authentication autenticacao = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(username, senha, Collections.emptyList()));
		
		SecurityContextHolder.getContext().setAuthentication(autenticacao);
		
		String token = headerPrefix + jwtService.gerarToken(autenticacao);
		
		var usuario = repositorioUsuario.findByUsername(username);
		
		return new LoginResponse(token, usuario.get());
	}
	
}
