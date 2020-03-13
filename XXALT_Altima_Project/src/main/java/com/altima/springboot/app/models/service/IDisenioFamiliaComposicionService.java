package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.models.entity.DisenioFamiliaComposicion;

public interface IDisenioFamiliaComposicionService {

	List<DisenioFamiliaComposicion> findAll();

	void save(DisenioFamiliaComposicion diseniofamiliacomposicion);

	void delete(Long id);

	DisenioFamiliaComposicion findOne(Long id);

}
