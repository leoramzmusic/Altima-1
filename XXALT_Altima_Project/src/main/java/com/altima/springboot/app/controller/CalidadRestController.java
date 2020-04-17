package com.altima.springboot.app.controller;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.altima.springboot.app.models.entity.DisenioCalidad;
import com.altima.springboot.app.models.entity.DisenioLookup;
import com.altima.springboot.app.models.entity.DisenioPruebaEncogimientoLavado;
import com.altima.springboot.app.models.entity.DisenioPruebaLavadoContaminacionCostura;
import com.altima.springboot.app.models.entity.DisenioTela;
import com.altima.springboot.app.models.service.DisenioLookupServiceImpl;
import com.altima.springboot.app.models.service.IDisenioCalidadService;
import com.altima.springboot.app.models.service.IDisenioLookupService;
import com.altima.springboot.app.models.service.IDisenioMaterialService;
import com.altima.springboot.app.models.service.IDisenioPruebaEncogimientoLavadoService;
import com.altima.springboot.app.models.service.IDisenioPruebaLavadoContaminacionCosturaService;
import com.altima.springboot.app.models.service.IDisenioTelaService;
import com.altima.springboot.app.models.service.IHrEmpleadoService;

@RestController
public class CalidadRestController {
	
	@Autowired
	private IDisenioTelaService disenioTela;
	@Autowired
	private IDisenioPruebaEncogimientoLavadoService EncogimientoLavado;
	@Autowired
	private IDisenioCalidadService CalidadService;
	@Autowired
	private IDisenioLookupService disenioLookup;
	@Autowired
	private IDisenioPruebaLavadoContaminacionCosturaService LavadoContaCostura;
	@Autowired
	private IHrEmpleadoService empleadoService;
	@Autowired
	private IDisenioMaterialService materialService;
	@Autowired
	private IDisenioCalidadService disenioCalidad;
	
	@RequestMapping(value = "/listarCalidad", method = RequestMethod.GET)
	public List<Object> listarCalidad() {
		return disenioCalidad.findAllWithIdTextTela();
	}
	
	@RequestMapping(value = "/listarTelasCalidad", method = RequestMethod.GET)
	public List<DisenioTela> listarTelas() {
		List<DisenioTela> resultTelas = disenioTela.findAll();
		return resultTelas;
	}
	
	@RequestMapping(value = "/listarOperarios", method = RequestMethod.GET)
	public List<Object> listarOperarios() {
		return empleadoService.findAllByPuesto(1L);
	}
	
	@RequestMapping(value = "/listarEntretelas", method = RequestMethod.GET)
	public List<Object> listarEntretelas() {
		List<DisenioLookup> lookupEntretela = disenioLookup.findByTipoLookup("Material");
		Long variable=0L;
		for (DisenioLookup i: lookupEntretela) {
			if (i.getNombreLookup().equalsIgnoreCase("Entretela")) {
				variable = i.getIdLookup();
			}
		}
		if(variable==null) {
			return null;
		}
		else {
			System.out.println(variable);
		return materialService.findAllByTipoMaterial(variable);
		}
	}
	
	@RequestMapping(value = "/listarTipoAguja", method = RequestMethod.GET)
	public List<DisenioLookup> listarAgujas() {
		return disenioLookup.findByTipoLookup("Medida Aguja");
	}
	
