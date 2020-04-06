package com.altima.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.altima.springboot.app.models.entity.DisenioLookup;
import com.altima.springboot.app.models.entity.DisenioPruebaEncogimientoLavado;
import com.altima.springboot.app.models.entity.DisenioPruebaLavadoContaminacionCostura;
import com.altima.springboot.app.models.service.IDisenioCalidadService;
import com.altima.springboot.app.models.service.IDisenioLookupService;
import com.altima.springboot.app.models.service.IDisenioPruebaEncogimientoLavadoService;
import com.altima.springboot.app.models.service.IDisenioPruebaLavadoContaminacionCosturaService;


@Controller
public class CalidadController {
	
	@Autowired
	IDisenioCalidadService disenioCalidad;
	
	@Autowired
	IDisenioPruebaEncogimientoLavadoService pruebaEncogiLavado;
	
	@Autowired
	IDisenioPruebaLavadoContaminacionCosturaService pruebaContaCostura;
	
	@Autowired
	IDisenioLookupService disenioLookup;
	
	@GetMapping("calidad") 
	public String listCalidad(Model model) {
		disenioCalidad.findAll();
		model.addAttribute("calidadComponentes",disenioCalidad.findAll());
		
		return "calidad";
	}
	
	@GetMapping("calidad-nueva-prueba") 
	public String addCalidad() {
		return "calidad-nueva-prueba";
	}
	
	@GetMapping("detalle-calidad") 
	public String infoCalidad() {
		return "detalle-calidad";
	}
	
