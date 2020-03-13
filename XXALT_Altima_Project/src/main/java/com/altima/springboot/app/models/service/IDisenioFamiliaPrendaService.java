package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.models.entity.DisenioFamiliaPrenda;

public interface IDisenioFamiliaPrendaService {

	List<DisenioFamiliaPrenda> findAll();

	void save(DisenioFamiliaPrenda diseniofamiliaprenda);

	void delete(Long id);

	DisenioFamiliaPrenda findOne(Long id);

}
