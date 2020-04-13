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
@Table(name = "alt_comercial_inventario_detalle")
public class ComercialInventarioDetalle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name="id_inventario_detalle")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long idInventarioDetalle;
	
	@Column(name="id_inventario")
	private Long idInventario;
	
	@Column(name="consecutivo")
	private String consecutivo;

	public Long getIdInventarioDetalle() {
		return idInventarioDetalle;
	}

	public void setIdInventarioDetalle(Long idInventarioDetalle) {
		this.idInventarioDetalle = idInventarioDetalle;
	}

	public Long getIdInventario() {
		return idInventario;
	}

	public void setIdInventario(Long idInventario) {
		this.idInventario = idInventario;
	}

	public String getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(String consecutivo) {
		this.consecutivo = consecutivo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
