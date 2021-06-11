package com.coffeeshop42.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "Lista de produtos")
@SequenceGenerator(name = "generator_produtosPedidos", sequenceName = "sequence_produtosPedidos", initialValue = 1, allocationSize = 1)
public class ProdutosPedidos {
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "generator_produtosPedidos")
	private Long id;
	
	private Produto produtoId;
	
	private Pedidos pedidoId;
	
	private Integer quantidade;
	
	private Double valor;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Produto getProdutoId() {
		return produtoId;
	}
	
	public void setProdutoId(Produto produtoId) {
		this.produtoId = produtoId;
	}
	
	public Pedidos getPedidoId() {
		return pedidoId;
	}
	
	public void setPedidoId(Pedidos pedidoId) {
		this.pedidoId = pedidoId;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}