	@RequestMapping(value = "/guardarPruebaEncogimiento", method = RequestMethod.POST)
	public String guardarPruebaEncogi(@RequestParam(name = "datos") String guardarEncogi) {
		String[] palabras = guardarEncogi.split(",");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		DisenioPruebaEncogimientoLavado PruebaEncoLavado = new DisenioPruebaEncogimientoLavado();
		DisenioCalidad disenioCalidad = new DisenioCalidad();
		double resultHilo = ((Double.parseDouble(palabras[11]) * 100 / Double.parseDouble(palabras[9])) - 100);
		double resultTrama = ((Double.parseDouble(palabras[12]) * 100 / Double.parseDouble(palabras[10])) - 100);
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		LocalDate localDate = LocalDate.now();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String formattedDate = localDate + " " + dateFormat.format(date);
		DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
		separadoresPersonalizados.setDecimalSeparator('.');
		DecimalFormat df = new DecimalFormat("0.##", separadoresPersonalizados);
		
		if (palabras[24].equals("") || palabras[24] == null) {
			disenioCalidad.setCreadoPor(auth.getName());
			disenioCalidad.setActualizadoPor(auth.getName());
			disenioCalidad.setFechaCreacion(formattedDate);
			disenioCalidad.setUltimaFechaModificacion(formattedDate);
			disenioCalidad.setEstatus("0");
			disenioCalidad.setIdTela(Long.valueOf(palabras[0]));
			CalidadService.save(disenioCalidad);
			disenioCalidad.setIdText("CAL" + (disenioCalidad.getIdCalidad() + 100000));
			CalidadService.save(disenioCalidad);
			PruebaEncoLavado.setIdCalidad(disenioCalidad.getIdCalidad());
			
		}
		
		else if (palabras[24] != null && EncogimientoLavado.ifExist(Long.valueOf(palabras[24])) == 0
				|| EncogimientoLavado.ifExistLavado(Long.valueOf(palabras[24]), "Prueba de Vapor") == 0) {
			PruebaEncoLavado.setIdCalidad(Long.valueOf(palabras[24]));
			
			if (EncogimientoLavado.ifExistLavado(Long.valueOf(palabras[24]), "Prueba de Lavado") == 1
					&& LavadoContaCostura.ifExistContaCostura(Long.valueOf(palabras[24]), "Resultado Costura") == 1
					&& LavadoContaCostura.ifExistContaCostura(Long.valueOf(palabras[24]), "Resultado de Contaminación") == 1) {
				
				disenioCalidad = CalidadService.findOne(Long.valueOf(palabras[24]));
				disenioCalidad.setEstatus("1");
				CalidadService.save(disenioCalidad);
			}
		}
		
		else {
			PruebaEncoLavado = EncogimientoLavado.findByTipoPrueba("Prueba de Vapor", Long.valueOf(palabras[24]));
		}
		
		PruebaEncoLavado.setCreadoPor(palabras[1]);
		PruebaEncoLavado.setFechaRealizacion(palabras[2].replace("T", " "));
		PruebaEncoLavado.setEntretelaPruebaVapor(palabras[3]);
		PruebaEncoLavado.setAdherenciaPruebaVapor(palabras[4]);
		PruebaEncoLavado.setProveedorPruebaVapor(palabras[5]);
		PruebaEncoLavado.setTemperaturaPruebaVapor(palabras[6]);
		PruebaEncoLavado.setTiempoPrueba(palabras[7]);
		PruebaEncoLavado.setPresionPrueba(palabras[8]);
		PruebaEncoLavado.setMedidaInicialHilo(palabras[9]);
		PruebaEncoLavado.setMedidaInicialTrama(palabras[10]);
		PruebaEncoLavado.setMedidaFinalHilo(palabras[11]);
		PruebaEncoLavado.setDiferenciaMedidaHilo(String.valueOf(df.format(resultHilo)));
		PruebaEncoLavado.setMedidaFinalTrama(palabras[12]);
		PruebaEncoLavado.setDiferenciaMedidaTrama(String.valueOf(df.format(resultTrama)));
		PruebaEncoLavado.setObservacionesResultados(palabras[13]);
		PruebaEncoLavado.setTipoPrueba("Prueba de Vapor");
		PruebaEncoLavado.setEstatus("1");
		
		EncogimientoLavado.save(PruebaEncoLavado);
		
		if (palabras[24].equals("") || palabras[24] == null) {
			PruebaEncoLavado = new DisenioPruebaEncogimientoLavado();
			PruebaEncoLavado.setIdCalidad(disenioCalidad.getIdCalidad());
		}
		
		else if (palabras[24] != null && EncogimientoLavado.ifExist(Long.valueOf(palabras[24])) == 0
				|| EncogimientoLavado.ifExistLavado(Long.valueOf(palabras[24]), "Prueba de Fusión") == 0) {
			PruebaEncoLavado = new DisenioPruebaEncogimientoLavado();
			PruebaEncoLavado.setIdCalidad(Long.valueOf(palabras[24]));
		}
		
		else {
			PruebaEncoLavado = EncogimientoLavado.findByTipoPrueba("Prueba de Fusión", Long.valueOf(palabras[24]));
		}
		
		resultHilo = ((Double.parseDouble(palabras[16]) * 100 / Double.parseDouble(palabras[14])) - 100);
		resultTrama = ((Double.parseDouble(palabras[17]) * 100 / Double.parseDouble(palabras[15])) - 100);
		PruebaEncoLavado.setCreadoPor(palabras[1]);
		PruebaEncoLavado.setFechaRealizacion(palabras[2].replace("T", " "));
		PruebaEncoLavado.setMedidaInicialHilo(palabras[14]);
		PruebaEncoLavado.setMedidaInicialTrama(palabras[15]);
		PruebaEncoLavado.setMedidaFinalHilo(palabras[16]);
		PruebaEncoLavado.setDiferenciaMedidaHilo(String.valueOf(df.format(resultHilo)));
		PruebaEncoLavado.setMedidaFinalTrama(palabras[17]);
		PruebaEncoLavado.setDiferenciaMedidaTrama(String.valueOf(df.format(resultTrama)));
		PruebaEncoLavado.setObservacionesResultados(palabras[18]);
		PruebaEncoLavado.setTipoPrueba("Prueba de Fusión");
		PruebaEncoLavado.setEstatus("1");
		
		EncogimientoLavado.save(PruebaEncoLavado);
		
		if (palabras[24].equals("") || palabras[24] == null) {
			PruebaEncoLavado = new DisenioPruebaEncogimientoLavado();
			PruebaEncoLavado.setIdCalidad(disenioCalidad.getIdCalidad());
		} else if (palabras[24] != null && EncogimientoLavado.ifExist(Long.valueOf(palabras[24])) == 0
				|| EncogimientoLavado.ifExistLavado(Long.valueOf(palabras[24]), "Plancha con Vapor") == 0) {
			PruebaEncoLavado = new DisenioPruebaEncogimientoLavado();
			PruebaEncoLavado.setIdCalidad(Long.valueOf(palabras[24]));
		}
		
		else {
			PruebaEncoLavado = EncogimientoLavado.findByTipoPrueba("Plancha con Vapor", Long.valueOf(palabras[24]));
		}
		resultHilo = ((Double.parseDouble(palabras[21]) * 100 / Double.parseDouble(palabras[19])) - 100);
		resultTrama = ((Double.parseDouble(palabras[22]) * 100 / Double.parseDouble(palabras[20])) - 100);
		
		PruebaEncoLavado.setCreadoPor(palabras[1]);
		PruebaEncoLavado.setFechaRealizacion(palabras[2].replace("T", " "));
		PruebaEncoLavado.setMedidaInicialHilo(palabras[19]);
		PruebaEncoLavado.setMedidaInicialTrama(palabras[20]);
		PruebaEncoLavado.setMedidaFinalHilo(palabras[21]);
		PruebaEncoLavado.setDiferenciaMedidaHilo(String.valueOf(df.format(resultHilo)));
		PruebaEncoLavado.setMedidaFinalTrama(palabras[22]);
		PruebaEncoLavado.setDiferenciaMedidaTrama(String.valueOf(df.format(resultTrama)));
		PruebaEncoLavado.setObservacionesResultados(palabras[23]);
		PruebaEncoLavado.setTipoPrueba("Plancha con Vapor");
		PruebaEncoLavado.setEstatus("1");
		
		EncogimientoLavado.save(PruebaEncoLavado);
		
		return "calidad";
	}
	
