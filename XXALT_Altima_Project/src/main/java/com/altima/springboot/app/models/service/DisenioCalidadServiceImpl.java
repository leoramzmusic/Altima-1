package com.altima.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altima.springboot.app.models.entity.DisenioCalidad;
import com.altima.springboot.app.repository.DisenioCalidadRepository;

@Service
public class DisenioCalidadServiceImpl implements IDisenioCalidadService {
	@Autowired
	private DisenioCalidadRepository repository;
	@Autowired
	private EntityManager em;
	
	@Override
	@Transactional(readOnly = true)
	public List<DisenioCalidad> findAll() {
		// TODO Auto-generated method stub
		return (List<DisenioCalidad>) repository.findAll();
	}
	
	@Override
	@Transactional
	public void save(DisenioCalidad diseniocalidad) {
		// TODO Auto-generated method stub
		repository.save(diseniocalidad);
		
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
	@Override
	@Transactional
	public DisenioCalidad findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object> findAllWithIdTextTela() {
		// TODO Auto-generated method stub
		return em.createNativeQuery(
				"select calidad.id_calidad, calidad.id_text, tela.id_text as text, calidad.id_material, tela.nombre_tela, calidad.estatus from alt_disenio_calidad as calidad\r\n" + 
				"						INNER JOIN alt_disenio_tela tela ON calidad.id_tela = tela.id_tela\r\n" + 
				"UNION\r\n" + 
				"SELECT calidad.id_calidad, calidad.id_text, material.id_text, calidad.id_material, material.nombre_material, calidad.estatus from alt_disenio_calidad as calidad\r\n" + 
				"						INNER JOIN alt_disenio_material material ON calidad.id_material = material.id_material\r\n" + 
				"						where material.calidad = 1")
				.getResultList();
	}
}
