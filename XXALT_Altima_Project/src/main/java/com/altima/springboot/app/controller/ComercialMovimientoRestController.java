package com.altima.springboot.app.controller;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.altima.springboot.app.models.entity.ComercialCliente;
import com.altima.springboot.app.models.entity.ComercialMovimiento;
import com.altima.springboot.app.models.entity.ComercialMovimientoMuestraDetalle;
import com.altima.springboot.app.models.service.IComercialClienteService;
import com.altima.springboot.app.models.service.IComercialMovimientoMuestraDetalleService;
import com.altima.springboot.app.models.service.IComercialMovimientoService;

@RestController
public class ComercialMovimientoRestController {

	@Autowired
	private IComercialClienteService clienteService;
	
	@Autowired
	private IComercialMovimientoService movimientoService;
	
	@Autowired
	private IComercialMovimientoMuestraDetalleService moviDetalleService;
	
	@RequestMapping(value="/listarEmpresasMovimiento", method=RequestMethod.GET)
	public List<ComercialCliente> listarEmpresasMovimiento(){
		return clienteService.findAll();
	}
	
	@RequestMapping(value="/listarMuestras", method = RequestMethod.GET)
	public List<Object> listarMuestras (){
		
		return movimientoService.listarMuestras();
	}
	
	@RequestMapping(value="/agregarMuestraTablita", method= RequestMethod.GET)
	public Object agregarMuestraTablita(@RequestParam(name="idMuestra") Long id) {
		
		return movimientoService.EncontrarMuestra(id);
	}
	
	@RequestMapping(value="/guardarNuevoMovimiento", method = RequestMethod.POST)
	public void guardarNuevoMovimiento (@RequestParam(name="vendedor")String vendedor,
										@RequestParam(name="empresa") String empresa,
										@RequestParam(name="prenda") String prensa,
										@RequestParam(name="object_muestras") String objectmuestras) {
		
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		LocalDate localDate = LocalDate.now();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String formattedDate = localDate + " " + dateFormat.format(date);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ComercialMovimiento comercialEntity = new ComercialMovimiento();
		
		
		comercialEntity.setVendedor(vendedor);
		comercialEntity.setEmpresa(empresa);
		comercialEntity.setCreadoPor(auth.getName());
		comercialEntity.setActualizadoPor(auth.getName());
		comercialEntity.setFechaCreacion(formattedDate);
		comercialEntity.setUltimaFechaModificacion(formattedDate);
		comercialEntity.setEstatus("Pendiente de recoger");
		comercialEntity.setIdText(" ");
		movimientoService.save(comercialEntity);
		comercialEntity.setIdText("MOV"+(comercialEntity.getIdMovimiento() +10000));
		movimientoService.save(comercialEntity);
		
		JSONArray muestras = new JSONArray(objectmuestras);
		for (int i = 0; i < muestras.length(); i++) {
			ComercialMovimientoMuestraDetalle muestraDetalleEntity = new ComercialMovimientoMuestraDetalle();
			System.out.println(muestras);
			JSONObject muestra = muestras.getJSONObject(i);
			System.out.println(muestra.get("idmuestra").toString());
			muestraDetalleEntity.setIdDetallePedido(Long.parseLong(muestra.get("idmuestra").toString()));
			muestraDetalleEntity.setCodigoBarras(muestra.getString("codigoBarras").toString());
			muestraDetalleEntity.setIdMovimiento(comercialEntity.getIdMovimiento());
			muestraDetalleEntity.setNombreMuestra(muestra.getString("nombreMuestra").toString());
			muestraDetalleEntity.setFechaCreacion(formattedDate);
			muestraDetalleEntity.setUltimaFechaModificacion(formattedDate);
			muestraDetalleEntity.setCreadoPor(auth.getName());
			muestraDetalleEntity.setActualizadoPor(auth.getName());
			muestraDetalleEntity.setEstatus("Pendiente de recoger");
			
			moviDetalleService.save(muestraDetalleEntity);
		
		
		}
	}
	
	
	@RequestMapping(value="/entregadoVendedor", method = RequestMethod.POST)
	public void entregadoVendedor(@RequestParam("idMovi") Long idMovimiento) {
		ComercialMovimiento movimientoEntity = movimientoService.findOne(idMovimiento);

		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		LocalDate localDate = LocalDate.now();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String formattedDate = localDate + " " + dateFormat.format(date);
		
		movimientoEntity.setEstatus("Entregado a vendedor");
		movimientoEntity.setFecha_salida(formattedDate);
		movimientoService.save(movimientoEntity);
	}
	
	@RequestMapping(value="/cancelarMovimiento", method = RequestMethod.POST)
	public void cancelado(@RequestParam("idMovi") Long idMovimiento) {
		ComercialMovimiento movimientoEntity = movimientoService.findOne(idMovimiento);

		
		
		movimientoEntity.setEstatus("Cancelado");
		movimientoService.save(movimientoEntity);
	}
	
	@RequestMapping(value="/devolverMovimiento", method = RequestMethod.POST)
	public void devolverMovimiento(@RequestParam("idMovi") Long idMovimiento) {
		ComercialMovimiento movimientoEntity = movimientoService.findOne(idMovimiento);

		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		LocalDate localDate = LocalDate.now();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String formattedDate = localDate + " " + dateFormat.format(date);
		
		movimientoEntity.setEstatus("Devuelto");
		movimientoEntity.setFecha_entrega(formattedDate);
		movimientoService.save(movimientoEntity);
	}
	
	
}
