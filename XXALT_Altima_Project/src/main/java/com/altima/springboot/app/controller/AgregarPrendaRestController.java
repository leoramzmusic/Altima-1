package com.altima.springboot.app.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.altima.springboot.app.models.entity.DisenioMaterial;
import com.altima.springboot.app.models.entity.DisenioMaterialPrenda;
import com.altima.springboot.app.models.entity.DisenioPrenda;
import com.altima.springboot.app.models.entity.DisenioPrendaPatronaje;
import com.altima.springboot.app.models.service.DisenioMaterialPrendaServiceImpl;
import com.altima.springboot.app.models.service.DisenioPrendaPatronajeServiceImpl;
import com.altima.springboot.app.models.service.DisenioPrendaServiceImpl;
import com.altima.springboot.app.models.service.IDisenioMaterialService;
import com.altima.springboot.app.models.service.UploadServiceImpl;


@RestController
public class AgregarPrendaRestController 
{
	@Autowired
	IDisenioMaterialService disenioMaterialService;
	@Autowired
	private UploadServiceImpl uService;
	@Autowired
	private DisenioPrendaServiceImpl prendaService;
	@Autowired
	private DisenioMaterialPrendaServiceImpl materialPrendaService;
	@Autowired
	private DisenioPrendaPatronajeServiceImpl prendaPatronajeService;

	public String file1;
	
	public String file2;
	
	public DisenioPrenda dp = new DisenioPrenda();
	
	@RequestMapping(value="/detalle_material", method=RequestMethod.GET)
	public Object detalleMaterial(@RequestParam Long id) 
	{
		Object dm = disenioMaterialService.findUno(id);
		
		return dm;
	}
	
	@RequestMapping(value="/detalle_patronaje", method=RequestMethod.GET)
	public Object detallePatronaje(@RequestParam Long id) 
	{
		Object dl = disenioMaterialService.findLookUp(id);
		
		return dl;
	}
	
