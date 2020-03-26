package com.altima.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altima.springboot.app.models.entity.DisenioLookup;
import com.altima.springboot.app.models.entity.DisenioPrenda;
import com.altima.springboot.app.models.entity.DisenioTela;
import com.altima.springboot.app.repository.DisenioTelaRepository;


@Service
public class DisenioTelaServiceImpl implements IDisenioTelaService {
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private DisenioTelaRepository repository;
	@Override
	@Transactional(readOnly=true)
	public List<DisenioTela> findAll() {
		// TODO Auto-generated method stub
		return (List<DisenioTela>) repository.findAll();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisenioLookup> findAllBotones() {
		// TODO Auto-generated method stub
		return em.createQuery("from DisenioLookup where tipo_lookup = 'Boton'").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisenioLookup> findAllColores() {
		// TODO Auto-generated method stub
		return em.createQuery("from DisenioLookup where tipo_lookup = 'Color'").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisenioLookup> findAllFamilaComposicion() {
		// TODO Auto-generated method stub
		return em.createQuery("from DisenioLookup where tipo_lookup = 'Familia Composicion'").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisenioPrenda> findAllPrenda() {
		// TODO Auto-generated method stub
		return em.createQuery("from DisenioPrenda").getResultList();
	}
	
	
	
	@Override
	@Transactional
	public void save(DisenioTela diseniotela) {
		// TODO Auto-generated method stub
		repository.save(diseniotela);

	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public DisenioTela findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
