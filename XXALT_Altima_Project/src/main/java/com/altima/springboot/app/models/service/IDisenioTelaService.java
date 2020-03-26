package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.models.entity.DisenioFamiliaComposicion;
import com.altima.springboot.app.models.entity.DisenioLookup;
import com.altima.springboot.app.models.entity.DisenioPrenda;
import com.altima.springboot.app.models.entity.DisenioTela;

public interface IDisenioTelaService {

	List<DisenioTela> findAll();
	
	List<DisenioLookup> findAllBotones();
	
	List<DisenioLookup> findAllColores();
	
	List<DisenioPrenda> findAllPrenda();
	
	List<DisenioFamiliaComposicion> findAllFamComposicion();

	void save(DisenioTela diseniotela);

	void delete(Long id);

	DisenioTela findOne(Long id);

}
