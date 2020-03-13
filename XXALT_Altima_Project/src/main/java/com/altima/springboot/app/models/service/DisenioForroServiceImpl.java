package com.altima.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.altima.springboot.app.models.entity.DisenioForro;
import com.altima.springboot.app.repository.DisenioForroRepository;


@Service
public class DisenioForroServiceImpl implements IDisenioForroService {
	@Autowired
	private DisenioForroRepository repository;
	@Override
	@Transactional(readOnly=true)
	public List<DisenioForro> findAll() {
		// TODO Auto-generated method stub
		return (List<DisenioForro>) repository.findAll();
	}

	@Override
	@Transactional
	public void save(DisenioForro disenioforro) {
		// TODO Auto-generated method stub
		repository.save(disenioforro);

	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public DisenioForro findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
