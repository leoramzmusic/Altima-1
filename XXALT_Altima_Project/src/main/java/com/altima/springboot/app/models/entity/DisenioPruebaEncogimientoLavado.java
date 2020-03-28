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
@Table(name = "alt_disenio_prueba_encogimiento_lavado")
public class DisenioPruebaEncogimientoLavado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_prueba_encogimiento_lavado")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long idPruebaEncogimientoLavado;
	
	@Column(name="id_prueba")
	private Long idPrueba;
	
	@Column(name="id_calidad")
	private Long idCalidad;

	@Column(name="entretela_prueba_vapor")
	private String entretelaPruebaVapor;
	
	@Column(name="creado_por")
	private String creadoPor;
	
	@Column(name="actualizado_por")
	private String actualizadoPor;
	
	@Column(name="fecha_realizacion")
	private String fechaRealizacion;
	
	@Column(name="fecha_finalizacion")
	private String fechaFinalizacion;
	
	@Column(name="proveedor_prueba_vapor")
	private String proveedorPruebaVapor;
	
	@Column(name="temperatura_prueba_vapor")
	private String temperaturaPruebaVapor;
	
	@Column(name="tiempo_prueba")
	private String tiempoPrueba;
	
	@Column(name="presion_prueba")
	private String presionPrueba;
	
	@Column(name="medida_inicial_hilo")
	private String medidaInicialHilo;
	
	@Column(name="medida_inicial_trama")
	private String medidaInicialTrama;
	
	@Column(name="medida_final_hilo")
	private String medidaFinalHilo;
	
	@Column(name="diferencia_medida_hilo")
	private String diferenciaMedidaHilo;
	
	@Column(name="medida_final_trama")
	private String medidaFinalTrama;
	
	@Column(name="diferencia_medida_trama")
	private String diferenciaMedidaTrama;
	
	@Column(name="observaciones_resultados")
	private String observacionesResultados;
	
	@Column(name="tipo_prueba")
	private String tipoPrueba;
	
	@Column(name="id_tela")
	private String idTela;
	
	@Column(name="estatus")
	private String estatus;

	public Long getIdPruebaEncogimientoLavado() {
		return idPruebaEncogimientoLavado;
	}

	public void setIdPruebaEncogimientoLavado(Long idPruebaEncogimientoLavado) {
		this.idPruebaEncogimientoLavado = idPruebaEncogimientoLavado;
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

	public String getEntretelaPruebaVapor() {
		return entretelaPruebaVapor;
	}

	public void setEntretelaPruebaVapor(String entretelaPruebaVapor) {
		this.entretelaPruebaVapor = entretelaPruebaVapor;
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

	public String getProveedorPruebaVapor() {
		return proveedorPruebaVapor;
	}

	public void setProveedorPruebaVapor(String proveedorPruebaVapor) {
		this.proveedorPruebaVapor = proveedorPruebaVapor;
	}

	public String getTemperaturaPruebaVapor() {
		return temperaturaPruebaVapor;
	}

	public void setTemperaturaPruebaVapor(String temperaturaPruebaVapor) {
		this.temperaturaPruebaVapor = temperaturaPruebaVapor;
	}

	public String getTiempoPrueba() {
		return tiempoPrueba;
	}

	public void setTiempoPrueba(String tiempoPrueba) {
		this.tiempoPrueba = tiempoPrueba;
	}

	public String getPresionPrueba() {
		return presionPrueba;
	}

	public void setPresionPrueba(String presionPrueba) {
		this.presionPrueba = presionPrueba;
	}

	public String getMedidaInicialHilo() {
		return medidaInicialHilo;
	}

	public void setMedidaInicialHilo(String medidaInicialHilo) {
		this.medidaInicialHilo = medidaInicialHilo;
	}

	public String getMedidaInicialTrama() {
		return medidaInicialTrama;
	}

	public void setMedidaInicialTrama(String medidaInicialTrama) {
		this.medidaInicialTrama = medidaInicialTrama;
	}

	public String getMedidaFinalHilo() {
		return medidaFinalHilo;
	}

	public void setMedidaFinalHilo(String medidaFinalHilo) {
		this.medidaFinalHilo = medidaFinalHilo;
	}

	public String getDiferenciaMedidaHilo() {
		return diferenciaMedidaHilo;
	}

	public void setDiferenciaMedidaHilo(String diferenciaMedidaHilo) {
		this.diferenciaMedidaHilo = diferenciaMedidaHilo;
	}

	public String getMedidaFinalTrama() {
		return medidaFinalTrama;
	}

	public void setMedidaFinalTrama(String medidaFinalTrama) {
		this.medidaFinalTrama = medidaFinalTrama;
	}

	public String getDiferenciaMedidaTrama() {
		return diferenciaMedidaTrama;
	}

	public void setDiferenciaMedidaTrama(String diferenciaMedidaTrama) {
		this.diferenciaMedidaTrama = diferenciaMedidaTrama;
	}

	public String getObservacionesResultados() {
		return observacionesResultados;
	}

	public void setObservacionesResultados(String observacionesResultados) {
		this.observacionesResultados = observacionesResultados;
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
		result = prime * result + ((diferenciaMedidaHilo == null) ? 0 : diferenciaMedidaHilo.hashCode());
		result = prime * result + ((diferenciaMedidaTrama == null) ? 0 : diferenciaMedidaTrama.hashCode());
		result = prime * result + ((entretelaPruebaVapor == null) ? 0 : entretelaPruebaVapor.hashCode());
		result = prime * result + ((estatus == null) ? 0 : estatus.hashCode());
		result = prime * result + ((fechaFinalizacion == null) ? 0 : fechaFinalizacion.hashCode());
		result = prime * result + ((fechaRealizacion == null) ? 0 : fechaRealizacion.hashCode());
		result = prime * result + ((idCalidad == null) ? 0 : idCalidad.hashCode());
		result = prime * result + ((idPrueba == null) ? 0 : idPrueba.hashCode());
		result = prime * result + ((idPruebaEncogimientoLavado == null) ? 0 : idPruebaEncogimientoLavado.hashCode());
		result = prime * result + ((idTela == null) ? 0 : idTela.hashCode());
		result = prime * result + ((medidaFinalHilo == null) ? 0 : medidaFinalHilo.hashCode());
		result = prime * result + ((medidaFinalTrama == null) ? 0 : medidaFinalTrama.hashCode());
		result = prime * result + ((medidaInicialHilo == null) ? 0 : medidaInicialHilo.hashCode());
		result = prime * result + ((medidaInicialTrama == null) ? 0 : medidaInicialTrama.hashCode());
		result = prime * result + ((observacionesResultados == null) ? 0 : observacionesResultados.hashCode());
		result = prime * result + ((presionPrueba == null) ? 0 : presionPrueba.hashCode());
		result = prime * result + ((proveedorPruebaVapor == null) ? 0 : proveedorPruebaVapor.hashCode());
		result = prime * result + ((temperaturaPruebaVapor == null) ? 0 : temperaturaPruebaVapor.hashCode());
		result = prime * result + ((tiempoPrueba == null) ? 0 : tiempoPrueba.hashCode());
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
		DisenioPruebaEncogimientoLavado other = (DisenioPruebaEncogimientoLavado) obj;
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
		if (diferenciaMedidaHilo == null) {
			if (other.diferenciaMedidaHilo != null)
				return false;
		} else if (!diferenciaMedidaHilo.equals(other.diferenciaMedidaHilo))
			return false;
		if (diferenciaMedidaTrama == null) {
			if (other.diferenciaMedidaTrama != null)
				return false;
		} else if (!diferenciaMedidaTrama.equals(other.diferenciaMedidaTrama))
			return false;
		if (entretelaPruebaVapor == null) {
			if (other.entretelaPruebaVapor != null)
				return false;
		} else if (!entretelaPruebaVapor.equals(other.entretelaPruebaVapor))
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
		if (idPruebaEncogimientoLavado == null) {
			if (other.idPruebaEncogimientoLavado != null)
				return false;
		} else if (!idPruebaEncogimientoLavado.equals(other.idPruebaEncogimientoLavado))
			return false;
		if (idTela == null) {
			if (other.idTela != null)
				return false;
		} else if (!idTela.equals(other.idTela))
			return false;
		if (medidaFinalHilo == null) {
			if (other.medidaFinalHilo != null)
				return false;
		} else if (!medidaFinalHilo.equals(other.medidaFinalHilo))
			return false;
		if (medidaFinalTrama == null) {
			if (other.medidaFinalTrama != null)
				return false;
		} else if (!medidaFinalTrama.equals(other.medidaFinalTrama))
			return false;
		if (medidaInicialHilo == null) {
			if (other.medidaInicialHilo != null)
				return false;
		} else if (!medidaInicialHilo.equals(other.medidaInicialHilo))
			return false;
		if (medidaInicialTrama == null) {
			if (other.medidaInicialTrama != null)
				return false;
		} else if (!medidaInicialTrama.equals(other.medidaInicialTrama))
			return false;
		if (observacionesResultados == null) {
			if (other.observacionesResultados != null)
				return false;
		} else if (!observacionesResultados.equals(other.observacionesResultados))
			return false;
		if (presionPrueba == null) {
			if (other.presionPrueba != null)
				return false;
		} else if (!presionPrueba.equals(other.presionPrueba))
			return false;
		if (proveedorPruebaVapor == null) {
			if (other.proveedorPruebaVapor != null)
				return false;
		} else if (!proveedorPruebaVapor.equals(other.proveedorPruebaVapor))
			return false;
		if (temperaturaPruebaVapor == null) {
			if (other.temperaturaPruebaVapor != null)
				return false;
		} else if (!temperaturaPruebaVapor.equals(other.temperaturaPruebaVapor))
			return false;
		if (tiempoPrueba == null) {
			if (other.tiempoPrueba != null)
				return false;
		} else if (!tiempoPrueba.equals(other.tiempoPrueba))
			return false;
		if (tipoPrueba == null) {
			if (other.tipoPrueba != null)
				return false;
		} else if (!tipoPrueba.equals(other.tipoPrueba))
			return false;
		return true;
	}
}
