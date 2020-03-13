package com.altima.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.altima.springboot.app.models.entity.DisenioFamiliaComposicion;
import com.altima.springboot.app.repository.DisenioFamiliaComposicionRepository;


@Service
public class DisenioFamiliaComposicionServiceImpl implements IDisenioFamiliaComposicionService {
	@Autowired
	private DisenioFamiliaComposicionRepository repository;
	@Override
	@Transactional(readOnly=true)
	public List<DisenioFamiliaComposicion> findAll() {
		// TODO Auto-generated method stub
		return (List<DisenioFamiliaComposicion>) repository.findAll();
	}

	@Override
	@Transactional
	public void save(DisenioFamiliaComposicion diseniofamiliacomposicion) {
		// TODO Auto-generated method stub
		repository.save(diseniofamiliacomposicion);

	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public DisenioFamiliaComposicion findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
