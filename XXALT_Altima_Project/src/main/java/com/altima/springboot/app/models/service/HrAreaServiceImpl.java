package com.altima.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altima.springboot.app.models.entity.HrArea;
import com.altima.springboot.app.repository.HrAreaRepository;


@Service
public class HrAreaServiceImpl implements IHrAreaService {
	@Autowired
	private HrAreaRepository repository;
	@Override
	@Transactional(readOnly=true)
	public List<HrArea> findAll() {
		// TODO Auto-generated method stub
		return (List<HrArea>) repository.findAll();
	}

	@Override
	@Transactional
	public void save(HrArea hrarea) {
		// TODO Auto-generated method stub
		repository.save(hrarea);

	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public HrArea findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
