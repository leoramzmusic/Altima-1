package com.altima.springboot.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.altima.springboot.app.models.entity.DisenioLookup;
import com.altima.springboot.app.models.service.ICatalogoService;
//import com.google.gson.Gson;

@CrossOrigin(origins = { "*" })
@Controller
public class CatalogoController {
	protected final Log logger = LogFactory.getLog(this.getClass());
	String pattern = "yyyy-MM-dd";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	String date = simpleDateFormat.format(new Date());

	@Autowired
	ICatalogoService catalogo;

	@RequestMapping(value = "/marcas", method = RequestMethod.GET)
	@ResponseBody
	public List<DisenioLookup> marcas() {

		return catalogo.findAllMarca();
	}

	@RequestMapping(value = "/colores", method = RequestMethod.GET)
	@ResponseBody
	public List<DisenioLookup> colores() {

		return catalogo.findAllColor();
	}

	@RequestMapping(value = "/trazos", method = RequestMethod.GET)
	@ResponseBody
	public List<DisenioLookup> trazos() {

		return catalogo.findAllPzasTrazo();
	}

	@RequestMapping(value = "/prendaslook", method = RequestMethod.GET)
	@ResponseBody
	public List<DisenioLookup> prendas() {

		return catalogo.findAllFamPrendas();
	}

	@RequestMapping(value = "/generos", method = RequestMethod.GET)
	@ResponseBody
	public List<DisenioLookup> generos() {

		return catalogo.findAllFamGenero();
	}

	@RequestMapping(value = "/composiciones", method = RequestMethod.GET)
	@ResponseBody
	public List<DisenioLookup> composiciones() {

		return catalogo.findAllFamComposicion();
	}

	@RequestMapping(value = "/cuidados", method = RequestMethod.GET)
	@ResponseBody
	public List<DisenioLookup> cuidados() {

		return catalogo.findAllInstrCuidado();
	}

	@RequestMapping(value = "/medidaslook", method = RequestMethod.GET)
	@ResponseBody
	public List<DisenioLookup> medidas() {

		return catalogo.findAllUnidadMedida();
	}

	@RequestMapping(value = "/materialeslook", method = RequestMethod.GET)
	@ResponseBody
	public List<DisenioLookup> materiales() {

		return catalogo.findAllMaterial();
	}
	
	@RequestMapping(value = "/marcadoreslook", method = RequestMethod.GET)
	@ResponseBody
	public List<DisenioLookup> marcadores() {

		return catalogo.findAllMarcador();
	}

	@RequestMapping(value = { "/catalogos" }, method = RequestMethod.GET)
	public String catalogo(Model model, RedirectAttributes flash) {
		
		return "/catalogos";
	}

	@PostMapping("/bajacatalogo")
	public String bajacatalogo(Long idcatalogo) {
		DisenioLookup catalogo2 = null;
		catalogo2 = catalogo.findOne(idcatalogo);
		catalogo2.setEstatus(0);
		catalogo.save(catalogo2);
		return "redirect:catalogos";

	}

