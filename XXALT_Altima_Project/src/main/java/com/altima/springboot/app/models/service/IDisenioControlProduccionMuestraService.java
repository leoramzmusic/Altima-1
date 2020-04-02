package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.models.entity.DisenioControlHora;
import com.altima.springboot.app.models.entity.DisenioControlProduccionMuestra;
public interface IDisenioControlProduccionMuestraService {
	
	List<DisenioControlProduccionMuestra> findAll(Long id);
	void save(DisenioControlProduccionMuestra DisenioControlProduccionMuestra);
	void delete(Long id);
	DisenioControlProduccionMuestra findOne(Long id);
	List<Object []> Operadores();
	List<Object []> OperacionesTrazo(Long id);
	List<Object []> OperacionesCorte(Long id);
	List<Object []> OperacionesCofeccion(Long id);
	List<Object []> OperacionesPlanchado(Long id);
	
	List<Object []> OperacionesTerminado(Long id);
	
	List<Object []> ContadorHoras(Long id);
	
	void saveHora(DisenioControlHora DisenioControlHora);
	DisenioControlHora findOneHora(Long id);
	
	public Integer Pausa(Long id);
}
