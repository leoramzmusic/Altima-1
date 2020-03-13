package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.models.entity.HrPuesto;

public interface IHrPuestoService {

	List<HrPuesto> findAll();

	void save(HrPuesto hrpuesto);

	void delete(Long id);

	HrPuesto findOne(Long id);

}
