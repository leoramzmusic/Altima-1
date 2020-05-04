package com.altima.springboot.app.models.service;

import java.util.List;


import com.altima.springboot.app.models.entity.DiseñoPrendaImagen;

public interface IDisenioPrendaImagenService 
{
	List<DiseñoPrendaImagen> findAll();

	void save(DiseñoPrendaImagen disenioImagenPrenda);

	void delete(Long id);

	DiseñoPrendaImagen findOne(Long id);
	
	List<DiseñoPrendaImagen> findByPrenda(Long id);
}
