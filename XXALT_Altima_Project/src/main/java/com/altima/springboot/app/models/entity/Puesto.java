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
@Table(name = "xxalt_puesto")
public class Puesto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_puesto")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long idPuesto;

	@Column(name="id_departamento")
	@NotBlank
	private Long idDepartamento;
	
	@Column(name="id_text")
	@NotBlank
	private String idText;
	
	@Column(name="nombre_puesto")
	@NotBlank
	private String nombrePuesto;
	
	@Column(name="tiempo_extra")
	@NotBlank
	private String tiempoExtra;
	
	@Column(name="estatus")
	@NotBlank
	private String estatus;
	
	@Column(name="total_plazas")
	@NotBlank
	private String totalPlazas;
	
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
}
