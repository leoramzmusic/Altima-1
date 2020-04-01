package com.altima.springboot.app.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altima.springboot.app.models.entity.DisenioPruebaLavadoContaminacionCostura;
import com.altima.springboot.app.repository.IDisenioPruebaLavadoContaminacionCosturaRepository;

@Service
public class DisenioPruebaLavadoContaminacionCosturaServiceImpl implements IDisenioPruebaLavadoContaminacionCosturaService {

	@Autowired
	private IDisenioPruebaLavadoContaminacionCosturaRepository repository;
	
	@Override
	public void save(DisenioPruebaLavadoContaminacionCostura PruebasLCC) {
		
		repository.save(PruebasLCC);
		
	}

}
