package com.altima.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "alt_pedido")
public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pedido")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long idPedido;
	
	@Column(name="id_cliente")
	private Long idCliente;
	
	@Column(name="fecha_creacion_pedido")
	private String fechaCreacionPedido;
	
	@Column(name="quien_creo_pedido")
	private String QuienCreoPedido;
	
	@Column(name="estatus")
	private String estatus;
	
	@Column(name="id_text")
	private String idText;
	
	@Column(name="prenda_producir")
	private String prendaProducir;

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getFechaCreacionPedido() {
		return fechaCreacionPedido;
	}

	public void setFechaCreacionPedido(String fechaCreacionPedido) {
		this.fechaCreacionPedido = fechaCreacionPedido;
	}

	public String getQuienCreoPedido() {
		return QuienCreoPedido;
	}

	public void setQuienCreoPedido(String quienCreoPedido) {
		QuienCreoPedido = quienCreoPedido;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getIdText() {
		return idText;
	}

	public void setIdText(String idText) {
		this.idText = idText;
	}

	public String getPrendaProducir() {
		return prendaProducir;
	}

	public void setPrendaProducir(String prendaProducir) {
		this.prendaProducir = prendaProducir;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
