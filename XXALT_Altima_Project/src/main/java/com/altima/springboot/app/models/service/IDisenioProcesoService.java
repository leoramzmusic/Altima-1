package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.models.entity.DisenioProceso;

public interface IDisenioProcesoService {

	List<DisenioProceso> findAll();

	void save(DisenioProceso disenioproceso);

	void delete(Long id);

	DisenioProceso findOne(Long id);

}
