package com.altima.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.altima.springboot.app.models.entity.DisenioProceso;
import com.altima.springboot.app.repository.DisenioProcesoRepository;


@Service
public class DisenioProcesoServiceImpl implements IDisenioProcesoService {
	@Autowired
	private DisenioProcesoRepository repository;
	@Override
	@Transactional(readOnly=true)
	public List<DisenioProceso> findAll() {
		// TODO Auto-generated method stub
		return (List<DisenioProceso>) repository.findAll();
	}

	@Override
	@Transactional
	public void save(DisenioProceso disenioproceso) {
		// TODO Auto-generated method stub
		repository.save(disenioproceso);

	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public DisenioProceso findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}