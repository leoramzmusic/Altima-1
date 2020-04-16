package com.altima.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.altima.springboot.app.models.entity.DisenioFamiliaPrenda;
import com.altima.springboot.app.repository.DisenioFamiliaPrendaRepository;

@Service
public class DisenioFamiliaPrendaServiceImpl implements IDisenioFamiliaPrendaService {
	@Autowired
	private DisenioFamiliaPrendaRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<DisenioFamiliaPrenda> findAll() {
		// TODO Auto-generated method stub
		return (List<DisenioFamiliaPrenda>) repository.findAll();
	}
	
	@Override
	@Transactional
	public void save(DisenioFamiliaPrenda diseniofamiliaprenda) {
		// TODO Auto-generated method stub
		repository.save(diseniofamiliaprenda);
		
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
	@Override
	@Transactional
	public DisenioFamiliaPrenda findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}
	
}