	@RequestMapping(value = "calidad-nueva-prueba/{id}", method = RequestMethod.GET)
	public String addPruebaCalidad(@PathVariable(name = "id") Long id, Model model) {
		List<DisenioPruebaEncogimientoLavado> pruebasEL = pruebaEncogiLavado.findAllByCalidad(id);
		List<DisenioPruebaLavadoContaminacionCostura> pruebasLCC = pruebaContaCostura.findAllByCalidad(id);

		if(pruebaContaCostura.ifExist(id)==0 || pruebaEncogiLavado.ifExist(id)==1 ) {
			
			for (DisenioPruebaEncogimientoLavado u : pruebasEL) {
				if (u.getTipoPrueba().equalsIgnoreCase("Prueba de Vapor")) {
				model.addAttribute("read", "true");
				model.addAttribute("tela", u.getIdTela());
				model.addAttribute("operarioEncogi", u.getCreadoPor());
				model.addAttribute("fechaRealizacionEncogi", u.getFechaRealizacion().replace(" ", "T"));
				model.addAttribute("fechaFinalizacionEncogi", u.getFechaFinalizacion().replace(" ", "T"));
				model.addAttribute("adherenciaEncogi", u.getAdherenciaPruebaVapor());
				model.addAttribute("proveedorEncogi", u.getProveedorPruebaVapor());
				model.addAttribute("temperaturaPruebaVapor", u.getTemperaturaPruebaVapor());
				model.addAttribute("tiempoPruebaVapor", u.getTiempoPrueba());
				model.addAttribute("presionPruebaVapor", u.getPresionPrueba());
				model.addAttribute("medidaHiloPruebaVapor", u.getMedidaInicialHilo());
				model.addAttribute("finalTramaPruebaVapor", u.getMedidaInicialTrama());
				model.addAttribute("diferenciaHiloPruebaVapor", u.getMedidaFinalHilo());
				model.addAttribute("finalHiloMedPruebaVapor", u.getDiferenciaMedidaHilo());
				model.addAttribute("diferenciaTramaPruebaVapor", u.getMedidaFinalTrama());
				model.addAttribute("finalTramaMedPruebaVapor", u.getDiferenciaMedidaTrama());
				model.addAttribute("observacionesReultPruebaVapor", u.getObservacionesResultados());
				model.addAttribute("displa", "true");
				}
				if (u.getTipoPrueba().equalsIgnoreCase("Prueba de Fusion")) {
				model.addAttribute("medidaHiloPruebaFusion", u.getMedidaInicialHilo());
				model.addAttribute("medidaTramaPruebaFusion", u.getMedidaInicialTrama());
				model.addAttribute("diferenciaHiloPruebaFusion", u.getMedidaFinalHilo());
				model.addAttribute("finalHiloMedPruebaFusion", u.getDiferenciaMedidaHilo());
				model.addAttribute("diferenciaTramaPruebaFusion", u.getMedidaFinalTrama());
				model.addAttribute("finalTramaMedPruebaFusion", u.getDiferenciaMedidaTrama());
				model.addAttribute("observacionesReultPruebaFusion", u.getObservacionesResultados());
				}
				if (u.getTipoPrueba().equalsIgnoreCase("Plancha con Vapor")) {
				model.addAttribute("medidaHiloPlanchaVapor", u.getMedidaInicialHilo());
				model.addAttribute("medidaTramaPlanchaVapor", u.getMedidaInicialTrama());
				model.addAttribute("diferenciaHiloPlanchaVapor", u.getMedidaFinalHilo());
				model.addAttribute("finalHiloMedPlanchaVapor", u.getDiferenciaMedidaHilo());
				model.addAttribute("diferenciaTramaPlanchaVapor", u.getMedidaFinalTrama());
				model.addAttribute("finalTramaMedPlanchaVapor", u.getDiferenciaMedidaTrama());
				model.addAttribute("observacionesReultPlanchaVapor", u.getObservacionesResultados());
				}
				
				if (u.getTipoPrueba().equalsIgnoreCase("Prueba de Lavado")) {
				model.addAttribute("readLavado", "true");
				model.addAttribute("telas", u.getIdTela());
				model.addAttribute("operarioLavado", u.getCreadoPor());
				model.addAttribute("fechaRealizacionLavado", u.getFechaRealizacion().replace(" ", "T"));
				model.addAttribute("fechaFinalizacionLavado", u.getFechaFinalizacion().replace(" ", "T"));
				model.addAttribute("medidaHiloPruebaLavado", u.getMedidaInicialHilo());
				model.addAttribute("medidaTramaPruebaLavado", u.getMedidaInicialTrama());
				model.addAttribute("diferenciaHiloPruebaLavado", u.getMedidaFinalHilo());
				model.addAttribute("finalHiloMedPruebaLavado", u.getDiferenciaMedidaHilo());
				model.addAttribute("diferenciaTramaPruebaLavado", u.getMedidaFinalTrama());
				model.addAttribute("finalTramaMedPruebaLavado", u.getDiferenciaMedidaTrama());
				model.addAttribute("observacionesReultPruebaLavado", u.getObservacionesResultados());
				model.addAttribute("displaLavado", "true");
				}
				System.out.println("asdasdasdasdasdasd"+pruebasLCC);
			}
			System.out.println("asdasdasdasdasdasd"+pruebasLCC);
		
			for (DisenioPruebaLavadoContaminacionCostura cc : pruebasLCC) {
				System.out.println("si esta entrando al ciclo");
				if(cc.getTipoPrueba().equalsIgnoreCase("Solidez/Color")) {
					model.addAttribute("observacionesReultSolidez", cc.getObservacionesResultados());
					
				}
				if(cc.getTipoPrueba().equalsIgnoreCase("Resultado pilling")) {
			
					model.addAttribute("observacionesReultPilling", cc.getObservacionesResultados());
				}
				if(cc.getTipoPrueba().equalsIgnoreCase("Resultado costura")) {
					model.addAttribute("readCostura", "true");
					model.addAttribute("observacionesDeslizamiento", cc.getObservacionesResultados());
					model.addAttribute("displaCostura", "true");
				}
				if(cc.getTipoPrueba().equalsIgnoreCase("Resultado de contaminación") || cc.getTipoPrueba().equalsIgnoreCase("Resultado de contaminacion")) {
					model.addAttribute("readContamin", "true");
					model.addAttribute("observacionesReultContaminacion", cc.getObservacionesResultados());				
					model.addAttribute("displaConta", "true");
				}

			}
			model.addAttribute("idCalidad", id);		
			return "/calidad-nueva-prueba";
		}
		else {
			return "calidad-nueva-prueba";
		}
	}
	
	@RequestMapping(value = "/detalle-calidad/{id}", method = RequestMethod.GET)
	public String infoPruebasCalidad(@PathVariable(name = "id") Long id) {
		
		return "detalle-calidad";
	}
}
