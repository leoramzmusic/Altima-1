package com.altima.springboot.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.altima.springboot.app.models.entity.DisenioLookup;
import com.altima.springboot.app.models.service.ICatalogoService;

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

	@RequestMapping(value = { "/catalogos", "/catalogos-marcas" }, method = RequestMethod.GET)
	public String catalogo(Model model, RedirectAttributes flash) {
		model.addAttribute("marcas", catalogo.findAll());
		return "/catalogos";
	}

	@PostMapping("/guardarcatalogo")
	public String guardacatalogo(String Marca, String Descripcion, String Color, HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (Marca != null) {
			DisenioLookup marca = new DisenioLookup();
			marca.setIdText("MAR004");
			marca.setNombre(Marca);
			marca.setTipoLookup("Marca");
			marca.setCreadoPor(auth.getName());
			marca.setFechaCreacion(date);
			catalogo.save(marca);
			marca.setIdText("MAR00" + (marca.getIdLookup()+10));
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
			catalogo.save(color);
			color.setIdText("COL00" + (color.getIdLookup()+10));
			catalogo.save(color);
			return "/catalogos";
		}
		return "redirect:catalogos";

	}

	@PostMapping("/editarcatalogo")
	public String editacatalogo(Model model, final Long idLookup, String Marca) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		DisenioLookup marca = null;
		if (idLookup > 0) {
			marca = catalogo.findOne(idLookup);
			marca.setNombre(Marca);
			marca.setUltimaFechaModificacion(date);
			marca.setActualizadoPor(auth.getName());
			catalogo.save(marca);
			return "redirect:catalogos";

		}
		return "redirect:catalogos";
	}
}