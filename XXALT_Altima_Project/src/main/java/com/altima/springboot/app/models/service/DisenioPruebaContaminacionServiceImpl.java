package com.altima.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.altima.springboot.app.models.entity.DisenioPruebaContaminacion;
import com.altima.springboot.app.repository.DisenioPruebaContaminacionRepository;


@Service
public class DisenioPruebaContaminacionServiceImpl implements IDisenioPruebaContaminacionService {
	@Autowired
	private DisenioPruebaContaminacionRepository repository;
	@Override
	@Transactional(readOnly=true)
	public List<DisenioPruebaContaminacion> findAll() {
		// TODO Auto-generated method stub
		return (List<DisenioPruebaContaminacion>) repository.findAll();
	}

	@Override
	@Transactional
	public void save(DisenioPruebaContaminacion diseniopruebacontaminacion) {
		// TODO Auto-generated method stub
		repository.save(diseniopruebacontaminacion);

	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public DisenioPruebaContaminacion findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
