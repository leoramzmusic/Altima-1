package com.altima.springboot.app.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "alt_disenio_control_hora")
public class DisenioControlHora {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_control_hora")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long idControlHora;
	
	@Column(name="id_control_produccion_muestra")
	private Long idControlProduccionMuestra;
	
	@Column(name="fecha_inicio")
	private String fechaInicio;
	
	@Column(name="fecha_fin")
	private String fechaFin;
	
	@Column(name="estatus")
	private String estatus;
	
	@Column(name="tipo")
	private String tipo;

	public Long getIdControlHora() {
		return idControlHora;
	}

	public void setIdControlHora(Long idControlHora) {
		this.idControlHora = idControlHora;
	}

	public Long getIdControlProduccionMuestra() {
		return idControlProduccionMuestra;
	}

	public void setIdControlProduccionMuestra(Long idControlProduccionMuestra) {
		this.idControlProduccionMuestra = idControlProduccionMuestra;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	

}
