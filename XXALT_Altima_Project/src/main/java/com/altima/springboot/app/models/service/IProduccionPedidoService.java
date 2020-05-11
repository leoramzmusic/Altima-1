package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.models.entity.ProduccionPedido;

public interface IProduccionPedidoService {
	
	List<ProduccionPedido> findAll();

	void save(ProduccionPedido pedido);

	void delete(Long id);

	ProduccionPedido findOne(Long id);
	
}



//GGGG
