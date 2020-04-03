package com.altima.springboot.app.controller;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.altima.springboot.app.models.entity.ControlHora;
import com.altima.springboot.app.models.entity.ControlProduccionMuestra;
import com.altima.springboot.app.models.entity.DisenioLookup;
import com.altima.springboot.app.models.service.IControlProduccionMuestraService;

@CrossOrigin(origins = { "*" })
@Controller
public class ControlController {
	@Autowired
	private  IControlProduccionMuestraService DCPM;
	
	protected final Log logger = LogFactory.getLog(this.getClass());
	@GetMapping("/control-de-produccion")
	//@RequestMapping(value = "/control-de-produccion", method = RequestMethod.GET)
	//@ResponseBody
	public String listControlProduccion(Model model) {		
		
		model.addAttribute("operador", DCPM.Operadores());
		
		model.addAttribute("pedidos", DCPM.ListarPedidos());
		return "control-de-produccion";
	}
	
	@RequestMapping(value = "/listar-trazos/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<Object []> listar_trazos(@PathVariable(value="id") Long id) {		
		
		return  DCPM.OperacionesTrazo(id);
	}
	
	@RequestMapping(value = "/listar-cortes/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<Object []> listar_cortes(@PathVariable(value="id") Long id) {		
		
		return  DCPM.OperacionesCorte(id);	
	}
	
	
	@RequestMapping(value = "/listar-confecciones/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<Object []> listar_confecciones(@PathVariable(value="id") Long id) {		
		
		return  DCPM.OperacionesCofeccion(id);	
	}
	//erik
	
	@RequestMapping(value = "/listar-horas/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<Object []> listar_horas(@PathVariable(value="id") Long id) {		
		
		return  DCPM.ContadorHoras(id);	
	}
	
	
	@RequestMapping(value = "/listar-planchados/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<Object []> listar_planchados(@PathVariable(value="id") Long id) {		
		
		return  DCPM.OperacionesPlanchado(id);
	}
	
	@RequestMapping(value = "/listar-terminados/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<Object []> listar_terminado(@PathVariable(value="id") Long id) {		
		
		return  DCPM.OperacionesTerminado(id);
	}
	
	@RequestMapping(value = "/operadores", method = RequestMethod.GET)
	@ResponseBody
	public List<Object []> operadores() {		
		return  DCPM.Operadores();
	}
	
	
	@PostMapping("/guardartrazo")
	public String guardacatalogo(String operador,String f1 ,String f2,Long id,String tipo ,HttpServletRequest request) throws ParseException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		ControlProduccionMuestra muestra = new ControlProduccionMuestra();
		System.out.println(tipo);
		if ( tipo.equals("trazo")) {
			System.out.println("Soy un trazo");
			muestra.setIdPedido(id);
			muestra.setFechaRecepcion(f1+":00");
			muestra.setFechaEntrega(f2+":00");
			muestra.setIdOperario(operador);
			muestra.setTipo("1");
			muestra.setCreadoPor(auth.getName());
			muestra.setActualizadoPor("Null");
			muestra.setFechaCreacion(hourdateFormat.format(date));
			muestra.setUltimaFechaModificacion(hourdateFormat.format(date));
			muestra.setEstatusTiempo("Nuevo");
			DCPM.save(muestra);
		}
		
		if ( tipo.equals("corte")) {
			muestra.setIdPedido(id);
			muestra.setFechaRecepcion(f1+":00");
			muestra.setFechaEntrega(f2+":00");
			muestra.setIdOperario(operador);
			muestra.setTipo("2");
			muestra.setCreadoPor(auth.getName());
			muestra.setActualizadoPor("Null");
			muestra.setFechaCreacion(hourdateFormat.format(date));
			muestra.setUltimaFechaModificacion(hourdateFormat.format(date));
			muestra.setEstatusTiempo("Nuevo");
			DCPM.save(muestra);
			System.out.println("Soy un corte");
		}
		
		if ( tipo.equals("confeccion")) {
			muestra.setIdPedido(id);
			muestra.setFechaRecepcion(f1+":00");
			muestra.setFechaEntrega(f2+":00");
			muestra.setIdOperario(operador);
			muestra.setTipo("3");
			muestra.setCreadoPor(auth.getName());
			muestra.setActualizadoPor("Null");
			muestra.setFechaCreacion(hourdateFormat.format(date));
			muestra.setUltimaFechaModificacion(hourdateFormat.format(date));
			muestra.setEstatusTiempo("Nuevo");
			DCPM.save(muestra);
			System.out.println("Soy un corte");
		}
		
		if ( tipo.equals("planchado")) {
			muestra.setIdPedido(id);
			muestra.setFechaRecepcion(f1+":00");
			muestra.setFechaEntrega(f2+":00");
			muestra.setIdOperario(operador);
			muestra.setTipo("4");
			muestra.setCreadoPor(auth.getName());
			muestra.setActualizadoPor("Null");
			muestra.setFechaCreacion(hourdateFormat.format(date));
			muestra.setUltimaFechaModificacion(hourdateFormat.format(date));
			muestra.setEstatusTiempo("Nuevo");
			DCPM.save(muestra);
			System.out.println("Soy un corte");
		}
		
