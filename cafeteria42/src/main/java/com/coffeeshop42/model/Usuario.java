package com.coffeeshop42.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuario")
@SequenceGenerator(name = "generator_usuario", sequenceName = "sequence_usuario", initialValue = 1, allocationSize = 1)
public class Usuario implements UserDetails {


	private static final long serialVersionUID = -6463936750333420403L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_usuario")
	private Long id;
	
	@Column(nullable = false, length = 60)
	private String email; 
	
	@Column(nullable = false, length = 10)
	private String username;
	
	@Column(nullable = false, length = 60)
	private String senha;
	
	@Column(nullable = false, length = 60)
	private String nome;
	
	@Column(nullable = false, length = 11)
	private String cpf;
	
	@Column(nullable = false, length = 10)
	private String telefone;
	
	@Column(nullable = false, length = 10)
	private Date dataNascimento;
	
	@Column(nullable = false)
	private Endereco endereco_id;
	
	public Usuario() {}
	
	public Usuario(Long id, String email, String username, String senha, String nome, String cpf, String telefone,
			Date dataNascimento, Endereco endereco_id) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.senha = senha;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.endereco_id = endereco_id;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Endereco getEndereco_id() {
		return endereco_id;
	}
	
	public void setEndereco_id(Endereco endereco_id) {
		this.endereco_id = endereco_id;
	}

	
	@Override
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		return null;
	}

	@Override
	@JsonIgnore
	public String getPassword() {
		
		return senha;
	}
	
	@Override
	@JsonIgnore
	public boolean isAccountNonExpired() {
	
		return false;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonLocked() {

		return false;
	}

	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
	
		return false;
	}

	@Override
	@JsonIgnore
	public boolean isEnabled() {
		
		return false;
	}
	
	
}
