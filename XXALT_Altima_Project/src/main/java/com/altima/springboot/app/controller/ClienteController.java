package com.altima.springboot.app.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import com.altima.springboot.app.models.entity.ComercialClienteFactura;
import com.altima.springboot.app.models.entity.ComercialClienteSucursal;
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
			if ( direccion.getNumeroExt()== null || direccion.getNumeroExt().isEmpty()) {
				direccion.setNumeroExt("S/N");
			}
			DireccionService.save(direccion);
			direccion.setIdText("DIR" + direccion.getIdDireccion());
			direccion.setCreadoPor(auth.getName());
			DireccionService.save(direccion);
			
			// Guardamos los datos de cliente.
			cliente.setEstatusCliente(0);
			cliente.setEstatusC(1);
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
			if ( direccion.getNumeroExt()== null || direccion.getNumeroExt().isEmpty()) {
				direccion.setNumeroExt("S/N");
			}
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
		cliente.setEstatusC(0);
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
	
	/*@GetMapping(value="/facturacion-clientes")
	public String facturacionClientes(){
		return"facturacion-clientes";
	}*/
	
	@GetMapping("/facturacion-clientes/{id}")
	public String listClients(@PathVariable(value = "id") Long id, Map<String, Object> model,
			RedirectAttributes redirectAttrs) {
		ComercialCliente cliente = null;
		cliente = ClienteService.findOne(id);
		model.put("cliente", cliente);
		model.put("facturas", ClienteService.ListaFactura(id));
		return "facturacion";
	}
	
	@GetMapping("/agregar-facturacion/{id}")
	public String crearCliente(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		ComercialCliente cliente = null;
		cliente = ClienteService.findOne(id);
		ComercialClienteFactura factura = new ComercialClienteFactura();
		HrDireccion direccion = new HrDireccion();
		model.put("factura", factura);
		model.put("cliente", cliente);
		model.put("direccion", direccion);
		model.put("subtitulo", "Nueva");
		return "facturacion-clientes";
	}
	
	
	@GetMapping("/guardar-facturacion")
	public String guardarCliente(ComercialClienteFactura factura, HrDireccion direccion,
			RedirectAttributes redirectAttrs) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		System.out.println("Hola soy  facturacion");
		
		if (factura.getIdClienteFacturaF() == null && direccion.getIdDireccion() == null) {
			if ( direccion.getNumeroExt()== null || direccion.getNumeroExt().isEmpty()) {
				direccion.setNumeroExt("S/N");
			}
			direccion.setEstatus(1);
			DireccionService.save(direccion);
			direccion.setIdText("DIR" + direccion.getIdDireccion());
			direccion.setCreadoPor(auth.getName());
			DireccionService.save(direccion);
			// Guardamos los datos de la facturacion   ClienteService.save(cliente);
			
			factura.setCreadoPorF(auth.getName());
			factura.setFechaCreacionF(hourdateFormat.format(date));
			factura.setUltimaFechaModificacionF(hourdateFormat.format(date));
			factura.setIdDireccionF(direccion.getIdDireccion());
			factura.setEstatusF("1");
			ClienteService.saveFactura(factura);
			factura.setIdTextF("FAC" + factura.getIdClienteFacturaF() );
			ClienteService.saveFactura(factura);
			redirectAttrs.addFlashAttribute("title", "Facturacion guardada correctamente").addFlashAttribute("icon", "success");
			
		} else {
			if ( direccion.getNumeroExt()== null || direccion.getNumeroExt().isEmpty()) {
				direccion.setNumeroExt("S/N");
			}
			direccion.setActualizadoPor(auth.getName());
			direccion.setUltimaFechaModificacion(new Date());
			factura.setEstatusF("1");
			factura.setActualizadoPorF(auth.getName());
			factura.setUltimaFechaModificacionF(hourdateFormat.format(date));
			factura.setEstatusF("1");
			factura.setIdDireccionF(direccion.getIdDireccion());
			redirectAttrs.addFlashAttribute("title", "Facturacion editada correctamente").addFlashAttribute("icon", "success");
			DireccionService.save(direccion);
			ClienteService.saveFactura(factura);
		}
		
		return "redirect:facturacion-clientes/" + factura.getIdClienteF();
	}
	
	
	
	@GetMapping("/editar-facturacion/{id}")
	public String editar_facturacion(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		ComercialClienteFactura factura = null;
		HrDireccion direccion;
		ComercialCliente cliente = null;
		factura = ClienteService.findOneFactura(id);
		direccion = DireccionService.findOne(factura.getIdDireccionF());
		cliente = ClienteService.findOne(factura.getIdClienteF());
		model.put("factura", factura);
		model.put("direccion", direccion);
		model.put("cliente", cliente);
		model.put("subtitulo", "Editar Factura");
		return "facturacion-clientes";
	}
	
	@GetMapping("delete-facturacion/{id}") 
	public String delete_facturacion(@PathVariable("id") Long id, RedirectAttributes redirectAttrs) throws Exception {
		
		ComercialClienteFactura factura = null;
		factura = ClienteService.findOneFactura(id);
		factura.setEstatusF("0");
		ClienteService.saveFactura(factura);
	
		redirectAttrs
        .addFlashAttribute("title", "Facturacion elimnada correctamente")
        .addFlashAttribute("icon", "success");
		return "redirect:/facturacion-clientes/"+factura.getIdClienteF();
	}
	
}
