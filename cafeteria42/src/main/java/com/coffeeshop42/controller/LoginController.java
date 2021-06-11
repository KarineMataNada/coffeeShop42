package com.coffeeshop42.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffeeshop42.dto.LoginRequest;
import com.coffeeshop42.dto.LoginResponse;
import com.coffeeshop42.service.UsuarioService;



@RestController
@RequestMapping("/api/login")
public class LoginController {

	@Autowired
	private UsuarioService servicoUsuario;
		
	@PostMapping
	public LoginResponse login (@RequestBody LoginRequest request) {		
		return servicoUsuario.logar(request.getUsername(), request.getSenha());
	}
		
}
