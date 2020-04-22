package com.altima.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altima.springboot.app.models.entity.ComercialMovimientoMuestraDetalle;
import com.altima.springboot.app.repository.ComercialMovimientoMuestraDetalleRepository;

@Service
public class ComercialMovimientoMuestraDetalleServiceImpl implements IComercialMovimientoMuestraDetalleService {

	@Autowired
	private ComercialMovimientoMuestraDetalleRepository repository;
	 
	@Autowired
	private EntityManager em;
	
	
	@Override
	@Transactional
	public void save(ComercialMovimientoMuestraDetalle muestraDetalle) {

		repository.save(muestraDetalle);
		
	}
	
	@Override
	@Transactional
	public ComercialMovimientoMuestraDetalle findOne(Long id) {
		
		
		return em.find(ComercialMovimientoMuestraDetalle.class, id);
	}

	@Override
	@Transactional
	public List<ComercialMovimientoMuestraDetalle> findAll() {
		
		return (List<ComercialMovimientoMuestraDetalle>) repository.findAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<ComercialMovimientoMuestraDetalle> findAllbyMovimiento(Long id){
		
		return em.createQuery("FROM ComercialMovimientoMuestraDetalle WHERE idMovimiento="+id).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<ComercialMovimientoMuestraDetalle> findAllbyEstatus(Long id){
		
		return em.createQuery("FROM ComercialMovimientoMuestraDetalle WHERE idMovimiento="+id+" AND estatus = 4 OR estatus = 6 OR estatus = 8").getResultList();
	}
	
	@Override
	@Transactional
	public String ifExistCheckBox(Long id) {
		
		return em.createNativeQuery("SELECT IF((SELECT COUNT(*) FROM alt_comercial_movimiento_muestra_detalle WHERE id_movimiento ="+id+" AND estatus = 4 OR estatus = 6 OR estatus = 8)>0, 1 , 0)").getSingleResult().toString();
	}
	
	
	
}
