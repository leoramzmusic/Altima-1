package com.altima.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.OrderBy;
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
		return em.createQuery("from DisenioLookup where tipo_lookup='Marca' and Estatus=1 ORDER BY idLookup ASC").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	@OrderBy("idLookup ASC")
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
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisenioLookup> findAllComposicion(){
		return em.createQuery("from DisenioLookup where tipo_lookup='Composicion' and Estatus=1").getResultList();
	}
	
	@Override
	@Transactional
	public DisenioLookup findLastComposicion(){
		return (DisenioLookup) em.createQuery("from DisenioLookup where tipo_lookup='Composicion' ORDER BY idLookup DESC").setMaxResults(1).getSingleResult();
	}
	
	@Override
	@Transactional
	public DisenioLookup findLastMarcador(){
		return (DisenioLookup) em.createQuery("from DisenioLookup where tipo_lookup='Marcador' ORDER BY idLookup DESC").setMaxResults(1).getSingleResult();
	}
	
	@Override
	@Transactional
	public DisenioLookup findLastMaterial(){
		return (DisenioLookup) em.createQuery("from DisenioLookup where tipo_lookup='Material' ORDER BY idLookup DESC").setMaxResults(1).getSingleResult();
	}
	
	@Override
	@Transactional
	public DisenioLookup findLastUnidadMedida(){
		return (DisenioLookup) em.createQuery("from DisenioLookup where tipo_lookup='Unidad Medida' ORDER BY idLookup DESC").setMaxResults(1).getSingleResult();
	}
	
	@Override
	@Transactional
	public DisenioLookup findLastInstrCuidado(){
		return (DisenioLookup) em.createQuery("from DisenioLookup where tipo_lookup='Instruccion Cuidado' ORDER BY idLookup DESC").setMaxResults(1).getSingleResult();
	}
	
	@Override
	@Transactional
	public DisenioLookup findLastFamComposicion(){
		return (DisenioLookup) em.createQuery("from DisenioLookup where tipo_lookup='Familia Composicion' ORDER BY idLookup DESC").setMaxResults(1).getSingleResult();
	}
	
	@Override
	@Transactional
	public DisenioLookup findLastFamGenero(){
		return (DisenioLookup) em.createQuery("from DisenioLookup where tipo_lookup='Familia Genero' ORDER BY idLookup DESC").setMaxResults(1).getSingleResult();
	}
	
	@Override
	@Transactional
	public DisenioLookup findLastFamPrendas(){
		return (DisenioLookup) em.createQuery("from DisenioLookup where tipo_lookup='Familia Prenda' ORDER BY idLookup DESC").setMaxResults(1).getSingleResult();
	}
	
	@Override
	@Transactional
	public DisenioLookup findLastPzasTrazo(){
		return (DisenioLookup) em.createQuery("from DisenioLookup where tipo_lookup='Pieza Trazo' ORDER BY idLookup DESC").setMaxResults(1).getSingleResult();
	}
	
	@Override
	@Transactional
	public DisenioLookup findLastColor(){
		return (DisenioLookup) em.createQuery("from DisenioLookup where tipo_lookup='Color' ORDER BY idLookup DESC").setMaxResults(1).getSingleResult();
	}
	
	@Override
	@Transactional
	public boolean findDuplicate(String Lookup){
		boolean duplicate;
		@SuppressWarnings("unchecked")
		List<DisenioLookup> result = em.createQuery("from DisenioLookup where nombreLookup='"+Lookup+"'").getResultList();
		if(result.isEmpty()) {
			duplicate=false;
		}
		else {
			duplicate=true;
		}
		 return duplicate;
	}
	
	

}
