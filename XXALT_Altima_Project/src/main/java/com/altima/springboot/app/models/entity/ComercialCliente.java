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
	
	@Column(name="apellido_paterno")
	private String ApellidoPaterno;
	
	@Column(name="apellido_materno")
	private String ApellidoMaterno;
	
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
	private String Observacion;
	
	@Column(name="tipo_cliente")
	private String TipoCliente;
	
	@Column(name="id_direccion")
	private Long IdDireccion;
	
	@Column(name="estatus")
	private String estatus;

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

	public String getApellidoPaterno() {
		return ApellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		ApellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return ApellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		ApellidoMaterno = apellidoMaterno;
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

	public String getTipoCliente() {
		return TipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		TipoCliente = tipoCliente;
	}

	public Long getIdDireccion() {
		return IdDireccion;
	}

	public void setIdDireccion(Long idDireccion) {
		IdDireccion = idDireccion;
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
		result = prime * result + ((ApellidoMaterno == null) ? 0 : ApellidoMaterno.hashCode());
		result = prime * result + ((ApellidoPaterno == null) ? 0 : ApellidoPaterno.hashCode());
		result = prime * result + ((CactualizadoPor == null) ? 0 : CactualizadoPor.hashCode());
		result = prime * result + ((CcreadoPor == null) ? 0 : CcreadoPor.hashCode());
		result = prime * result + ((CfechaCreacion == null) ? 0 : CfechaCreacion.hashCode());
		result = prime * result + ((CidText == null) ? 0 : CidText.hashCode());
		result = prime * result + ((Correo == null) ? 0 : Correo.hashCode());
		result = prime * result + ((CultimaFechaModificacion == null) ? 0 : CultimaFechaModificacion.hashCode());
		result = prime * result + ((IdDireccion == null) ? 0 : IdDireccion.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + ((Observacion == null) ? 0 : Observacion.hashCode());
		result = prime * result + ((PaginaWeb == null) ? 0 : PaginaWeb.hashCode());
		result = prime * result + ((RazonSocial == null) ? 0 : RazonSocial.hashCode());
		result = prime * result + ((Rfc == null) ? 0 : Rfc.hashCode());
		result = prime * result + ((Telefono == null) ? 0 : Telefono.hashCode());
		result = prime * result + ((TipoCliente == null) ? 0 : TipoCliente.hashCode());
		result = prime * result + ((estatus == null) ? 0 : estatus.hashCode());
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
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
		ComercialCliente other = (ComercialCliente) obj;
		if (ApellidoMaterno == null) {
			if (other.ApellidoMaterno != null)
				return false;
		} else if (!ApellidoMaterno.equals(other.ApellidoMaterno))
			return false;
		if (ApellidoPaterno == null) {
			if (other.ApellidoPaterno != null)
				return false;
		} else if (!ApellidoPaterno.equals(other.ApellidoPaterno))
			return false;
		if (CactualizadoPor == null) {
			if (other.CactualizadoPor != null)
				return false;
		} else if (!CactualizadoPor.equals(other.CactualizadoPor))
			return false;
		if (CcreadoPor == null) {
			if (other.CcreadoPor != null)
				return false;
		} else if (!CcreadoPor.equals(other.CcreadoPor))
			return false;
		if (CfechaCreacion == null) {
			if (other.CfechaCreacion != null)
				return false;
		} else if (!CfechaCreacion.equals(other.CfechaCreacion))
			return false;
		if (CidText == null) {
			if (other.CidText != null)
				return false;
		} else if (!CidText.equals(other.CidText))
			return false;
		if (Correo == null) {
			if (other.Correo != null)
				return false;
		} else if (!Correo.equals(other.Correo))
			return false;
		if (CultimaFechaModificacion == null) {
			if (other.CultimaFechaModificacion != null)
				return false;
		} else if (!CultimaFechaModificacion.equals(other.CultimaFechaModificacion))
			return false;
		if (IdDireccion == null) {
			if (other.IdDireccion != null)
				return false;
		} else if (!IdDireccion.equals(other.IdDireccion))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		if (Observacion == null) {
			if (other.Observacion != null)
				return false;
		} else if (!Observacion.equals(other.Observacion))
			return false;
		if (PaginaWeb == null) {
			if (other.PaginaWeb != null)
				return false;
		} else if (!PaginaWeb.equals(other.PaginaWeb))
			return false;
		if (RazonSocial == null) {
			if (other.RazonSocial != null)
				return false;
		} else if (!RazonSocial.equals(other.RazonSocial))
			return false;
		if (Rfc == null) {
			if (other.Rfc != null)
				return false;
		} else if (!Rfc.equals(other.Rfc))
			return false;
		if (Telefono == null) {
			if (other.Telefono != null)
				return false;
		} else if (!Telefono.equals(other.Telefono))
			return false;
		if (TipoCliente == null) {
			if (other.TipoCliente != null)
				return false;
		} else if (!TipoCliente.equals(other.TipoCliente))
			return false;
		if (estatus == null) {
			if (other.estatus != null)
				return false;
		} else if (!estatus.equals(other.estatus))
			return false;
		if (idCliente == null) {
			if (other.idCliente != null)
				return false;
		} else if (!idCliente.equals(other.idCliente))
			return false;
		return true;
	}
	
}