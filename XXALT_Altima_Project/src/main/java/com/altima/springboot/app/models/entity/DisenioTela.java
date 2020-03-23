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
@Table(name = "alt_disenio_tela")
public class DisenioTela implements Serializable{

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
	
	@Column(name="nombre_tela")
	@NotBlank
	private String nombreTela;
	
	

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
	
	@Column(name="consumo")
	private String consumo;
	
	@Column(name="costo_por_tela")
	private String costoPorTela;
	
	@Column(name="id_prenda")
	private Long idPrenda;
	
	@Column(name="id_color")
	private Long idColor;
	
	@Column(name="id_proveedor")
	private Long idProveedor;

	@Column(name="indicacion")
	private String indicacion;
	
	@Column(name="foto")
	private String foto;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="descripcion")
	private String descripcion;
	
	
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

	public String getConsumo() {
		return consumo;
	}

	public void setConsumo(String consumo) {
		this.consumo = consumo;
	}

	public String getCostoPorTela() {
		return costoPorTela;
	}

	public void setCostoPorTela(String costoPorTela) {
		this.costoPorTela = costoPorTela;
	}

	public Long getIdPrenda() {
		return idPrenda;
	}

	public void setIdPrenda(Long idPrenda) {
		this.idPrenda = idPrenda;
	}

	public Long getIdColor() {
		return idColor;
	}

	public void setIdColor(Long idColor) {
		this.idColor = idColor;
	}

	public Long getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getIndicacion() {
		return indicacion;
	}

	public void setIndicacion(String indicacion) {
		this.indicacion = indicacion;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public String getNombreTela() {
		return nombreTela;
	}

	public void setNombreTela(String nombreTela) {
		this.nombreTela = nombreTela;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreTela == null) ? 0 : nombreTela.hashCode());
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
		DisenioTela other = (DisenioTela) obj;
		if (nombreTela == null) {
			if (other.nombreTela != null)
				return false;
		} else if (!nombreTela.equals(other.nombreTela))
			return false;
		return true;
	}
}
