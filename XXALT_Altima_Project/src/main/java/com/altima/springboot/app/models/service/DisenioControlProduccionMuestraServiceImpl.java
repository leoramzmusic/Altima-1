package com.altima.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altima.springboot.app.models.entity.DisenioControlProduccionMuestra;
import com.altima.springboot.app.repository.DisenioControlProduccionMuestraRepository;

@Service
public class DisenioControlProduccionMuestraServiceImpl implements IDisenioControlProduccionMuestraService {
	 private DisenioControlProduccionMuestraRepository repository;
	 @PersistenceContext
	private EntityManager em;
	@Override
	public List<DisenioControlProduccionMuestra> findAll() {
		// TODO Auto-generated method stub
		return (List<DisenioControlProduccionMuestra>) repository.findAll();
	}

	@Override
	public void save(DisenioControlProduccionMuestra DisenioControlProduccionMuestra) {
		// TODO Auto-generated method stub
		repository.save(DisenioControlProduccionMuestra);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public DisenioControlProduccionMuestra findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object []> Operadores() {
		// TODO Auto-generated method stub
		
		
		List<Object[]> re= em.createNativeQuery("select empleado.id_empleado, persona.nombre_persona from alt_hr_empleado as empleado, alt_hr_persona as persona \r\n" + 
				"where 1=1 \r\n" + 
				"and empleado.id_persona= persona.id_persona\r\n" + 
				"and empleado.id_puesto=1").getResultList();
		return re;
	}

}
