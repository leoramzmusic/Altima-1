package com.altima.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altima.springboot.app.models.entity.DisenioCalidad;
import com.altima.springboot.app.repository.DisenioCalidadRepository;


@Service
public class DisenioCalidadServiceImpl implements IDisenioCalidadService {
	@Autowired
	private DisenioCalidadRepository repository;
	@Override
	@Transactional(readOnly=true)
	public List<DisenioCalidad> findAll() {
		// TODO Auto-generated method stub
		return (List<DisenioCalidad>) repository.findAll();
	}

	@Override
	@Transactional
	public void save(DisenioCalidad diseniocalidad) {
		// TODO Auto-generated method stub
		repository.save(diseniocalidad);

	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public DisenioCalidad findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
