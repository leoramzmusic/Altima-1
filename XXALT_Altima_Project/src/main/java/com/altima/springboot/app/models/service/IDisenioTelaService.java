package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.models.entity.DisenioLookup;
import com.altima.springboot.app.models.entity.DisenioPrenda;
import com.altima.springboot.app.models.entity.DisenioTela;

public interface IDisenioTelaService {

	List<DisenioTela> findAll();
	
	List<DisenioLookup> findAllBotones();
	
	List<DisenioLookup> findAllColores();
	
	List<DisenioLookup> findAllFamilaComposicion();
	
	List<DisenioPrenda> findAllPrenda();

	void save(DisenioTela diseniotela);

	void delete(Long id);

	DisenioTela findOne(Long id);

}
