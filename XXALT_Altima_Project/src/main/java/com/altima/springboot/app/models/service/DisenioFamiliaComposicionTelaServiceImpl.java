package com.altima.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altima.springboot.app.models.entity.DisenioFamiliaComposicionTela;
import com.altima.springboot.app.repository.DisenioFamiliaComposicionTelaRepository;

@Service
public class DisenioFamiliaComposicionTelaServiceImpl implements IDisenioFamiliaComposicionTelaService {
	
	@Autowired
	private DisenioFamiliaComposicionTelaRepository repository;
	
	@Override
	public List<DisenioFamiliaComposicionTela> findAll() {
		return (List<DisenioFamiliaComposicionTela>) repository.findAll();
		
	}
	
	@Override
	public void save(DisenioFamiliaComposicionTela DisenioFamiliaComposicionTela) {
		repository.save(DisenioFamiliaComposicionTela);
		
	}
	
	@Override
	public void delete(Long id) {
		repository.deleteById(id);
		
	}
	
	@Override
	public DisenioFamiliaComposicionTela findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}
	
}
