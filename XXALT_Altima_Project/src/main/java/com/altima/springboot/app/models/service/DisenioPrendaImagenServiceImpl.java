package com.altima.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altima.springboot.app.models.entity.DiseñoPrendaImagen;

import com.altima.springboot.app.repository.DisenioPrendaImagenRepository;

@Service
public class DisenioPrendaImagenServiceImpl implements IDisenioPrendaImagenService
{
	@Autowired
	private EntityManager em;
	
	@Autowired
	private DisenioPrendaImagenRepository repository;
	
	@Override
	public List<DiseñoPrendaImagen> findAll() {
		// TODO Auto-generated method stub
		return (List<DiseñoPrendaImagen>) repository.findAll();
	}

	@Override
	public void save(DiseñoPrendaImagen disenioImagenPrenda) {
		// TODO Auto-generated method stub
		repository.save(disenioImagenPrenda);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public DiseñoPrendaImagen findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DiseñoPrendaImagen> findByPrenda(Long id) {
		// TODO Auto-generated method stub
		return em.createQuery("FROM DiseñoPrendaImagen WHERE idPrenda =" + id).getResultList();
	}

}
