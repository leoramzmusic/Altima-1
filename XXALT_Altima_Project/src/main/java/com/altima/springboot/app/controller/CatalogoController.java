package com.altima.springboot.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.altima.springboot.app.models.entity.DisenioLookup;

////@CrossOrigin(origins = { "http://localhost:8086" })


//@RequestMapping("/api")
@Controller
public class CatalogoController {
	@GetMapping("/catalogos") 
	public String catalogo(Model model, RedirectAttributes flash) {
		
		
		
	return "/catalogos";
	}
	
	@Secured("ROLE_ADMIN")
	//@RequestMapping(value = "/guardarcatalogo", method = RequestMethod.POST)
	@PostMapping("/guardarcatalogo")
	public String guardacatalogo(String actualizadoPor) {
		
	System.out.println(actualizadoPor);
		System.out.println("hola");
		
		
		return "redirect:catalogos";
		
	}
}
