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
@Table(name = "xxalt_tela")
public class Tela implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_tela")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long idTela;
	
	@Column(name="id_familia_composicion")
	@NotBlank
	private Long idFamiliaComposicion;
	
	@Column(name="id_lookup")
	@NotBlank
	private Long idLookup;

	@Column(name="id_calidad")
	@NotBlank
	private Long idCalidad;
	
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
	
	@Column(name="clave_tela")
	@NotBlank
	private String claveTela;
	
	@Column(name="descripcion_tela")
	@NotBlank
	private String descripcionTela;
	
	@Column(name="linea_tela")
	@NotBlank
	private String lineaTela;
	
	@Column(name="ancho")
	@NotBlank
	private String ancho;
	
	@Column(name="consumo_promedio")
	@NotBlank
	private String consumoPromedio;
	
	@Column(name="existencia")
	@NotBlank
	private String existencia;
	
	@Column(name="indicaciones")
	@NotBlank
	private String indicaciones;

	public Long getIdTela() {
		return idTela;
	}

	public void setIdTela(Long idTela) {
		this.idTela = idTela;
	}

	public Long getIdFamiliaComposicion() {
		return idFamiliaComposicion;
	}

	public void setIdFamiliaComposicion(Long idFamiliaComposicion) {
		this.idFamiliaComposicion = idFamiliaComposicion;
	}

	public Long getIdLookup() {
		return idLookup;
	}

	public void setIdLookup(Long idLookup) {
		this.idLookup = idLookup;
	}

	public Long getIdCalidad() {
		return idCalidad;
	}

	public void setIdCalidad(Long idCalidad) {
		this.idCalidad = idCalidad;
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

	public String getClaveTela() {
		return claveTela;
	}

	public void setClaveTela(String claveTela) {
		this.claveTela = claveTela;
	}

	public String getDescripcionTela() {
		return descripcionTela;
	}

	public void setDescripcionTela(String descripcionTela) {
		this.descripcionTela = descripcionTela;
	}

	public String getLineaTela() {
		return lineaTela;
	}

	public void setLineaTela(String lineaTela) {
		this.lineaTela = lineaTela;
	}

	public String getAncho() {
		return ancho;
	}

	public void setAncho(String ancho) {
		this.ancho = ancho;
	}

	public String getConsumoPromedio() {
		return consumoPromedio;
	}

	public void setConsumoPromedio(String consumoPromedio) {
		this.consumoPromedio = consumoPromedio;
	}

	public String getExistencia() {
		return existencia;
	}

	public void setExistencia(String existencia) {
		this.existencia = existencia;
	}

	public String getIndicaciones() {
		return indicaciones;
	}

	public void setIndicaciones(String indicaciones) {
		this.indicaciones = indicaciones;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actualizadoPor == null) ? 0 : actualizadoPor.hashCode());
		result = prime * result + ((ancho == null) ? 0 : ancho.hashCode());
		result = prime * result + ((claveTela == null) ? 0 : claveTela.hashCode());
		result = prime * result + ((consumoPromedio == null) ? 0 : consumoPromedio.hashCode());
		result = prime * result + ((creadoPor == null) ? 0 : creadoPor.hashCode());
		result = prime * result + ((descripcionTela == null) ? 0 : descripcionTela.hashCode());
		result = prime * result + ((existencia == null) ? 0 : existencia.hashCode());
		result = prime * result + ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
		result = prime * result + ((idCalidad == null) ? 0 : idCalidad.hashCode());
		result = prime * result + ((idFamiliaComposicion == null) ? 0 : idFamiliaComposicion.hashCode());
		result = prime * result + ((idLookup == null) ? 0 : idLookup.hashCode());
		result = prime * result + ((idTela == null) ? 0 : idTela.hashCode());
		result = prime * result + ((idText == null) ? 0 : idText.hashCode());
		result = prime * result + ((indicaciones == null) ? 0 : indicaciones.hashCode());
		result = prime * result + ((lineaTela == null) ? 0 : lineaTela.hashCode());
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
		Tela other = (Tela) obj;
		if (actualizadoPor == null) {
			if (other.actualizadoPor != null)
				return false;
		} else if (!actualizadoPor.equals(other.actualizadoPor))
			return false;
		if (ancho == null) {
			if (other.ancho != null)
				return false;
		} else if (!ancho.equals(other.ancho))
			return false;
		if (claveTela == null) {
			if (other.claveTela != null)
				return false;
		} else if (!claveTela.equals(other.claveTela))
			return false;
		if (consumoPromedio == null) {
			if (other.consumoPromedio != null)
				return false;
		} else if (!consumoPromedio.equals(other.consumoPromedio))
			return false;
		if (creadoPor == null) {
			if (other.creadoPor != null)
				return false;
		} else if (!creadoPor.equals(other.creadoPor))
			return false;
		if (descripcionTela == null) {
			if (other.descripcionTela != null)
				return false;
		} else if (!descripcionTela.equals(other.descripcionTela))
			return false;
		if (existencia == null) {
			if (other.existencia != null)
				return false;
		} else if (!existencia.equals(other.existencia))
			return false;
		if (fechaCreacion == null) {
			if (other.fechaCreacion != null)
				return false;
		} else if (!fechaCreacion.equals(other.fechaCreacion))
			return false;
		if (idCalidad == null) {
			if (other.idCalidad != null)
				return false;
		} else if (!idCalidad.equals(other.idCalidad))
			return false;
		if (idFamiliaComposicion == null) {
			if (other.idFamiliaComposicion != null)
				return false;
		} else if (!idFamiliaComposicion.equals(other.idFamiliaComposicion))
			return false;
		if (idLookup == null) {
			if (other.idLookup != null)
				return false;
		} else if (!idLookup.equals(other.idLookup))
			return false;
		if (idTela == null) {
			if (other.idTela != null)
				return false;
		} else if (!idTela.equals(other.idTela))
			return false;
		if (idText == null) {
			if (other.idText != null)
				return false;
		} else if (!idText.equals(other.idText))
			return false;
		if (indicaciones == null) {
			if (other.indicaciones != null)
				return false;
		} else if (!indicaciones.equals(other.indicaciones))
			return false;
		if (lineaTela == null) {
			if (other.lineaTela != null)
				return false;
		} else if (!lineaTela.equals(other.lineaTela))
			return false;
		if (ultimaFechaModificacion == null) {
			if (other.ultimaFechaModificacion != null)
				return false;
		} else if (!ultimaFechaModificacion.equals(other.ultimaFechaModificacion))
			return false;
		return true;
	}
}
