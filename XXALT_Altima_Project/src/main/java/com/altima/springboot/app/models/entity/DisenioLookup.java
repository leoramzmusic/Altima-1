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
@Table(name = "alt_disenio_lookup")
public class DisenioLookup implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_lookup")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name="native",strategy="native")
	private Long idLookup;

	@Column(name="id_text")
	private String idText;
	
	@Column(name="nombre_lookup")
	private String nombreLookup;
	
	@Column(name="descripcion_lookup")
	private String descripcionLookup;
	
	@Column(name="tipo_lookup")
	private String tipoLookup;
	
	@Column(name="creado_por")
	private String creadoPor;
	
	@Column(name="actualizado_por")
	private String actualizadoPor;
	
	@Column(name="fecha_creacion")
	private String fechaCreacion;
	
	@Column(name="ultima_fecha_modificacion")
	private String ultimaFechaModificacion;
	
	@Column(name="estatus")
	private Integer Estatus;
	
	@Column(name="atributo_1")
	private String atributo1;
	
	@Column(name="atributo_2")
	private String atributo2;

	@Column(name="atributo_3")
	private String atributo3;

	public Long getIdLookup() {
		return idLookup;
	}

	public void setIdLookup(Long idLookup) {
		this.idLookup = idLookup;
	}

	public String getIdText() {
		return idText;
	}

	public void setIdText(String idText) {
		this.idText = idText;
	}

	public String getNombreLookup() {
		return nombreLookup;
	}

	public void setNombreLookup(String nombreLookup) {
		this.nombreLookup = nombreLookup;
	}

	public String getDescripcionLookup() {
		return descripcionLookup;
	}

	public void setDescripcionLookup(String descripcionLookup) {
		this.descripcionLookup = descripcionLookup;
	}

	public String getTipoLookup() {
		return tipoLookup;
	}

	public void setTipoLookup(String tipoLookup) {
		this.tipoLookup = tipoLookup;
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

	public Integer getEstatus() {
		return Estatus;
	}

	public void setEstatus(Integer estatus) {
		Estatus = estatus;
	}

	public String getAtributo1() {
		return atributo1;
	}

	public void setAtributo1(String atributo1) {
		this.atributo1 = atributo1;
	}

	public String getAtributo2() {
		return atributo2;
	}

	public void setAtributo2(String atributo2) {
		this.atributo2 = atributo2;
	}

	public String getAtributo3() {
		return atributo3;
	}

	public void setAtributo3(String atributo3) {
		this.atributo3 = atributo3;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Estatus == null) ? 0 : Estatus.hashCode());
		result = prime * result + ((actualizadoPor == null) ? 0 : actualizadoPor.hashCode());
		result = prime * result + ((atributo1 == null) ? 0 : atributo1.hashCode());
		result = prime * result + ((atributo2 == null) ? 0 : atributo2.hashCode());
		result = prime * result + ((atributo3 == null) ? 0 : atributo3.hashCode());
		result = prime * result + ((creadoPor == null) ? 0 : creadoPor.hashCode());
		result = prime * result + ((descripcionLookup == null) ? 0 : descripcionLookup.hashCode());
		result = prime * result + ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
		result = prime * result + ((idLookup == null) ? 0 : idLookup.hashCode());
		result = prime * result + ((idText == null) ? 0 : idText.hashCode());
		result = prime * result + ((nombreLookup == null) ? 0 : nombreLookup.hashCode());
		result = prime * result + ((tipoLookup == null) ? 0 : tipoLookup.hashCode());
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
		DisenioLookup other = (DisenioLookup) obj;
		if (Estatus == null) {
			if (other.Estatus != null)
				return false;
		} else if (!Estatus.equals(other.Estatus))
			return false;
		if (actualizadoPor == null) {
			if (other.actualizadoPor != null)
				return false;
		} else if (!actualizadoPor.equals(other.actualizadoPor))
			return false;
		if (atributo1 == null) {
			if (other.atributo1 != null)
				return false;
		} else if (!atributo1.equals(other.atributo1))
			return false;
		if (atributo2 == null) {
			if (other.atributo2 != null)
				return false;
		} else if (!atributo2.equals(other.atributo2))
			return false;
		if (atributo3 == null) {
			if (other.atributo3 != null)
				return false;
		} else if (!atributo3.equals(other.atributo3))
			return false;
		if (creadoPor == null) {
			if (other.creadoPor != null)
				return false;
		} else if (!creadoPor.equals(other.creadoPor))
			return false;
		if (descripcionLookup == null) {
			if (other.descripcionLookup != null)
				return false;
		} else if (!descripcionLookup.equals(other.descripcionLookup))
			return false;
		if (fechaCreacion == null) {
			if (other.fechaCreacion != null)
				return false;
		} else if (!fechaCreacion.equals(other.fechaCreacion))
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
		if (nombreLookup == null) {
			if (other.nombreLookup != null)
				return false;
		} else if (!nombreLookup.equals(other.nombreLookup))
			return false;
		if (tipoLookup == null) {
			if (other.tipoLookup != null)
				return false;
		} else if (!tipoLookup.equals(other.tipoLookup))
			return false;
		if (ultimaFechaModificacion == null) {
			if (other.ultimaFechaModificacion != null)
				return false;
		} else if (!ultimaFechaModificacion.equals(other.ultimaFechaModificacion))
			return false;
		return true;
	}	
}
