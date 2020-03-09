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
@Table(name = "alt_disenio_material")
public class DisenioMaterial implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_material")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long idMaterial;
	
	@Column(name="id_lookup")
	@NotBlank
	private Long idLookup;
	
	@Column(name="id_lookup2")
	@NotBlank
	private Long idLookup2;
	
	@Column(name="id_proceso")
	@NotBlank
	private Long idProceso;

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

	@Column(name="descripcion_material")
	@NotBlank
	private String descripcionMaterial;
	
	@Column(name="unidad_medida")
	@NotBlank
	private String unidadMedida;
	
	@Column(name="modelo")
	@NotBlank
	private String modelo;
	
	@Column(name="precio_unitario")
	@NotBlank
	private String precioUnitario;
	
	@Column(name="explosion")
	@NotBlank
	private String explosion;
	
	@Column(name="incluir_en_patronaje")
	@NotBlank
	private String incluirEnPatronaje;
	
	@Column(name="tamanio")
	@NotBlank
	private String tamanio;
	
	@Column(name="modelo_proveedor")
	@NotBlank
	private String modeloProveedor;
	
	@Column(name="id_almacen")
	@NotBlank
	private Long idAlmacen;

	public Long getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(Long idMaterial) {
		this.idMaterial = idMaterial;
	}

	public Long getIdLookup() {
		return idLookup;
	}

	public void setIdLookup(Long idLookup) {
		this.idLookup = idLookup;
	}

	public Long getIdLookup2() {
		return idLookup2;
	}

	public void setIdLookup2(Long idLookup2) {
		this.idLookup2 = idLookup2;
	}

	public Long getIdProceso() {
		return idProceso;
	}

	public void setIdProceso(Long idProceso) {
		this.idProceso = idProceso;
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

	public String getDescripcionMaterial() {
		return descripcionMaterial;
	}

	public void setDescripcionMaterial(String descripcionMaterial) {
		this.descripcionMaterial = descripcionMaterial;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(String precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public String getExplosion() {
		return explosion;
	}

	public void setExplosion(String explosion) {
		this.explosion = explosion;
	}

	public String getIncluirEnPatronaje() {
		return incluirEnPatronaje;
	}

	public void setIncluirEnPatronaje(String incluirEnPatronaje) {
		this.incluirEnPatronaje = incluirEnPatronaje;
	}

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public String getModeloProveedor() {
		return modeloProveedor;
	}

	public void setModeloProveedor(String modeloProveedor) {
		this.modeloProveedor = modeloProveedor;
	}

	public Long getIdAlmacen() {
		return idAlmacen;
	}

	public void setIdAlmacen(Long idAlmacen) {
		this.idAlmacen = idAlmacen;
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
		result = prime * result + ((descripcionMaterial == null) ? 0 : descripcionMaterial.hashCode());
		result = prime * result + ((explosion == null) ? 0 : explosion.hashCode());
		result = prime * result + ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
		result = prime * result + ((idAlmacen == null) ? 0 : idAlmacen.hashCode());
		result = prime * result + ((idLookup == null) ? 0 : idLookup.hashCode());
		result = prime * result + ((idLookup2 == null) ? 0 : idLookup2.hashCode());
		result = prime * result + ((idMaterial == null) ? 0 : idMaterial.hashCode());
		result = prime * result + ((idProceso == null) ? 0 : idProceso.hashCode());
		result = prime * result + ((idText == null) ? 0 : idText.hashCode());
		result = prime * result + ((incluirEnPatronaje == null) ? 0 : incluirEnPatronaje.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((modeloProveedor == null) ? 0 : modeloProveedor.hashCode());
		result = prime * result + ((precioUnitario == null) ? 0 : precioUnitario.hashCode());
		result = prime * result + ((tamanio == null) ? 0 : tamanio.hashCode());
		result = prime * result + ((ultimaFechaModificacion == null) ? 0 : ultimaFechaModificacion.hashCode());
		result = prime * result + ((unidadMedida == null) ? 0 : unidadMedida.hashCode());
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
		DisenioMaterial other = (DisenioMaterial) obj;
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
		if (descripcionMaterial == null) {
			if (other.descripcionMaterial != null)
				return false;
		} else if (!descripcionMaterial.equals(other.descripcionMaterial))
			return false;
		if (explosion == null) {
			if (other.explosion != null)
				return false;
		} else if (!explosion.equals(other.explosion))
			return false;
		if (fechaCreacion == null) {
			if (other.fechaCreacion != null)
				return false;
		} else if (!fechaCreacion.equals(other.fechaCreacion))
			return false;
		if (idAlmacen == null) {
			if (other.idAlmacen != null)
				return false;
		} else if (!idAlmacen.equals(other.idAlmacen))
			return false;
		if (idLookup == null) {
			if (other.idLookup != null)
				return false;
		} else if (!idLookup.equals(other.idLookup))
			return false;
		if (idLookup2 == null) {
			if (other.idLookup2 != null)
				return false;
		} else if (!idLookup2.equals(other.idLookup2))
			return false;
		if (idMaterial == null) {
			if (other.idMaterial != null)
				return false;
		} else if (!idMaterial.equals(other.idMaterial))
			return false;
		if (idProceso == null) {
			if (other.idProceso != null)
				return false;
		} else if (!idProceso.equals(other.idProceso))
			return false;
		if (idText == null) {
			if (other.idText != null)
				return false;
		} else if (!idText.equals(other.idText))
			return false;
		if (incluirEnPatronaje == null) {
			if (other.incluirEnPatronaje != null)
				return false;
		} else if (!incluirEnPatronaje.equals(other.incluirEnPatronaje))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (modeloProveedor == null) {
			if (other.modeloProveedor != null)
				return false;
		} else if (!modeloProveedor.equals(other.modeloProveedor))
			return false;
		if (precioUnitario == null) {
			if (other.precioUnitario != null)
				return false;
		} else if (!precioUnitario.equals(other.precioUnitario))
			return false;
		if (tamanio == null) {
			if (other.tamanio != null)
				return false;
		} else if (!tamanio.equals(other.tamanio))
			return false;
		if (ultimaFechaModificacion == null) {
			if (other.ultimaFechaModificacion != null)
				return false;
		} else if (!ultimaFechaModificacion.equals(other.ultimaFechaModificacion))
			return false;
		if (unidadMedida == null) {
			if (other.unidadMedida != null)
				return false;
		} else if (!unidadMedida.equals(other.unidadMedida))
			return false;
		return true;
	}
}
