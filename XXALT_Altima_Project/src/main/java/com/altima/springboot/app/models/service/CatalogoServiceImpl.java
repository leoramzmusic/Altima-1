package com.altima.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altima.springboot.app.models.entity.DisenioLookup;
import com.altima.springboot.app.repository.CatalogoRepository;


@Service
public class CatalogoServiceImpl implements ICatalogoService {
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private CatalogoRepository repository;
	@Override
	@Transactional(readOnly=true)
	public List<DisenioLookup> findAll() {
		// TODO Auto-generated method stub
		return (List<DisenioLookup>) repository.findAll();
	}

	@Override
	@Transactional
	public void save(DisenioLookup diseniolookup) {
		// TODO Auto-generated method stub
		repository.save(diseniolookup);

	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public DisenioLookup findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisenioLookup> findAllMarca() {
		return em.createQuery("from DisenioLookup where tipo_lookup='Marca'").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisenioLookup> findAllColor() {
		return em.createQuery("from DisenioLookup where tipo_lookup='Color'").getResultList();
	}

}
