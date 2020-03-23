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
	@NotBlank
	private Long idFamiliaPrenda;
	
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
	
	@Column(name="numero_prenda")
	@NotBlank
	private String numeroPrenda;
	
	@Column(name="nombre_prenda")
	@NotBlank
	private String nombrePrenda;
	
	@Column(name="descripcion_prenda")
	@NotBlank
	private String descripcionPrenda;
	
	@Column(name="tipo_prenda")
	@NotBlank
	private String tipoPrenda;
	
	

	@Column(name="detalle_prenda")
	@NotBlank
	private String detallePrenda;
	
	@Column(name="nota_especial")
	@NotBlank
	private String notaEspecial;
	
	@Column(name="detalle_confeccion")
	@NotBlank
	private String detalleConfeccion;
	
	@Column(name="marcadores")
	@NotBlank
	private String marcadores;
	
	@Column(name="consumo_tela")
	@NotBlank
	private String consumoTela;
	
	@Column(name="consumo_forro")
	@NotBlank
	private String consumoForro;
	
	@Column(name="precio")
	@NotBlank
	private String precio;
	
	@Column(name="dibujo_frente")
	@NotBlank
	private String dibujoFrente;
	
	@Column(name="dibujo_espalda")
	@NotBlank
	private String dibujoEspalda;
	
	@Column(name="precio_local_actual")
	@NotBlank
	private String precioLocalActual;
	
	@Column(name="precio_local_anterior")
	@NotBlank
	private String precioLocalAnterior;
	
	@Column(name="precio_foraneo_actual")
	@NotBlank
	private String precioForaneoActual;
	
	@Column(name="precio_foraneo_anterior")
	@NotBlank
	private String precioForaneoAnterior;
	
	@Column(name="cve_ruta")
	@NotBlank
	private String cveRuta;
	
	@Column(name="cve_prenda")
	@NotBlank
	private String cvePrenda;

	@Column(name="tipo_largo")
	@NotBlank
	private String tipoLargo;
	
	@Column(name="especificacion")
	@NotBlank
	private String especificacion;
	
	@Column(name="imprimir_etiquetas")
	@NotBlank
	private String imprimirEtiquetas;
	
	@Column(name="modelo_boton")
	@NotBlank
	private String modeloBoton;
	
	@Column(name="estatus_recepcion_muestra")
	@NotBlank
	private String estatusRecepcionMuestra;
	
	@Column(name="devolucion")
	@NotBlank
	private String devolucion;
	
	@Column(name="precio_m_prod")
	@NotBlank
	private String precioMprod;
	
	@Column(name="precio_m_muestra")
	@NotBlank
	private String precioMmuestra;

	@Column(name="categoria")
	@NotBlank
	private String categoria;
	
	@Column(name="combinacion")
	@NotBlank
	private String combinacion;
	
	@Column(name="total_prendas")
	@NotBlank
	private String totalPrendas;
	
	@Column(name="mostrar")
	@NotBlank
	private String mostrar;
	
	@Column(name="id_lookup")
	@NotBlank
	private Long idLookup;
	
	@Column(name="id_lookup2")
	@NotBlank
	private Long idLookup2;
	
	@Column(name="id_lookup3")
	@NotBlank
	private Long idLookup3;
	
	
	public String getCvePrenda() {
		return cvePrenda;
	}

	public void setCvePrenda(String cvePrenda) {
		this.cvePrenda = cvePrenda;
	}
	public Long getIdFamiliaPrenda() {
		return idFamiliaPrenda;
	}

	public void setIdFamiliaPrenda(Long idFamiliaPrenda) {
		this.idFamiliaPrenda = idFamiliaPrenda;
	}

	public Long getIdPrenda() {
		return idPrenda;
	}

	public void setIdPrenda(Long idPrenda) {
		this.idPrenda = idPrenda;
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
		return nombrePrenda;
	}

	public void setDescripcionPrenda(String descripcionPrenda) {
		this.nombrePrenda = descripcionPrenda;
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

	public String getCveRuta() {
		return cveRuta;
	}

	public void setCveRuta(String cveRuta) {
		this.cveRuta = cveRuta;
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

	public Long getIdLookup3() {
		return idLookup3;
	}

	public void setIdLookup3(Long idLookup3) {
		this.idLookup3 = idLookup3;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombrePrenda == null) ? 0 : nombrePrenda.hashCode());
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
		if (nombrePrenda == null) {
			if (other.nombrePrenda != null)
				return false;
		} else if (!nombrePrenda.equals(other.nombrePrenda))
			return false;
		return true;
	}


}

