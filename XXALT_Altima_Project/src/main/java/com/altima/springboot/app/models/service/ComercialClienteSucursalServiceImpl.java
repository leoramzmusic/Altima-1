package com.altima.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altima.springboot.app.models.entity.ComercialClienteSucursal;
import com.altima.springboot.app.repository.ComercialClienteSucursalRepository;

@Service
public class ComercialClienteSucursalServiceImpl implements IComercialClienteSucursalService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private ComercialClienteSucursalRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<ComercialClienteSucursal> findAll() {
		// TODO Auto-generated method stub
		return (List<ComercialClienteSucursal>) repository.findAll();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<ComercialClienteSucursal> ClienteSucursales(Long id) {
		return em.createQuery("from ComercialClienteSucursal where id_cliente=" + id).getResultList();
	}
	
	@Override
	public void save(ComercialClienteSucursal Sucursal) {
		repository.save(Sucursal);
		
	}
	
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
	@Override
	public ComercialClienteSucursal findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}
}
