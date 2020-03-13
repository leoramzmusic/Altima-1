package com.altima.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.altima.springboot.app.models.entity.DisenioTelaForro;
import com.altima.springboot.app.repository.DisenioTelaForroRepository;


@Service
public class DisenioTelaForroServiceImpl implements IDisenioTelaForroService {
	@Autowired
	private DisenioTelaForroRepository repository;
	@Override
	@Transactional(readOnly=true)
	public List<DisenioTelaForro> findAll() {
		// TODO Auto-generated method stub
		return (List<DisenioTelaForro>) repository.findAll();
	}

	@Override
	@Transactional
	public void save(DisenioTelaForro diseniotelaforro) {
		// TODO Auto-generated method stub
		repository.save(diseniotelaforro);

	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public DisenioTelaForro findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
