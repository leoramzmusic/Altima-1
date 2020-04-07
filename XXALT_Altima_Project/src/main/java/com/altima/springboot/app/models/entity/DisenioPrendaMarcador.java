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
@Table(name = "alt_desenio_prenda_marcador")
public class DisenioPrendaMarcador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_prenda_marcador")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long idPrendaMarcador;
	
	@Column(name="id_prenda")
	private Long idMaterial;
	
	
	@Column(name="id_marcador")
	private Long idTela;


	public Long getIdPrendaMarcador() {
		return idPrendaMarcador;
	}


	public void setIdPrendaMarcador(Long idPrendaMarcador) {
		this.idPrendaMarcador = idPrendaMarcador;
	}


	public Long getIdMaterial() {
		return idMaterial;
	}


	public void setIdMaterial(Long idMaterial) {
		this.idMaterial = idMaterial;
	}


	public Long getIdTela() {
		return idTela;
	}


	public void setIdTela(Long idTela) {
		this.idTela = idTela;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
