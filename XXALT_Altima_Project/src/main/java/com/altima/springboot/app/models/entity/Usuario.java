package com.altima.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "xxalt_usuario")

public class Usuario  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="id_usuario")
	@NotBlank
	private Long idUsuario;
	
	@Column(name="id_rol")
	@NotBlank
	private Long idRol;
	
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

	public Long getIdUsuario() {
		return idUsuario;
	}
	
	//@ManyToMany(fetch = FetchType.LAZY) //campo que une dos tablas por medio de los ID
			//@JoinTable(name=""
				//,joinColumns=@JoinColumn(name="")
				//,inverseJoinColumns=@JoinColumn(name=""))
			//private Set<Rol> rol;
			
			
			
			//public Set<Rol> getRol() {
				//return rol;
		

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actualizadoPor == null) ? 0 : actualizadoPor.hashCode());
		result = prime * result + ((creadoPor == null) ? 0 : creadoPor.hashCode());
		result = prime * result + ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
		result = prime * result + ((idRol == null) ? 0 : idRol.hashCode());
		result = prime * result + ((idText == null) ? 0 : idText.hashCode());
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
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
		Usuario other = (Usuario) obj;
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
		if (fechaCreacion == null) {
			if (other.fechaCreacion != null)
				return false;
		} else if (!fechaCreacion.equals(other.fechaCreacion))
			return false;
		if (idRol == null) {
			if (other.idRol != null)
				return false;
		} else if (!idRol.equals(other.idRol))
			return false;
		if (idText == null) {
			if (other.idText != null)
				return false;
		} else if (!idText.equals(other.idText))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (ultimaFechaModificacion == null) {
			if (other.ultimaFechaModificacion != null)
				return false;
		} else if (!ultimaFechaModificacion.equals(other.ultimaFechaModificacion))
			return false;
		return true;
	}
}
