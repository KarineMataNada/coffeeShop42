package com.coffeeshop42.model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "Pedidos")
@SequenceGenerator(name = "generator_pedidos", sequenceName = "sequence_pedidos", initialValue = 1, allocationSize = 1)
public class Pedidos {

	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "generator_pedido")
	private Long id;
	
	private String numero;
	
	private ArrayList<ProdutosPedidos> listaDeProdutoPedido;
	
	private Double valorTotal;
	
	private Date dataDoPedido;
	
	private String Status;
	
	private ArrayList<Usuario> usuarioId;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public ArrayList<ProdutosPedidos> getListaDeProdutoPedido() {
		return listaDeProdutoPedido;
	}
	
	public void setListaDeProdutoPedido(ArrayList<ProdutosPedidos> listaDeProdutoPedido) {
		this.listaDeProdutoPedido = listaDeProdutoPedido;
	}
	
	public Double getValorTotal() {
		return valorTotal;
	}
	
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public Date getDataDoPedido() {
		return dataDoPedido;
	}
	
	public void setDataDoPedido(Date dataDoPedido) {
		this.dataDoPedido = dataDoPedido;
	}
	
	public String getStatus() {
		return Status;
	}
	
	public void setStatus(String status) {
		Status = status;
	}
	
	public ArrayList<Usuario> getUsuarioId() {
		return usuarioId;
	}
	
	public void setUsuarioId(ArrayList<Usuario> usuarioId) {
		this.usuarioId = usuarioId;
	}
		
}
