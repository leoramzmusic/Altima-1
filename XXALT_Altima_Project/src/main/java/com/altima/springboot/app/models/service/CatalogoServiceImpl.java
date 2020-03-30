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
		return em.createQuery("from DisenioLookup where tipo_lookup='Marca' and Estatus=1").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisenioLookup> findAllColor() {
		return em.createQuery("from DisenioLookup where tipo_lookup='Color' and Estatus=1").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisenioLookup> findAllPzasTrazo() {
		return em.createQuery("from DisenioLookup where tipo_lookup='Pieza Trazo' and Estatus=1").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisenioLookup> findAllFamPrendas() {
		return em.createQuery("from DisenioLookup where tipo_lookup='Familia Prenda' and Estatus=1").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisenioLookup> findAllFamGenero() {
		return em.createQuery("from DisenioLookup where tipo_lookup='Familia Genero' and Estatus=1").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisenioLookup> findAllFamComposicion() {
		return em.createQuery("from DisenioLookup where tipo_lookup='Familia Composicion' and Estatus=1").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisenioLookup> findAllInstrCuidado(){
		return em.createQuery("from DisenioLookup where tipo_lookup='Instruccion Cuidado' and Estatus=1").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisenioLookup> findAllUnidadMedida(){
		return em.createQuery("from DisenioLookup where tipo_lookup='Unidad Medida' and Estatus=1").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisenioLookup> findAllMaterial(){
		return em.createQuery("from DisenioLookup where tipo_lookup='Material' and Estatus=1").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisenioLookup> findAllMarcador(){
		return em.createQuery("from DisenioLookup where tipo_lookup='Marcador' and Estatus=1").getResultList();
	}

}
