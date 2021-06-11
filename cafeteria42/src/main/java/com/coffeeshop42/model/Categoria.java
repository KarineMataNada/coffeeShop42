package com.coffeeshop42.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Categoria")
@SequenceGenerator(name = "generator_usuario", sequenceName = "sequence_usuario", initialValue = 1, allocationSize = 1)
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_usuario")
	private Long id;
	
	@Column(nullable = false, length = 60)
	private String nome;
	
	@Column(nullable = false, length = 255)
	private String descricao;
	
	public Categoria() {}
	
	public Categoria(Long id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
