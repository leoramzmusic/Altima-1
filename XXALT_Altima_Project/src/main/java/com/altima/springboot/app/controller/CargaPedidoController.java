package com.altima.springboot.app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.altima.springboot.app.models.service.IControlProduccionMuestraService;

@CrossOrigin(origins = { "*" })
@Controller
public class CargaPedidoController {
	@Autowired
	private  IControlProduccionMuestraService DCPM;

	
	@RequestMapping(value = "/mostrar-pedidos", method = RequestMethod.GET)
	@ResponseBody
	public List<Object []> operadores(Long id) {
		System.out.println("Hola pinche putita, te pones bien cachonda hija de tu puta madre: "+ id );
		
		return  DCPM.Operadores();
	}
//ssss
}
