package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.models.entity.ComercialCliente;

public interface IComercialClienteService {
	
	List<ComercialCliente> findAll();

	void save(ComercialCliente ComercialCliente);

	void delete(Long id);

	ComercialCliente findOne(Long id);

}
