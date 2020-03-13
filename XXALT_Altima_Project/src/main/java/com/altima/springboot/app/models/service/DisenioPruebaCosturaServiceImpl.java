package com.altima.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.altima.springboot.app.models.entity.DisenioPruebaCostura;
import com.altima.springboot.app.repository.DisenioPruebaCosturaRepository;


@Service
public class DisenioPruebaCosturaServiceImpl implements IDisenioPruebaCosturaService {
	@Autowired
	private DisenioPruebaCosturaRepository repository;
	@Override
	@Transactional(readOnly=true)
	public List<DisenioPruebaCostura> findAll() {
		// TODO Auto-generated method stub
		return (List<DisenioPruebaCostura>) repository.findAll();
	}

	@Override
	@Transactional
	public void save(DisenioPruebaCostura diseniopruebacostura) {
		// TODO Auto-generated method stub
		repository.save(diseniopruebacostura);

	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public DisenioPruebaCostura findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
