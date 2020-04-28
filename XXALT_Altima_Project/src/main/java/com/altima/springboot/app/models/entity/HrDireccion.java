package com.altima.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "alt_hr_direccion")

public class HrDireccion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_direccion")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long idDireccion;
	
	@Column(name="id_text")
	private String idText;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="municipio")
	private String municipio;
	
	@Column(name="colonia")
	private String colonia;
	
	@Column(name="calle")
	private String calle;
	
	@Column(name="numero_ext")
	private String NumeroExt;
	
	@Column(name="numero_int")
	private String NumeroInt;
	
	@Column(name="codigo_postal")
	private String codigoPostal;
	
	@Column(name="creado_por")
	private String creadoPor;
	
	@Column(name="actualizado_por")
	private String actualizadoPor;
	
	@Column(name="fecha_creacion")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date fechaCreacion;
	
	@Column(name="ultima_fecha_modificacion")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date ultimaFechaModificacion;
	
	@Column(name="estatus")

	private Integer estatus;

	
	        
	
	
	public Long getIdDireccion() {
		return idDireccion;
	}





	public void setIdDireccion(Long idDireccion) {
		this.idDireccion = idDireccion;
	}





	public String getIdText() {
		return idText;
	}





	public void setIdText(String idText) {
		this.idText = idText;
	}





	public String getEstado() {
		return estado;
	}





	public void setEstado(String estado) {
		this.estado = estado;
	}





	public String getMunicipio() {
		return municipio;
	}





	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}





	public String getColonia() {
		return colonia;
	}





	public void setColonia(String colonia) {
		this.colonia = colonia;
	}





	public String getCalle() {
		return calle;
	}





	public void setCalle(String calle) {
		this.calle = calle;
	}





	public String getNumeroExt() {
		return NumeroExt;
	}





	public void setNumeroExt(String numeroExt) {
		NumeroExt = numeroExt;
	}





	public String getNumeroInt() {
		return NumeroInt;
	}





	public void setNumeroInt(String numeroInt) {
		NumeroInt = numeroInt;
	}





	public String getCodigoPostal() {
		return codigoPostal;
	}





	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
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





	public Date getFechaCreacion() {
		return fechaCreacion;
	}





	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}





	public Date getUltimaFechaModificacion() {
		return ultimaFechaModificacion;
	}





	public void setUltimaFechaModificacion(Date ultimaFechaModificacion) {
		this.ultimaFechaModificacion = ultimaFechaModificacion;
	}





	public Integer getEstatus() {
		return estatus;
	}





	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}





	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((NumeroExt == null) ? 0 : NumeroExt.hashCode());
		result = prime * result + ((NumeroInt == null) ? 0 : NumeroInt.hashCode());
		result = prime * result + ((actualizadoPor == null) ? 0 : actualizadoPor.hashCode());
		result = prime * result + ((calle == null) ? 0 : calle.hashCode());
		result = prime * result + ((codigoPostal == null) ? 0 : codigoPostal.hashCode());
		result = prime * result + ((colonia == null) ? 0 : colonia.hashCode());
		result = prime * result + ((creadoPor == null) ? 0 : creadoPor.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((estatus == null) ? 0 : estatus.hashCode());
		result = prime * result + ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
		result = prime * result + ((idDireccion == null) ? 0 : idDireccion.hashCode());
		result = prime * result + ((idText == null) ? 0 : idText.hashCode());
		result = prime * result + ((municipio == null) ? 0 : municipio.hashCode());
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
		HrDireccion other = (HrDireccion) obj;
		if (NumeroExt == null) {
			if (other.NumeroExt != null)
				return false;
		} else if (!NumeroExt.equals(other.NumeroExt))
			return false;
		if (NumeroInt == null) {
			if (other.NumeroInt != null)
				return false;
		} else if (!NumeroInt.equals(other.NumeroInt))
			return false;
		if (actualizadoPor == null) {
			if (other.actualizadoPor != null)
				return false;
		} else if (!actualizadoPor.equals(other.actualizadoPor))
			return false;
		if (calle == null) {
			if (other.calle != null)
				return false;
		} else if (!calle.equals(other.calle))
			return false;
		if (codigoPostal == null) {
			if (other.codigoPostal != null)
				return false;
		} else if (!codigoPostal.equals(other.codigoPostal))
			return false;
		if (colonia == null) {
			if (other.colonia != null)
				return false;
		} else if (!colonia.equals(other.colonia))
			return false;
		if (creadoPor == null) {
			if (other.creadoPor != null)
				return false;
		} else if (!creadoPor.equals(other.creadoPor))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
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
		if (idDireccion == null) {
			if (other.idDireccion != null)
				return false;
		} else if (!idDireccion.equals(other.idDireccion))
			return false;
		if (idText == null) {
			if (other.idText != null)
				return false;
		} else if (!idText.equals(other.idText))
			return false;
		if (municipio == null) {
			if (other.municipio != null)
				return false;
		} else if (!municipio.equals(other.municipio))
			return false;
		if (ultimaFechaModificacion == null) {
			if (other.ultimaFechaModificacion != null)
				return false;
		} else if (!ultimaFechaModificacion.equals(other.ultimaFechaModificacion))
			return false;
		return true;
	}





	@PrePersist
	public void prePersist() {
		fechaCreacion=new Date();
	}
	
	
}
