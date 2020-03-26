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
@Table(name = "alt_disenio_prenda")
public class DisenioPrenda implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_prenda")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long idPrenda;
	
	@Column(name="id_familia_prenda")
	private Long idFamiliaPrenda;
	
	@Column(name="id_text")
	private String idText;
	
	@Column(name="creado_por")
	private String creadoPor;
	
	@Column(name="actualizado_por")
	private String actualizadoPor;
	
	@Column(name="fecha_creacion")
	private String fechaCreacion;
	
	@Column(name="ultima_fecha_modificacion")
	private String ultimaFechaModificacion;
	
	@Column(name="numero_prenda")
	private String numeroPrenda;
	
	@Column(name="nombre_prenda")
	private String nombrePrenda;
	
	@Column(name="descripcion_prenda")
	private String descripcionPrenda;
	
	@Column(name="tipo_prenda")
	private String tipoPrenda;
	
	@Column(name="detalle_prenda")
	private String detallePrenda;
	
	@Column(name="nota_especial")
	private String notaEspecial;
	
	@Column(name="detalle_confeccion")
	private String detalleConfeccion;
	
	@Column(name="marcadores")
	private String marcadores;
	
	@Column(name="consumo_tela")
	private String consumoTela;
	
	@Column(name="consumo_forro")
	private String consumoForro;
	
	@Column(name="precio")
	private String precio;
	
	@Column(name="dibujo_frente")
	private String dibujoFrente;
	
	@Column(name="dibujo_espalda")
	private String dibujoEspalda;
	
	@Column(name="precio_local_actual")
	private String precioLocalActual;
	
	@Column(name="precio_local_anterior")
	private String precioLocalAnterior;
	
	@Column(name="precio_foraneo_actual")
	private String precioForaneoActual;
	
	@Column(name="precio_foraneo_anterior")
	private String precioForaneoAnterior;
	
	@Column(name="cve_ruta")
	private String cveRuta;
	
	@Column(name="cve_prenda")
	private String cvePrenda;

	@Column(name="tipo_largo")
	private String tipoLargo;
	
	@Column(name="especificacion")
	private String especificacion;
	
	@Column(name="imprimir_etiquetas")
	private String imprimirEtiquetas;
	
	@Column(name="modelo_boton")
	private String modeloBoton;
	
	@Column(name="estatus_recepcion_muestra")
	private String estatusRecepcionMuestra;
	
	@Column(name="fecha_recepcion_muestra")
	private String fechaRecepcionMuestra;
	
	@Column(name="devolucion")
	private String devolucion;
	
	@Column(name="precio_m_prod")
	private String precioMprod;
	
	@Column(name="precio_m_muestra")
	private String precioMmuestra;

	@Column(name="categoria")
	private String categoria;
	
	@Column(name="combinacion")
	private String combinacion;
	
	@Column(name="total_prendas")
	private String totalPrendas;
	
	@Column(name="mostrar")
	private String mostrar;
	
	@Column(name="estatus")
	private Long estatus;

	public Long getIdPrenda() {
		return idPrenda;
	}

	public void setIdPrenda(Long idPrenda) {
		this.idPrenda = idPrenda;
	}

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

	public String getNumeroPrenda() {
		return numeroPrenda;
	}

	public void setNumeroPrenda(String numeroPrenda) {
		this.numeroPrenda = numeroPrenda;
	}

	public String getNombrePrenda() {
		return nombrePrenda;
	}

	public void setNombrePrenda(String nombrePrenda) {
		this.nombrePrenda = nombrePrenda;
	}

	public String getDescripcionPrenda() {
		return descripcionPrenda;
	}

	public void setDescripcionPrenda(String descripcionPrenda) {
		this.descripcionPrenda = descripcionPrenda;
	}

	public String getTipoPrenda() {
		return tipoPrenda;
	}

	public void setTipoPrenda(String tipoPrenda) {
		this.tipoPrenda = tipoPrenda;
	}

	public String getDetallePrenda() {
		return detallePrenda;
	}

	public void setDetallePrenda(String detallePrenda) {
		this.detallePrenda = detallePrenda;
	}

	public String getNotaEspecial() {
		return notaEspecial;
	}

	public void setNotaEspecial(String notaEspecial) {
		this.notaEspecial = notaEspecial;
	}

	public String getDetalleConfeccion() {
		return detalleConfeccion;
	}

	public void setDetalleConfeccion(String detalleConfeccion) {
		this.detalleConfeccion = detalleConfeccion;
	}

	public String getMarcadores() {
		return marcadores;
	}

	public void setMarcadores(String marcadores) {
		this.marcadores = marcadores;
	}

	public String getConsumoTela() {
		return consumoTela;
	}

	public void setConsumoTela(String consumoTela) {
		this.consumoTela = consumoTela;
	}

	public String getConsumoForro() {
		return consumoForro;
	}

	public void setConsumoForro(String consumoForro) {
		this.consumoForro = consumoForro;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getDibujoFrente() {
		return dibujoFrente;
	}

	public void setDibujoFrente(String dibujoFrente) {
		this.dibujoFrente = dibujoFrente;
	}

	public String getDibujoEspalda() {
		return dibujoEspalda;
	}

	public void setDibujoEspalda(String dibujoEspalda) {
		this.dibujoEspalda = dibujoEspalda;
	}

	public String getPrecioLocalActual() {
		return precioLocalActual;
	}

	public void setPrecioLocalActual(String precioLocalActual) {
		this.precioLocalActual = precioLocalActual;
	}

	public String getPrecioLocalAnterior() {
		return precioLocalAnterior;
	}

	public void setPrecioLocalAnterior(String precioLocalAnterior) {
		this.precioLocalAnterior = precioLocalAnterior;
	}

	public String getPrecioForaneoActual() {
		return precioForaneoActual;
	}

	public void setPrecioForaneoActual(String precioForaneoActual) {
		this.precioForaneoActual = precioForaneoActual;
	}

	public String getPrecioForaneoAnterior() {
		return precioForaneoAnterior;
	}

	public void setPrecioForaneoAnterior(String precioForaneoAnterior) {
		this.precioForaneoAnterior = precioForaneoAnterior;
	}

	public String getCveRuta() {
		return cveRuta;
	}

	public void setCveRuta(String cveRuta) {
		this.cveRuta = cveRuta;
	}

	public String getCvePrenda() {
		return cvePrenda;
	}

	public void setCvePrenda(String cvePrenda) {
		this.cvePrenda = cvePrenda;
	}

	public String getTipoLargo() {
		return tipoLargo;
	}

	public void setTipoLargo(String tipoLargo) {
		this.tipoLargo = tipoLargo;
	}

	public String getEspecificacion() {
		return especificacion;
	}

	public void setEspecificacion(String especificacion) {
		this.especificacion = especificacion;
	}

	public String getImprimirEtiquetas() {
		return imprimirEtiquetas;
	}

	public void setImprimirEtiquetas(String imprimirEtiquetas) {
		this.imprimirEtiquetas = imprimirEtiquetas;
	}

	public String getModeloBoton() {
		return modeloBoton;
	}

	public void setModeloBoton(String modeloBoton) {
		this.modeloBoton = modeloBoton;
	}

	public String getEstatusRecepcionMuestra() {
		return estatusRecepcionMuestra;
	}

	public void setEstatusRecepcionMuestra(String estatusRecepcionMuestra) {
		this.estatusRecepcionMuestra = estatusRecepcionMuestra;
	}

	public String getFechaRecepcionMuestra() {
		return fechaRecepcionMuestra;
	}

	public void setFechaRecepcionMuestra(String fechaRecepcionMuestra) {
		this.fechaRecepcionMuestra = fechaRecepcionMuestra;
	}

	public String getDevolucion() {
		return devolucion;
	}

	public void setDevolucion(String devolucion) {
		this.devolucion = devolucion;
	}

	public String getPrecioMprod() {
		return precioMprod;
	}

	public void setPrecioMprod(String precioMprod) {
		this.precioMprod = precioMprod;
	}

	public String getPrecioMmuestra() {
		return precioMmuestra;
	}

	public void setPrecioMmuestra(String precioMmuestra) {
		this.precioMmuestra = precioMmuestra;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCombinacion() {
		return combinacion;
	}

	public void setCombinacion(String combinacion) {
		this.combinacion = combinacion;
	}

	public String getTotalPrendas() {
		return totalPrendas;
	}

	public void setTotalPrendas(String totalPrendas) {
		this.totalPrendas = totalPrendas;
	}

	public String getMostrar() {
		return mostrar;
	}

	public void setMostrar(String mostrar) {
		this.mostrar = mostrar;
	}

	public Long getEstatus() {
		return estatus;
	}

	public void setEstatus(Long estatus) {
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
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((combinacion == null) ? 0 : combinacion.hashCode());
		result = prime * result + ((consumoForro == null) ? 0 : consumoForro.hashCode());
		result = prime * result + ((consumoTela == null) ? 0 : consumoTela.hashCode());
		result = prime * result + ((creadoPor == null) ? 0 : creadoPor.hashCode());
		result = prime * result + ((cvePrenda == null) ? 0 : cvePrenda.hashCode());
		result = prime * result + ((cveRuta == null) ? 0 : cveRuta.hashCode());
		result = prime * result + ((descripcionPrenda == null) ? 0 : descripcionPrenda.hashCode());
		result = prime * result + ((detalleConfeccion == null) ? 0 : detalleConfeccion.hashCode());
		result = prime * result + ((detallePrenda == null) ? 0 : detallePrenda.hashCode());
		result = prime * result + ((devolucion == null) ? 0 : devolucion.hashCode());
		result = prime * result + ((dibujoEspalda == null) ? 0 : dibujoEspalda.hashCode());
		result = prime * result + ((dibujoFrente == null) ? 0 : dibujoFrente.hashCode());
		result = prime * result + ((especificacion == null) ? 0 : especificacion.hashCode());
		result = prime * result + ((estatus == null) ? 0 : estatus.hashCode());
		result = prime * result + ((estatusRecepcionMuestra == null) ? 0 : estatusRecepcionMuestra.hashCode());
		result = prime * result + ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
		result = prime * result + ((fechaRecepcionMuestra == null) ? 0 : fechaRecepcionMuestra.hashCode());
		result = prime * result + ((idFamiliaPrenda == null) ? 0 : idFamiliaPrenda.hashCode());
		result = prime * result + ((idPrenda == null) ? 0 : idPrenda.hashCode());
		result = prime * result + ((idText == null) ? 0 : idText.hashCode());
		result = prime * result + ((imprimirEtiquetas == null) ? 0 : imprimirEtiquetas.hashCode());
		result = prime * result + ((marcadores == null) ? 0 : marcadores.hashCode());
		result = prime * result + ((modeloBoton == null) ? 0 : modeloBoton.hashCode());
		result = prime * result + ((mostrar == null) ? 0 : mostrar.hashCode());
		result = prime * result + ((nombrePrenda == null) ? 0 : nombrePrenda.hashCode());
		result = prime * result + ((notaEspecial == null) ? 0 : notaEspecial.hashCode());
		result = prime * result + ((numeroPrenda == null) ? 0 : numeroPrenda.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		result = prime * result + ((precioForaneoActual == null) ? 0 : precioForaneoActual.hashCode());
		result = prime * result + ((precioForaneoAnterior == null) ? 0 : precioForaneoAnterior.hashCode());
		result = prime * result + ((precioLocalActual == null) ? 0 : precioLocalActual.hashCode());
		result = prime * result + ((precioLocalAnterior == null) ? 0 : precioLocalAnterior.hashCode());
		result = prime * result + ((precioMmuestra == null) ? 0 : precioMmuestra.hashCode());
		result = prime * result + ((precioMprod == null) ? 0 : precioMprod.hashCode());
		result = prime * result + ((tipoLargo == null) ? 0 : tipoLargo.hashCode());
		result = prime * result + ((tipoPrenda == null) ? 0 : tipoPrenda.hashCode());
		result = prime * result + ((totalPrendas == null) ? 0 : totalPrendas.hashCode());
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
		DisenioPrenda other = (DisenioPrenda) obj;
		if (actualizadoPor == null) {
			if (other.actualizadoPor != null)
				return false;
		} else if (!actualizadoPor.equals(other.actualizadoPor))
			return false;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (combinacion == null) {
			if (other.combinacion != null)
				return false;
		} else if (!combinacion.equals(other.combinacion))
			return false;
		if (consumoForro == null) {
			if (other.consumoForro != null)
				return false;
		} else if (!consumoForro.equals(other.consumoForro))
			return false;
		if (consumoTela == null) {
			if (other.consumoTela != null)
				return false;
		} else if (!consumoTela.equals(other.consumoTela))
			return false;
		if (creadoPor == null) {
			if (other.creadoPor != null)
				return false;
		} else if (!creadoPor.equals(other.creadoPor))
			return false;
		if (cvePrenda == null) {
			if (other.cvePrenda != null)
				return false;
		} else if (!cvePrenda.equals(other.cvePrenda))
			return false;
		if (cveRuta == null) {
			if (other.cveRuta != null)
				return false;
		} else if (!cveRuta.equals(other.cveRuta))
			return false;
		if (descripcionPrenda == null) {
			if (other.descripcionPrenda != null)
				return false;
		} else if (!descripcionPrenda.equals(other.descripcionPrenda))
			return false;
		if (detalleConfeccion == null) {
			if (other.detalleConfeccion != null)
				return false;
		} else if (!detalleConfeccion.equals(other.detalleConfeccion))
			return false;
		if (detallePrenda == null) {
			if (other.detallePrenda != null)
				return false;
		} else if (!detallePrenda.equals(other.detallePrenda))
			return false;
		if (devolucion == null) {
			if (other.devolucion != null)
				return false;
		} else if (!devolucion.equals(other.devolucion))
			return false;
		if (dibujoEspalda == null) {
			if (other.dibujoEspalda != null)
				return false;
		} else if (!dibujoEspalda.equals(other.dibujoEspalda))
			return false;
		if (dibujoFrente == null) {
			if (other.dibujoFrente != null)
				return false;
		} else if (!dibujoFrente.equals(other.dibujoFrente))
			return false;
		if (especificacion == null) {
			if (other.especificacion != null)
				return false;
		} else if (!especificacion.equals(other.especificacion))
			return false;
		if (estatus == null) {
			if (other.estatus != null)
				return false;
		} else if (!estatus.equals(other.estatus))
			return false;
		if (estatusRecepcionMuestra == null) {
			if (other.estatusRecepcionMuestra != null)
				return false;
		} else if (!estatusRecepcionMuestra.equals(other.estatusRecepcionMuestra))
			return false;
		if (fechaCreacion == null) {
			if (other.fechaCreacion != null)
				return false;
		} else if (!fechaCreacion.equals(other.fechaCreacion))
			return false;
		if (fechaRecepcionMuestra == null) {
			if (other.fechaRecepcionMuestra != null)
				return false;
		} else if (!fechaRecepcionMuestra.equals(other.fechaRecepcionMuestra))
			return false;
		if (idFamiliaPrenda == null) {
			if (other.idFamiliaPrenda != null)
				return false;
		} else if (!idFamiliaPrenda.equals(other.idFamiliaPrenda))
			return false;
		if (idPrenda == null) {
			if (other.idPrenda != null)
				return false;
		} else if (!idPrenda.equals(other.idPrenda))
			return false;
		if (idText == null) {
			if (other.idText != null)
				return false;
		} else if (!idText.equals(other.idText))
			return false;
		if (imprimirEtiquetas == null) {
			if (other.imprimirEtiquetas != null)
				return false;
		} else if (!imprimirEtiquetas.equals(other.imprimirEtiquetas))
			return false;
		if (marcadores == null) {
			if (other.marcadores != null)
				return false;
		} else if (!marcadores.equals(other.marcadores))
			return false;
		if (modeloBoton == null) {
			if (other.modeloBoton != null)
				return false;
		} else if (!modeloBoton.equals(other.modeloBoton))
			return false;
		if (mostrar == null) {
			if (other.mostrar != null)
				return false;
		} else if (!mostrar.equals(other.mostrar))
			return false;
		if (nombrePrenda == null) {
			if (other.nombrePrenda != null)
				return false;
		} else if (!nombrePrenda.equals(other.nombrePrenda))
			return false;
		if (notaEspecial == null) {
			if (other.notaEspecial != null)
				return false;
		} else if (!notaEspecial.equals(other.notaEspecial))
			return false;
		if (numeroPrenda == null) {
			if (other.numeroPrenda != null)
				return false;
		} else if (!numeroPrenda.equals(other.numeroPrenda))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		if (precioForaneoActual == null) {
			if (other.precioForaneoActual != null)
				return false;
		} else if (!precioForaneoActual.equals(other.precioForaneoActual))
			return false;
		if (precioForaneoAnterior == null) {
			if (other.precioForaneoAnterior != null)
				return false;
		} else if (!precioForaneoAnterior.equals(other.precioForaneoAnterior))
			return false;
		if (precioLocalActual == null) {
			if (other.precioLocalActual != null)
				return false;
		} else if (!precioLocalActual.equals(other.precioLocalActual))
			return false;
		if (precioLocalAnterior == null) {
			if (other.precioLocalAnterior != null)
				return false;
		} else if (!precioLocalAnterior.equals(other.precioLocalAnterior))
			return false;
		if (precioMmuestra == null) {
			if (other.precioMmuestra != null)
				return false;
		} else if (!precioMmuestra.equals(other.precioMmuestra))
			return false;
		if (precioMprod == null) {
			if (other.precioMprod != null)
				return false;
		} else if (!precioMprod.equals(other.precioMprod))
			return false;
		if (tipoLargo == null) {
			if (other.tipoLargo != null)
				return false;
		} else if (!tipoLargo.equals(other.tipoLargo))
			return false;
		if (tipoPrenda == null) {
			if (other.tipoPrenda != null)
				return false;
		} else if (!tipoPrenda.equals(other.tipoPrenda))
			return false;
		if (totalPrendas == null) {
			if (other.totalPrendas != null)
				return false;
		} else if (!totalPrendas.equals(other.totalPrendas))
			return false;
		if (ultimaFechaModificacion == null) {
			if (other.ultimaFechaModificacion != null)
				return false;
		} else if (!ultimaFechaModificacion.equals(other.ultimaFechaModificacion))
			return false;
		return true;
	}
	
	
}