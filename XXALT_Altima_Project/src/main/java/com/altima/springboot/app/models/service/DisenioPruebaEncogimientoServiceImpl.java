package com.altima.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.altima.springboot.app.models.entity.DisenioPruebaEncogimiento;
import com.altima.springboot.app.repository.DisenioPruebaEncogimientoRepository;


@Service
public class DisenioPruebaEncogimientoServiceImpl implements IDisenioPruebaEncogimientoService {
	@Autowired
	private DisenioPruebaEncogimientoRepository repository;
	@Override
	@Transactional(readOnly=true)
	public List<DisenioPruebaEncogimiento> findAll() {
		// TODO Auto-generated method stub
		return (List<DisenioPruebaEncogimiento>) repository.findAll();
	}

	@Override
	@Transactional
	public void save(DisenioPruebaEncogimiento diseniopruebaencogimiento) {
		// TODO Auto-generated method stub
		repository.save(diseniopruebaencogimiento);

	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public DisenioPruebaEncogimiento findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
