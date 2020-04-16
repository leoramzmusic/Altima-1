package com.altima.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.altima.springboot.app.models.entity.DisenioForro;
import com.altima.springboot.app.repository.DisenioForroRepository;

@Service
public class DisenioForroServiceImpl implements IDisenioForroService {
	@PersistenceContext
	private EntityManager em;
	@Autowired
	private DisenioForroRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<DisenioForro> findAll() {
		// TODO Auto-generated method stub
		return (List<DisenioForro>) repository.findAll();
	}
	
	@Override
	@Transactional
	public void save(DisenioForro disenioforro) {
		// TODO Auto-generated method stub
		repository.save(disenioforro);
		
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
	@Override
	@Transactional
	public DisenioForro findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object[]> ForrosSelect(Long id) {
		// TODO Auto-generated method stub
		List<Object[]> re = em
				.createNativeQuery("select f.id_forro ,f.nombre_forro \r\n" + "from 	alt_disenio_forro as f \r\n"
						+ "where not exists (select alt_disenio_tela_forro.id_forro, f.nombre_forro from  \r\n"
						+ "					alt_disenio_tela_forro \r\n" + "					where 1=1\r\n"
						+ "					and alt_disenio_tela_forro.id_forro= f.id_forro \r\n"
						+ "					and alt_disenio_tela_forro.id_tela=" + id + ")")
				.getResultList();
		return re;
	}
	
}
