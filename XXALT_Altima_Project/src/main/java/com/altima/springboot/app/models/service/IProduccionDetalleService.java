package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.models.entity.ProduccionDetallePedido;

public interface IProduccionDetalleService {

	List<ProduccionDetallePedido> findAll();

	void save(ProduccionDetallePedido orden);

	void delete(Long id);

	ProduccionDetallePedido findOne(Long id);

	// comienzan las consultas

	List<Object[]> ListarMuestras(Long id, String tipo);

	List<Object[]> Terminados(Long id, Long tipo);

	List<Object[]> PrendaOrdenes(Long id);

	// dar de baja las ordenes
	void bajasOrdenes(String fecha, String edito, String idPrenda,
			String idPedido, String talla, String largo, String costo);

	List<Object[]> muestrariosCatalogo();
	

	public Integer Contador ();

}
