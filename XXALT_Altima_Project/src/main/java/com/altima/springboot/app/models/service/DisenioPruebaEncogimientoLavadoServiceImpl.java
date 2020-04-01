package com.altima.springboot.app.models.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altima.springboot.app.models.entity.DisenioPruebaEncogimientoLavado;
import com.altima.springboot.app.repository.DisenioPruebaEncogimientoLavadoRepository;

@Service
public class DisenioPruebaEncogimientoLavadoServiceImpl implements IDisenioPruebaEncogimientoLavadoService {

	@Autowired
	private DisenioPruebaEncogimientoLavadoRepository repository;
	
	
	@Override
	public List<DisenioPruebaEncogimientoLavado> findAll(DisenioPruebaEncogimientoLavado pruebaEncogimientoLavado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(DisenioPruebaEncogimientoLavado pruebaEncogimientoLavado) {

		repository.save(pruebaEncogimientoLavado);
	}

}
