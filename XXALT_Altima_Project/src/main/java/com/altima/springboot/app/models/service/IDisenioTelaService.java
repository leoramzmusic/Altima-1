package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.models.entity.DisenioTela;

public interface IDisenioTelaService {

	List<DisenioTela> findAll();

	void save(DisenioTela diseniotela);

	void delete(Long id);

	DisenioTela findOne(Long id);

}
