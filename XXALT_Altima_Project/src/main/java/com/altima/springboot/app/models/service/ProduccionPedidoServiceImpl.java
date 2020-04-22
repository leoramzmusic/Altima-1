package com.altima.springboot.app.models.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altima.springboot.app.models.entity.ProduccionPedido;
import com.altima.springboot.app.repository.ProduccionPedidoRepository;

@Service
public class ProduccionPedidoServiceImpl implements IProduccionPedidoService {
	
	@Autowired
	private ProduccionPedidoRepository repository;
	
	@Override
	public List<ProduccionPedido> findAll() {
		// TODO Auto-generated method stub
		return (List<ProduccionPedido>) repository.findAll();
	}

	@Override
	public void save(ProduccionPedido pedido) {
		// TODO Auto-generated method stub
		repository.save(pedido);
	}
	//   agregar-control-muestra
	
	
	
	
	

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public ProduccionPedido findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
