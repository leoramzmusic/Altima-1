package com.altima.springboot.app.models.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.altima.springboot.app.models.entity.DisenioFamiliaComposicionForro;
import com.altima.springboot.app.repository.DisenioFamiliaComposicionForroRepository;

@Service
public class DisenioFamiliaComposicionForroServiceImpl implements IDisenioFamiliaComposicionForroService {


	@Autowired
	private DisenioFamiliaComposicionForroRepository repository;
	
	@Override
	public List<DisenioFamiliaComposicionForro> findAll() {
		return (List<DisenioFamiliaComposicionForro>) repository.findAll();
	
	}

	@Override
	public void save(DisenioFamiliaComposicionForro DisenioFamiliaComposicionForro) {
		repository.save(DisenioFamiliaComposicionForro);

	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);

	}

	@Override
	public DisenioFamiliaComposicionForro findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
