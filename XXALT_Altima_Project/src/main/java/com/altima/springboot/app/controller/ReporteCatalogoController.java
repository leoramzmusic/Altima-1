package com.altima.springboot.app.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.altima.springboot.app.models.entity.DisenioLookup;
import com.altima.springboot.app.models.service.ICatalogoService;
import com.altima.springboot.app.models.service.IUploadService;
import com.altima.springboot.app.models.service.ReporteCatalogoService;
//import com.google.gson.Gson;

@CrossOrigin(origins = { "*" })
@Controller
public class ReporteCatalogoController {
	
	protected final Log logger = LogFactory.getLog(this.getClass());
	String pattern = "yyyy-MM-dd";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	String date = simpleDateFormat.format(new Date());

	@Autowired
	ReporteCatalogoService catalogo;
	
	
	
	@RequestMapping(value = { "/reporte-catalogo" }, method = RequestMethod.GET)
	public String reporte(Model model, RedirectAttributes flash) {

		List<String[]> listLookups = catalogo.findAllLookup();

		model.addAttribute("listLookups", listLookups);

		System.out.println("Si entro al metodo reporte GET" + listLookups);

		return "/reporte-catalogo";
	}

	
	
	@RequestMapping(value = { "/reporte-catalogo" }, method = RequestMethod.POST)

	public String reporteSave(Model model, @RequestParam(name = "cata", required = false) String cata,
			@RequestParam(name = "palabra", required = false) String palabra,
			@RequestParam(name = "fecha1", required = false) String fecha1,
			@RequestParam(name = "fecha2", required = false) String fecha2) {
		
		int link=0;

		if (cata.length() != 0 && palabra.length() != 0 && fecha1.length() != 0 && fecha2.length() != 0) {

			System.out.println("Si entro al metodo reporte POSTTTTTT" + cata);
			System.out.println("Si entro al metodo reporte POSTTTTTT" + palabra);
			System.out.println("Si entro al metodo reporte POSTTTTTT" + fecha1);
			System.out.println("Si entro al metodo reporte POSTTTTTT" + fecha2);
			model.addAttribute("catalogoFiltro", catalogo.findFiltroReporte(cata, palabra, fecha1, fecha2));
			System.out.println("aqui vemos que pedo con el object" + catalogo.findFiltroReporte(cata, palabra, fecha1, fecha2));
			List<String[]> listLookups = catalogo.findAllLookup();
			model.addAttribute("listLookups", listLookups);
			model.addAttribute("cata", cata);
			model.addAttribute("palabra", palabra);
			model.addAttribute("fecha1", fecha1);
			model.addAttribute("fecha2", fecha2);			
			link=1;
			model.addAttribute("link", link);
			System.out.println("verificacion del link" + link);

		} else {

			if (cata.length() != 0 && palabra.length() == 0 && fecha1.length() != 0 && fecha2.length() != 0) {

				System.out.println("Si entro al metodo reporte POSTTTTTT" + cata);
				System.out.println("Si entro al metodo reporte POSTTTTTT" + palabra);
				System.out.println("Si entro al metodo reporte POSTTTTTT" + fecha1);
				System.out.println("Si entro al metodo reporte POSTTTTTT" + fecha2);
				model.addAttribute("catalogoFiltro", catalogo.findFiltroReporteSinpalabra(cata, fecha1, fecha2));
				System.out.println("aqui vemos que pedo con el object"+ catalogo.findFiltroReporte(cata, palabra, fecha1, fecha2));
				List<String[]> listLookups = catalogo.findAllLookup();
				model.addAttribute("listLookups", listLookups);
				model.addAttribute("cata", cata);
				model.addAttribute("palabra", palabra);
				model.addAttribute("fecha1", fecha1);
				model.addAttribute("fecha2", fecha2);
				link=2;
				model.addAttribute("link", link);
				System.out.println("verificacion del link" + link);

			} else {

				if (cata.length() != 0 && palabra.length() != 0 && fecha1.length() == 0 && fecha2.length() == 0) {

					System.out.println("Si entro al metodo reporte POSTTTTTT" + cata);
					System.out.println("Si entro al metodo reporte POSTTTTTT" + palabra);
					System.out.println("Si entro al metodo reporte POSTTTTTT" + fecha1);
					System.out.println("Si entro al metodo reporte POSTTTTTT" + fecha2);
					model.addAttribute("catalogoFiltro", catalogo.findFiltroReporteSinFechas(cata, palabra));
					System.out.println("aqui vemos que pedo con el object"
							+ catalogo.findFiltroReporte(cata, palabra, fecha1, fecha2));
					List<String[]> listLookups = catalogo.findAllLookup();
					model.addAttribute("listLookups", listLookups);
					model.addAttribute("cata", cata);
					model.addAttribute("palabra", palabra);
					model.addAttribute("fecha1", fecha1);
					model.addAttribute("fecha2", fecha2);
					link=3;
					model.addAttribute("link", link);
					System.out.println("verificacion del link" + link);


				} else {

					System.out.println("Si entro al metodo reporte POSTTTTTT" + cata);
					System.out.println("Si entro al metodo reporte POSTTTTTT" + palabra);
					System.out.println("Si entro al metodo reporte POSTTTTTT" + fecha1);
					System.out.println("Si entro al metodo reporte POSTTTTTT" + fecha2);
					model.addAttribute("catalogoFiltro", catalogo.findFiltroReporteSinFePa(cata));
					System.out.println("aqui vemos que pedo con el object"
							+ catalogo.findFiltroReporte(cata, palabra, fecha1, fecha2));
					List<String[]> listLookups = catalogo.findAllLookup();
					model.addAttribute("listLookups", listLookups);
					model.addAttribute("cata", cata);
					model.addAttribute("palabra", palabra);
					model.addAttribute("fecha1", fecha1);
					model.addAttribute("fecha2", fecha2);
					link=4;
					model.addAttribute("link", link);
					System.out.println("verificacion del link" + link);

				}

			}

		}



		return "/reporte-catalogo";
	}

