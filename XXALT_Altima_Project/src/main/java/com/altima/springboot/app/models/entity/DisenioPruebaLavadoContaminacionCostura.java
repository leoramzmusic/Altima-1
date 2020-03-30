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
@Table(name = "alt_disenio_prueba_lavado_contaminacion_costura")
public class DisenioPruebaLavadoContaminacionCostura implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_prueba_lavado_contaminacion_costura")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long idPruebaLavadoContaminacionCostura;
	
	@Column(name="id_prueba")
	private Long idPrueba;
	
	@Column(name="id_calidad")
	private Long idCalidad;
	
	@Column(name="creado_por")
	private String creadoPor;
	
	@Column(name="actualizado_por")
	private String actualizadoPor;
	
	@Column(name="fecha_realizacion")
	private String fechaRealizacion;
	
	@Column(name="fecha_finalizacion")
	private String fechaFinalizacion;

	@Column(name="	tipo_aguja")
	private String tipoAguja;

	@Column(name="deslizamiento_tela")
	private String deslizamientoTela;
	
	@Column(name="observaciones_deslizado")
	private String observacionesDeslizado;
	
	@Column(name="rasgado_tela")
	private String rasgadoTela;
	
	@Column(name="observaciones_rasgado")
	private String observacionesRasgado;
	
	@Column(name="prueba_calidad")
	private String pruebaCalidad;
	
	@Column(name="observaciones_resultados")
	private String observacionesResultados;
	
	@Column(name="prueba_pilling")
	private String prueba_pilling;
	
	@Column(name="estatus")
	private String estatus;
	
	@Column(name="tipo_prueba")
	private String tipoPrueba;
	
	@Column(name="id_tela")
	private String idTela;
	
	
	public Long getIdPruebaLavadoContaminacionCostura() {
		return idPruebaLavadoContaminacionCostura;
	}

	public void setIdPruebaLavadoContaminacionCostura(Long idPruebaLavadoContaminacionCostura) {
		this.idPruebaLavadoContaminacionCostura = idPruebaLavadoContaminacionCostura;
	}

	public Long getIdPrueba() {
		return idPrueba;
	}

	public void setIdPrueba(Long idPrueba) {
		this.idPrueba = idPrueba;
	}

	public Long getIdCalidad() {
		return idCalidad;
	}

	public void setIdCalidad(Long idCalidad) {
		this.idCalidad = idCalidad;
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

	public String getFechaRealizacion() {
		return fechaRealizacion;
	}

	public void setFechaRealizacion(String fechaRealizacion) {
		this.fechaRealizacion = fechaRealizacion;
	}

	public String getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(String fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public String getTipoAguja() {
		return tipoAguja;
	}

	public void setTipoAguja(String tipoAguja) {
		this.tipoAguja = tipoAguja;
	}

	public String getDeslizamientoTela() {
		return deslizamientoTela;
	}

	public void setDeslizamientoTela(String deslizamientoTela) {
		this.deslizamientoTela = deslizamientoTela;
	}

	public String getObservacionDeslizado() {
		return observacionesDeslizado;
	}

	public void setObservacionDeslizado(String observacionDeslizado) {
		this.observacionesDeslizado = observacionDeslizado;
	}

	public String getRasgadoTela() {
		return rasgadoTela;
	}

	public void setRasgadoTela(String rasgadoTela) {
		this.rasgadoTela = rasgadoTela;
	}

	public String getObservacionRasgado() {
		return observacionesRasgado;
	}

	public void setObservacionRasgado(String observacionRasgado) {
		this.observacionesRasgado = observacionRasgado;
	}

	public String getPruebaCalidad() {
		return pruebaCalidad;
	}

	public void setPruebaCalidad(String pruebaCalidad) {
		this.pruebaCalidad = pruebaCalidad;
	}

	public String getObservacionesResultados() {
		return observacionesResultados;
	}

	public void setObservacionesResultados(String observacionesResultados) {
		this.observacionesResultados = observacionesResultados;
	}

	public String getPrueba_pilling() {
		return prueba_pilling;
	}

	public void setPrueba_pilling(String prueba_pilling) {
		this.prueba_pilling = prueba_pilling;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getTipoPrueba() {
		return tipoPrueba;
	}

	public void setTipoPrueba(String tipoPrueba) {
		this.tipoPrueba = tipoPrueba;
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
		result = prime * result + ((actualizadoPor == null) ? 0 : actualizadoPor.hashCode());
		result = prime * result + ((creadoPor == null) ? 0 : creadoPor.hashCode());
		result = prime * result + ((deslizamientoTela == null) ? 0 : deslizamientoTela.hashCode());
		result = prime * result + ((estatus == null) ? 0 : estatus.hashCode());
		result = prime * result + ((fechaFinalizacion == null) ? 0 : fechaFinalizacion.hashCode());
		result = prime * result + ((fechaRealizacion == null) ? 0 : fechaRealizacion.hashCode());
		result = prime * result + ((idCalidad == null) ? 0 : idCalidad.hashCode());
		result = prime * result + ((idPrueba == null) ? 0 : idPrueba.hashCode());
		result = prime * result
				+ ((idPruebaLavadoContaminacionCostura == null) ? 0 : idPruebaLavadoContaminacionCostura.hashCode());
		result = prime * result + ((idTela == null) ? 0 : idTela.hashCode());
		result = prime * result + ((observacionesDeslizado == null) ? 0 : observacionesDeslizado.hashCode());
		result = prime * result + ((observacionesRasgado == null) ? 0 : observacionesRasgado.hashCode());
		result = prime * result + ((observacionesResultados == null) ? 0 : observacionesResultados.hashCode());
		result = prime * result + ((pruebaCalidad == null) ? 0 : pruebaCalidad.hashCode());
		result = prime * result + ((prueba_pilling == null) ? 0 : prueba_pilling.hashCode());
		result = prime * result + ((rasgadoTela == null) ? 0 : rasgadoTela.hashCode());
		result = prime * result + ((tipoAguja == null) ? 0 : tipoAguja.hashCode());
		result = prime * result + ((tipoPrueba == null) ? 0 : tipoPrueba.hashCode());
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
		DisenioPruebaLavadoContaminacionCostura other = (DisenioPruebaLavadoContaminacionCostura) obj;
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
		if (deslizamientoTela == null) {
			if (other.deslizamientoTela != null)
				return false;
		} else if (!deslizamientoTela.equals(other.deslizamientoTela))
			return false;
		if (estatus == null) {
			if (other.estatus != null)
				return false;
		} else if (!estatus.equals(other.estatus))
			return false;
		if (fechaFinalizacion == null) {
			if (other.fechaFinalizacion != null)
				return false;
		} else if (!fechaFinalizacion.equals(other.fechaFinalizacion))
			return false;
		if (fechaRealizacion == null) {
			if (other.fechaRealizacion != null)
				return false;
		} else if (!fechaRealizacion.equals(other.fechaRealizacion))
			return false;
		if (idCalidad == null) {
			if (other.idCalidad != null)
				return false;
		} else if (!idCalidad.equals(other.idCalidad))
			return false;
		if (idPrueba == null) {
			if (other.idPrueba != null)
				return false;
		} else if (!idPrueba.equals(other.idPrueba))
			return false;
		if (idPruebaLavadoContaminacionCostura == null) {
			if (other.idPruebaLavadoContaminacionCostura != null)
				return false;
		} else if (!idPruebaLavadoContaminacionCostura.equals(other.idPruebaLavadoContaminacionCostura))
			return false;
		if (idTela == null) {
			if (other.idTela != null)
				return false;
		} else if (!idTela.equals(other.idTela))
			return false;
		if (observacionesDeslizado == null) {
			if (other.observacionesDeslizado != null)
				return false;
		} else if (!observacionesDeslizado.equals(other.observacionesDeslizado))
			return false;
		if (observacionesRasgado == null) {
			if (other.observacionesRasgado != null)
				return false;
		} else if (!observacionesRasgado.equals(other.observacionesRasgado))
			return false;
		if (observacionesResultados == null) {
			if (other.observacionesResultados != null)
				return false;
		} else if (!observacionesResultados.equals(other.observacionesResultados))
			return false;
		if (pruebaCalidad == null) {
			if (other.pruebaCalidad != null)
				return false;
		} else if (!pruebaCalidad.equals(other.pruebaCalidad))
			return false;
		if (prueba_pilling == null) {
			if (other.prueba_pilling != null)
				return false;
		} else if (!prueba_pilling.equals(other.prueba_pilling))
			return false;
		if (rasgadoTela == null) {
			if (other.rasgadoTela != null)
				return false;
		} else if (!rasgadoTela.equals(other.rasgadoTela))
			return false;
		if (tipoAguja == null) {
			if (other.tipoAguja != null)
				return false;
		} else if (!tipoAguja.equals(other.tipoAguja))
			return false;
		if (tipoPrueba == null) {
			if (other.tipoPrueba != null)
				return false;
		} else if (!tipoPrueba.equals(other.tipoPrueba))
			return false;
		return true;
	}

	
	
	
	
	
	

}
