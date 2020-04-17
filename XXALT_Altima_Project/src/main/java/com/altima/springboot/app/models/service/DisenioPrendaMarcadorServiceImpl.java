package com.altima.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.altima.springboot.app.models.entity.DisenioPrendaMarcador;
import com.altima.springboot.app.repository.DisenioPrendaMarcadorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisenioPrendaMarcadorServiceImpl implements IDisenioPrendaMarcadorService {
	@Autowired
	private DisenioPrendaMarcadorRepository repository;
	@Autowired
	EntityManager em;
	
	@Override
	public List<DisenioPrendaMarcador> findAll() {
		// TODO Auto-generated method stub
		return (List<DisenioPrendaMarcador>) repository.findAll();
	}
	
	@Override
	public void save(DisenioPrendaMarcador disenioprenda) {
		// TODO Auto-generated method stub
		repository.save(disenioprenda);
	}
	
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
	@Override
	public DisenioPrendaMarcador findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DisenioPrendaMarcador> findByIdPrenda(Long id) {
		// TODO Auto-generated method stub
		return em.createQuery(
				"SELECT dpm.idMarcador,dl.nombreLookup as idMarcador,dpm.idPrenda FROM DisenioPrendaMarcador dpm inner join DisenioLookup dl on dpm.idMarcador=dl.idLookup WHERE dpm.idPrenda ="
						+ id)
				.getResultList();
	}
	
	@Override
	@Transactional
	public void deleteByIdPrenda(Long id) {
		// TODO Auto-generated method stub
		em.createNativeQuery("DELETE FROM alt_disenio_prenda_marcador WHERE id_prenda = " + id).executeUpdate();
		;
	}
	
}