		if ( tipo.equals("terminado")) {
			muestra.setIdPedido(id);
			muestra.setFechaRecepcion(f1+":00");
			muestra.setFechaEntrega(f2+":00");
			muestra.setIdOperario(operador);
			muestra.setTipo("5");
			muestra.setCreadoPor(auth.getName());
			muestra.setActualizadoPor("Null");
			muestra.setFechaCreacion(hourdateFormat.format(date));
			muestra.setUltimaFechaModificacion(hourdateFormat.format(date));
			muestra.setEstatusTiempo("Nuevo");
			DCPM.save(muestra);
			System.out.println("Soy un corte");
		}
		
		return "redirect:control-de-produccion";

	}
	
	@PostMapping("/play")
	public String playProceso(Long idproceso ,String tipo  ,HttpServletRequest request) {
		System.out.println("Hola soy de play el id es"+ idproceso); 
		System.out.println("Hola soy de play el tipo es"+ tipo);
		ControlProduccionMuestra muestra;
		muestra=DCPM.findOne(idproceso);
		muestra.setEstatusTiempo("Play");
		DCPM.save(muestra);
		if ( tipo.equals("trazo")) {
			System.out.println("Soy un trazo");
			ControlHora hora = new ControlHora();
			hora.setIdControlProduccionMuestra(muestra.getIdControlProduccionMuestra());
			Date date = new Date();
			DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			hora.setFechaInicio(hourdateFormat.format(date));
			hora.setEstatus("Play");
			hora.setTipo("1");
			DCPM.saveHora(hora);
		}
		
		if ( tipo.equals("corte")) {
			System.out.println("Soy un trazo");
			ControlHora hora = new ControlHora();
			hora.setIdControlProduccionMuestra(muestra.getIdControlProduccionMuestra());
			Date date = new Date();
			DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			hora.setFechaInicio(hourdateFormat.format(date));
			hora.setEstatus("Play");
			hora.setTipo("2");
			DCPM.saveHora(hora);
		}
		
		if ( tipo.equals("confeccion")) {
			System.out.println("Soy un trazo");
			ControlHora hora = new ControlHora();
			hora.setIdControlProduccionMuestra(muestra.getIdControlProduccionMuestra());
			Date date = new Date();
			DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			hora.setFechaInicio(hourdateFormat.format(date));
			hora.setEstatus("Play");
			hora.setTipo("3");
			DCPM.saveHora(hora);
		}
		
		if ( tipo.equals("planchado")) {
			System.out.println("Soy un trazo");
			ControlHora hora = new ControlHora();
			hora.setIdControlProduccionMuestra(muestra.getIdControlProduccionMuestra());
			Date date = new Date();
			DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			hora.setFechaInicio(hourdateFormat.format(date));
			hora.setEstatus("Play");
			hora.setTipo("4");
			DCPM.saveHora(hora);
		}
		
		if ( tipo.equals("terminado")) {
			System.out.println("Soy un trazo");
			ControlHora hora = new ControlHora();
			hora.setIdControlProduccionMuestra(muestra.getIdControlProduccionMuestra());
			Date date = new Date();
			DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			hora.setFechaInicio(hourdateFormat.format(date));
			hora.setEstatus("Play");
			hora.setTipo("5");
			DCPM.saveHora(hora);
		}
		
		return "redirect:control-de-produccion";

	}
	
	@PostMapping("/pausa")
	public String pausoProceso(Long idproceso,String tipo  , HttpServletRequest request) {
		
		
		
		ControlProduccionMuestra muestra;
		muestra=DCPM.findOne(idproceso);
		muestra.setEstatusTiempo("Pausa");
		DCPM.save(muestra);
		
		ControlHora hora ;
		Integer id= DCPM.Pausa(muestra.getIdControlProduccionMuestra());
		
		hora=DCPM.findOneHora(Long.valueOf(id));
		
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		hora.setFechaFin(hourdateFormat.format(date));
		hora.setEstatus("Pausa");
		
		DCPM.saveHora(hora);
	
		return "redirect:control-de-produccion";

	}
	
	@PostMapping("/stop")
	public String stopProceso(Long idproceso ,String tipo , HttpServletRequest request) {
		System.out.println("Hola soy stop");
		
		ControlProduccionMuestra muestra;
		muestra=DCPM.findOne(idproceso);
		muestra.setEstatusTiempo("Stop");
		DCPM.save(muestra);
		
		ControlHora hora ;
		Integer id= DCPM.Pausa(muestra.getIdControlProduccionMuestra());
		
		hora=DCPM.findOneHora(Long.valueOf(id));
		
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		hora.setFechaFin(hourdateFormat.format(date));
		hora.setEstatus("Stop");
		
		DCPM.saveHora(hora);
	
		return "redirect:control-de-produccion";

	}

	@GetMapping("/agregar-muestra")
	public String agregarMuestra() {
		return "agregar-muestra";
	}

	
	//Sssssss
	
	
	
	
}