	@RequestMapping(value = "/guardarPruebaLavado", method = RequestMethod.POST)
	public String guardarPruebaLavado(@RequestParam(name = "datos") String guardarEncogi) {
		String[] palabras = guardarEncogi.split(",");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		DisenioPruebaEncogimientoLavado PruebaEncoLavado = new DisenioPruebaEncogimientoLavado();
		DisenioCalidad disenioCalidad = new DisenioCalidad();
		DisenioPruebaLavadoContaminacionCostura PruebaLavadoContaCostura = new DisenioPruebaLavadoContaminacionCostura();
		
		DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
		separadoresPersonalizados.setDecimalSeparator('.');
		DecimalFormat df = new DecimalFormat("0.##", separadoresPersonalizados);
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		LocalDate localDate = LocalDate.now();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String formattedDate = localDate + " " + dateFormat.format(date);
		if (palabras[12].equals("") || palabras[12] == null) {
			disenioCalidad.setCreadoPor(auth.getName());
			disenioCalidad.setActualizadoPor(auth.getName());
			disenioCalidad.setFechaCreacion(formattedDate);
			disenioCalidad.setUltimaFechaModificacion(formattedDate);
			disenioCalidad.setEstatus("0");
			disenioCalidad.setIdTela(Long.valueOf(palabras[0]));
			CalidadService.save(disenioCalidad);
			disenioCalidad.setIdText("CAL" + (disenioCalidad.getIdCalidad() + 100000));
			CalidadService.save(disenioCalidad);
			PruebaEncoLavado.setIdCalidad(disenioCalidad.getIdCalidad());
			
		}
		
		else if (palabras[12] != null && EncogimientoLavado.ifExist(Long.valueOf(palabras[12])) == 0
				|| EncogimientoLavado.ifExistLavado(Long.valueOf(palabras[12]), "Prueba de Lavado") == 0) {
			PruebaEncoLavado.setIdCalidad(Long.valueOf(palabras[12]));
			
			if (LavadoContaCostura.ifExistContaCostura(Long.valueOf(palabras[12]), "Resultado Costura") == 1
					&& LavadoContaCostura.ifExistContaCostura(Long.valueOf(palabras[12]), "Resultado de Contaminación") == 1
					&& EncogimientoLavado.ifExistLavado(Long.valueOf(palabras[12]), "Prueba de Vapor") == 1) {
				
				disenioCalidad = CalidadService.findOne(Long.valueOf(palabras[12]));
				disenioCalidad.setEstatus("1");
				CalidadService.save(disenioCalidad);
			}
		}
		
		else {
			PruebaEncoLavado = EncogimientoLavado.findByTipoPrueba("Prueba de Lavado", Long.valueOf(palabras[12]));
		}
		
		double resultHilo = ((Double.parseDouble(palabras[5]) * 100 / Double.parseDouble(palabras[3])) - 100);
		double resultTrama = ((Double.parseDouble(palabras[6]) * 100 / Double.parseDouble(palabras[4])) - 100);
		
		PruebaEncoLavado.setCreadoPor(palabras[1]);
		PruebaEncoLavado.setFechaRealizacion(palabras[2].replace("T", " "));
		PruebaEncoLavado.setMedidaInicialHilo(palabras[3]);
		PruebaEncoLavado.setMedidaInicialTrama(palabras[4]);
		PruebaEncoLavado.setMedidaFinalHilo(palabras[5]);
		PruebaEncoLavado.setDiferenciaMedidaHilo(String.valueOf(df.format(resultHilo)));
		PruebaEncoLavado.setMedidaFinalTrama(palabras[6]);
		PruebaEncoLavado.setDiferenciaMedidaTrama(String.valueOf(df.format(resultTrama)));
		PruebaEncoLavado.setObservacionesResultados(palabras[7]);
		PruebaEncoLavado.setTipoPrueba("Prueba de Lavado");
		PruebaEncoLavado.setEstatus("1");
		
		EncogimientoLavado.save(PruebaEncoLavado);
		
		if (palabras[12].equals("") || palabras[12] == null) {
			PruebaLavadoContaCostura.setIdCalidad(disenioCalidad.getIdCalidad());
		}
		
		else if (palabras[12] != null && LavadoContaCostura.ifExist(Long.valueOf(palabras[12])) == 0
				|| LavadoContaCostura.ifExistContaCostura(Long.valueOf(palabras[12]), "Solidez/Color") == 0) {
			PruebaLavadoContaCostura.setIdCalidad(Long.valueOf(palabras[12]));
		}
		
		else {
			PruebaLavadoContaCostura = LavadoContaCostura.findByTipoPrueba("Solidez/Color", Long.valueOf(palabras[12]));
		}
		
		PruebaLavadoContaCostura.setCreadoPor(palabras[1]);
		PruebaLavadoContaCostura.setFechaRealizacion(palabras[2].replace("T", " "));
		PruebaLavadoContaCostura.setPruebaCalidad(palabras[8]);
		PruebaLavadoContaCostura.setObservacionesResultados(palabras[9]);
		PruebaLavadoContaCostura.setTipoPrueba("Solidez/Color");
		PruebaLavadoContaCostura.setEstatus("1");
		
		LavadoContaCostura.save(PruebaLavadoContaCostura);
		
		if (palabras[12].equals("") || palabras[12] == null) {
			PruebaLavadoContaCostura = new DisenioPruebaLavadoContaminacionCostura();
			PruebaLavadoContaCostura.setIdCalidad(disenioCalidad.getIdCalidad());
		} else if (palabras[12] != null && LavadoContaCostura.ifExist(Long.valueOf(palabras[12])) == 0
				|| LavadoContaCostura.ifExistContaCostura(Long.valueOf(palabras[12]), "Resultado Pilling") == 0) {
			PruebaLavadoContaCostura = new DisenioPruebaLavadoContaminacionCostura();
			PruebaLavadoContaCostura.setIdCalidad(Long.valueOf(palabras[12]));
			
		} else {
			PruebaLavadoContaCostura = LavadoContaCostura.findByTipoPrueba("Resultado Pilling", Long.valueOf(palabras[12]));
		}
		
		PruebaLavadoContaCostura.setCreadoPor(palabras[1]);
		PruebaLavadoContaCostura.setFechaRealizacion(palabras[2].replace("T", " "));
		PruebaLavadoContaCostura.setPrueba_pilling(palabras[10]);
		PruebaLavadoContaCostura.setObservacionesResultados(palabras[11]);
		PruebaLavadoContaCostura.setTipoPrueba("Resultado Pilling");
		PruebaLavadoContaCostura.setEstatus("1");
		
		LavadoContaCostura.save(PruebaLavadoContaCostura);
		
		return "calidad";
	}
	
