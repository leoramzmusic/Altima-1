package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.models.entity.ControlHora;
import com.altima.springboot.app.models.entity.ControlProduccionMuestra;
public interface IControlProduccionMuestraService {
	
	List<ControlProduccionMuestra> findAll(Long id);
	void save(ControlProduccionMuestra DisenioControlProduccionMuestra);
	void delete(Long id);
	ControlProduccionMuestra findOne(Long id);
	List<Object []> Operadores();
	
	
	List<Object []> Operaciones(Long id, String tipo);
	
	

	
	List<Object []> ContadorHoras(Long id);
	
	void saveHora(ControlHora DisenioControlHora);
	ControlHora findOneHora(Long id);
	
	public Integer Pausa(Long id);
	
	List<Object []> ListarPedidos();
	
	
	public Integer Contador (String tipo);
	
	
	//vhbjnklm   bbbbbb
	
	
	
	
}
