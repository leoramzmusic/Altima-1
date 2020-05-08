package com.altima.springboot.app.models.service;

import java.util.List;


import com.altima.springboot.app.models.entity.DiseñoPrendaImagen;
import com.altima.springboot.app.models.entity.ProduccionDetallePedido;



public interface IInventarioService {
	
	
	public List<ProduccionDetallePedido> listInventario();
	
	
	void save(DiseñoPrendaImagen diseñoPrendaImagen);
	
	Object findOnePreImg(Long id);
	
	
	DiseñoPrendaImagen findOne(Long Id);
	
	
	
	
	
	

}
