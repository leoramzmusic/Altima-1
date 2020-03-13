package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.models.entity.DisenioPruebaEncogimiento;

public interface IDisenioPruebaEncogimientoService {

	List<DisenioPruebaEncogimiento> findAll();

	void save(DisenioPruebaEncogimiento diseniopruebaencogimiento);

	void delete(Long id);

	DisenioPruebaEncogimiento findOne(Long id);

}
