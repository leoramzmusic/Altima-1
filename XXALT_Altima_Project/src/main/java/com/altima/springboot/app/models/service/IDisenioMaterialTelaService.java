package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.models.entity.DisenioMaterialTela;

public interface IDisenioMaterialTelaService {

	void save(DisenioMaterialTela diseniocalidad);

	void delete(Long id);

	List<DisenioMaterialTela> findAll();

	DisenioMaterialTela findOne(Long id);

	List<Object[]> findAllById(Long id);

}
