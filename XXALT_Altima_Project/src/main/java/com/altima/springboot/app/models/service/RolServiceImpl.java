package com.altima.springboot.app.models.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altima.springboot.app.models.entity.Rol;
import com.altima.springboot.app.models.entity.Usuario;
import com.altima.springboot.app.repository.RolRepository;
import com.altima.springboot.app.repository.UsuarioRepository;
@Service
public class RolServiceImpl implements IRolService {

	@Autowired	
	EntityManager em;
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ArrayList findBySeccionRol(String seccion) {
		// TODO Auto-generated method stub
		ArrayList secciones =new ArrayList();
		List<String> seccionNombre=new ArrayList<String>();
		List<String> seccionId=new ArrayList<String>();
		for(Rol sec: repository.findBySeccionRol(seccion)) {
			seccionNombre.add(sec.getPermisoRol());
			seccionId.add(sec.getIdRol().toString());
		}
		secciones.add(seccionNombre);
		secciones.add(seccionId);
		return secciones;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Rol> FindByDepartamento (){
		return em.createQuery("SELECT DISTINCT departamentoRol FROM Rol \r\n" + 
				"WHERE nombreRol!='ADMINISTRADOR'").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Rol> FindBySeccion (){
		return em.createQuery("SELECT DISTINCT departamentoRol, seccionRol FROM Rol \r\n" + 
				"WHERE nombreRol!='ADMINISTRADOR'").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Rol> FindByPermiso(){
		return em.createQuery("SELECT DISTINCT permisoRol FROM Rol \r\n" + 
				"WHERE nombreRol!='ADMINISTRADOR'").getResultList();
	}
}
