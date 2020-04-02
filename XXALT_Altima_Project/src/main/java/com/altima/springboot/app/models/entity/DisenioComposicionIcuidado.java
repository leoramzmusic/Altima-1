package com.altima.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "alt_disenio_composicion_icuidado")
public class DisenioComposicionIcuidado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_composicion_icuidado")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long idUmedidaIcuidado;
	
	@Column(name="id_composicion")
	@NotBlank
	private Long idComposicion;
	
	@Column(name="id_instrucciones_cuidado")
	@NotBlank
	private Long idInstruccionesCuidado;

	public Long getIdUmedidaIcuidado() {
		return idUmedidaIcuidado;
	}

	public void setIdUmedidaIcuidado(Long idUmedidaIcuidado) {
		this.idUmedidaIcuidado = idUmedidaIcuidado;
	}

	public Long getIdComposicion() {
		return idComposicion;
	}

	public void setIdComposicion(Long idComposicion) {
		this.idComposicion = idComposicion;
	}

	public Long getIdInstruccionesCuidado() {
		return idInstruccionesCuidado;
	}

	public void setIdInstruccionesCuidado(Long idInstruccionesCuidado) {
		this.idInstruccionesCuidado = idInstruccionesCuidado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
