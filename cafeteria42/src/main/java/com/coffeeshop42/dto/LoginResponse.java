package com.coffeeshop42.dto;

import com.coffeeshop42.model.Usuario;

public class LoginResponse {
	
	private String token;
	
	private Usuario usuario;
		
	public LoginResponse(String token, Usuario usuario) {
		this.token = token;
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
		
}
