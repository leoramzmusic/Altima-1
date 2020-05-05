package com.altima.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.altima.springboot.app.models.entity.ComercialCalendario;
import com.altima.springboot.app.models.service.IComercialCalendarioService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class CalendarioRestController {
	@Autowired
	IComercialCalendarioService calendarioService;
	
	@RequestMapping(value="/allevents", method=RequestMethod.GET)
	public List<ComercialCalendario> allEvents() {
		return calendarioService.findAll();
	}
	
	@RequestMapping(value="/event", method=RequestMethod.POST)
	public String addEvent(String title,String description,String start,String end, String color) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		ComercialCalendario calendario = new ComercialCalendario();
		calendario.setTitle(title);
		calendario.setDescription(description);
		calendario.setStart(start);
		calendario.setEnd(end);
		calendario.setColor(color);
		calendario.setCreadoPor(auth.getName());
		calendario.setFechaCreacion(hourdateFormat.format(date));
		calendario.setUltimaFechaModificacion(hourdateFormat.format(date));
		calendario.setEstatus("1");
		calendarioService.save(calendario);
		return "/event";
		
	}
	
	@RequestMapping(value="/event", method=RequestMethod.PATCH)
	public String updateEvent(String idCalendario, String title,String description,String start,String end, String color) {
		System.out.println("hoollla");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
	
		if (idCalendario.isEmpty()) {
			ComercialCalendario calendario = new ComercialCalendario();
			calendario.setTitle(title);
			calendario.setDescription(description);
			calendario.setStart(start);
			calendario.setEnd(end);
			calendario.setColor(color);
			calendario.setCreadoPor(auth.getName());
			calendario.setFechaCreacion(hourdateFormat.format(date));
			calendario.setUltimaFechaModificacion(hourdateFormat.format(date));
			calendario.setEstatus("1");
			calendarioService.save(calendario);
		}
		else {
			System.out.println("quieres editar verdad perrrroooooooooooo");
			
			ComercialCalendario calendario = calendarioService.findOne(Long.valueOf(idCalendario));
			
			calendario.setTitle(title);
			calendario.setDescription(description);
			calendario.setStart(start);
			calendario.setEnd(end);
			calendario.setColor(color);
			//calendario.setCreadoPor(auth.getName());
			//calendario.setFechaCreacion(hourdateFormat.format(date));
			calendario.setUltimaFechaModificacion(hourdateFormat.format(date));
			calendario.setActualizadoPor(auth.getName());
			calendarioService.save(calendario);
			
		}
		
		return "/event";
	}
	
	@RequestMapping(value="/event", method=RequestMethod.DELETE)
	public void removeEvent(@RequestParam(name = "id") Long id) {
		System.out.println("quieres elimnar verdad perrrroooooooooooo"+ id);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		ComercialCalendario calendario = calendarioService.findOne(id);
		calendario.setUltimaFechaModificacion(hourdateFormat.format(date));
		calendario.setActualizadoPor(auth.getName());
		calendario.setEstatus("0");
		calendarioService.save(calendario);
		
		//calendarioService.delete(id);
	}
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	class BadDateFormatException extends RuntimeException {
	  private static final long serialVersionUID = 1L;
		public BadDateFormatException(String dateString) {
	        super(dateString);
	    }
	}
	
}
