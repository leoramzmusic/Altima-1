package com.altima.springboot.app.models.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altima.springboot.app.models.entity.DiseñoPrendaImagen;

import com.altima.springboot.app.repository.DisenioImagenPrendaRepository;

@Service
public class DisenioImagenPrendaServiceImpl implements IDisenioImagenPrendaService
{
	@Autowired
	private EntityManager em;
	
	@Autowired
	private DisenioImagenPrendaRepository repository;
	
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

	@SuppressWarnings({ "unchecked", "null" })
	@Override
	public List<DiseñoPrendaImagen> findByPrenda(Long id) {
		// TODO Auto-generated method stub
		List<DiseñoPrendaImagen> existentes = em.createQuery("FROM DiseñoPrendaImagen WHERE idPrenda =" + id).getResultList();
		List<DiseñoPrendaImagen> listaNueva = new ArrayList<>();
		
		for(int i = 0; i < 6; i++)
		{
			Long num = i + 1L;
			
			if(i < existentes.size())
			{
				DiseñoPrendaImagen dpi = existentes.get(i);
				dpi.setEstatus(num.toString());
				listaNueva.add(dpi);
				dpi = new DiseñoPrendaImagen();
			}
			else
			{
				DiseñoPrendaImagen dpi = new DiseñoPrendaImagen();
				dpi.setEstatus(num.toString());
				listaNueva.add(dpi);
			}
		}
		
		
		
		return listaNueva;
	}

}
