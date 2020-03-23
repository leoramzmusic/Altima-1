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
@Table(name = "alt_disenio_familia_prenda")
public class DisenioFamiliaPrenda implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_familia_prenda")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long idFamiliaPrenda;
	
	@Column(name="id_text")
	@NotBlank
	private String idText;
	
	@Column(name="id_lookup")
	@NotBlank
	private String idLookup;
	
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
	
	@Column(name="tipo_prenda")
	@NotBlank
	private String tipoPrenda;
	
	@Column(name="nombre_familia_prenda")
	@NotBlank
	private String nombreFamiliaPrenda;
	
	@Column(name="descripcion_familia_prenda")
	@NotBlank
	private String descripcionFamiliaPrenda;
	
	
	@Column(name="id_familia_genero")
	@NotBlank
	private Long idFamiliaGenero;


	public Long getIdFamiliaPrenda() {
		return idFamiliaPrenda;
	}


	public void setIdFamiliaPrenda(Long idFamiliaPrenda) {
		this.idFamiliaPrenda = idFamiliaPrenda;
	}


	public String getIdText() {
		return idText;
	}


	public void setIdText(String idText) {
		this.idText = idText;
	}


	public String getIdLookup() {
		return idLookup;
	}


	public void setIdLookup(String idLookup) {
		this.idLookup = idLookup;
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


	public String getTipoPrenda() {
		return tipoPrenda;
	}


	public void setTipoPrenda(String tipoPrenda) {
		this.tipoPrenda = tipoPrenda;
	}


	public String getNombreFamiliaPrenda() {
		return nombreFamiliaPrenda;
	}


	public void setNombreFamiliaPrenda(String nombreFamiliaPrenda) {
		this.nombreFamiliaPrenda = nombreFamiliaPrenda;
	}


	public String getDescripcionFamiliaPrenda() {
		return descripcionFamiliaPrenda;
	}


	public void setDescripcionFamiliaPrenda(String descripcionFamiliaPrenda) {
		this.descripcionFamiliaPrenda = descripcionFamiliaPrenda;
	}


	public Long getIdFamiliaGenero() {
		return idFamiliaGenero;
	}


	public void setIdFamiliaGenero(Long idFamiliaGenero) {
		this.idFamiliaGenero = idFamiliaGenero;
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
		result = prime * result + ((descripcionFamiliaPrenda == null) ? 0 : descripcionFamiliaPrenda.hashCode());
		result = prime * result + ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
		result = prime * result + ((idFamiliaGenero == null) ? 0 : idFamiliaGenero.hashCode());
		result = prime * result + ((idFamiliaPrenda == null) ? 0 : idFamiliaPrenda.hashCode());
		result = prime * result + ((idLookup == null) ? 0 : idLookup.hashCode());
		result = prime * result + ((idText == null) ? 0 : idText.hashCode());
		result = prime * result + ((nombreFamiliaPrenda == null) ? 0 : nombreFamiliaPrenda.hashCode());
		result = prime * result + ((tipoPrenda == null) ? 0 : tipoPrenda.hashCode());
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
		DisenioFamiliaPrenda other = (DisenioFamiliaPrenda) obj;
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
		if (descripcionFamiliaPrenda == null) {
			if (other.descripcionFamiliaPrenda != null)
				return false;
		} else if (!descripcionFamiliaPrenda.equals(other.descripcionFamiliaPrenda))
			return false;
		if (fechaCreacion == null) {
			if (other.fechaCreacion != null)
				return false;
		} else if (!fechaCreacion.equals(other.fechaCreacion))
			return false;
		if (idFamiliaGenero == null) {
			if (other.idFamiliaGenero != null)
				return false;
		} else if (!idFamiliaGenero.equals(other.idFamiliaGenero))
			return false;
		if (idFamiliaPrenda == null) {
			if (other.idFamiliaPrenda != null)
				return false;
		} else if (!idFamiliaPrenda.equals(other.idFamiliaPrenda))
			return false;
		if (idLookup == null) {
			if (other.idLookup != null)
				return false;
		} else if (!idLookup.equals(other.idLookup))
			return false;
		if (idText == null) {
			if (other.idText != null)
				return false;
		} else if (!idText.equals(other.idText))
			return false;
		if (nombreFamiliaPrenda == null) {
			if (other.nombreFamiliaPrenda != null)
				return false;
		} else if (!nombreFamiliaPrenda.equals(other.nombreFamiliaPrenda))
			return false;
		if (tipoPrenda == null) {
			if (other.tipoPrenda != null)
				return false;
		} else if (!tipoPrenda.equals(other.tipoPrenda))
			return false;
		if (ultimaFechaModificacion == null) {
			if (other.ultimaFechaModificacion != null)
				return false;
		} else if (!ultimaFechaModificacion.equals(other.ultimaFechaModificacion))
			return false;
		return true;
	}
}
