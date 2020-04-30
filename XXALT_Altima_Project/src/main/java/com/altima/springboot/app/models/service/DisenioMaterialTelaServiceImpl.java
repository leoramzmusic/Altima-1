package com.altima.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.altima.springboot.app.models.entity.DisenioMaterialTela;
import com.altima.springboot.app.repository.DisenioMaterialTelaRepository;

@Service
public class DisenioMaterialTelaServiceImpl implements IDisenioMaterialTelaService {
	@Autowired
	private DisenioMaterialTelaRepository repository;
	@Autowired
	private EntityManager em;
	
	@Override
	@Transactional(readOnly = true)
	public List<DisenioMaterialTela> findAll() {
		// TODO Auto-generated method stub
		return (List<DisenioMaterialTela>) repository.findAll();
	}
	
	@Override
	@Transactional
	public void save(DisenioMaterialTela diseniomaterialtela) {
		// TODO Auto-generated method stub
		repository.save(diseniomaterialtela);
		
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
	@Override
	@Transactional
	public DisenioMaterialTela findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Object[]> findAllById(Long id) {
		// TODO Auto-generated method stub
		return em.createQuery("Select dm.idMaterial,dmt.tipo,dm.nombreMaterial,dmt.color,dmt.codigoColor from DisenioMaterialTela dmt inner join DisenioMaterial dm on dm.idMaterial=dmt.idMaterial where dmt.idTela="+id).getResultList();
	}
	
}
