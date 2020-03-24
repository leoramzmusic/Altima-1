package com.altima.springboot.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.altima.springboot.app.models.entity.DisenioLookup;
import com.altima.springboot.app.models.entity.DisenioRuta;
import com.altima.springboot.app.models.entity.DisenioRutaProceso;
import com.altima.springboot.app.models.service.DisenioRutaProcesoServiceImpl;
import com.altima.springboot.app.models.service.DisenioRutaServiceImpl;
import com.altima.springboot.app.models.service.IDisenioLookupService;

@RestController
public class RutasRestController {

	@Autowired
	private DisenioRutaServiceImpl disenioruta;
	
	@Autowired
	IDisenioLookupService disenioLookup;
	
	@Autowired
	private DisenioRutaProcesoServiceImpl disenioRutaProceso;
	
	public Long id;
	
	@RequestMapping(value="/crear_ruta", method=RequestMethod.POST)
	public DisenioRuta crear(@RequestParam(name = "nombre") String nombreRuta, 
						@RequestParam(name = "descripcion") String descripcionRuta, 
						@RequestParam(name = "procesos") String procesos)  {
		DisenioRuta rutas = new DisenioRuta();
		DisenioRutaProceso procesoRuta = new DisenioRutaProceso();
			
		if(id==null) {
			
			System.out.println(id);
			rutas.setNombreRuta(nombreRuta);
			rutas.setDescripcionRuta(descripcionRuta);
			rutas.setActualizadoPor("c");
			rutas.setCreadoPor("d");
			rutas.setFechaCreacion("2020-03-18");
			rutas.setUltimaFechaModificacion("2020-03-18");
			rutas.setClaveRuta("RUT0021");
			rutas.setIdText("RUT0021");
			disenioruta.save(rutas);
			
	        String[] palabras = procesos.split(",");
			for (String a: palabras) {
				procesoRuta = new DisenioRutaProceso();
				procesoRuta.setIdRuta(rutas.getIdRuta().toString());
				procesoRuta.setIdProceso(a);
				
				disenioRutaProceso.save(procesoRuta);
			}
			DisenioRuta listarutas = disenioruta.findOne(rutas.getIdRuta());
			id=null;
			return listarutas;
		}else
		{
			DisenioRuta ruta = disenioruta.findOne(id);
			ruta.setNombreRuta(nombreRuta);
			ruta.setDescripcionRuta(descripcionRuta);
			System.out.println(ruta.getActualizadoPor());
			disenioruta.save(ruta);
			String[] palabras = procesos.split(",");
			List<Object[]> listaprocesos = disenioRutaProceso.findByRutaEntity(id);
				
			 for (Object[] i : listaprocesos) {
				 System.out.println(i[0]+"es el objecto");
				 disenioRutaProceso.delete(Long.parseLong(i[0].toString()));
				 
				}
				System.out.println(procesos);
			for (String a: palabras) {
				procesoRuta = new DisenioRutaProceso();
				procesoRuta.setIdRuta(id.toString());
				procesoRuta.setIdProceso(a);
				disenioRutaProceso.save(procesoRuta);
			}

			id=null;
			return ruta;
		}
	}
	
@RequestMapping(value="/listarRutas", method=RequestMethod.GET)
public List<DisenioRuta> listarRutas() {
	
	List<DisenioRuta> listarutas = disenioruta.findAll();
	return listarutas;
}

@RequestMapping(value="/listarProcesos", method=RequestMethod.POST)
public List<DisenioLookup> listarProcesos() {
	
	List<DisenioLookup> listaProcesos = disenioLookup.findByTipoLookup("Proceso");
	return listaProcesos;
}

@RequestMapping(value="/editarRuta", method=RequestMethod.POST)
public List<Object> editarRuta(@RequestParam(name = "idRuta") Long idruta, List<Object> ruta) {
	id = idruta;
	DisenioRuta rut = disenioruta.findOne(idruta);
	ruta.add(rut);
	ruta.addAll(disenioRutaProceso.findByRuta(idruta));
	
	return ruta;
}
}