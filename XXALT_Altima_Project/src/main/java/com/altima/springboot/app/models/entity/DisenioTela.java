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
@Table(name = "alt_disenio_tela")
public class DisenioTela implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_tela")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long idTela;
	
	@Column(name="id_familia_composicion")
	private Long idFamiliaComposicion;

	@Column(name="id_calidad")
	private Long idCalidad;
	
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
	
	@Column(name="descripcion_tela")
	private String descripcionTela;
	
	@Column(name="nombre_tela")
	private String nombreTela;

	@Column(name="linea_tela")
	private String lineaTela;
	
	@Column(name="ancho")
	private String ancho;
	
	@Column(name="id_unidad_medida")
	private String idUnidadMedida;
	
	@Column(name="consumo_promedio")
	private String consumoPromedio;
	
	@Column(name="existencia")
	private String existencia;
	
	@Column(name="indicacion")
	private String indicacion;
	
	@Column(name="consumo")
	private String consumo;
	
	@Column(name="costo_por_metro")
	private String costoPorMetro;
	
	@Column(name="color")
	private String Color;
	
	@Column(name="codigo_color")
	private String codigoColor;
	
	@Column(name="estampado")
	private String estampado;
	
	@Column(name="id_proveedor")
	private Long idProveedor;
	
	@Column(name="foto")
	private String foto;
	
	@Column(name="estatus")
	private String estatus;
	
	@Column(name="estatus_tela")
	private String estatusTela;

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

	public String getDescripcionTela() {
		return descripcionTela;
	}

	public void setDescripcionTela(String descripcionTela) {
		this.descripcionTela = descripcionTela;
	}

	public String getNombreTela() {
		return nombreTela;
	}

	public void setNombreTela(String nombreTela) {
		this.nombreTela = nombreTela;
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

	public String getIdUnidadMedida() {
		return idUnidadMedida;
	}

	public void setIdUnidadMedida(String idUnidadMedida) {
		this.idUnidadMedida = idUnidadMedida;
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

	public String getIndicacion() {
		return indicacion;
	}

	public void setIndicacion(String indicacion) {
		this.indicacion = indicacion;
	}

	public String getConsumo() {
		return consumo;
	}

	public void setConsumo(String consumo) {
		this.consumo = consumo;
	}

	public String getCostoPorMetro() {
		return costoPorMetro;
	}

	public void setCostoPorMetro(String costoPorMetro) {
		this.costoPorMetro = costoPorMetro;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public String getCodigoColor() {
		return codigoColor;
	}

	public void setCodigoColor(String codigoColor) {
		this.codigoColor = codigoColor;
	}

	public String getEstampado() {
		return estampado;
	}

	public void setEstampado(String estampado) {
		this.estampado = estampado;
	}

	public Long getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getEstatusTela() {
		return estatusTela;
	}

	public void setEstatusTela(String estatusTela) {
		this.estatusTela = estatusTela;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
}
