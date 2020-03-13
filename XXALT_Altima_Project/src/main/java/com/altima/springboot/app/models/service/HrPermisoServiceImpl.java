package com.altima.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.altima.springboot.app.models.entity.HrPermiso;
import com.altima.springboot.app.repository.HrPermisoRepository;


@Service
public class HrPermisoServiceImpl implements IHrPermisoService {
	@Autowired
	private HrPermisoRepository repository;
	@Override
	@Transactional(readOnly=true)
	public List<HrPermiso> findAll() {
		// TODO Auto-generated method stub
		return (List<HrPermiso>) repository.findAll();
	}

	@Override
	@Transactional
	public void save(HrPermiso hrpermiso) {
		// TODO Auto-generated method stub
		repository.save(hrpermiso);

	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public HrPermiso findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
