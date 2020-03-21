package com.altima.springboot.app.controller;

import java.util.Date;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.altima.springboot.app.models.entity.ComercialCliente;
import com.altima.springboot.app.models.entity.ComercialClienteSucursal;
import com.altima.springboot.app.models.entity.HrDireccion;
import com.altima.springboot.app.models.service.IComercialClienteService;
import com.altima.springboot.app.models.service.IComercialClienteSucursalService;
import com.altima.springboot.app.models.service.IHrDireccionService;

@Controller
public class ClienteSucursalController {
	@Autowired
	private IComercialClienteService ClienteService;
	@Autowired
	private IHrDireccionService DireccionService;
	@Autowired
	private IComercialClienteSucursalService SucursalService;
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	@GetMapping("/sucursales/{id}") 
	public String listClients(@PathVariable(value="id") Long id , Map<String,Object> model, RedirectAttributes redirectAttrs) {
		ComercialCliente cliente = null;
		cliente=ClienteService.findOne(id);
		model.put("cliente",cliente);
		model.put("sucursales",SucursalService.ClienteSucursales(id) );
		return "sucursales";
	}
	
	
	@GetMapping("/agregar-sucursal/{id}") 
	public String crearCliente(@PathVariable(value="id") Long id, Map<String, Object> model) {
		ComercialCliente cliente = null;
		cliente=ClienteService.findOne(id);
		ComercialClienteSucursal sucursal = new ComercialClienteSucursal();
		HrDireccion  direccion = new HrDireccion ();
		model.put("sucursal",sucursal);
		model.put("cliente",cliente);
		model.put("direccion", direccion);
		model.put("subtitulo", "Nueva");
		return "agregar-sucursal";
	}
	
	@GetMapping("/guardar-sucursal")
	public String guardarCliente(ComercialClienteSucursal sucursal , HrDireccion direccion,RedirectAttributes redirectAttrs) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (sucursal.getIdClienteSucursal()== null && direccion.getIdDireccion()== null) {
			DireccionService.save(direccion);
			direccion.setIdText("DIR"+direccion.getIdDireccion());
			direccion.setCreadoPor(auth.getName());
			DireccionService.save(direccion);
			//Guardamos los datos de la sucursal.
			sucursal.setIdDireccion(direccion.getIdDireccion());
			SucursalService.save(sucursal);
			sucursal.setSIdText("SUC"+sucursal.getNoSucursal());
			sucursal.setSCreadoPor(auth.getName());
			sucursal.setIdDireccion(direccion.getIdDireccion());
			redirectAttrs
            .addFlashAttribute("title", "Sucursal guardada correctamente")
            .addFlashAttribute("icon", "success");
			SucursalService.save(sucursal);
		}
		else {	
			direccion.setActualizadoPor(auth.getName());
			direccion.setUltimaFechaModificacion(new Date());
			sucursal.setSActualizadoPor(auth.getName());
			sucursal.setSUltimaFechaModificacion(new Date ());
			redirectAttrs
            .addFlashAttribute("title", "Sucursal editada correctamente")
            .addFlashAttribute("icon", "success");
			DireccionService.save(direccion);
			SucursalService.save(sucursal);   
		}
		
		return "redirect:sucursales/"+sucursal.getIdCliente();
	}
	
	@GetMapping("/editar-sucursal/{id}")
	public String editar(@PathVariable(value="id") Long id , Map<String,Object> model) {
		
		ComercialCliente cliente = null;
		HrDireccion direccion = null;
		ComercialClienteSucursal sucursal = null;
		sucursal=SucursalService.findOne(id);
		direccion=DireccionService.findOne(sucursal.getIdDireccion());
		cliente=ClienteService.findOne(sucursal.getIdClienteSucursal());
		model.put("sucursal",sucursal);
		model.put("cliente",cliente);
		model.put("direccion", direccion);
		model.put("subtitulo", "Editar");
		
		return"agregar-sucursal";   
	}
}
