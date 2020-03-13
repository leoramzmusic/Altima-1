package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.models.entity.HrEmpleadoUsuario;

public interface IHrEmpleadoUsuarioService {

	List<HrEmpleadoUsuario> findAll();

	void save(HrEmpleadoUsuario hrempleadousuario);

	void delete(Long id);

	HrEmpleadoUsuario findOne(Long id);

}
