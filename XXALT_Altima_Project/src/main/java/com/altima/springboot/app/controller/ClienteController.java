package com.altima.springboot.app.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.Map;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.altima.springboot.app.models.entity.ComercialCliente;
import com.altima.springboot.app.models.entity.DisenioTela;
import com.altima.springboot.app.models.entity.HrDireccion;
import com.altima.springboot.app.models.service.IComercialClienteService;
import com.altima.springboot.app.models.service.IHrDireccionService;
import com.altima.springboot.app.models.service.IUploadService;

@Controller
public class ClienteController {
	@Autowired
	private IComercialClienteService ClienteService;
	@Autowired
	private IHrDireccionService DireccionService;
	@Autowired
	private IUploadService UploadService;
	
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	@GetMapping("/clientes")
	public String listClients(Model model) {
		model.addAttribute("clientes", ClienteService.findAll());
		return "clientes";
	}
	
	@GetMapping("/agregar-cliente")
	public String crearCliente(Map<String, Object> model) {
		ComercialCliente cliente = new ComercialCliente();
		HrDireccion direccion = new HrDireccion();
		model.put("cliente", cliente);
		model.put("direccion", direccion);
		model.put("subtitulo", "Nuevo Cliente");
		return "agregar-cliente";
	}
	
	@PostMapping("/guardar-cliente")
	public String guardarCliente(ComercialCliente cliente, HrDireccion direccion, RedirectAttributes redirectAttrs,
			@RequestParam(value="imagenCliente", required=false) MultipartFile imagenCliente) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (cliente.getIdCliente() == null && direccion.getIdDireccion() == null) {
			direccion.setEstatus(1);
			DireccionService.save(direccion);
			direccion.setIdText("DIR" + direccion.getIdDireccion());
			direccion.setCreadoPor(auth.getName());
			DireccionService.save(direccion);
			// Guardamos los datos de cliente.
			
			cliente.setEstatusCliente(0);
			cliente.setEstatus(1);
			ClienteService.save(cliente);
			cliente.setCidText("CLTE" + cliente.getIdCliente());
			cliente.setCcreadoPor(auth.getName());
			cliente.setIdDireccion(direccion.getIdDireccion());
			
			if (!imagenCliente.isEmpty()){
				if ( cliente.getImagen() != null && cliente.getImagen().length() > 0) {
					UploadService.deleteForro(cliente.getImagen());
				}
				String uniqueFilename = null;
				try {
					uniqueFilename = UploadService.copyCliente(imagenCliente);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cliente.setImagen(uniqueFilename);
			}
			
			
			ClienteService.save(cliente);
			redirectAttrs.addFlashAttribute("title", "Cliente guardado correctamente").addFlashAttribute("icon", "success");
		} else {
			direccion.setActualizadoPor(auth.getName());
			direccion.setUltimaFechaModificacion(new Date());
			cliente.setCactualizadoPor(auth.getName());
			cliente.setCultimaFechaModificacion(new Date());
			
			if (!imagenCliente.isEmpty()){
				if ( cliente.getImagen() != null && cliente.getImagen().length() > 0) {
					UploadService.deleteForro(cliente.getImagen());
				}
				String uniqueFilename = null;
				try {
					uniqueFilename = UploadService.copyCliente(imagenCliente);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cliente.setImagen(uniqueFilename);
			}
			redirectAttrs.addFlashAttribute("title", "Cliente editado correctamente").addFlashAttribute("icon", "success");
			
			DireccionService.save(direccion);
			ClienteService.save(cliente);
		}
		
		return "redirect:clientes";
	}
	
	@GetMapping("/editar-cliente/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		ComercialCliente cliente = null;
		HrDireccion direccion;
		cliente = ClienteService.findOne(id);
		direccion = DireccionService.findOne(cliente.getIdDireccion());
		model.put("cliente", cliente);
		model.put("direccion", direccion);
		model.put("estatus", Integer.parseInt(cliente.getTipoCliente()));
		model.put("subtitulo", "Editar Cliente");
		return "agregar-cliente";
	}
	
	@GetMapping("delete-cliente/{id}") 
	public String deleteMaterial(@PathVariable("id") Long id, RedirectAttributes redirectAttrs) throws Exception {
		ComercialCliente cliente = ClienteService.findOne(id);
		cliente.setEstatus(0);
		ClienteService.save(cliente);
		redirectAttrs
        .addFlashAttribute("title", "Cliente elimnado correctamente")
        .addFlashAttribute("icon", "success");
		  return "redirect:/clientes";
	}
	
	@GetMapping(value = "/uploads/clientes/{filename:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String filename) {

		Resource recurso = null;
		try {
			recurso = UploadService.loadCliente(filename);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"")
				.body(recurso);
	}
	
	@GetMapping(value="/facturacion-clientes")
	public String facturacionClientes()
	{
		return"facturacion-clientes";
	}
	
}
