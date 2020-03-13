package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.models.entity.HrUnidadNegocio;

public interface IHrUnidadNegocioService {

	List<HrUnidadNegocio> findAll();

	void save(HrUnidadNegocio hrunidadnegocio);

	void delete(Long id);

	HrUnidadNegocio findOne(Long id);

}
