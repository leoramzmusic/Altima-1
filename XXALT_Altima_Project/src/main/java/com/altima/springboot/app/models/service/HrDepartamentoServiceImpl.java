package com.altima.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.altima.springboot.app.models.entity.HrDepartamento;
import com.altima.springboot.app.repository.HrDepartamentoRepository;


@Service
public class HrDepartamentoServiceImpl implements IHrDepartamentoService {
	@Autowired
	private HrDepartamentoRepository repository;
	@Override
	@Transactional(readOnly=true)
	public List<HrDepartamento> findAll() {
		// TODO Auto-generated method stub
		return (List<HrDepartamento>) repository.findAll();
	}

	@Override
	@Transactional
	public void save(HrDepartamento hrdepartamento) {
		// TODO Auto-generated method stub
		repository.save(hrdepartamento);

	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public HrDepartamento findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
