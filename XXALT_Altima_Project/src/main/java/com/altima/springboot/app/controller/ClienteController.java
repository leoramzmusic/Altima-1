package com.altima.springboot.app.controller;
import java.util.Date;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.altima.springboot.app.models.entity.ComercialCliente;
import com.altima.springboot.app.models.entity.HrDireccion;
import com.altima.springboot.app.models.service.IComercialClienteService;
import com.altima.springboot.app.models.service.IHrDireccionService;

@Controller
public class ClienteController {
	@Autowired
	private IComercialClienteService ClienteService;
	@Autowired
	private IHrDireccionService DireccionService;
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	@GetMapping("/clientes") 
	public String listClients(Model model) {
		model.addAttribute("clientes", ClienteService.findAll());
		return "clientes";
	}

	@GetMapping("/agregar-cliente") 
	public String crearCliente(Map<String, Object> model) {
		ComercialCliente cliente = new ComercialCliente();
		HrDireccion  direccion = new HrDireccion ();
		model.put("cliente",cliente);
		model.put("direccion", direccion);
		model.put("subtitulo", "Nuevo Cliente");
		return "agregar-cliente";
	}
	
	@PostMapping("/guardar-cliente")
	public String guardarCliente(ComercialCliente cliente , HrDireccion direccion, RedirectAttributes redirectAttrs) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (cliente.getIdCliente() == null && direccion.getIdDireccion()== null) {
			DireccionService.save(direccion);
			direccion.setIdText("DIR"+direccion.getIdDireccion());
			direccion.setCreadoPor(auth.getName());
			DireccionService.save(direccion);
			//Guardamos los datos de cliente.
			
			ClienteService.save(cliente);
			cliente.setCidText("CLTE"+cliente.getIdCliente() );
			cliente.setCcreadoPor(auth.getName());
			cliente.setIdDireccion(direccion.getIdDireccion() );
			ClienteService.save(cliente);
			redirectAttrs
            .addFlashAttribute("title", "Cliente guardado correctamente")
            .addFlashAttribute("icon", "success");
		}
		else {
			direccion.setActualizadoPor(auth.getName());
			direccion.setUltimaFechaModificacion(new Date());
			cliente.setCactualizadoPor(auth.getName());
			cliente.setCultimaFechaModificacion(new Date());
			redirectAttrs
            .addFlashAttribute("title", "Cliente editado correctamente")
            .addFlashAttribute("icon", "success");
			
			DireccionService.save(direccion);
			ClienteService.save(cliente);   
		}
		
		return "redirect:clientes";
	}
	
	@GetMapping("/editar-cliente/{id}")
	public String editar(@PathVariable(value="id") Long id , Map<String,Object> model) {
		ComercialCliente cliente = null;
		HrDireccion direccion;
		cliente=ClienteService.findOne(id);
		direccion=DireccionService.findOne(cliente.getIdDireccion());
		model.put("cliente",cliente);
		model.put("direccion", direccion);
		model.put("estatus", Integer.parseInt(cliente.getTipoCliente()) );
		model.put("subtitulo", "Editar Cliente");
		return"agregar-cliente";   
	}
	

}
