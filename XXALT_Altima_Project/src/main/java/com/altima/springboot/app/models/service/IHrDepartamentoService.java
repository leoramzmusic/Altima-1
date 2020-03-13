package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.models.entity.HrDepartamento;

public interface IHrDepartamentoService {

	List<HrDepartamento> findAll();

	void save(HrDepartamento hrdepartamento);

	void delete(Long id);

	HrDepartamento findOne(Long id);

}
