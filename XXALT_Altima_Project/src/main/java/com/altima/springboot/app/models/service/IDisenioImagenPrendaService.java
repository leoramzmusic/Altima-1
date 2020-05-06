package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.models.entity.DisenioPrenda;
import com.altima.springboot.app.models.entity.DiseñoPrendaImagen;

public interface IDisenioImagenPrendaService 
{
	List<DiseñoPrendaImagen> findAll();

	void save(DiseñoPrendaImagen disenioImagenprenda);

	void delete(Long id);

	DiseñoPrendaImagen findOne(Long id);
	
	List<DiseñoPrendaImagen> findByPrenda(Long id);
}
