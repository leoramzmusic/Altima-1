package com.altima.springboot.app.controller;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
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
		
		
		/* lista de estatus en la tabla de muestras
		 * 
		 * 1 = "Pendiente de recoger"
		 * 2 = "Cancelado"
		 * 3 = "Devuelto"
		 * 4 = "Entregado a vendedor" con checkBox en la tabla
		 * 5 = "Entregado a vendedor" sin checkBox en la tabla
		 * 6 = "Traspaso" con checkBox en la tabla
		 * 7 = "Traspaso" sin checkBox en la tabla
		 * 8 = "Prestado a empresa" con checkBox en la tabla
		 * 9 = "Prestado a empresa" sin checkBox en la tabla
		 * 10= "Devuelto con recargos"
		 **********/
		
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
			muestraDetalleEntity.setModeloPrenda(muestra.getString("modeloPrenda").toString());
			muestraDetalleEntity.setCodigoTela(muestra.getString("codigoTela").toString());
			muestraDetalleEntity.setFechaCreacion(formattedDate);
			muestraDetalleEntity.setUltimaFechaModificacion(formattedDate);
			muestraDetalleEntity.setCreadoPor(auth.getName());
			muestraDetalleEntity.setActualizadoPor(auth.getName());
			muestraDetalleEntity.setEstatus(1);
			
			moviDetalleService.save(muestraDetalleEntity);
		
		
		}
	}
	
	@RequestMapping(value="/listDetalleMuestras", method = RequestMethod.POST)
	public List<ComercialMovimientoMuestraDetalle> listarDetalleMuestras(@RequestParam(name="idMovi") Long idMovimiento){
		
		return moviDetalleService.findAllbyMovimiento(idMovimiento);
	}
	
	
	
	
	
	@RequestMapping(value="/entregadoVendedor", method = RequestMethod.POST)
	public void entregadoVendedor(@RequestParam("idMovi") Long idMovimiento) {
		ComercialMovimiento movimientoEntity = movimientoService.findOne(idMovimiento);
		ComercialCliente cliente = clienteService.findOne(Long.parseLong(movimientoEntity.getEmpresa()));
		
		List<ComercialMovimientoMuestraDetalle> listamuestras = moviDetalleService.findAllbyMovimiento(idMovimiento); 
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		LocalDate localDate = LocalDate.now();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String formattedDate = localDate + " " + dateFormat.format(date);
		
		movimientoEntity.setEstatus("Entregado a vendedor");
		movimientoEntity.setFecha_salida(formattedDate);
		movimientoService.save(movimientoEntity);
		String var = "";
		
		/* lista de estatus en la tabla de muestras
		 * 
		 * 1 = "Pendiente de recoger"
		 * 2 = "Cancelado"
		 * 3 = "Devuelto"
		 * 4 = "Entregado a vendedor" con checkBox en la tabla
		 * 5 = "Entregado a vendedor" sin checkBox en la tabla
		 * 6 = "Traspaso" con checkBox en la tabla
		 * 7 = "Traspaso" sin checkBox en la tabla
		 * 8 = "Prestado a empresa" con checkBox en la tabla
		 * 9 = "Prestado a empresa" sin checkBox en la tabla
		 * 10= "Devuelto con recargos"
		 **********/
		
		for (ComercialMovimientoMuestraDetalle muestra: listamuestras) {
			
			ComercialMovimientoMuestraDetalle muestraDetalleEntity = new ComercialMovimientoMuestraDetalle();
			
			muestraDetalleEntity.setIdDetallePedido(muestra.getIdDetallePedido());
			muestraDetalleEntity.setCodigoBarras(muestra.getCodigoBarras());
			muestraDetalleEntity.setIdMovimiento(muestra.getIdMovimiento());
			muestraDetalleEntity.setNombreMuestra(muestra.getNombreMuestra());
			muestraDetalleEntity.setFecha_salida(formattedDate);
			muestraDetalleEntity.setFechaCreacion(formattedDate);
			muestraDetalleEntity.setUltimaFechaModificacion(formattedDate);
			muestraDetalleEntity.setCreadoPor(auth.getName());
			muestraDetalleEntity.setActualizadoPor(auth.getName());
			muestraDetalleEntity.setEstatus(4);
			if(cliente.getApellidoPaterno()==null || cliente.getApellidoMaterno()==null) {
				muestraDetalleEntity.setEntregadaPor(cliente.getNombre()+" "+ var +" "+ var);
			}
			else {
				muestraDetalleEntity.setEntregadaPor(cliente.getNombre()+" "+ cliente.getApellidoPaterno() +" "+ cliente.getApellidoMaterno());
			}
			muestraDetalleEntity.setRecibidaPor(movimientoEntity.getVendedor());
			moviDetalleService.save(muestraDetalleEntity);
		}
		
		
		
		
		
	}
	
	@RequestMapping(value="/cancelarMovimiento", method = RequestMethod.POST)
	public void cancelado(@RequestParam("idMovi") Long idMovimiento) {
		ComercialMovimiento movimientoEntity = movimientoService.findOne(idMovimiento);

		List<ComercialMovimientoMuestraDetalle> listamuestras = moviDetalleService.findAllbyMovimiento(idMovimiento); 
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		LocalDate localDate = LocalDate.now();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String formattedDate = localDate + " " + dateFormat.format(date);
		
		movimientoEntity.setEstatus("Cancelado");
		movimientoService.save(movimientoEntity);
		
		/* lista de estatus en la tabla de muestras
		 * 
		 * 1 = "Pendiente de recoger"
		 * 2 = "Cancelado"
		 * 3 = "Devuelto"
		 * 4 = "Entregado a vendedor" con checkBox en la tabla
		 * 5 = "Entregado a vendedor" sin checkBox en la tabla
		 * 6 = "Traspaso" con checkBox en la tabla
		 * 7 = "Traspaso" sin checkBox en la tabla
		 * 8 = "Prestado a empresa" con checkBox en la tabla
		 * 9 = "Prestado a empresa" sin checkBox en la tabla
		 * 10= "Devuelto con recargos"
		 **********/
		
		for (ComercialMovimientoMuestraDetalle muestra: listamuestras) {
			muestra.setEstatus(2);
			muestra.setActualizadoPor(auth.getName());
			muestra.setUltimaFechaModificacion(formattedDate);
			moviDetalleService.save(muestra);
		}
		
	}
	
	@RequestMapping(value="/devolverMovimiento", method = RequestMethod.POST)
	public void devolverMovimiento(@RequestParam("idMovi") Long idMovimiento) {
		ComercialMovimiento movimientoEntity = movimientoService.findOne(idMovimiento);

		List<ComercialMovimientoMuestraDetalle> listamuestras = moviDetalleService.findAllbyEstatus(idMovimiento); 
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		LocalDate localDate = LocalDate.now();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String formattedDate = localDate + " " + dateFormat.format(date);
		
		movimientoEntity.setEstatus("Devuelto");
		movimientoEntity.setFecha_entrega(formattedDate);
		movimientoService.save(movimientoEntity);
		
		/* lista de estatus en la tabla de muestras
		 * 
		 * 1 = "Pendiente de recoger"
		 * 2 = "Cancelado"
		 * 3 = "Devuelto"
		 * 4 = "Entregado a vendedor" con checkBox en la tabla
		 * 5 = "Entregado a vendedor" sin checkBox en la tabla
		 * 6 = "Traspaso" con checkBox en la tabla
		 * 7 = "Traspaso" sin checkBox en la tabla
		 * 8 = "Prestado a empresa" con checkBox en la tabla
		 * 9 = "Prestado a empresa" sin checkBox en la tabla
		 *10 = "Devuelto con recargos"
		 **********/
		for (ComercialMovimientoMuestraDetalle muestra: listamuestras) {
			ComercialMovimientoMuestraDetalle muestraDetalleEntity = new ComercialMovimientoMuestraDetalle();
			
			muestra.setEstatus(muestra.getEstatus()+1);
			
			moviDetalleService.save(muestra);
			
			muestraDetalleEntity.setIdDetallePedido(muestra.getIdDetallePedido());
			muestraDetalleEntity.setCodigoBarras(muestra.getCodigoBarras());
			muestraDetalleEntity.setIdMovimiento(muestra.getIdMovimiento());
			muestraDetalleEntity.setNombreMuestra(muestra.getNombreMuestra());
			muestraDetalleEntity.setActualizadoPor(auth.getName());
			muestraDetalleEntity.setFecha_salida(muestra.getFecha_salida());
			muestraDetalleEntity.setFecha_devolucion(formattedDate);
			muestraDetalleEntity.setEntregadaPor(muestra.getRecibidaPor());
			muestraDetalleEntity.setRecibidaPor(muestra.getEntregadaPor());
			muestraDetalleEntity.setFechaCreacion(formattedDate);
			muestraDetalleEntity.setUltimaFechaModificacion(formattedDate);
			muestraDetalleEntity.setCreadoPor(auth.getName());
			muestraDetalleEntity.setEstatus(3);
			
			moviDetalleService.save(muestraDetalleEntity);
		}
	}
	
	
	@SuppressWarnings("unused")
	@RequestMapping(value="/devolverIndividual", method = RequestMethod.POST)
	public void devolverIndividual(@RequestParam("idMuestras")String muestrasDevolver) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		LocalDate localDate = LocalDate.now();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String formattedDate = localDate + " " + dateFormat.format(date);
		
		String[] listaids;
		listaids = muestrasDevolver.split(",");

		for (String i :listaids) {
			ComercialMovimientoMuestraDetalle muestra = moviDetalleService.findOne(Long.parseLong(i));
			
			muestra.setEstatus(muestra.getEstatus()+1);
			moviDetalleService.save(muestra);
			
			
			ComercialMovimientoMuestraDetalle muestraDetalleEntity = new ComercialMovimientoMuestraDetalle();
			
			muestraDetalleEntity.setIdDetallePedido(muestra.getIdDetallePedido());
			muestraDetalleEntity.setCodigoBarras(muestra.getCodigoBarras());
			muestraDetalleEntity.setIdMovimiento(muestra.getIdMovimiento());
			muestraDetalleEntity.setNombreMuestra(muestra.getNombreMuestra());
			muestraDetalleEntity.setActualizadoPor(auth.getName());
			muestraDetalleEntity.setFecha_salida(muestra.getFecha_salida());
			muestraDetalleEntity.setFecha_devolucion(formattedDate);
			muestraDetalleEntity.setEntregadaPor(muestra.getRecibidaPor());
			muestraDetalleEntity.setRecibidaPor(muestra.getEntregadaPor());
			muestraDetalleEntity.setFechaCreacion(formattedDate);
			muestraDetalleEntity.setUltimaFechaModificacion(formattedDate);
			muestraDetalleEntity.setCreadoPor(auth.getName());
			muestraDetalleEntity.setEstatus(3);
			moviDetalleService.save(muestraDetalleEntity);
			if(moviDetalleService.ifExistCheckBox(muestra.getIdMovimiento()).equals("1")) {
				ComercialMovimiento movimientoEntity = movimientoService.findOne(muestra.getIdMovimiento());
				movimientoEntity.setEstatus("Devolución parcial");
				movimientoService.save(movimientoEntity);
			}	
		}
		ComercialMovimientoMuestraDetalle muestra = moviDetalleService.findOne(Long.parseLong(listaids[0]));
		if(moviDetalleService.ifExistCheckBox(muestra.getIdMovimiento()).equals("0")) {
			ComercialMovimiento movimientoEntity = movimientoService.findOne(muestra.getIdMovimiento());
			movimientoEntity.setEstatus("Devuelto");
			movimientoService.save(movimientoEntity);
		}
		
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value="/prestamoEmpresa", method = RequestMethod.POST)
	public void prestadoEmpresa(@RequestParam("idMuestras")String muestrasDevolver) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		LocalDate localDate = LocalDate.now();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String formattedDate = localDate + " " + dateFormat.format(date);
		
		String[] listaids;
		listaids = muestrasDevolver.split(",");

		for (String i :listaids) {
			ComercialMovimientoMuestraDetalle muestra = moviDetalleService.findOne(Long.parseLong(i));
			
			muestra.setEstatus(muestra.getEstatus()+1);
			moviDetalleService.save(muestra);
			
			
			ComercialMovimientoMuestraDetalle muestraDetalleEntity = new ComercialMovimientoMuestraDetalle();
			
			muestraDetalleEntity.setIdDetallePedido(muestra.getIdDetallePedido());
			muestraDetalleEntity.setCodigoBarras(muestra.getCodigoBarras());
			muestraDetalleEntity.setIdMovimiento(muestra.getIdMovimiento());
			muestraDetalleEntity.setNombreMuestra(muestra.getNombreMuestra());
			muestraDetalleEntity.setActualizadoPor(auth.getName());
			muestraDetalleEntity.setFecha_salida(formattedDate);
			muestraDetalleEntity.setEntregadaPor(muestra.getRecibidaPor());
			muestraDetalleEntity.setRecibidaPor(muestra.getEntregadaPor());
			muestraDetalleEntity.setFechaCreacion(formattedDate);
			muestraDetalleEntity.setUltimaFechaModificacion(formattedDate);
			muestraDetalleEntity.setCreadoPor(auth.getName());
			muestraDetalleEntity.setEstatus(8);
			moviDetalleService.save(muestraDetalleEntity);
			if(moviDetalleService.ifExistCheckBox(muestra.getIdMovimiento()).equals("1")) {
				ComercialMovimiento movimientoEntity = movimientoService.findOne(muestra.getIdMovimiento());
				movimientoEntity.setEstatus("Prestamo empresa");
				movimientoService.save(movimientoEntity);
			}	
		}
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value="/traspasoSolicitud", method = RequestMethod.POST)
	public Long traspasoSolicitud(@RequestParam("idMuestras")String muestrasDevolver,
								  @RequestParam("nuevoVendedor")String vendedor) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		LocalDate localDate = LocalDate.now();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String formattedDate = localDate + " " + dateFormat.format(date);
		String[] listaids;
		listaids = muestrasDevolver.split(",");
		ComercialMovimientoMuestraDetalle muestra = moviDetalleService.findOne(Long.parseLong(listaids[0]));

		for (String i :listaids) {
			muestra = moviDetalleService.findOne(Long.parseLong(i));
			
			muestra.setEstatus(muestra.getEstatus()+1);
			moviDetalleService.save(muestra);

			ComercialMovimientoMuestraDetalle muestraDetalleEntity = new ComercialMovimientoMuestraDetalle();
			
			muestraDetalleEntity.setIdDetallePedido(muestra.getIdDetallePedido());
			muestraDetalleEntity.setCodigoBarras(muestra.getCodigoBarras());
			muestraDetalleEntity.setIdMovimiento(muestra.getIdMovimiento());
			muestraDetalleEntity.setNombreMuestra(muestra.getNombreMuestra());
			muestraDetalleEntity.setActualizadoPor(auth.getName());
			muestraDetalleEntity.setFecha_salida(formattedDate);
			muestraDetalleEntity.setEntregadaPor(muestra.getRecibidaPor());
			muestraDetalleEntity.setRecibidaPor(vendedor);
			muestraDetalleEntity.setFechaCreacion(formattedDate);
			muestraDetalleEntity.setUltimaFechaModificacion(formattedDate);
			muestraDetalleEntity.setCreadoPor(auth.getName());
			muestraDetalleEntity.setEstatus(6);
			moviDetalleService.save(muestraDetalleEntity);
			if(moviDetalleService.ifExistCheckBox(muestra.getIdMovimiento()).equals("1")) {
				ComercialMovimiento movimientoEntity = movimientoService.findOne(muestra.getIdMovimiento());
				movimientoEntity.setEstatus("Traspaso");
				movimientoService.save(movimientoEntity);
			}	
		}
		
		return muestra.getIdMovimiento();
	}
	
}
