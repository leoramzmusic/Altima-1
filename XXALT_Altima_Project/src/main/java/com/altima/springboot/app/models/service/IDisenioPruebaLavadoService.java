package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.models.entity.DisenioPruebaLavado;

public interface IDisenioPruebaLavadoService {

	List<DisenioPruebaLavado> findAll();

	void save(DisenioPruebaLavado diseniopruebalavado);

	void delete(Long id);

	DisenioPruebaLavado findOne(Long id);

}
