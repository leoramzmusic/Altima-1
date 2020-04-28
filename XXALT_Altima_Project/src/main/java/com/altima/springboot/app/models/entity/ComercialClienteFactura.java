package com.altima.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "alt_comercial_cliente_factura")
public class ComercialClienteFactura implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_cliente_factura")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long idClienteFactura;
	
	@Column(name="id_cliente")
	private Long idCliente;
	
	@Column(name="id_direccion")
	private Long idDireccion;
	
	@Column(name="id_text")
	private String idText;
	
	@Column(name="creado_por")
	private String creadoPor;
	
	@Column(name="actualizado_por")
	private String actualizadoPor;
	
	@Column(name="fecha_creacion")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date fechaCreacion;
	
	@Column(name="ultima_fecha_modificacion")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date ultimaFechaModificacion;
	
	@Column(name="estatus")
	private String estatus;
	
	@Column(name="cuenta_contable")
	private String cuentaContable;
	
	@Column(name="rfc_factura")
	private String rfcFactura;
	
	
	
	
	
	
	

	

}
