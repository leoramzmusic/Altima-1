package com.altima.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "alt_comercial_cliente")
public class ComercialCliente implements Serializable {
	
	private static final long serialVersionUID =1L;
	
	@Id
	@Column(name="id_cliente")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long idCliente;
	
	@Column(name="id_text")
	private String CidText;
	
	@Column(name="creado_por")
	private String CcreadoPor;
	
	@Column(name="actualizado_por")
	private String CactualizadoPor;
	
	@Column(name="fecha_creacion")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date CfechaCreacion;
	
	
	@Column(name="ultima_fecha_modificacion")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date CultimaFechaModificacion;
	
	@Column(name="nombre")
	private String Nombre;
	
	@Column(name="razon_social")
	private String RazonSocial;
	
	@Column(name="correo")
	private String Correo;
	
	@Column(name="telefono")
	private String Telefono;
	
	@Column(name="rfc")
	private String Rfc;
	
	@Column(name="pagina_web")
	private String PaginaWeb;
	
	@Column(name="observacion")
	@NotBlank
	private String Observacion;
	
	@Column(name="id_direccion")
	private Long IdDireccion;

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	
	public String getCidText() {
		return CidText;
	}

	public void setCidText(String cidText) {
		CidText = cidText;
	}

	public String getCcreadoPor() {
		return CcreadoPor;
	}

	public void setCcreadoPor(String ccreadoPor) {
		CcreadoPor = ccreadoPor;
	}

	public String getCactualizadoPor() {
		return CactualizadoPor;
	}

	public void setCactualizadoPor(String cactualizadoPor) {
		CactualizadoPor = cactualizadoPor;
	}

	public Date getCfechaCreacion() {
		return CfechaCreacion;
	}

	public void setCfechaCreacion(Date cfechaCreacion) {
		CfechaCreacion = cfechaCreacion;
	}

	public Date getCultimaFechaModificacion() {
		return CultimaFechaModificacion;
	}

	public void setCultimaFechaModificacion(Date cultimaFechaModificacion) {
		CultimaFechaModificacion = cultimaFechaModificacion;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getRazonSocial() {
		return RazonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		RazonSocial = razonSocial;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getRfc() {
		return Rfc;
	}

	public void setRfc(String rfc) {
		Rfc = rfc;
	}

	public String getPaginaWeb() {
		return PaginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
		PaginaWeb = paginaWeb;
	}

	public String getObservacion() {
		return Observacion;
	}

	public void setObservacion(String observacion) {
		Observacion = observacion;
	}   

	public Long getIdDireccion() {
		return IdDireccion;
	}

	public void setIdDireccion(Long idDireccion) {
		IdDireccion = idDireccion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	@PrePersist
	public void prePersist() {
		CfechaCreacion=new Date();  
	}
	
}