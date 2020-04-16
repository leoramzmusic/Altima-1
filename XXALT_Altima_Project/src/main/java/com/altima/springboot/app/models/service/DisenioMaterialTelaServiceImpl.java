package com.altima.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.altima.springboot.app.models.entity.DisenioMaterialTela;
import com.altima.springboot.app.repository.DisenioMaterialTelaRepository;

@Service
public class DisenioMaterialTelaServiceImpl implements IDisenioMaterialTelaService {
	@Autowired
	private DisenioMaterialTelaRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<DisenioMaterialTela> findAll() {
		// TODO Auto-generated method stub
		return (List<DisenioMaterialTela>) repository.findAll();
	}
	
	@Override
	@Transactional
	public void save(DisenioMaterialTela diseniomaterialtela) {
		// TODO Auto-generated method stub
		repository.save(diseniomaterialtela);
		
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
	@Override
	@Transactional
	public DisenioMaterialTela findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}
	
}
