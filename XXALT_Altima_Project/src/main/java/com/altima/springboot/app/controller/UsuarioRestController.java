package com.altima.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.altima.springboot.app.models.entity.Rol;
import com.altima.springboot.app.models.service.IRolService;

@RestController
public class UsuarioRestController {
	
	@Autowired
	IRolService rolService;
	
	

	
	@RequestMapping (value="/listRoles", method=RequestMethod.GET)
	private List<Rol> listRoles(){
		
		return rolService.FindByDepartamento();
	}
	
	@RequestMapping (value="/listSecciones", method=RequestMethod.GET)
	private List<Rol> listSecciones(){
		
		return rolService.FindBySeccion();
	}

	@RequestMapping (value="/listPermisos", method=RequestMethod.GET)
	private List<Rol> listPermisos(){
		
		return rolService.FindByPermiso();
	}
}
