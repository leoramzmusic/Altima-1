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
@Table(name = "alt_disenio_familia_composicion")
public class DisenioFamiliaComposicion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_familia_composicion")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long idFamiliaComposicion;
	
	@Column(name="id_text")
	@NotBlank
	private String idText;
	
	@Column(name="creado_por")
	@NotBlank
	private String creadoPor;
	
	@Column(name="actualizado_por")
	@NotBlank
	private String actualizadoPor;
	
	@Column(name="fecha_creacion")
	@NotBlank
	private String fechaCreacion;
	
	@Column(name="ultima_fecha_modificacion")
	@NotBlank
	private String ultimaFechaModificacion;
	
	@Column(name="descripcion_familia_composicion")
	@NotBlank
	private String descripcionFamiliaComposicion;
	
	@Column(name="nombre_familia_composicion")
	@NotBlank
	private String nombreFamiliaComposicion;
	
	@Column(name="estatus")
	@NotBlank
	private String estatus;

	public Long getIdFamiliaComposicion() {
		return idFamiliaComposicion;
	}

	public void setIdFamiliaComposicion(Long idFamiliaComposicion) {
		this.idFamiliaComposicion = idFamiliaComposicion;
	}

	public String getIdText() {
		return idText;
	}

	public void setIdText(String idText) {
		this.idText = idText;
	}

	public String getCreadoPor() {
		return creadoPor;
	}

	public void setCreadoPor(String creadoPor) {
		this.creadoPor = creadoPor;
	}

	public String getActualizadoPor() {
		return actualizadoPor;
	}

	public void setActualizadoPor(String actualizadoPor) {
		this.actualizadoPor = actualizadoPor;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getUltimaFechaModificacion() {
		return ultimaFechaModificacion;
	}

	public void setUltimaFechaModificacion(String ultimaFechaModificacion) {
		this.ultimaFechaModificacion = ultimaFechaModificacion;
	}

	public String getDescripcionFamiliaComposicion() {
		return descripcionFamiliaComposicion;
	}

	public void setDescripcionFamiliaComposicion(String descripcionFamiliaComposicion) {
		this.descripcionFamiliaComposicion = descripcionFamiliaComposicion;
	}

	public String getNombreFamiliaComposicion() {
		return nombreFamiliaComposicion;
	}

	public void setNombreFamiliaComposicion(String nombreFamiliaComposicion) {
		this.nombreFamiliaComposicion = nombreFamiliaComposicion;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actualizadoPor == null) ? 0 : actualizadoPor.hashCode());
		result = prime * result + ((creadoPor == null) ? 0 : creadoPor.hashCode());
		result = prime * result
				+ ((descripcionFamiliaComposicion == null) ? 0 : descripcionFamiliaComposicion.hashCode());
		result = prime * result + ((estatus == null) ? 0 : estatus.hashCode());
		result = prime * result + ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
		result = prime * result + ((idFamiliaComposicion == null) ? 0 : idFamiliaComposicion.hashCode());
		result = prime * result + ((idText == null) ? 0 : idText.hashCode());
		result = prime * result + ((nombreFamiliaComposicion == null) ? 0 : nombreFamiliaComposicion.hashCode());
		result = prime * result + ((ultimaFechaModificacion == null) ? 0 : ultimaFechaModificacion.hashCode());
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
		DisenioFamiliaComposicion other = (DisenioFamiliaComposicion) obj;
		if (actualizadoPor == null) {
			if (other.actualizadoPor != null)
				return false;
		} else if (!actualizadoPor.equals(other.actualizadoPor))
			return false;
		if (creadoPor == null) {
			if (other.creadoPor != null)
				return false;
		} else if (!creadoPor.equals(other.creadoPor))
			return false;
		if (descripcionFamiliaComposicion == null) {
			if (other.descripcionFamiliaComposicion != null)
				return false;
		} else if (!descripcionFamiliaComposicion.equals(other.descripcionFamiliaComposicion))
			return false;
		if (estatus == null) {
			if (other.estatus != null)
				return false;
		} else if (!estatus.equals(other.estatus))
			return false;
		if (fechaCreacion == null) {
			if (other.fechaCreacion != null)
				return false;
		} else if (!fechaCreacion.equals(other.fechaCreacion))
			return false;
		if (idFamiliaComposicion == null) {
			if (other.idFamiliaComposicion != null)
				return false;
		} else if (!idFamiliaComposicion.equals(other.idFamiliaComposicion))
			return false;
		if (idText == null) {
			if (other.idText != null)
				return false;
		} else if (!idText.equals(other.idText))
			return false;
		if (nombreFamiliaComposicion == null) {
			if (other.nombreFamiliaComposicion != null)
				return false;
		} else if (!nombreFamiliaComposicion.equals(other.nombreFamiliaComposicion))
			return false;
		if (ultimaFechaModificacion == null) {
			if (other.ultimaFechaModificacion != null)
				return false;
		} else if (!ultimaFechaModificacion.equals(other.ultimaFechaModificacion))
			return false;
		return true;
	}
}