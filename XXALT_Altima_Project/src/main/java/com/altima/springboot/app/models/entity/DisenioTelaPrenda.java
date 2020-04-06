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
@Table(name = "alt_disenio_tela_prenda")
public class DisenioTelaPrenda implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_tela_prenda")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long idTelaPrenda;
	
	@Column(name="id_tela")
	private Long idTela;
	
	@Column(name="id_prenda")
	private Long idPrenda;

	public Long getIdTelaPrenda() {
		return idTelaPrenda;
	}

	public void setIdTelaPrenda(Long idTelaPrenda) {
		this.idTelaPrenda = idTelaPrenda;
	}

	public Long getIdTela() {
		return idTela;
	}

	public void setIdTela(Long idTela) {
		this.idTela = idTela;
	}

	public Long getIdPrenda() {
		return idPrenda;
	}

	public void setIdPrenda(Long idPrenda) {
		this.idPrenda = idPrenda;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
