package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.models.entity.DisenioMaterial;

public interface IDisenioMaterialService {

	List<DisenioMaterial> findAll();

	void save(DisenioMaterial diseniomaterial);

	void delete(Long id);

	DisenioMaterial findOne(Long id);

}
