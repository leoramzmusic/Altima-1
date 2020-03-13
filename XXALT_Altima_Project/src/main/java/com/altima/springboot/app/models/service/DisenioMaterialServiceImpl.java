package com.altima.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altima.springboot.app.models.entity.DisenioMaterial;
import com.altima.springboot.app.repository.DisenioMaterialRepository;


@Service
public class DisenioMaterialServiceImpl implements IDisenioMaterialService {
	@Autowired
	private DisenioMaterialRepository repository;
	@Override
	@Transactional(readOnly=true)
	public List<DisenioMaterial> findAll() {
		// TODO Auto-generated method stub
		return (List<DisenioMaterial>) repository.findAll();
	}

	@Override
	@Transactional
	public void save(DisenioMaterial diseniomaterial) {
		// TODO Auto-generated method stub
		repository.save(diseniomaterial);

	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public DisenioMaterial findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
