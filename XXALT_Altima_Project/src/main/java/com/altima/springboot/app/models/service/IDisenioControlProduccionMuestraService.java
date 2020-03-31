package com.altima.springboot.app.models.service;

import java.util.List;
import com.altima.springboot.app.models.entity.DisenioControlProduccionMuestra;
public interface IDisenioControlProduccionMuestraService {
	
	List<DisenioControlProduccionMuestra> findAll();

	void save(DisenioControlProduccionMuestra DisenioControlProduccionMuestra);

	void delete(Long id);

	DisenioControlProduccionMuestra findOne(Long id);
	
	List<Object []> Operadores();

}
