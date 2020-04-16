package com.altima.springboot.app.models.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.altima.springboot.app.models.entity.ComercialCliente;
import com.altima.springboot.app.repository.ComercialClienteRepository;

@Service
public class ComercialClienteServiceImpl implements IComercialClienteService {
	
	@Autowired
	private ComercialClienteRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<ComercialCliente> findAll() {
		// TODO Auto-generated method stub
		return (List<ComercialCliente>) repository.findAll();
	}
	
	@Override
	public void save(ComercialCliente ComercialCliente) {
		repository.save(ComercialCliente);
		
	}
	
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
	@Override
	public ComercialCliente findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}
	
}
