package com.coffeeshop42.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.caffeteria.cafe.model.Cafe;
import com.coffeeshop42.dto.LoginResponse;
import com.coffeeshop42.exception.ResourceInternalServerError.ResourceNotFoundException;
import com.coffeeshop42.model.Usuario;
import com.coffeeshop42.repository.UsuarioRepository;
import com.coffeeshop42.security.JWTService;

import br.com.serratec.padaria1.produto.Produto;
import io.swagger.annotations.ApiOperation;

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
	
	public Usuario adicionar(Usuario usuario) {
		usuario.setId(null);
		
		if(repositorioUsuario.findByUsername(usuario.getUsername()).isPresent()) {
			
		}
		
		String senha = passwordEnconder.encode(usuario.getSenha());
		usuario.setSenha(senha);
		
		return repositorioUsuario.save(usuario);
		
	}
	//put
    public Optional<Usuario> atualizar(Long id) {
        Optional<Usuario> usuario = repositorioUsuario.findById(id);

        if (usuario.isEmpty()) {
            throw ResourceNotFoundException("Usuario não encontrado por id");
        }
        usuario.setId(id);
        usuario.remove(usuario);
        this.repositorioUsuario.save(usuario);
        return usuarioAtt;
    }
	

	public void deletar(@PathVariable(value = "id") Long id) {
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