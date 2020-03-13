package com.altima.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.altima.springboot.app.models.entity.HrEmpleadoUsuario;
import com.altima.springboot.app.repository.HrEmpleadoUsuarioRepository;


@Service
public class HrEmpleadoUsuarioServiceImpl implements IHrEmpleadoUsuarioService {
	@Autowired
	private HrEmpleadoUsuarioRepository repository;
	@Override
	@Transactional(readOnly=true)
	public List<HrEmpleadoUsuario> findAll() {
		// TODO Auto-generated method stub
		return (List<HrEmpleadoUsuario>) repository.findAll();
	}

	@Override
	@Transactional
	public void save(HrEmpleadoUsuario hrempleadousuario) {
		// TODO Auto-generated method stub
		repository.save(hrempleadousuario);

	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public HrEmpleadoUsuario findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
