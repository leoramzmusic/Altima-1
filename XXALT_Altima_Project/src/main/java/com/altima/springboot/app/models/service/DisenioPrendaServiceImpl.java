package com.altima.springboot.app.models.service;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.altima.springboot.app.models.entity.DisenioPrenda;
import com.altima.springboot.app.repository.DisenioPrendaRepository;

@Service
public class DisenioPrendaServiceImpl implements IDisenioPrendaService {
	@Autowired
	private DisenioPrendaRepository repository;
	@Autowired
	private EntityManager em;
	
	@Override
	@Transactional(readOnly = true)
	public List<DisenioPrenda> findAll() {
		// TODO Auto-generated method stub
		return (List<DisenioPrenda>) repository.findAll();
	}
	
	@Override
	@Transactional
	public void save(DisenioPrenda disenioprenda) {
		// TODO Auto-generated method stub
		repository.save(disenioprenda);
		
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
	@Override
	@Transactional
	public DisenioPrenda findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public String[] getExistencias(Long familiaPrenda) {
		String[] response = new String[2];
		
		//Consecutivo Numero
		List<BigInteger> existencias = em.createNativeQuery("SELECT COUNT(*) FROM `alt_disenio_prenda` WHERE id_familia_prenda =" + familiaPrenda).getResultList();
		BigInteger res = existencias.get(0);
		Long retu = (res.longValue());
		response[0] = retu.toString();
		
		//Consecutivo Nombre
		List<String> nombre = em.createNativeQuery("SELECT nombre_lookup FROM `alt_disenio_lookup` WHERE id_lookup =" + familiaPrenda).getResultList();
		response[1] = nombre.get(0).toString();
		
		return response;
	}
	
}
