package com.altima.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.altima.springboot.app.models.entity.HrPuesto;
import com.altima.springboot.app.repository.HrPuestoRepository;


@Service
public class HrPuestoServiceImpl implements IHrPuestoService {
	@Autowired
	private HrPuestoRepository repository;
	@Override
	@Transactional(readOnly=true)
	public List<HrPuesto> findAll() {
		// TODO Auto-generated method stub
		return (List<HrPuesto>) repository.findAll();
	}

	@Override
	@Transactional
	public void save(HrPuesto hrpuesto) {
		// TODO Auto-generated method stub
		repository.save(hrpuesto);

	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public HrPuesto findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
