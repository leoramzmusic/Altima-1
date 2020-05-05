package com.altima.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altima.springboot.app.models.entity.ComercialCalendario;
import com.altima.springboot.app.repository.ComercialCalendarioRepository;

@Service
public class ComercialCalendarioServiceImpl implements IComercialCalendarioService {
	@PersistenceContext
	private EntityManager em;
	
	@Autowired 
	private ComercialCalendarioRepository repository;
	
	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<ComercialCalendario> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from ComercialCalendario where estatus=1").getResultList();
	}

	@Override
	public void save(ComercialCalendario comercialCalendario) {
		repository.save(comercialCalendario);

	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);

	}

	@Override
	public ComercialCalendario findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
