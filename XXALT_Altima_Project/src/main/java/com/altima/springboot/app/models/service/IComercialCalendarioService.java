package com.altima.springboot.app.models.service;

import java.util.List;
import com.altima.springboot.app.models.entity.ComercialCalendario;

public interface IComercialCalendarioService {
	
	List<ComercialCalendario> findAll();
	void save (ComercialCalendario comercialCalendario);
	void delete (Long id);
	ComercialCalendario findOne(Long id);
	
	

}
