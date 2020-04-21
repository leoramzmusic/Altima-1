package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.models.entity.ComercialMovimientoMuestraDetalle;

public interface IComercialMovimientoMuestraDetalleService {
	
	void save(ComercialMovimientoMuestraDetalle muestraDetalle);
	
	public List<ComercialMovimientoMuestraDetalle> findAll ();

}
