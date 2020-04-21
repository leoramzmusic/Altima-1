package com.altima.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altima.springboot.app.models.entity.ComercialMovimientoMuestraDetalle;
import com.altima.springboot.app.repository.ComercialMovimientoMuestraDetalleRepository;

@Service
public class ComercialMovimientoMuestraDetalleServiceImpl implements IComercialMovimientoMuestraDetalleService {

	@Autowired
	private ComercialMovimientoMuestraDetalleRepository repository;
	
	
	@Override
	public void save(ComercialMovimientoMuestraDetalle muestraDetalle) {

		repository.save(muestraDetalle);
		
	}

	@Override
	public List<ComercialMovimientoMuestraDetalle> findAll() {
		
		return (List<ComercialMovimientoMuestraDetalle>) repository.findAll();
	}

}