	@RequestMapping(value = "/guardarPruebaCostura", method = RequestMethod.POST)
	public String guardarPruebaCostura(@RequestParam(name = "datos") String guardarEncogi) {
		String[] palabras = guardarEncogi.split(",");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		DisenioCalidad disenioCalidad = new DisenioCalidad();
		DisenioPruebaLavadoContaminacionCostura PruebaLavadoContaCostura = new DisenioPruebaLavadoContaminacionCostura();
		
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		LocalDate localDate = LocalDate.now();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String formattedDate = localDate + " " + dateFormat.format(date);
		if (palabras[8].equals("") || palabras[8] == null) {
			disenioCalidad.setCreadoPor(auth.getName());
			disenioCalidad.setActualizadoPor(auth.getName());
			disenioCalidad.setFechaCreacion(formattedDate);
			disenioCalidad.setUltimaFechaModificacion(formattedDate);
			disenioCalidad.setEstatus("0");
			disenioCalidad.setIdTela(Long.valueOf(palabras[0]));
			CalidadService.save(disenioCalidad);
			disenioCalidad.setIdText("CAL" + (disenioCalidad.getIdCalidad() + 100000));
			CalidadService.save(disenioCalidad);
			PruebaLavadoContaCostura.setIdCalidad(disenioCalidad.getIdCalidad());
		} else if (palabras[8] != null && LavadoContaCostura.ifExist(Long.valueOf(palabras[8])) == 0
				|| LavadoContaCostura.ifExistContaCostura(Long.valueOf(palabras[8]), "Resultado Costura") == 0) {
			PruebaLavadoContaCostura.setIdCalidad(Long.valueOf(palabras[8]));
			
			if (EncogimientoLavado.ifExistLavado(Long.valueOf(palabras[8]), "Prueba de Lavado") == 1
					&& LavadoContaCostura.ifExistContaCostura(Long.valueOf(palabras[8]), "Resultado de Contaminación") == 1
					&& EncogimientoLavado.ifExistLavado(Long.valueOf(palabras[8]), "Prueba de Vapor") == 1) {
				
				disenioCalidad = CalidadService.findOne(Long.valueOf(palabras[8]));
				disenioCalidad.setEstatus("1");
				CalidadService.save(disenioCalidad);
			}
			
		} else {
			PruebaLavadoContaCostura = LavadoContaCostura.findByTipoPrueba("Resultado Costura", Long.valueOf(palabras[8]));
		}
		
		PruebaLavadoContaCostura.setCreadoPor(palabras[1]);
		PruebaLavadoContaCostura.setFechaRealizacion(palabras[2].replace("T", " "));
		PruebaLavadoContaCostura.setTipoAguja(palabras[3]);
		PruebaLavadoContaCostura.setDeslizamientoTela(palabras[4]);
		PruebaLavadoContaCostura.setObservacionesResultados(palabras[5]);
		PruebaLavadoContaCostura.setTipoPrueba("Resultado Costura");
		PruebaLavadoContaCostura.setEstatus("1");
		
		LavadoContaCostura.save(PruebaLavadoContaCostura);
		
		if (palabras[8].equals("") || palabras[8] == null) {
			PruebaLavadoContaCostura = new DisenioPruebaLavadoContaminacionCostura();
			PruebaLavadoContaCostura.setIdCalidad(disenioCalidad.getIdCalidad());
		} else if (palabras[8] != null && LavadoContaCostura.ifExist(Long.valueOf(palabras[8])) == 0
				|| LavadoContaCostura.ifExistContaCostura(Long.valueOf(palabras[8]), "Rasgado de Tela") == 0) {
			PruebaLavadoContaCostura = new DisenioPruebaLavadoContaminacionCostura();
			PruebaLavadoContaCostura.setIdCalidad(Long.valueOf(palabras[8]));
			
		} else {
			PruebaLavadoContaCostura = LavadoContaCostura.findByTipoPrueba("Rasgado de Tela", Long.valueOf(palabras[8]));
		}
		
		PruebaLavadoContaCostura.setCreadoPor(palabras[1]);
		PruebaLavadoContaCostura.setFechaRealizacion(palabras[2].replace("T", " "));
		PruebaLavadoContaCostura.setRasgadoTela(palabras[6]);
		PruebaLavadoContaCostura.setObservacionesResultados(palabras[7]);
		PruebaLavadoContaCostura.setTipoPrueba("Rasgado de Tela");
		PruebaLavadoContaCostura.setEstatus("1");
		
		LavadoContaCostura.save(PruebaLavadoContaCostura);
		return "calidad";
	}
	
