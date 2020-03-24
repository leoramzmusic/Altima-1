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
@Table(name = "alt_disenio_ruta_proceso")
public class DisenioRutaProceso implements Serializable{

	@Id
	@Column(name="id_ruta_proceso")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long idRutaProceso;
	
	@Column(name="id_ruta")
	@NotBlank
	private String idRuta;
	
	@Column(name="id_proceso")
	@NotBlank
	private String idProceso;

	public Long getIdRutaProceso() {
		return idRutaProceso;
	}

	public void setIdRutaProceso(Long idRutaProceso) {
		this.idRutaProceso = idRutaProceso;
	}

	public String getIdRuta() {
		return idRuta;
	}

	public void setIdRuta(String idRuta) {
		this.idRuta = idRuta;
	}

	public String getIdProceso() {
		return idProceso;
	}

	public void setIdProceso(String idProceso) {
		this.idProceso = idProceso;
	}
	
	
	
	
	
}
