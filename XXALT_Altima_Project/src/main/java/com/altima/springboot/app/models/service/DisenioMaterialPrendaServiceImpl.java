package com.altima.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.altima.springboot.app.models.entity.DisenioMaterialPrenda;
import com.altima.springboot.app.repository.DisenioMaterialPrendaRepository;


@Service
public class DisenioMaterialPrendaServiceImpl implements IDisenioMaterialPrendaService {
	@Autowired
	private DisenioMaterialPrendaRepository repository;
	@Autowired
	private EntityManager em;
	@Override
	@Transactional(readOnly=true)
	public List<DisenioMaterialPrenda> findAll() {
		// TODO Auto-generated method stub
		return (List<DisenioMaterialPrenda>) repository.findAll();
	}

	@Override
	@Transactional
	public void save(DisenioMaterialPrenda diseniomaterialprenda) {
		// TODO Auto-generated method stub
		repository.save(diseniomaterialprenda);

	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public DisenioMaterialPrenda findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	@Override
	public String deleteAllMaterialFromPrenda(Long id) {
		// TODO Auto-generated method stub
		em.createNativeQuery("DELETE FROM alt_disenio_material_prenda WHERE id_prenda = " + id);
		return "Erased";
	}

}