	@RequestMapping(value = "/prendas", method = RequestMethod.POST)
	public void guardar(HttpServletResponse response, DisenioPrenda dp, BindingResult result, Model model, @RequestParam("file") MultipartFile foto, @RequestParam("file2") MultipartFile foto2, RedirectAttributes flash) throws InterruptedException, IOException 
	{
		
		/*
		if (dp.getIdPrenda() != null && dp.getIdPrenda() > 0 && dp.getDibujoFrente() != null && dp.getDibujoFrente().length() > 0)  
		{
			uService.delete(dp.getDibujoFrente());
		}
		*/
		
		String[] uniqueFilename = null;
		try 
		{
			uniqueFilename = uService.copy(foto, foto2);
		}
		catch (IOException e) 
		{
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.dp.setDibujoEspalda(uniqueFilename[0]);
		this.dp.setDibujoFrente(uniqueFilename[1]);
		
		response.sendRedirect("/prendas");
	}
	
	@RequestMapping(value="/guardar_prenda", method=RequestMethod.POST)
	public DisenioPrenda guardarPrenda(@RequestParam(name = "disenioprenda") String disenioprenda)
	{
		//Coso del auth
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				
		JSONObject prenda = new JSONObject(disenioprenda.toString());
		dp.setIdFamiliaPrenda(Long.valueOf((String) prenda.get("idFamiliaPrenda")));
		dp.setCreadoPor(auth.getName());
		dp.setActualizadoPor(auth.getName());
		dp.setNumeroPrenda(prenda.get("numeroPrenda").toString());
		dp.setNombrePrenda(prenda.get("nombrePrenda").toString());
		dp.setDescripcionPrenda(prenda.get("descripcionPrenda").toString());
		dp.setTipoPrenda(prenda.get("tipoPrenda").toString());
		dp.setDetallePrenda(prenda.get("detallePrenda").toString());
		dp.setNotaEspecial(prenda.get("notaEspecial").toString());
		dp.setPrecioLocalActual(prenda.get("precioLocalActual").toString());
		dp.setPrecioLocalAnterior(prenda.get("precioLocalAnterior").toString());
		dp.setPrecioForaneoActual(prenda.get("precioForaneoActual").toString());
		dp.setPrecioForaneoAnterior(prenda.get("precioForaneoAnterior").toString());
		dp.setDetalleConfeccion(prenda.get("detalleConfeccion").toString());
		dp.setMarcadores(prenda.get("marcadores").toString());
		dp.setConsumoTela(prenda.get("consumoTela").toString());
		dp.setConsumoForro(prenda.get("consumoForro").toString());
		dp.setPrecio(prenda.get("precio").toString());
		dp.setCveRuta(prenda.get("cveRuta").toString());
		dp.setTipoLargo(prenda.get("tipoLargo").toString());
		dp.setCvePrenda(prenda.get("cvePrenda").toString());
		dp.setEspecificacion(prenda.get("especificacion").toString());
		dp.setImprimirEtiquetas(prenda.get("imprimirEtiquetas").toString());
		dp.setModeloBoton(prenda.get("modeloBoton").toString());
		dp.setEstatusRecepcionMuestra(prenda.get("estatusRecepcionMuestra").toString());
		dp.setDevolucion(prenda.get("devolucion").toString());
		dp.setPrecioMprod(prenda.get("precioMprod").toString());
		dp.setPrecioMmuestra(prenda.get("precioMmuestra").toString());
		dp.setCategoria(prenda.get("categoria").toString());
		dp.setCombinacion(prenda.get("combinacion").toString());
		dp.setTotalPrendas(prenda.get("totalPrendas").toString());
		dp.setMostrar(prenda.get("mostrar").toString());
		dp.setEstatus(0L);
		
		return dp;
	}
	
	@RequestMapping(value="/guardar_final", method=RequestMethod.GET)
	public void guardarFinal( @RequestParam(name = "objeto_materiales") String objeto_materiales, @RequestParam(name = "objeto_patronaje") String objeto_patronaje) throws NoSuchFieldException, SecurityException
	{
		prendaService.save(dp);
		dp.setIdText("PRE" + (1000 + dp.getIdPrenda()));
		prendaService.save(dp);
		
		//Coso del auth
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		//Se guardan Muchos a Muchos de Materiales
		JSONArray materiales = new JSONArray(objeto_materiales);
		for(int i = 0; i < materiales.length(); i++)
		{
			JSONObject material = materiales.getJSONObject(i);
			DisenioMaterialPrenda mdp = new DisenioMaterialPrenda();
			mdp.setIdMaterial(Long.valueOf(material.get("id").toString()));
			mdp.setIdPrenda(Long.valueOf( dp.getIdPrenda()));
			mdp.setCreadoPor(auth.getName());
			mdp.setActualizadoPor(auth.getName());
			materialPrendaService.save(mdp);
		}
		
		
		//Se guardan Muchos a Muchos de Patronaje
		JSONArray patronajes = new JSONArray(objeto_patronaje);
		for(int i = 0; i < patronajes.length(); i++)
		{
			JSONObject patronaje = patronajes.getJSONObject(i);
			DisenioPrendaPatronaje dpp = new DisenioPrendaPatronaje();
			dpp.setIdPrenda(Long.valueOf(dp.getIdPrenda()));
			dpp.setIdPatronaje(patronaje.get("id").toString());
			dpp.setCantidadTela(patronaje.get("cantidadTela").toString());
			dpp.setCantidadForro(patronaje.get("cantidadForro").toString());
			dpp.setCantidadEntretela(patronaje.get("cantidadEntretela").toString());
			System.out.println(patronaje.get("id").toString());
			prendaPatronajeService.save(dpp);
		}
		
		
		dp = null;
		this.dp = new DisenioPrenda();
	}
}
