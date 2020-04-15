package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.models.entity.ProduccionDetallePedido;

public interface IProduccionDetalleService {
	
	List<ProduccionDetallePedido> findAll();

	void save(ProduccionDetallePedido orden);

	void delete(Long id);

	ProduccionDetallePedido findOne(Long id);
	
	// comienzan las consultas
	
	List<Object []> ListarMuestrasTrazo(Long id);
	
	List <Object []> Terminados(Long id, Long tipo);

}
