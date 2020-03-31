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
	
	@Column(name="id_prenda")
	private Long idPrenda;
	
	@Column(name="id_color")
	private Long idColor;
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actualizadoPor == null) ? 0 : actualizadoPor.hashCode());
		result = prime * result + ((ancho == null) ? 0 : ancho.hashCode());
		result = prime * result + ((consumo == null) ? 0 : consumo.hashCode());
		result = prime * result + ((consumoPromedio == null) ? 0 : consumoPromedio.hashCode());
		result = prime * result + ((costoPorMetro == null) ? 0 : costoPorMetro.hashCode());
		result = prime * result + ((creadoPor == null) ? 0 : creadoPor.hashCode());
		result = prime * result + ((descripcionTela == null) ? 0 : descripcionTela.hashCode());
		result = prime * result + ((estatus == null) ? 0 : estatus.hashCode());
		result = prime * result + ((estatusTela == null) ? 0 : estatusTela.hashCode());
		result = prime * result + ((existencia == null) ? 0 : existencia.hashCode());
		result = prime * result + ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
		result = prime * result + ((foto == null) ? 0 : foto.hashCode());
		result = prime * result + ((idCalidad == null) ? 0 : idCalidad.hashCode());
		result = prime * result + ((idColor == null) ? 0 : idColor.hashCode());
		result = prime * result + ((idFamiliaComposicion == null) ? 0 : idFamiliaComposicion.hashCode());
		result = prime * result + ((idPrenda == null) ? 0 : idPrenda.hashCode());
		result = prime * result + ((idProveedor == null) ? 0 : idProveedor.hashCode());
		result = prime * result + ((idTela == null) ? 0 : idTela.hashCode());
		result = prime * result + ((idText == null) ? 0 : idText.hashCode());
		result = prime * result + ((idUnidadMedida == null) ? 0 : idUnidadMedida.hashCode());
		result = prime * result + ((indicacion == null) ? 0 : indicacion.hashCode());
		result = prime * result + ((lineaTela == null) ? 0 : lineaTela.hashCode());
		result = prime * result + ((nombreTela == null) ? 0 : nombreTela.hashCode());
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
		DisenioTela other = (DisenioTela) obj;
		if (actualizadoPor == null) {
			if (other.actualizadoPor != null)
				return false;
		} else if (!actualizadoPor.equals(other.actualizadoPor))
			return false;
		if (ancho == null) {
			if (other.ancho != null)
				return false;
		} else if (!ancho.equals(other.ancho))
			return false;
		if (consumo == null) {
			if (other.consumo != null)
				return false;
		} else if (!consumo.equals(other.consumo))
			return false;
		if (consumoPromedio == null) {
			if (other.consumoPromedio != null)
				return false;
		} else if (!consumoPromedio.equals(other.consumoPromedio))
			return false;
		if (costoPorMetro == null) {
			if (other.costoPorMetro != null)
				return false;
		} else if (!costoPorMetro.equals(other.costoPorMetro))
			return false;
		if (creadoPor == null) {
			if (other.creadoPor != null)
				return false;
		} else if (!creadoPor.equals(other.creadoPor))
			return false;
		if (descripcionTela == null) {
			if (other.descripcionTela != null)
				return false;
		} else if (!descripcionTela.equals(other.descripcionTela))
			return false;
		if (estatus == null) {
			if (other.estatus != null)
				return false;
		} else if (!estatus.equals(other.estatus))
			return false;
		if (estatusTela == null) {
			if (other.estatusTela != null)
				return false;
		} else if (!estatusTela.equals(other.estatusTela))
			return false;
		if (existencia == null) {
			if (other.existencia != null)
				return false;
		} else if (!existencia.equals(other.existencia))
			return false;
		if (fechaCreacion == null) {
			if (other.fechaCreacion != null)
				return false;
		} else if (!fechaCreacion.equals(other.fechaCreacion))
			return false;
		if (foto == null) {
			if (other.foto != null)
				return false;
		} else if (!foto.equals(other.foto))
			return false;
		if (idCalidad == null) {
			if (other.idCalidad != null)
				return false;
		} else if (!idCalidad.equals(other.idCalidad))
			return false;
		if (idColor == null) {
			if (other.idColor != null)
				return false;
		} else if (!idColor.equals(other.idColor))
			return false;
		if (idFamiliaComposicion == null) {
			if (other.idFamiliaComposicion != null)
				return false;
		} else if (!idFamiliaComposicion.equals(other.idFamiliaComposicion))
			return false;
		if (idPrenda == null) {
			if (other.idPrenda != null)
				return false;
		} else if (!idPrenda.equals(other.idPrenda))
			return false;
		if (idProveedor == null) {
			if (other.idProveedor != null)
				return false;
		} else if (!idProveedor.equals(other.idProveedor))
			return false;
		if (idTela == null) {
			if (other.idTela != null)
				return false;
		} else if (!idTela.equals(other.idTela))
			return false;
		if (idText == null) {
			if (other.idText != null)
				return false;
		} else if (!idText.equals(other.idText))
			return false;
		if (idUnidadMedida == null) {
			if (other.idUnidadMedida != null)
				return false;
		} else if (!idUnidadMedida.equals(other.idUnidadMedida))
			return false;
		if (indicacion == null) {
			if (other.indicacion != null)
				return false;
		} else if (!indicacion.equals(other.indicacion))
			return false;
		if (lineaTela == null) {
			if (other.lineaTela != null)
				return false;
		} else if (!lineaTela.equals(other.lineaTela))
			return false;
		if (nombreTela == null) {
			if (other.nombreTela != null)
				return false;
		} else if (!nombreTela.equals(other.nombreTela))
			return false;
		if (ultimaFechaModificacion == null) {
			if (other.ultimaFechaModificacion != null)
				return false;
		} else if (!ultimaFechaModificacion.equals(other.ultimaFechaModificacion))
			return false;
		return true;
	}
}
