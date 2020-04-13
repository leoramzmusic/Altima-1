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
@Table(name = "alt_disenio_prenda_marcador")
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
	private Long idPrenda;
	
	
	@Column(name="id_marcador")
	private Long idMarcador;


	public Long getIdPrendaMarcador() {
		return idPrendaMarcador;
	}


	public void setIdPrendaMarcador(Long idPrendaMarcador) {
		this.idPrendaMarcador = idPrendaMarcador;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getIdMarcador() {
		return idMarcador;
	}

	public void setIdMarcador(Long idMarcador) {
		this.idMarcador = idMarcador;
	}

	public Long getIdPrenda() {
		return idPrenda;
	}

	public void setIdPrenda(Long idPrenda) {
		this.idPrenda = idPrenda;
	}
	
	
	
}
