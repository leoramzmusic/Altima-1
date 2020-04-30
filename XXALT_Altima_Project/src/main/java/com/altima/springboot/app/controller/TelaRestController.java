package com.altima.springboot.app.controller;

import java.util.List;

import com.altima.springboot.app.models.entity.DisenioLookup;
import com.altima.springboot.app.models.entity.DisenioMaterial;
import com.altima.springboot.app.models.service.IDisenioTelaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TelaRestController {
    @Autowired
    private IDisenioTelaService disenioTelaService;
    
    @GetMapping("/getMaterial")
	public List<DisenioMaterial> listarMaterial(@RequestParam(name="tipo") String tipo) {
    System.out.println("el tepo"+tipo);
		return disenioTelaService.findAllMaterial(tipo);
  }
    @GetMapping("/getTipo")
	public List<DisenioLookup> listarTipo() {
		return disenioTelaService.findAllTipo();
	}
}
