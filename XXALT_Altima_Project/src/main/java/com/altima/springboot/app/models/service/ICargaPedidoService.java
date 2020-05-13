package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.models.entity.ComercialPedidoInformación;

public interface ICargaPedidoService {
	
	List<ComercialPedidoInformación> findAll();

	void save(ComercialPedidoInformación pedido);

	void delete(Long id);

	ComercialPedidoInformación findOne(Long id);

}
