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
import com.altima.springboot.app.models.entity.DisenioPruebaEncogimientoLavado;
import com.altima.springboot.app.models.entity.DisenioPruebaLavadoContaminacionCostura;
import com.altima.springboot.app.models.entity.DisenioTela;
import com.altima.springboot.app.models.service.IDisenioCalidadService;
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
	IDisenioPruebaEncogimientoLavadoService pruebaEncogiLavado;
	
	@Autowired
	IDisenioPruebaLavadoContaminacionCosturaService pruebaContaCostura;
	
	@Autowired
	private IDisenioPruebaLavadoContaminacionCosturaService LavadoContaCostura;
	
	@Autowired
	private IHrEmpleadoService empleadoService;
	
	@Autowired
	private IDisenioMaterialService materialService;
	
	@Autowired
	IDisenioCalidadService disenioCalidad;
	
	@RequestMapping(value="/listarCalidad", method=RequestMethod.GET)
	public List<DisenioCalidad> listarCalidad(){
		
		return disenioCalidad.findAll();
	}
	
	@RequestMapping(value="/listarTelasCalidad", method=RequestMethod.GET)
	public List<DisenioTela> listarTelas(){
		List<DisenioTela> resultTelas = disenioTela.findAll();
		return resultTelas;
	}
	@RequestMapping(value="/listarOperarios", method=RequestMethod.GET)
	public List<Object> listarOperarios(){
		return empleadoService.findAllByPuesto(1L);
	}
	
	@RequestMapping(value="/listarEntretelas", method=RequestMethod.GET)
	public List<Object> listarEntretelas(){
		return materialService.findAllByTipoMaterial(111L);
	}
	
	@RequestMapping(value="/guardarPruebaEncogimiento", method=RequestMethod.POST)
	public String guardarPruebaEncogi(@RequestParam(name = "datos") String guardarEncogi){
		String[] palabras = guardarEncogi.split(",");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		DisenioPruebaEncogimientoLavado PruebaEncoLavado = new DisenioPruebaEncogimientoLavado();
		DisenioCalidad disenioCalidad = new DisenioCalidad();
 		double resultHilo = ((Double.parseDouble(palabras[12])*100/Double.parseDouble(palabras[10]))-100);
 		double resultTrama = ((Double.parseDouble(palabras[13])*100/Double.parseDouble(palabras[11]))-100);
 		System.out.println(palabras);
 		Calendar cal = Calendar.getInstance();
        Date date=cal.getTime();
        LocalDate localDate = LocalDate.now();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedDate=localDate + " "+ dateFormat.format(date);
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
		separadoresPersonalizados.setDecimalSeparator('.');
		DecimalFormat df =new DecimalFormat("0.##", separadoresPersonalizados);
 		
		System.out.println(palabras);
			if(palabras[25].equals("") || palabras[25]==null) {
			disenioCalidad.setCreadoPor(auth.getName());
			disenioCalidad.setActualizadoPor(auth.getName());
			disenioCalidad.setFechaCreacion(formattedDate);
			disenioCalidad.setUltimaFechaModificacion(formattedDate);
			disenioCalidad.setEstatus("0");
			CalidadService.save(disenioCalidad);
			disenioCalidad.setIdText("CAL"+ (disenioCalidad.getIdCalidad()+100000));
			CalidadService.save(disenioCalidad);
			PruebaEncoLavado.setIdCalidad(disenioCalidad.getIdCalidad());
		}
		
		else if (palabras[25]!=null && EncogimientoLavado.ifExist(Long.valueOf(palabras[25]))==0) {
			PruebaEncoLavado.setIdCalidad(Long.valueOf(palabras[25]));	
		}
			
		else {
			PruebaEncoLavado = EncogimientoLavado.findByTipoPrueba("Prueba de Vapor", Long.valueOf(palabras[25]));
		}
		PruebaEncoLavado.setIdTela(palabras[0]);
		PruebaEncoLavado.setCreadoPor(palabras[1]);
		PruebaEncoLavado.setFechaRealizacion(palabras[2].replace("T", " "));
		PruebaEncoLavado.setFechaFinalizacion(palabras[3].replace("T", " "));
		PruebaEncoLavado.setEntretelaPruebaVapor(palabras[4]);
		PruebaEncoLavado.setAdherenciaPruebaVapor(palabras[5]);
		PruebaEncoLavado.setProveedorPruebaVapor(palabras[6]);
		PruebaEncoLavado.setTemperaturaPruebaVapor(palabras[7]);
		PruebaEncoLavado.setTiempoPrueba(palabras[8]);
		PruebaEncoLavado.setPresionPrueba(palabras[9]);
		PruebaEncoLavado.setMedidaInicialHilo(palabras[10]);
		PruebaEncoLavado.setMedidaInicialTrama(palabras[11]);
		PruebaEncoLavado.setMedidaFinalHilo(palabras[12]);
		PruebaEncoLavado.setDiferenciaMedidaHilo(String.valueOf(df.format(resultHilo)));
		PruebaEncoLavado.setMedidaFinalTrama(palabras[13]);
		PruebaEncoLavado.setDiferenciaMedidaTrama(String.valueOf(df.format(resultTrama)));
		PruebaEncoLavado.setObservacionesResultados(palabras[14]);
		PruebaEncoLavado.setTipoPrueba("Prueba de Vapor");
		PruebaEncoLavado.setEstatus("1");
		
		EncogimientoLavado.save(PruebaEncoLavado);
		
		if(palabras[25].equals("") || palabras[25]==null) {
			PruebaEncoLavado = new DisenioPruebaEncogimientoLavado();
			PruebaEncoLavado.setIdCalidad(disenioCalidad.getIdCalidad());
		}

		else if (palabras[25]!=null && EncogimientoLavado.ifExist(Long.valueOf(palabras[25]))==0) {
			PruebaEncoLavado = new DisenioPruebaEncogimientoLavado();
			PruebaEncoLavado.setIdCalidad(Long.valueOf(palabras[25]));	
		}
			
		else {
			PruebaEncoLavado = EncogimientoLavado.findByTipoPrueba("Prueba de Fusion", Long.valueOf(palabras[25]));
		}
		
		resultHilo = ((Double.parseDouble(palabras[17])*100/Double.parseDouble(palabras[15]))-100);
 		resultTrama = ((Double.parseDouble(palabras[18])*100/Double.parseDouble(palabras[16]))-100);
		PruebaEncoLavado.setIdTela(palabras[0]);
		PruebaEncoLavado.setCreadoPor(palabras[1]);
		PruebaEncoLavado.setFechaRealizacion(palabras[2].replace("T", " "));
		PruebaEncoLavado.setFechaFinalizacion(palabras[3].replace("T", " "));
		PruebaEncoLavado.setMedidaInicialHilo(palabras[15]);
		PruebaEncoLavado.setMedidaInicialTrama(palabras[16]);
		PruebaEncoLavado.setMedidaFinalHilo(palabras[17]);
		PruebaEncoLavado.setDiferenciaMedidaHilo(String.valueOf(df.format(resultHilo)));
		PruebaEncoLavado.setMedidaFinalTrama(palabras[18]);
		PruebaEncoLavado.setDiferenciaMedidaTrama(String.valueOf(df.format(resultTrama)));
		PruebaEncoLavado.setObservacionesResultados(palabras[19]);
		PruebaEncoLavado.setTipoPrueba("Prueba de Fusion");
		PruebaEncoLavado.setEstatus("1");
		
		EncogimientoLavado.save(PruebaEncoLavado);
		
		if(palabras[25].equals("") || palabras[25]==null) {
			PruebaEncoLavado = new DisenioPruebaEncogimientoLavado();
			PruebaEncoLavado.setIdCalidad(disenioCalidad.getIdCalidad());
		}		
		else if (palabras[25]!=null && EncogimientoLavado.ifExist(Long.valueOf(palabras[25]))==0) {
			PruebaEncoLavado = new DisenioPruebaEncogimientoLavado();
			PruebaEncoLavado.setIdCalidad(Long.valueOf(palabras[25]));	
		}
			
		else {
			PruebaEncoLavado = EncogimientoLavado.findByTipoPrueba("Plancha con Vapor", Long.valueOf(palabras[25]));
		}
		resultHilo = ((Double.parseDouble(palabras[22])*100/Double.parseDouble(palabras[20]))-100);
 		resultTrama = ((Double.parseDouble(palabras[23])*100/Double.parseDouble(palabras[21]))-100);
		
		PruebaEncoLavado.setIdTela(palabras[0]);
		PruebaEncoLavado.setCreadoPor(palabras[1]);
		PruebaEncoLavado.setFechaRealizacion(palabras[2].replace("T", " "));
		PruebaEncoLavado.setFechaFinalizacion(palabras[3].replace("T", " "));
		PruebaEncoLavado.setMedidaInicialHilo(palabras[20]);
		PruebaEncoLavado.setMedidaInicialTrama(palabras[21]);
		PruebaEncoLavado.setMedidaFinalHilo(palabras[22]);
		PruebaEncoLavado.setDiferenciaMedidaHilo(String.valueOf(df.format(resultHilo)));
		PruebaEncoLavado.setMedidaFinalTrama(palabras[23]);
		PruebaEncoLavado.setDiferenciaMedidaTrama(String.valueOf(df.format(resultTrama)));
		PruebaEncoLavado.setObservacionesResultados(palabras[24]);
		PruebaEncoLavado.setTipoPrueba("Plancha con Vapor");
		PruebaEncoLavado.setEstatus("1");
		
		EncogimientoLavado.save(PruebaEncoLavado);
		
		return "calidad";
	}
	
	
	@RequestMapping(value="/guardarPruebaLavado", method=RequestMethod.POST)
	public String guardarPruebaLavado(@RequestParam(name = "datos") String guardarEncogi){
		String[] palabras = guardarEncogi.split(",");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		DisenioPruebaEncogimientoLavado PruebaEncoLavado = new DisenioPruebaEncogimientoLavado();
		DisenioCalidad disenioCalidad = new DisenioCalidad();
		DisenioPruebaLavadoContaminacionCostura PruebaLavadoContaCostura = new DisenioPruebaLavadoContaminacionCostura();
		
		DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
		separadoresPersonalizados.setDecimalSeparator('.');
		DecimalFormat df =new DecimalFormat("0.##", separadoresPersonalizados);
		Calendar cal = Calendar.getInstance();
        Date date=cal.getTime();
        LocalDate localDate = LocalDate.now();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedDate=localDate + " "+ dateFormat.format(date);
       
        if(palabras[13].equals("") || palabras[13]==null) {
			disenioCalidad.setCreadoPor(auth.getName());
			disenioCalidad.setActualizadoPor(auth.getName());
			disenioCalidad.setFechaCreacion(formattedDate);
			disenioCalidad.setUltimaFechaModificacion(formattedDate);
			disenioCalidad.setEstatus("0");
			CalidadService.save(disenioCalidad);
			disenioCalidad.setIdText("CAL"+ (disenioCalidad.getIdCalidad()+100000));
			CalidadService.save(disenioCalidad);
			PruebaEncoLavado.setIdCalidad(disenioCalidad.getIdCalidad());
        }
        
        else if (palabras[13]!=null && EncogimientoLavado.ifExist(Long.valueOf(palabras[13]))==0) {
			PruebaEncoLavado.setIdCalidad(Long.valueOf(palabras[13]));	
		}
			
		else {
			PruebaEncoLavado = EncogimientoLavado.findByTipoPrueba("Prueba de Lavado", Long.valueOf(palabras[13]));
		}
			
		
		double resultHilo = ((Double.parseDouble(palabras[6])*100/Double.parseDouble(palabras[4]))-100);
 		double resultTrama = ((Double.parseDouble(palabras[7])*100/Double.parseDouble(palabras[5]))-100);
		
		
		PruebaEncoLavado.setIdTela(palabras[0]);
		PruebaEncoLavado.setCreadoPor(palabras[1]);
		PruebaEncoLavado.setFechaRealizacion(palabras[2].replace("T", " "));
		PruebaEncoLavado.setFechaFinalizacion(palabras[3].replace("T", " "));
		PruebaEncoLavado.setMedidaInicialHilo(palabras[4]);
		PruebaEncoLavado.setMedidaInicialTrama(palabras[5]);
		PruebaEncoLavado.setMedidaFinalHilo(palabras[6]);
		PruebaEncoLavado.setDiferenciaMedidaHilo(String.valueOf(df.format(resultHilo)));
		PruebaEncoLavado.setMedidaFinalTrama(palabras[7]);
		PruebaEncoLavado.setDiferenciaMedidaTrama(String.valueOf(df.format(resultTrama)));
		PruebaEncoLavado.setObservacionesResultados(palabras[8]);
		PruebaEncoLavado.setTipoPrueba("Prueba de Lavado");
		PruebaEncoLavado.setEstatus("1");
		
		EncogimientoLavado.save(PruebaEncoLavado);
		
		if(palabras[13].equals("") || palabras[13]==null) {
			PruebaLavadoContaCostura.setIdCalidad(disenioCalidad.getIdCalidad());
		 }
		
		else if (palabras[13]!=null && LavadoContaCostura.ifExist(Long.valueOf(palabras[13]))==0) {
			PruebaLavadoContaCostura.setIdCalidad(Long.valueOf(palabras[13]));	
		}
			
		else {
			PruebaLavadoContaCostura = LavadoContaCostura.findByTipoPrueba("Solidez/Color", Long.valueOf(palabras[13]));
		}
		 
		PruebaLavadoContaCostura.setIdTela(palabras[0]);
		PruebaLavadoContaCostura.setCreadoPor(palabras[1]);
		PruebaLavadoContaCostura.setFechaRealizacion(palabras[2].replace("T", " "));
		PruebaLavadoContaCostura.setFechaFinalizacion(palabras[3].replace("T", " "));
		PruebaLavadoContaCostura.setPruebaCalidad(palabras[9]);
		PruebaLavadoContaCostura.setObservacionesResultados(palabras[10]);
		PruebaLavadoContaCostura.setTipoPrueba("Solidez/Color");
		PruebaLavadoContaCostura.setEstatus("1");
		
		LavadoContaCostura.save(PruebaLavadoContaCostura);
		
		if(palabras[13].equals("") || palabras[13]==null) {
			PruebaLavadoContaCostura = new DisenioPruebaLavadoContaminacionCostura();
			PruebaLavadoContaCostura.setIdCalidad(disenioCalidad.getIdCalidad());
			 }
		else if (palabras[13]!=null && LavadoContaCostura.ifExist(Long.valueOf(palabras[13]))==0) {
			PruebaLavadoContaCostura = new DisenioPruebaLavadoContaminacionCostura();
			PruebaLavadoContaCostura.setIdCalidad(Long.valueOf(palabras[13]));	
			
		}
		else {
			PruebaLavadoContaCostura = LavadoContaCostura.findByTipoPrueba("Resultado Pilling", Long.valueOf(palabras[13]));
		}
			
		PruebaLavadoContaCostura.setIdTela(palabras[0]);
		PruebaLavadoContaCostura.setCreadoPor(palabras[1]);
		PruebaLavadoContaCostura.setFechaRealizacion(palabras[2].replace("T", " "));
		PruebaLavadoContaCostura.setFechaFinalizacion(palabras[3].replace("T", " "));
		PruebaLavadoContaCostura.setPrueba_pilling(palabras[11]);
		PruebaLavadoContaCostura.setObservacionesResultados(palabras[12]);
		PruebaLavadoContaCostura.setTipoPrueba("Resultado Pilling");
		PruebaLavadoContaCostura.setEstatus("1");
		
		LavadoContaCostura.save(PruebaLavadoContaCostura);
		
		return "calidad";
	}
	
	
	@RequestMapping(value="/guardarPruebaCostura", method=RequestMethod.POST)
	public String guardarPruebaCostura(@RequestParam(name = "datos") String guardarEncogi){
		String[] palabras = guardarEncogi.split(",");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		DisenioCalidad disenioCalidad = new DisenioCalidad();
		DisenioPruebaLavadoContaminacionCostura PruebaLavadoContaCostura = new DisenioPruebaLavadoContaminacionCostura();
	
		Calendar cal = Calendar.getInstance();
        Date date=cal.getTime();
        LocalDate localDate = LocalDate.now();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedDate=localDate + " "+ dateFormat.format(date);
			
        if(palabras[9].equals("") || palabras[9]==null) {
        	disenioCalidad.setCreadoPor(auth.getName());
			disenioCalidad.setActualizadoPor(auth.getName());
			disenioCalidad.setFechaCreacion(formattedDate);
			disenioCalidad.setUltimaFechaModificacion(formattedDate);
			disenioCalidad.setEstatus("0");
			CalidadService.save(disenioCalidad);
			disenioCalidad.setIdText("CAL"+ (disenioCalidad.getIdCalidad()+100000));
			CalidadService.save(disenioCalidad);
			PruebaLavadoContaCostura.setIdCalidad(disenioCalidad.getIdCalidad());
		}
        else if (palabras[9]!=null && LavadoContaCostura.ifExist(Long.valueOf(palabras[9]))==0) {
			PruebaLavadoContaCostura.setIdCalidad(Long.valueOf(palabras[9]));	
			
		}
		else {
			PruebaLavadoContaCostura = LavadoContaCostura.findByTipoPrueba("Resultado Costura", Long.valueOf(palabras[9]));
		}
		PruebaLavadoContaCostura.setIdTela(palabras[0]);
		PruebaLavadoContaCostura.setCreadoPor(palabras[1]);
		PruebaLavadoContaCostura.setFechaRealizacion(palabras[2].replace("T", " "));
		PruebaLavadoContaCostura.setFechaFinalizacion(palabras[3].replace("T", " "));
		PruebaLavadoContaCostura.setTipoAguja("2");
		PruebaLavadoContaCostura.setDeslizamientoTela(palabras[5]);
		PruebaLavadoContaCostura.setObservacionesResultados(palabras[6]);
		PruebaLavadoContaCostura.setTipoPrueba("Resultado Costura");
		PruebaLavadoContaCostura.setEstatus("1");
		
		LavadoContaCostura.save(PruebaLavadoContaCostura);
		
		if(palabras[9].equals("") || palabras[9]==null) {
			PruebaLavadoContaCostura = new DisenioPruebaLavadoContaminacionCostura();
			PruebaLavadoContaCostura.setIdCalidad(disenioCalidad.getIdCalidad());
		}
		else if (palabras[9]!=null && LavadoContaCostura.ifExist(Long.valueOf(palabras[9]))==0) {
			PruebaLavadoContaCostura = new DisenioPruebaLavadoContaminacionCostura();
			PruebaLavadoContaCostura.setIdCalidad(Long.valueOf(palabras[9]));	
			
		}
		else {
			PruebaLavadoContaCostura = LavadoContaCostura.findByTipoPrueba("Rasgado de Tela", Long.valueOf(palabras[9]));
		}
		
		PruebaLavadoContaCostura.setIdTela(palabras[0]);
		PruebaLavadoContaCostura.setCreadoPor(palabras[1]);
		PruebaLavadoContaCostura.setFechaRealizacion(palabras[2].replace("T", " "));
		PruebaLavadoContaCostura.setFechaFinalizacion(palabras[3].replace("T", " "));
		PruebaLavadoContaCostura.setRasgadoTela(palabras[7]);
		PruebaLavadoContaCostura.setObservacionesResultados(palabras[8]);
		PruebaLavadoContaCostura.setTipoPrueba("Rasgado de Tela");
		PruebaLavadoContaCostura.setEstatus("1");
		
		LavadoContaCostura.save(PruebaLavadoContaCostura);
		return "calidad";
	}
	
	@RequestMapping(value="/guardarPruebaContaminacion", method=RequestMethod.POST)
	public String guardarPruebaContaminacion(@RequestParam(name = "datos") String guardarEncogi){
		String[] palabras = guardarEncogi.split(",");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		DisenioCalidad disenioCalidad = new DisenioCalidad();
		DisenioPruebaLavadoContaminacionCostura PruebaLavadoContaCostura = new DisenioPruebaLavadoContaminacionCostura();
	
		Calendar cal = Calendar.getInstance();
        Date date=cal.getTime();
        LocalDate localDate = LocalDate.now();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedDate=localDate + " "+ dateFormat.format(date);
        System.out.println(guardarEncogi);
 		if(palabras[6].equals("") || palabras[6]==null) {
			disenioCalidad.setCreadoPor(auth.getName());
			disenioCalidad.setActualizadoPor(auth.getName());
			disenioCalidad.setFechaCreacion(formattedDate);
			disenioCalidad.setUltimaFechaModificacion(formattedDate);
			disenioCalidad.setEstatus("0");
			disenioCalidad.setEstatus("0");
			CalidadService.save(disenioCalidad);
			disenioCalidad.setIdText("CAL"+ (disenioCalidad.getIdCalidad()+100000));
			CalidadService.save(disenioCalidad);
			PruebaLavadoContaCostura.setIdCalidad(disenioCalidad.getIdCalidad());
 		}
 		else if (palabras[6]!=null && LavadoContaCostura.ifExist(Long.valueOf(palabras[6]))==0) {
			PruebaLavadoContaCostura.setIdCalidad(Long.valueOf(palabras[6]));	
			
		}
		else {
			PruebaLavadoContaCostura = LavadoContaCostura.findByTipoPrueba("Resultado de Contaminación", Long.valueOf(palabras[6]));
		}
		
		PruebaLavadoContaCostura.setIdTela(palabras[0]);
		PruebaLavadoContaCostura.setCreadoPor(palabras[1]);
		PruebaLavadoContaCostura.setFechaRealizacion(palabras[2].replace("T", " "));
		PruebaLavadoContaCostura.setFechaFinalizacion(palabras[3].replace("T", " "));
		PruebaLavadoContaCostura.setPruebaCalidad(palabras[4]);
		PruebaLavadoContaCostura.setObservacionesResultados(palabras[5]);
		PruebaLavadoContaCostura.setTipoPrueba("Resultado de Contaminación");
		PruebaLavadoContaCostura.setEstatus("1");

			
		
		System.out.println("guarda prueba contaminaciones");
		LavadoContaCostura.save(PruebaLavadoContaCostura);
		return "redirect:/calidad";
	}
}
