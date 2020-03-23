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
@Table(name = "alt_disenio_familia_composicion_tela")
public class DisenioFamiliaComposicionTela implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_familia_composicion_tela")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long idFamiliaComposicionTela;
	
	@Column(name="id_familia_composicion")
	@NotBlank
	private String idFamiliaComposicion;
	
	@Column(name="id_tela")
	@NotBlank
	private String idTela;
	
	

	public Long getIdFamiliaComposicionTela() {
		return idFamiliaComposicionTela;
	}

	public void setIdFamiliaComposicionTela(Long idFamiliaComposicionTela) {
		this.idFamiliaComposicionTela = idFamiliaComposicionTela;
	}

	public String getIdFamiliaComposicion() {
		return idFamiliaComposicion;
	}

	public void setIdFamiliaComposicion(String idFamiliaComposicion) {
		this.idFamiliaComposicion = idFamiliaComposicion;
	}

	public String getIdTela() {
		return idTela;
	}

	public void setIdTela(String idTela) {
		this.idTela = idTela;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFamiliaComposicion == null) ? 0 : idFamiliaComposicion.hashCode());
		result = prime * result + ((idFamiliaComposicionTela == null) ? 0 : idFamiliaComposicionTela.hashCode());
		result = prime * result + ((idTela == null) ? 0 : idTela.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DisenioFamiliaComposicionTela other = (DisenioFamiliaComposicionTela) obj;
		if (idFamiliaComposicion == null) {
			if (other.idFamiliaComposicion != null)
				return false;
		} else if (!idFamiliaComposicion.equals(other.idFamiliaComposicion))
			return false;
		if (idFamiliaComposicionTela == null) {
			if (other.idFamiliaComposicionTela != null)
				return false;
		} else if (!idFamiliaComposicionTela.equals(other.idFamiliaComposicionTela))
			return false;
		if (idTela == null) {
			if (other.idTela != null)
				return false;
		} else if (!idTela.equals(other.idTela))
			return false;
		return true;
	}
}
