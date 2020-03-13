package com.altima.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.altima.springboot.app.models.entity.DisenioPrenda;
import com.altima.springboot.app.repository.DisenioPrendaRepository;


@Service
public class DisenioPrendaServiceImpl implements IDisenioPrendaService {
	@Autowired
	private DisenioPrendaRepository repository;
	@Override
	@Transactional(readOnly=true)
	public List<DisenioPrenda> findAll() {
		// TODO Auto-generated method stub
		return (List<DisenioPrenda>) repository.findAll();
	}

	@Override
	@Transactional
	public void save(DisenioPrenda disenioprenda) {
		// TODO Auto-generated method stub
		repository.save(disenioprenda);

	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public DisenioPrenda findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
