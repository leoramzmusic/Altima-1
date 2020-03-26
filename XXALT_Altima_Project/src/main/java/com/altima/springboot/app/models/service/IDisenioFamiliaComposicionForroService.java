package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.models.entity.DisenioFamiliaComposicionForro;

public interface IDisenioFamiliaComposicionForroService {
	
	List<DisenioFamiliaComposicionForro> findAll();

	void save(DisenioFamiliaComposicionForro DisenioFamiliaComposicionForro);

	void delete(Long id);

	DisenioFamiliaComposicionForro findOne(Long id);

}
