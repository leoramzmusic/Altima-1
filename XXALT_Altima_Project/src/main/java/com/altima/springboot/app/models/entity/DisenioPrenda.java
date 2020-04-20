package com.altima.springboot.app.models.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "alt_disenio_prenda")
public class DisenioPrenda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_prenda")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long idPrenda;

	@Column(name = "id_familia_prenda")
	private Long idFamiliaPrenda;

	@Column(name = "id_text")
	private String idText;
	
	@Column(name = "id_text_prospecto")
	private String idTextProspecto;

	@Column(name = "creado_por")
	private String creadoPor;

	@Column(name = "actualizado_por")
	private String actualizadoPor;

	@Column(name = "fecha_creacion")
	private String fechaCreacion;

	@Column(name = "ultima_fecha_modificacion")
	private String ultimaFechaModificacion;

	@Column(name = "numero_prenda")
	private String numeroPrenda;

	@Column(name = "nombre_prenda")
	private String nombrePrenda;

	@Column(name = "descripcion_prenda")
	private String descripcionPrenda;

	@Column(name = "tipo_prenda")
	private String tipoPrenda;

	@Column(name = "detalle_prenda")
	private String detallePrenda;

	@Column(name = "nota_especial")
	private String notaEspecial;

	@Column(name = "detalle_confeccion")
	private String detalleConfeccion;

	@Column(name = "id_marcador")
	private String idMarcador;

	@Column(name = "consumo_tela")
	private String consumoTela;

	@Column(name = "consumo_forro")
	private String consumoForro;

	@Column(name = "precio")
	private String precio;

	@Column(name = "dibujo_frente")
	private String dibujoFrente;

	@Column(name = "dibujo_espalda")
	private String dibujoEspalda;

	@Column(name = "precio_local_actual")
	private String precioLocalActual;

	@Column(name = "precio_local_anterior")
	private String precioLocalAnterior;

	@Column(name = "precio_foraneo_actual")
	private String precioForaneoActual;

	@Column(name = "precio_foraneo_anterior")
	private String precioForaneoAnterior;

	@Column(name = "id_ruta")
	private String idRuta;

	@Column(name = "tipo_largo")
	private String tipoLargo;

	@Column(name = "imprimir_etiquetas")
	private String imprimirEtiquetas;

	@Column(name = "estatus_recepcion_muestra")
	private String estatusRecepcionMuestra;

	@Column(name = "fecha_recepcion_muestra")
	private String fechaRecepcionMuestra;

	@Column(name = "devolucion")
	private String devolucion;

	@Column(name = "precio_m_prod")
	private String precioMprod;

	@Column(name = "precio_m_muestra")
	private String precioMmuestra;

	@Column(name = "categoria")
	private String categoria;

	@Column(name = "combinacion")
	private String combinacion;

	@Column(name = "estatus")
	private Long estatus;
	
	@Column(name = "prenda_local")
	private String prendaLocal;
	
	

	public String getPrendaLocal() {
		return prendaLocal;
	}

	public void setPrendaLocal(String prendaLocal) {
		this.prendaLocal = prendaLocal;
	}

	public String getIdTextProspecto() {
		return idTextProspecto;
	}

	public void setIdTextProspecto(String idTextProspecto) {
		this.idTextProspecto = idTextProspecto;
	}

	public String getIdMarcador() {
		return idMarcador;
	}

	public void setIdMarcador(String idMarcador) {
		this.idMarcador = idMarcador;
	}

	public String getIdRuta() {
		return idRuta;
	}

	public void setIdRuta(String idRuta) {
		this.idRuta = idRuta;
	}

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

	public void setMarcadores(String marcadores) {
		this.idMarcador = marcadores;
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
		return idRuta;
	}

	public void setCveRuta(String cveRuta) {
		this.idRuta = cveRuta;
	}

	public String getTipoLargo() {
		return tipoLargo;
	}

	public void setTipoLargo(String tipoLargo) {
		this.tipoLargo = tipoLargo;
	}

	public String getImprimirEtiquetas() {
		return imprimirEtiquetas;
	}

	public void setImprimirEtiquetas(String imprimirEtiquetas) {
		this.imprimirEtiquetas = imprimirEtiquetas;
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

	public Long getEstatus() {
		return estatus;
	}

	public void setEstatus(Long estatus) {
		this.estatus = estatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}