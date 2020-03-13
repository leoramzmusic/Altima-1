package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.models.entity.DisenioPruebaCostura;

public interface IDisenioPruebaCosturaService {

	List<DisenioPruebaCostura> findAll();

	void save(DisenioPruebaCostura diseniopruebacostura);

	void delete(Long id);

	DisenioPruebaCostura findOne(Long id);

}
