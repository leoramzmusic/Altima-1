package com.altima.springboot.app.controller;

import java.text.DateFormat;
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
	private IDisenioPruebaLavadoContaminacionCosturaService LavadoContaCostura;
	
	@Autowired
	private IHrEmpleadoService empleadoService;
	
	@Autowired
	private IDisenioMaterialService materialService;
	
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
	public List<String> guardarPruebaEncogi(@RequestParam(name = "datos") String guardarEncogi){
		String[] palabras = guardarEncogi.split(",");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		DisenioPruebaEncogimientoLavado PruebaEncoLavado = new DisenioPruebaEncogimientoLavado();
		DisenioCalidad disenioCalidad = new DisenioCalidad();
 		double resultHilo = ((Double.parseDouble(palabras[12])*100/Double.parseDouble(palabras[10]))-100);
 		double resultTrama = ((Double.parseDouble(palabras[13])*100/Double.parseDouble(palabras[11]))-100);
 		
 		Calendar cal = Calendar.getInstance();
        Date date=cal.getTime();
        LocalDate localDate = LocalDate.now();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedDate=localDate + " "+ dateFormat.format(date);
 		
 		
		disenioCalidad.setCreadoPor(auth.getName());
		disenioCalidad.setActualizadoPor(auth.getName());
		disenioCalidad.setFechaCreacion(formattedDate);
		disenioCalidad.setUltimaFechaModificacion(formattedDate);
		disenioCalidad.setEstatus("0");
		CalidadService.save(disenioCalidad);
		disenioCalidad.setIdText("CAL"+ (disenioCalidad.getIdCalidad()+100000));
		CalidadService.save(disenioCalidad);
 		
		PruebaEncoLavado.setIdCalidad(disenioCalidad.getIdCalidad());
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
		PruebaEncoLavado.setDiferenciaMedidaHilo(String.valueOf(resultHilo));
		PruebaEncoLavado.setMedidaFinalTrama(palabras[13]);
		PruebaEncoLavado.setDiferenciaMedidaTrama(String.valueOf(resultTrama));
		PruebaEncoLavado.setObservacionesResultados(palabras[14]);
		PruebaEncoLavado.setTipoPrueba("1");
		PruebaEncoLavado.setEstatus("1");
		
		EncogimientoLavado.save(PruebaEncoLavado);
		
		PruebaEncoLavado = new DisenioPruebaEncogimientoLavado();
		resultHilo = ((Double.parseDouble(palabras[17])*100/Double.parseDouble(palabras[15]))-100);
 		resultTrama = ((Double.parseDouble(palabras[18])*100/Double.parseDouble(palabras[16]))-100);
		
		PruebaEncoLavado.setIdCalidad(disenioCalidad.getIdCalidad());
		PruebaEncoLavado.setIdTela(palabras[0]);
		PruebaEncoLavado.setCreadoPor(palabras[1]);
		PruebaEncoLavado.setFechaRealizacion(palabras[2].replace("T", " "));
		PruebaEncoLavado.setFechaFinalizacion(palabras[3].replace("T", " "));
		PruebaEncoLavado.setMedidaInicialHilo(palabras[15]);
		PruebaEncoLavado.setMedidaInicialTrama(palabras[16]);
		PruebaEncoLavado.setMedidaFinalHilo(palabras[17]);
		PruebaEncoLavado.setDiferenciaMedidaHilo(String.valueOf(resultHilo));
		PruebaEncoLavado.setMedidaFinalTrama(palabras[18]);
		PruebaEncoLavado.setDiferenciaMedidaTrama(String.valueOf(resultTrama));
		PruebaEncoLavado.setObservacionesResultados(palabras[19]);
		PruebaEncoLavado.setTipoPrueba("2");
		PruebaEncoLavado.setEstatus("1");
		
		EncogimientoLavado.save(PruebaEncoLavado);
		
		PruebaEncoLavado = new DisenioPruebaEncogimientoLavado();
		resultHilo = ((Double.parseDouble(palabras[22])*100/Double.parseDouble(palabras[20]))-100);
 		resultTrama = ((Double.parseDouble(palabras[23])*100/Double.parseDouble(palabras[21]))-100);
		
		PruebaEncoLavado.setIdCalidad(disenioCalidad.getIdCalidad());
		PruebaEncoLavado.setIdTela(palabras[0]);
		PruebaEncoLavado.setCreadoPor(palabras[1]);
		PruebaEncoLavado.setFechaRealizacion(palabras[2].replace("T", " "));
		PruebaEncoLavado.setFechaFinalizacion(palabras[3].replace("T", " "));
		PruebaEncoLavado.setMedidaInicialHilo(palabras[20]);
		PruebaEncoLavado.setMedidaInicialTrama(palabras[21]);
		PruebaEncoLavado.setMedidaFinalHilo(palabras[22]);
		PruebaEncoLavado.setDiferenciaMedidaHilo(String.valueOf(resultHilo));
		PruebaEncoLavado.setMedidaFinalTrama(palabras[23]);
		PruebaEncoLavado.setDiferenciaMedidaTrama(String.valueOf(resultTrama));
		PruebaEncoLavado.setObservacionesResultados(palabras[24]);
		PruebaEncoLavado.setTipoPrueba("3");
		PruebaEncoLavado.setEstatus("1");
		
		EncogimientoLavado.save(PruebaEncoLavado);
		
		return null;
	}
	
	
	@RequestMapping(value="/guardarPruebaLavado", method=RequestMethod.POST)
	public List<String> guardarPruebaLavado(@RequestParam(name = "datos") String guardarEncogi){
		String[] palabras = guardarEncogi.split(",");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		DisenioPruebaEncogimientoLavado PruebaEncoLavado = new DisenioPruebaEncogimientoLavado();
		DisenioCalidad disenioCalidad = new DisenioCalidad();
		DisenioPruebaLavadoContaminacionCostura PruebaLavadoContaCostura = new DisenioPruebaLavadoContaminacionCostura();
	
		Calendar cal = Calendar.getInstance();
        Date date=cal.getTime();
        LocalDate localDate = LocalDate.now();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedDate=localDate + " "+ dateFormat.format(date);
 		
		disenioCalidad.setCreadoPor(auth.getName());
		disenioCalidad.setActualizadoPor(auth.getName());
		disenioCalidad.setFechaCreacion(formattedDate);
		disenioCalidad.setUltimaFechaModificacion(formattedDate);
		disenioCalidad.setEstatus("0");
		CalidadService.save(disenioCalidad);
		disenioCalidad.setIdText("CAL"+ (disenioCalidad.getIdCalidad()+100000));
		CalidadService.save(disenioCalidad);
	
		
		double resultHilo = ((Double.parseDouble(palabras[6])*100/Double.parseDouble(palabras[4]))-100);
 		double resultTrama = ((Double.parseDouble(palabras[7])*100/Double.parseDouble(palabras[5]))-100);
		
		PruebaEncoLavado.setIdCalidad(disenioCalidad.getIdCalidad());
		PruebaEncoLavado.setIdTela(palabras[0]);
		PruebaEncoLavado.setCreadoPor(palabras[1]);
		PruebaEncoLavado.setFechaRealizacion(palabras[2].replace("T", " "));
		PruebaEncoLavado.setFechaFinalizacion(palabras[3].replace("T", " "));
		PruebaEncoLavado.setMedidaInicialHilo(palabras[4]);
		PruebaEncoLavado.setMedidaInicialTrama(palabras[5]);
		PruebaEncoLavado.setMedidaFinalHilo(palabras[6]);
		PruebaEncoLavado.setDiferenciaMedidaHilo(String.valueOf(resultHilo));
		PruebaEncoLavado.setMedidaFinalTrama(palabras[7]);
		PruebaEncoLavado.setDiferenciaMedidaTrama(String.valueOf(resultTrama));
		PruebaEncoLavado.setObservacionesResultados(palabras[8]);
		PruebaEncoLavado.setTipoPrueba("4");
		PruebaEncoLavado.setEstatus("1");
		
		EncogimientoLavado.save(PruebaEncoLavado);
		
		PruebaLavadoContaCostura.setIdCalidad(disenioCalidad.getIdCalidad());
		PruebaLavadoContaCostura.setIdTela(palabras[0]);
		PruebaLavadoContaCostura.setCreadoPor(palabras[1]);
		PruebaLavadoContaCostura.setFechaRealizacion(palabras[2].replace("T", " "));
		PruebaLavadoContaCostura.setFechaFinalizacion(palabras[3].replace("T", " "));
		PruebaLavadoContaCostura.setPruebaCalidad(palabras[9]);
		PruebaLavadoContaCostura.setObservacionesResultados(palabras[10]);
		PruebaLavadoContaCostura.setTipoPrueba("5");
		PruebaLavadoContaCostura.setEstatus("1");
		
		LavadoContaCostura.save(PruebaLavadoContaCostura);
		
		PruebaLavadoContaCostura = new DisenioPruebaLavadoContaminacionCostura();
		PruebaLavadoContaCostura.setIdCalidad(disenioCalidad.getIdCalidad());
		PruebaLavadoContaCostura.setIdTela(palabras[0]);
		PruebaLavadoContaCostura.setCreadoPor(palabras[1]);
		PruebaLavadoContaCostura.setFechaRealizacion(palabras[2].replace("T", " "));
		PruebaLavadoContaCostura.setFechaFinalizacion(palabras[3].replace("T", " "));
		PruebaLavadoContaCostura.setPrueba_pilling(palabras[11]);
		PruebaLavadoContaCostura.setObservacionesResultados(palabras[12]);
		PruebaLavadoContaCostura.setTipoPrueba("6");
		PruebaLavadoContaCostura.setEstatus("1");
		
		LavadoContaCostura.save(PruebaLavadoContaCostura);
		
		return null;
	}
	
	
	@RequestMapping(value="/guardarPruebaCostura", method=RequestMethod.POST)
	public void guardarPruebaCostura(@RequestParam(name = "datos") String guardarEncogi){
		String[] palabras = guardarEncogi.split(",");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		DisenioCalidad disenioCalidad = new DisenioCalidad();
		DisenioPruebaLavadoContaminacionCostura PruebaLavadoContaCostura = new DisenioPruebaLavadoContaminacionCostura();
	
		Calendar cal = Calendar.getInstance();
        Date date=cal.getTime();
        LocalDate localDate = LocalDate.now();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedDate=localDate + " "+ dateFormat.format(date);
		disenioCalidad.setCreadoPor(auth.getName());
		disenioCalidad.setActualizadoPor(auth.getName());
		disenioCalidad.setFechaCreacion(formattedDate);
		disenioCalidad.setUltimaFechaModificacion(formattedDate);
		disenioCalidad.setEstatus("0");
		CalidadService.save(disenioCalidad);
		disenioCalidad.setIdText("CAL"+ (disenioCalidad.getIdCalidad()+100000));
		CalidadService.save(disenioCalidad);
	
		PruebaLavadoContaCostura.setIdCalidad(disenioCalidad.getIdCalidad());
		PruebaLavadoContaCostura.setIdTela(palabras[0]);
		PruebaLavadoContaCostura.setCreadoPor(palabras[1]);
		PruebaLavadoContaCostura.setFechaRealizacion(palabras[2].replace("T", " "));
		PruebaLavadoContaCostura.setFechaFinalizacion(palabras[3].replace("T", " "));
		PruebaLavadoContaCostura.setTipoAguja("2");
		PruebaLavadoContaCostura.setDeslizamientoTela(palabras[5]);
		PruebaLavadoContaCostura.setObservacionesResultados(palabras[6]);
		PruebaLavadoContaCostura.setTipoPrueba("6");
		PruebaLavadoContaCostura.setEstatus("1");
		
		LavadoContaCostura.save(PruebaLavadoContaCostura);
		
		PruebaLavadoContaCostura = new DisenioPruebaLavadoContaminacionCostura();
		PruebaLavadoContaCostura.setIdCalidad(disenioCalidad.getIdCalidad());
		PruebaLavadoContaCostura.setIdTela(palabras[0]);
		PruebaLavadoContaCostura.setCreadoPor(palabras[1]);
		PruebaLavadoContaCostura.setFechaRealizacion(palabras[2]);
		PruebaLavadoContaCostura.setFechaFinalizacion(palabras[3]);
		PruebaLavadoContaCostura.setRasgadoTela(palabras[7]);
		PruebaLavadoContaCostura.setObservacionesResultados(palabras[8]);
		PruebaLavadoContaCostura.setTipoPrueba("6");
		PruebaLavadoContaCostura.setEstatus("1");
		
		LavadoContaCostura.save(PruebaLavadoContaCostura);
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
 		List<DisenioCalidad> lista = CalidadService.findAll();
 		
 		int max= lista.size()+1;
 		System.out.println(max);
		disenioCalidad.setCreadoPor(auth.getName());
		disenioCalidad.setActualizadoPor(auth.getName());
		disenioCalidad.setFechaCreacion(formattedDate);
		disenioCalidad.setUltimaFechaModificacion(formattedDate);
		disenioCalidad.setEstatus("0");
		disenioCalidad.setIdText("CAL"+ (max+100000));
		CalidadService.save(disenioCalidad);
	
		PruebaLavadoContaCostura.setIdCalidad(disenioCalidad.getIdCalidad());
		PruebaLavadoContaCostura.setIdTela(palabras[0]);
		PruebaLavadoContaCostura.setCreadoPor(palabras[1]);
		PruebaLavadoContaCostura.setFechaRealizacion(palabras[2].replace("T", " "));
		PruebaLavadoContaCostura.setFechaFinalizacion(palabras[3].replace("T", " "));
		PruebaLavadoContaCostura.setPruebaCalidad(palabras[4]);
		PruebaLavadoContaCostura.setObservacionesResultados(palabras[5]);
		PruebaLavadoContaCostura.setTipoPrueba("6");
		PruebaLavadoContaCostura.setEstatus("1");
		System.out.println("guarda prueba contaminaciones");
		LavadoContaCostura.save(PruebaLavadoContaCostura);
		return "calidad";
	}
}