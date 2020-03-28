package com.altima.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altima.springboot.app.models.entity.DisenioPrendaPatronaje;
import com.altima.springboot.app.repository.DisenioPrendaPatronajeRepository;

@Service
public class DisenioPrendaPatronajeServiceImpl implements IDisenioPrendaPatronajeService
{
	@Autowired
	private DisenioPrendaPatronajeRepository repository;
	@Autowired
	private EntityManager em;
	@Override
	public List<DisenioPrendaPatronaje> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(DisenioPrendaPatronaje disenioprendapatronaje) {
		// TODO Auto-generated method stub
		repository.save(disenioprendapatronaje);
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

	@Override
	public String deleteAllPatronajeFromPrenda(Long id) {
		// TODO Auto-generated method stub
		em.createNativeQuery("DELETE FROM alt_disenio_prenda_patronaje WHERE id_prenda = " + id);
		return "Erased";
	}

}
