package com.altima.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.altima.springboot.app.models.entity.HrEmpleado;
import com.altima.springboot.app.repository.HrEmpleadoRepository;


@Service
public class HrEmpleadoServiceImpl implements IHrEmpleadoService {
	@Autowired
	private HrEmpleadoRepository repository;
	@Override
	@Transactional(readOnly=true)
	public List<HrEmpleado> findAll() {
		// TODO Auto-generated method stub
		return (List<HrEmpleado>) repository.findAll();
	}

	@Override
	@Transactional
	public void save(HrEmpleado hrempleado) {
		// TODO Auto-generated method stub
		repository.save(hrempleado);

	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public HrEmpleado findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