	@PostMapping("/guardarcatalogo")
	public String guardacatalogo(String Marca, String Descripcion, String Color, String PiezaTrazo,
			String FamiliaPrenda, String FamiliaGenero, String FamiliaComposicion, String InstruccionCuidado,
			String UnidadMedida, String Material, HttpServletRequest request,String Marcador) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (Marca != null) {
			DisenioLookup marca = new DisenioLookup();
			marca.setIdText("MAR004");
			marca.setNombreLookup(Marca);
			marca.setTipoLookup("Marca");
			marca.setCreadoPor(auth.getName());
			marca.setFechaCreacion(date);
			marca.setEstatus(1);
			catalogo.save(marca);
			marca.setIdText("MAR00" + (marca.getIdLookup() + 10));
			catalogo.save(marca);
			return "redirect:catalogos";
		}
		if (Color != null) {
			DisenioLookup color = new DisenioLookup();
			color.setIdText("COL004");
			color.setNombreLookup(Color);
			color.setTipoLookup("Color");
			color.setCreadoPor(auth.getName());
			color.setFechaCreacion(date);
			color.setEstatus(1);
			catalogo.save(color);
			color.setIdText("COL00" + (color.getIdLookup() + 10));
			catalogo.save(color);
			return "/catalogos";
		}
		if (PiezaTrazo != null) {
			DisenioLookup piezatrazo = new DisenioLookup();
			piezatrazo.setIdText("COL004");
			piezatrazo.setNombreLookup(PiezaTrazo);
			piezatrazo.setTipoLookup("Pieza Trazo");
			piezatrazo.setCreadoPor(auth.getName());
			piezatrazo.setFechaCreacion(date);
			piezatrazo.setEstatus(1);
			catalogo.save(piezatrazo);
			piezatrazo.setIdText("PZTR00" + (piezatrazo.getIdLookup() + 10));
			catalogo.save(piezatrazo);
			return "/catalogos";
		}
		if (FamiliaPrenda != null) {
			DisenioLookup familiaprenda = new DisenioLookup();
			familiaprenda.setIdText("Fam004");
			familiaprenda.setNombreLookup(FamiliaPrenda);
			familiaprenda.setTipoLookup("Familia Prenda");
			familiaprenda.setCreadoPor(auth.getName());
			familiaprenda.setFechaCreacion(date);
			familiaprenda.setEstatus(1);
			catalogo.save(familiaprenda);
			familiaprenda.setIdText("FAMPR00" + (familiaprenda.getIdLookup() + 10));
			catalogo.save(familiaprenda);
			return "/catalogos";
		}
		if (FamiliaGenero != null) {
			DisenioLookup familiagenero = new DisenioLookup();
			familiagenero.setIdText("Fam004");
			familiagenero.setNombreLookup(FamiliaGenero);
			familiagenero.setTipoLookup("Familia Genero");
			familiagenero.setCreadoPor(auth.getName());
			familiagenero.setFechaCreacion(date);
			familiagenero.setEstatus(1);
			catalogo.save(familiagenero);
			familiagenero.setIdText("FAMGE00" + (familiagenero.getIdLookup() + 10));
			catalogo.save(familiagenero);
			return "/catalogos";
		}
		if (FamiliaComposicion != null) {
			DisenioLookup familiacomposicion = new DisenioLookup();
			familiacomposicion.setIdText("Fam004");
			familiacomposicion.setNombreLookup(FamiliaComposicion);
			familiacomposicion.setTipoLookup("Familia Composicion");
			familiacomposicion.setCreadoPor(auth.getName());
			familiacomposicion.setFechaCreacion(date);
			familiacomposicion.setEstatus(1);
			catalogo.save(familiacomposicion);
			familiacomposicion.setIdText("FAMCOMP00" + (familiacomposicion.getIdLookup() + 10));
			catalogo.save(familiacomposicion);
			return "/catalogos";
		}
		if (InstruccionCuidado != null) {
			DisenioLookup instruccioncuidado = new DisenioLookup();
			instruccioncuidado.setIdText("Fam004");
			instruccioncuidado.setNombreLookup(InstruccionCuidado);
			instruccioncuidado.setTipoLookup("Instruccion Cuidado");
			instruccioncuidado.setCreadoPor(auth.getName());
			instruccioncuidado.setFechaCreacion(date);
			instruccioncuidado.setEstatus(1);
			catalogo.save(instruccioncuidado);
			instruccioncuidado.setIdText("INSTRCU00" + (instruccioncuidado.getIdLookup() + 10));
			catalogo.save(instruccioncuidado);
			return "/catalogos";
		}
		if (UnidadMedida != null) {
			DisenioLookup unidadmedida = new DisenioLookup();
			unidadmedida.setIdText("Fam004");
			unidadmedida.setNombreLookup(UnidadMedida);
			unidadmedida.setTipoLookup("Unidad Medida");
			unidadmedida.setCreadoPor(auth.getName());
			unidadmedida.setFechaCreacion(date);
			unidadmedida.setEstatus(1);
			catalogo.save(unidadmedida);
			unidadmedida.setIdText("UMED00" + (unidadmedida.getIdLookup() + 10));
			catalogo.save(unidadmedida);
			return "/catalogos";
		}
		if (Material != null) {
			DisenioLookup material = new DisenioLookup();
			material.setIdText("Fam004");
			material.setNombreLookup(Material);
			material.setTipoLookup("Material");
			material.setCreadoPor(auth.getName());
			material.setFechaCreacion(date);
			material.setEstatus(1);
			catalogo.save(material);
			material.setIdText("MAT00" + (material.getIdLookup() + 10));
			catalogo.save(material);
			return "/catalogos";
		}
		if (Marcador != null) {
			DisenioLookup marcador = new DisenioLookup();
			marcador.setIdText("Fam004");
			marcador.setNombreLookup(Marcador);
			marcador.setTipoLookup("Marcador");
			marcador.setCreadoPor(auth.getName());
			marcador.setFechaCreacion(date);
			marcador.setEstatus(1);
			catalogo.save(marcador);
			marcador.setIdText("MARC00" + (marcador.getIdLookup() + 10));
			catalogo.save(marcador);
			return "/catalogos";
		}
		return "redirect:catalogos";

	}

	@PostMapping("/editarcatalogo")
	public String editacatalogo(Model model, final Long idLookup, String Marca, String Color, String PiezaTrazo,
			String FamiliaPrenda, String Descripcion, String FamiliaGenero, String FamiliaComposicion,
			String InstruccionCuidado, String UnidadMedida, String Material,String Marcador) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		DisenioLookup marca = null;
		DisenioLookup color = null;
		DisenioLookup piezatrazo = null;
		DisenioLookup familiaprenda = null;
		DisenioLookup familiagenero = null;
		DisenioLookup familiacomposicion = null;
		DisenioLookup instruccioncuidado = null;
		DisenioLookup unidadmedida = null;
		DisenioLookup material = null;
		DisenioLookup marcador = null;
		if (Marca != null && idLookup > 0) {
			marca = catalogo.findOne(idLookup);
			marca.setNombreLookup(Marca);
			marca.setUltimaFechaModificacion(date);
			marca.setActualizadoPor(auth.getName());
			catalogo.save(marca);
			return "redirect:catalogos";
		}
		if (Color != null && idLookup > 0) {
			color = catalogo.findOne(idLookup);
			color.setNombreLookup(Color);
			color.setUltimaFechaModificacion(date);
			color.setActualizadoPor(auth.getName());
			catalogo.save(color);
			return "redirect:catalogos";
		}
		if (PiezaTrazo != null && idLookup > 0) {
			piezatrazo = catalogo.findOne(idLookup);
			piezatrazo.setNombreLookup(PiezaTrazo);
			piezatrazo.setUltimaFechaModificacion(date);
			piezatrazo.setActualizadoPor(auth.getName());
			catalogo.save(piezatrazo);
			return "redirect:catalogos";
		}
		if (FamiliaPrenda != null && idLookup > 0) {
			familiaprenda = catalogo.findOne(idLookup);
			familiaprenda.setNombreLookup(FamiliaPrenda);
			familiaprenda.setUltimaFechaModificacion(date);
			familiaprenda.setActualizadoPor(auth.getName());
			catalogo.save(familiaprenda);
			return "redirect:catalogos";
		}
		if (FamiliaGenero != null && idLookup > 0) {
			familiagenero = catalogo.findOne(idLookup);
			familiagenero.setNombreLookup(FamiliaGenero);
			familiagenero.setUltimaFechaModificacion(date);
			familiagenero.setActualizadoPor(auth.getName());
			catalogo.save(familiagenero);
			return "redirect:catalogos";
		}
		if (FamiliaComposicion != null && idLookup > 0) {
			familiacomposicion = catalogo.findOne(idLookup);
			familiacomposicion.setNombreLookup(FamiliaComposicion);
			familiacomposicion.setUltimaFechaModificacion(date);
			familiacomposicion.setActualizadoPor(auth.getName());
			catalogo.save(familiacomposicion);
			return "redirect:catalogos";
		}
		if (InstruccionCuidado != null && idLookup > 0) {
			instruccioncuidado = catalogo.findOne(idLookup);
			instruccioncuidado.setNombreLookup(InstruccionCuidado);
			instruccioncuidado.setUltimaFechaModificacion(date);
			instruccioncuidado.setActualizadoPor(auth.getName());
			catalogo.save(instruccioncuidado);
			return "redirect:catalogos";
		}
		if (UnidadMedida != null && idLookup > 0) {
			unidadmedida = catalogo.findOne(idLookup);
			unidadmedida.setNombreLookup(UnidadMedida);
			unidadmedida.setUltimaFechaModificacion(date);
			unidadmedida.setActualizadoPor(auth.getName());
			catalogo.save(unidadmedida);
			return "redirect:catalogos";
		}
		if (Material != null && idLookup > 0) {
			material = catalogo.findOne(idLookup);
			material.setNombreLookup(Material);
			material.setUltimaFechaModificacion(date);
			material.setActualizadoPor(auth.getName());
			catalogo.save(material);
			return "redirect:catalogos";
		}
		if (Marcador != null && idLookup > 0) {
			marcador = catalogo.findOne(idLookup);
			marcador.setNombreLookup(Marcador);
			marcador.setUltimaFechaModificacion(date);
			marcador.setActualizadoPor(auth.getName());
			catalogo.save(marcador);
			return "redirect:catalogos";
		}
		return "redirect:catalogos";
	}

	@RequestMapping(value = { "/imprimir/{lookup}" }, method = RequestMethod.GET)
	public String ver(@PathVariable(value = "lookup") String lookup, Model model) {

		if (lookup.equals("marca")) {
			List<DisenioLookup> lookup1 = catalogo.findAllMarca();
			model.addAttribute("lookup", lookup1);
		}

		return "/imprimir";
	}
}
