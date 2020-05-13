package com.altima.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altima.springboot.app.models.entity.ComercialPedidoInformación;
import com.altima.springboot.app.models.entity.DisenioLookup;
import com.altima.springboot.app.repository.CargaPedidoRepository;

@Service
public class CargaPedidoServiceImpl implements ICargaPedidoService {
	
	
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	CargaPedidoRepository repository;
	
	@Override
	public List<ComercialPedidoInformación> findAll() {
		// TODO Auto-generated method stub
		return (List<ComercialPedidoInformación>) repository.findAll();
	}

	@Override
	public void save(ComercialPedidoInformación pedido) {
		// TODO Auto-generated method stub
		repository.save(pedido);

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

	@Override
	public ComercialPedidoInformación findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