	@RequestMapping(value = "/guardarPruebaContaminacion", method = RequestMethod.POST)
	public String guardarPruebaContaminacion(@RequestParam(name = "datos") String guardarEncogi) {
		String[] palabras = guardarEncogi.split(",");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		DisenioCalidad disenioCalidad = new DisenioCalidad();
		DisenioPruebaLavadoContaminacionCostura PruebaLavadoContaCostura = new DisenioPruebaLavadoContaminacionCostura();
		
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		LocalDate localDate = LocalDate.now();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String formattedDate = localDate + " " + dateFormat.format(date);
		if (palabras[5].equals("") || palabras[5] == null) {
			disenioCalidad.setCreadoPor(auth.getName());
			disenioCalidad.setActualizadoPor(auth.getName());
			disenioCalidad.setFechaCreacion(formattedDate);
			disenioCalidad.setUltimaFechaModificacion(formattedDate);
			disenioCalidad.setEstatus("0");
			disenioCalidad.setEstatus("0");
			disenioCalidad.setIdTela(Long.valueOf(palabras[0]));
			CalidadService.save(disenioCalidad);
			disenioCalidad.setIdText("CAL" + (disenioCalidad.getIdCalidad() + 100000));
			CalidadService.save(disenioCalidad);
			PruebaLavadoContaCostura.setIdCalidad(disenioCalidad.getIdCalidad());
		} else if (palabras[5] != null && LavadoContaCostura.ifExist(Long.valueOf(palabras[5])) == 0
				|| LavadoContaCostura.ifExistContaCostura(Long.valueOf(palabras[5]), "Resultado de Contaminación") == 0) {
			
			if (EncogimientoLavado.ifExistLavado(Long.valueOf(palabras[5]), "Prueba de Lavado") == 1
					&& LavadoContaCostura.ifExistContaCostura(Long.valueOf(palabras[5]), "Resultado Costura") == 1
					&& EncogimientoLavado.ifExistLavado(Long.valueOf(palabras[5]), "Prueba de Vapor") == 1) {
				
				disenioCalidad = CalidadService.findOne(Long.valueOf(palabras[5]));
				disenioCalidad.setEstatus("1");
				CalidadService.save(disenioCalidad);
			}
			PruebaLavadoContaCostura.setIdCalidad(Long.valueOf(palabras[5]));
		} else {
			PruebaLavadoContaCostura = LavadoContaCostura.findByTipoPrueba("Resultado de Contaminación",
					Long.valueOf(palabras[5]));
		}
		
		PruebaLavadoContaCostura.setCreadoPor(palabras[1]);
		PruebaLavadoContaCostura.setFechaRealizacion(palabras[2].replace("T", " "));
		PruebaLavadoContaCostura.setPruebaCalidad(palabras[3]);
		PruebaLavadoContaCostura.setObservacionesResultados(palabras[4]);
		PruebaLavadoContaCostura.setTipoPrueba("Resultado de Contaminación");
		PruebaLavadoContaCostura.setEstatus("1");
		
		LavadoContaCostura.save(PruebaLavadoContaCostura);
		return "redirect:/calidad";
	}
}
