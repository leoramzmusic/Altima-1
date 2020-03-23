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
@Table(name = "alt_disenio_forro")
public class DisenioForro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_forro")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long idForro;
	
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
	
	@Column(name="clave_forro")
	@NotBlank
	private String claveForro;
	
	@Column(name="descripcion_forro")
	@NotBlank
	private String descripcionForro;
	
	@Column(name="nombre_forro")
	@NotBlank
	private String nombreForro;
	
	public String getNombreForro() {
		return nombreForro;
	}

	public void setNombreForro(String nombreForro) {
		this.nombreForro = nombreForro;
	}

	@Column(name="composicion_forro")
	@NotBlank
	private String composicionForro;
	
	@Column(name="ancho_forro")
	@NotBlank
	private String anchoForro;
	
	@Column(name="consumo_promedio_forro")
	@NotBlank
	private String consumoPromedioForro;
	
	@Column(name="existencia_forro")
	@NotBlank
	private String existenciaForro;

	public Long getIdForro() {
		return idForro;
	}

	public void setIdForro(Long idForro) {
		this.idForro = idForro;
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

	public String getClaveForro() {
		return claveForro;
	}

	public void setClaveForro(String claveForro) {
		this.claveForro = claveForro;
	}

	public String getDescripcionForro() {
		return descripcionForro;
	}

	public void setDescripcionForro(String descripcionForro) {
		this.descripcionForro = descripcionForro;
	}

	public String getComposicionForro() {
		return composicionForro;
	}

	public void setComposicionForro(String composicionForro) {
		this.composicionForro = composicionForro;
	}

	public String getAnchoForro() {
		return anchoForro;
	}

	public void setAnchoForro(String anchoForro) {
		this.anchoForro = anchoForro;
	}

	public String getConsumoPromedioForro() {
		return consumoPromedioForro;
	}

	public void setConsumoPromedioForro(String consumoPromedioForro) {
		this.consumoPromedioForro = consumoPromedioForro;
	}

	public String getExistenciaForro() {
		return existenciaForro;
	}

	public void setExistenciaForro(String existenciaForro) {
		this.existenciaForro = existenciaForro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actualizadoPor == null) ? 0 : actualizadoPor.hashCode());
		result = prime * result + ((anchoForro == null) ? 0 : anchoForro.hashCode());
		result = prime * result + ((claveForro == null) ? 0 : claveForro.hashCode());
		result = prime * result + ((composicionForro == null) ? 0 : composicionForro.hashCode());
		result = prime * result + ((consumoPromedioForro == null) ? 0 : consumoPromedioForro.hashCode());
		result = prime * result + ((creadoPor == null) ? 0 : creadoPor.hashCode());
		result = prime * result + ((descripcionForro == null) ? 0 : descripcionForro.hashCode());
		result = prime * result + ((existenciaForro == null) ? 0 : existenciaForro.hashCode());
		result = prime * result + ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
		result = prime * result + ((idForro == null) ? 0 : idForro.hashCode());
		result = prime * result + ((idText == null) ? 0 : idText.hashCode());
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
		DisenioForro other = (DisenioForro) obj;
		if (actualizadoPor == null) {
			if (other.actualizadoPor != null)
				return false;
		} else if (!actualizadoPor.equals(other.actualizadoPor))
			return false;
		if (anchoForro == null) {
			if (other.anchoForro != null)
				return false;
		} else if (!anchoForro.equals(other.anchoForro))
			return false;
		if (claveForro == null) {
			if (other.claveForro != null)
				return false;
		} else if (!claveForro.equals(other.claveForro))
			return false;
		if (composicionForro == null) {
			if (other.composicionForro != null)
				return false;
		} else if (!composicionForro.equals(other.composicionForro))
			return false;
		if (consumoPromedioForro == null) {
			if (other.consumoPromedioForro != null)
				return false;
		} else if (!consumoPromedioForro.equals(other.consumoPromedioForro))
			return false;
		if (creadoPor == null) {
			if (other.creadoPor != null)
				return false;
		} else if (!creadoPor.equals(other.creadoPor))
			return false;
		if (descripcionForro == null) {
			if (other.descripcionForro != null)
				return false;
		} else if (!descripcionForro.equals(other.descripcionForro))
			return false;
		if (existenciaForro == null) {
			if (other.existenciaForro != null)
				return false;
		} else if (!existenciaForro.equals(other.existenciaForro))
			return false;
		if (fechaCreacion == null) {
			if (other.fechaCreacion != null)
				return false;
		} else if (!fechaCreacion.equals(other.fechaCreacion))
			return false;
		if (idForro == null) {
			if (other.idForro != null)
				return false;
		} else if (!idForro.equals(other.idForro))
			return false;
		if (idText == null) {
			if (other.idText != null)
				return false;
		} else if (!idText.equals(other.idText))
			return false;
		if (ultimaFechaModificacion == null) {
			if (other.ultimaFechaModificacion != null)
				return false;
		} else if (!ultimaFechaModificacion.equals(other.ultimaFechaModificacion))
			return false;
		return true;
	}
	
	
	
	
}
