package com.altima.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.altima.springboot.app.models.entity.DisenioPruebaLavado;
import com.altima.springboot.app.repository.DisenioPruebaLavadoRepository;


@Service
public class DisenioPruebaLavadoServiceImpl implements IDisenioPruebaLavadoService {
	@Autowired
	private DisenioPruebaLavadoRepository repository;
	@Override
	@Transactional(readOnly=true)
	public List<DisenioPruebaLavado> findAll() {
		// TODO Auto-generated method stub
		return (List<DisenioPruebaLavado>) repository.findAll();
	}

	@Override
	@Transactional
	public void save(DisenioPruebaLavado diseniopruebalavado) {
		// TODO Auto-generated method stub
		repository.save(diseniopruebalavado);

	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public DisenioPruebaLavado findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
