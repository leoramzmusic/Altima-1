package com.altima.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.altima.springboot.app.models.entity.HrUnidadNegocio;
import com.altima.springboot.app.repository.HrUnidadNegocioRepository;


@Service
public class HrUnidadNegocioServiceImpl implements IHrUnidadNegocioService {
	@Autowired
	private HrUnidadNegocioRepository repository;
	@Override
	@Transactional(readOnly=true)
	public List<HrUnidadNegocio> findAll() {
		// TODO Auto-generated method stub
		return (List<HrUnidadNegocio>) repository.findAll();
	}

	@Override
	@Transactional
	public void save(HrUnidadNegocio hrunidadnegocio) {
		// TODO Auto-generated method stub
		repository.save(hrunidadnegocio);

	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public HrUnidadNegocio findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
