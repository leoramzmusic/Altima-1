package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.models.entity.HrEmpleado;

public interface IHrEmpleadoService {

	List<HrEmpleado> findAll();

	void save(HrEmpleado hrempleado);

	void delete(Long id);

	HrEmpleado findOne(Long id);
	
	List<Object> findAllByPuesto(Long id);
	
	List<Object> findEmpleadoPersona();

}
