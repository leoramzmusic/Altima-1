package com.altima.springboot.app.controller;

import java.io.Console;
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
@RequestMapping("/")
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

	@RequestMapping(value = { "/catalogos", "/catalogos-marcas" }, method = RequestMethod.GET)
	public String catalogo(Model model, RedirectAttributes flash) {
		model.addAttribute("marcas", catalogo.findAllMarca());
		// Gson gson = new Gson();
		// convert your list to json
		// String marca = gson.toJson(catalogo.findAllMarca());
		// print your generated json
		// System.out.println("{" + "\"marca\": " + marca + "}");
		// model.addAttribute("colores22", marca);
		// model.addAttribute("marca", "{" + "\"marca\": " + marca + "}");
		model.addAttribute("colores", catalogo.findAllColor());
		model.addAttribute("pzastrazo", catalogo.findAllPzasTrazo());
		model.addAttribute("famprendas", catalogo.findAllFamPrendas());
		model.addAttribute("famgenero", catalogo.findAllFamGenero());
		model.addAttribute("famcomposicion", catalogo.findAllFamComposicion());
		model.addAttribute("instrcuidado", catalogo.findAllInstrCuidado());
		return "/catalogos";
	}

	@PostMapping("/guardarcatalogo")
	public String guardacatalogo(String Marca, String Descripcion, String Color, String PiezaTrazo,
			String FamiliaPrenda, String FamiliaGenero, String FamiliaComposicion, String InstruccionCuidado,
			HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (Marca != null) {
			System.out.println("entra");
			DisenioLookup marca = new DisenioLookup();
			marca.setIdText("MAR004");
			marca.setNombre(Marca);
			marca.setTipoLookup("Marca");
			marca.setCreadoPor(auth.getName());
			marca.setFechaCreacion(date);
			marca.SetEstatus(1);
			catalogo.save(marca);
			marca.setIdText("MAR00" + (marca.getIdLookup() + 10));
			catalogo.save(marca);
			return "redirect:catalogos";
		}
		if (Color != null) {
			DisenioLookup color = new DisenioLookup();
			color.setIdText("COL004");
			color.setNombre(Color);
			color.setTipoLookup("Color");
			color.setCreadoPor(auth.getName());
			color.setFechaCreacion(date);
			color.SetEstatus(1);
			catalogo.save(color);
			color.setIdText("COL00" + (color.getIdLookup() + 10));
			catalogo.save(color);
			return "/catalogos";
		}
		if (PiezaTrazo != null) {
			DisenioLookup piezatrazo = new DisenioLookup();
			piezatrazo.setIdText("COL004");
			piezatrazo.setNombre(PiezaTrazo);
			piezatrazo.setTipoLookup("Pieza Trazo");
			piezatrazo.setCreadoPor(auth.getName());
			piezatrazo.setFechaCreacion(date);
			piezatrazo.SetEstatus(1);
			catalogo.save(piezatrazo);
			piezatrazo.setIdText("PZTR00" + (piezatrazo.getIdLookup() + 10));
			catalogo.save(piezatrazo);
			return "/catalogos";
		}
		if (FamiliaPrenda != null) {
			DisenioLookup familiaprenda = new DisenioLookup();
			familiaprenda.setIdText("Fam004");
			familiaprenda.setNombre(FamiliaPrenda);
			familiaprenda.setDescripcion(Descripcion);
			familiaprenda.setTipoLookup("Familia Prenda");
			familiaprenda.setCreadoPor(auth.getName());
			familiaprenda.setFechaCreacion(date);
			familiaprenda.SetEstatus(1);
			catalogo.save(familiaprenda);
			familiaprenda.setIdText("FAMPR00" + (familiaprenda.getIdLookup() + 10));
			catalogo.save(familiaprenda);
			return "/catalogos";
		}
		if (FamiliaGenero != null) {
			DisenioLookup familiagenero = new DisenioLookup();
			familiagenero.setIdText("Fam004");
			familiagenero.setNombre(FamiliaGenero);
			familiagenero.setTipoLookup("Familia Genero");
			familiagenero.setCreadoPor(auth.getName());
			familiagenero.setFechaCreacion(date);
			familiagenero.SetEstatus(1);
			catalogo.save(familiagenero);
			familiagenero.setIdText("FAMGE00" + (familiagenero.getIdLookup() + 10));
			catalogo.save(familiagenero);
			return "/catalogos";
		}
		if (FamiliaComposicion != null) {
			DisenioLookup familiacomposicion = new DisenioLookup();
			familiacomposicion.setIdText("Fam004");
			familiacomposicion.setNombre(FamiliaComposicion);
			familiacomposicion.setTipoLookup("Familia Composicion");
			familiacomposicion.setCreadoPor(auth.getName());
			familiacomposicion.setFechaCreacion(date);
			familiacomposicion.SetEstatus(1);
			catalogo.save(familiacomposicion);
			familiacomposicion.setIdText("FAMCOMP00" + (familiacomposicion.getIdLookup() + 10));
			catalogo.save(familiacomposicion);
			return "/catalogos";
		}
		if (InstruccionCuidado != null) {
			DisenioLookup instruccioncuidado = new DisenioLookup();
			instruccioncuidado.setIdText("Fam004");
			instruccioncuidado.setNombre(InstruccionCuidado);
			instruccioncuidado.setTipoLookup("Instruccion Cuidado");
			instruccioncuidado.setCreadoPor(auth.getName());
			instruccioncuidado.setFechaCreacion(date);
			instruccioncuidado.SetEstatus(1);
			catalogo.save(instruccioncuidado);
			instruccioncuidado.setIdText("INSTRCU00" + (instruccioncuidado.getIdLookup() + 10));
			catalogo.save(instruccioncuidado);
			return "/catalogos";
		}
		return "redirect:catalogos";

	}

	@PostMapping("/editarcatalogo")
	public String editacatalogo(Model model, final Long idLookup, String Marca, String Color, String PiezaTrazo,
			String FamiliaPrenda, String Descripcion, String FamiliaGenero, String FamiliaComposicion,
			String InstruccionCuidado) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		DisenioLookup marca = null;
		DisenioLookup color = null;
		DisenioLookup piezatrazo = null;
		DisenioLookup familiaprenda = null;
		DisenioLookup familiagenero = null;
		DisenioLookup familiacomposicion = null;
		DisenioLookup instruccioncuidado = null;
		if (Marca != null && idLookup > 0) {
			marca = catalogo.findOne(idLookup);
			marca.setNombre(Marca);
			marca.setUltimaFechaModificacion(date);
			marca.setActualizadoPor(auth.getName());
			catalogo.save(marca);
			return "redirect:catalogos";
		}
		if (Color != null && idLookup > 0) {
			color = catalogo.findOne(idLookup);
			color.setNombre(Color);
			color.setUltimaFechaModificacion(date);
			color.setActualizadoPor(auth.getName());
			catalogo.save(color);
			return "redirect:catalogos";
		}
		if (PiezaTrazo != null && idLookup > 0) {
			piezatrazo = catalogo.findOne(idLookup);
			piezatrazo.setNombre(PiezaTrazo);
			piezatrazo.setUltimaFechaModificacion(date);
			piezatrazo.setActualizadoPor(auth.getName());
			catalogo.save(piezatrazo);
			return "redirect:catalogos";
		}
		if (FamiliaPrenda != null && idLookup > 0) {
			familiaprenda = catalogo.findOne(idLookup);
			familiaprenda.setNombre(FamiliaPrenda);
			familiaprenda.setDescripcion(Descripcion);
			familiaprenda.setUltimaFechaModificacion(date);
			familiaprenda.setActualizadoPor(auth.getName());
			catalogo.save(familiaprenda);
			return "redirect:catalogos";
		}
		if (FamiliaGenero != null && idLookup > 0) {
			familiagenero = catalogo.findOne(idLookup);
			familiagenero.setNombre(FamiliaGenero);
			familiagenero.setUltimaFechaModificacion(date);
			familiagenero.setActualizadoPor(auth.getName());
			catalogo.save(familiagenero);
			return "redirect:catalogos";
		}
		if (FamiliaComposicion != null && idLookup > 0) {
			familiacomposicion = catalogo.findOne(idLookup);
			familiacomposicion.setNombre(FamiliaComposicion);
			familiacomposicion.setUltimaFechaModificacion(date);
			familiacomposicion.setActualizadoPor(auth.getName());
			catalogo.save(familiacomposicion);
			return "redirect:catalogos";
		}
		if (InstruccionCuidado != null && idLookup > 0) {
			instruccioncuidado = catalogo.findOne(idLookup);
			instruccioncuidado.setNombre(InstruccionCuidado);
			instruccioncuidado.setUltimaFechaModificacion(date);
			instruccioncuidado.setActualizadoPor(auth.getName());
			catalogo.save(instruccioncuidado);
			return "redirect:catalogos";
		}
		return "redirect:catalogos";
	}
}
