
package com.altima.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altima.springboot.app.models.entity.DisenioLookup;
import com.altima.springboot.app.models.entity.DisenioMaterial;
import com.altima.springboot.app.models.entity.DisenioProceso;
import com.altima.springboot.app.repository.DisenioMaterialRepository;


@Service
public class DisenioMaterialServiceImpl implements IDisenioMaterialService {
	@Autowired
	private DisenioMaterialRepository repository;
	
	
	
	@Autowired
	private EntityManager em;
	
	@Override
	@Transactional(readOnly=true)
	public List<DisenioMaterial> findAll() {
		// TODO Auto-generated method stub
		return (List<DisenioMaterial>) repository.findAll();
	}

	@Override
	@Transactional
	public void save(DisenioMaterial diseniomaterial) {
		// TODO Auto-generated method stub
		repository.save(diseniomaterial);

	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public DisenioMaterial findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisenioLookup> findListaLookupMat(){
	
		return em.createQuery("SELECT idLookup, nombre, tipoLookup FROM DisenioLookup WHERE tipoLookup= 'material' and   estatus=1").getResultList();
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisenioLookup> findListaLookupMed(){
	
		return em.createQuery("SELECT idLookup, nombre, tipoLookup FROM DisenioLookup WHERE tipoLookup= 'medida' and   estatus=1").getResultList();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisenioLookup> findListaMarcas(){
	
		return em.createQuery("SELECT idLookup, nombre, tipoLookup FROM DisenioLookup WHERE tipoLookup= 'Marca' and   estatus=1").getResultList();
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisenioLookup> findListaClasificacion(){
	
		return em.createQuery("SELECT idLookup, nombre, tipoLookup FROM DisenioLookup WHERE tipoLookup= 'clasificacion' and   estatus=1").getResultList();
	}
	
	
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> disenioMaterial() {
		
		List<Object[]> mv;
		mv= em.createNativeQuery("{call  alt_pr_materiales}").getResultList(); 
		return  mv;
			}
	
	
	
	

	
	

}
