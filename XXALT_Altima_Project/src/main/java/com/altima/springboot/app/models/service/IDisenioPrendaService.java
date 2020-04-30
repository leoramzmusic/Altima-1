package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.models.entity.DisenioPrenda;

public interface IDisenioPrendaService {

	List<DisenioPrenda> findAll();

	void save(DisenioPrenda disenioprenda);

	void delete(Long id);

	DisenioPrenda findOne(Long id);
	
	String[] getExistencias(Long familiaPrenda);

}