	@RequestMapping(value = { "/imprimirleo/{cata}/{palabra}/{fecha1}/{fecha2}/{link}" }, method = RequestMethod.GET)
	public String imp(@PathVariable(value = "cata") String cata, @PathVariable(value = "palabra") String palabra,
			@PathVariable(value = "fecha1") String fecha1, @PathVariable(value = "fecha2") String fecha2, @PathVariable(value = "link") int link, Model model) {
		
		
		if (link== 1) {


             System.out.println("si entro pelo alv con todo ");
	         System.out.println("Si entro al metodo reporte imp" + cata);
	         System.out.println("Si entro al metodo reporte " + palabra);
	         System.out.println("Si entro al metodo reporte " + fecha1);
	         System.out.println("Si entro al metodo reporte " + fecha2);
             List<DisenioLookup> lookup1 = catalogo.findFiltroReporte(cata, palabra, fecha1, fecha2);
             model.addAttribute("lookup", lookup1);

		} else {

			if (link== 2) {
				
				
				System.out.println("si entro pelo alv sin palabra");
		         System.out.println("Si entro al metodo reporte imp" + cata);
		         System.out.println("Si entro al metodo reporte " + palabra);
		         System.out.println("Si entro al metodo reporte " + fecha1);
		         System.out.println("Si entro al metodo reporte " + fecha2);
	             List<DisenioLookup> lookup1 = catalogo.findFiltroReporteSinpalabra(cata, fecha1, fecha2);
	             model.addAttribute("lookup", lookup1);

	

			} else {

				if (link== 3) {
					
					
					System.out.println("si entro pelo sin fechas");
			         System.out.println("Si entro al metodo reporte imp" + cata);
			         System.out.println("Si entro al metodo reporte " + palabra);
			         System.out.println("Si entro al metodo reporte " + fecha1);
			         System.out.println("Si entro al metodo reporte " + fecha2);
		             List<DisenioLookup> lookup1 = catalogo.findFiltroReporteSinFechas(cata, palabra);
		             model.addAttribute("lookup", lookup1);

		

				} else {
					
					
					System.out.println("si entro pelo alv sin nada");
			         System.out.println("Si entro al metodo reporte " + cata);
			         System.out.println("Si entro al metodo reporte " + palabra);
			         System.out.println("Si entro al metodo reporte " + fecha1);
			         System.out.println("Si entro al metodo reporte " + fecha2);
		             List<DisenioLookup> lookup1 = catalogo.findFiltroReporteSinFePa(cata);
		             
		             
		             model.addAttribute("lookup", lookup1);

				
				}

			}

		}


		

		return "/imprimir";
	}
	
	
	
	
	
	

}
