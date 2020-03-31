package com.altima.springboot.app.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.altima.springboot.app.models.service.IDisenioControlProduccionMuestraService;

@CrossOrigin(origins = { "*" })
@Controller
public class ControlController {
	@Autowired
	private  IDisenioControlProduccionMuestraService DCPM;
	
	
	@GetMapping("/control-de-produccion")
	//@RequestMapping(value = "/control-de-produccion", method = RequestMethod.GET)
	//@ResponseBody
	public String listControlProduccion(Model model) {		
	
		return "control-de-produccion";
	}
	
	
	@RequestMapping(value = "/operadores_listar", method = RequestMethod.GET)
	@ResponseBody
	public List<Object[]> listarOperadores() {		
		return  DCPM.Operadores();
	}
	
	
	@PostMapping("/guardartrazo")
	public String guardacatalogo(Long operador,String f1 ,String f2, HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		System.out.println("Hola soy el contralador");
		
		System.out.println("Hola soy el id"+operador);
		
		System.out.println("Hola soy el f1"+f1);
		System.out.println("Hola soy el f2"+f2);
		
		return "redirect:control-de-produccion";

	}

	@GetMapping("/agregar-muestra")
	public String agregarMuestra() {
		return "agregar-muestra";
	}

}
