package com.altima.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altima.springboot.app.models.entity.Rol;
import com.altima.springboot.app.models.entity.Usuario;
import com.altima.springboot.app.repository.RolRepository;
import com.altima.springboot.app.repository.UsuarioRepository;
@Service
public class RolServiceImpl implements IRolService {

	@Autowired	
	private RolRepository repository;
	
	@Override
	public List<Rol> findAll() {
		// TODO Auto-generated method stub
		return (List<Rol>) repository.findAll();
	}

	@Override
	public Rol findOne(Long id_rol) {
		// TODO Auto-generated method stub
		return repository.findById(id_rol).orElse(null);
	}

	@Override
	public void save(Rol rol) {
		// TODO Auto-generated method stub
		repository.save(rol);
	}

	@Override
	public void delete(Long id_rol) {
		// TODO Auto-generated method stub
		repository.deleteById(id_rol);
	}

}
