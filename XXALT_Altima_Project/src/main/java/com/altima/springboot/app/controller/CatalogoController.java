package com.altima.springboot.app.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.altima.springboot.app.models.entity.DisenioComposicionIcuidado;
import com.altima.springboot.app.models.entity.DisenioLookup;
import com.altima.springboot.app.models.service.ICatalogoService;
import com.altima.springboot.app.models.service.IDisenioComposicionCuidadoService;
import com.altima.springboot.app.models.service.IUploadService;
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

	@Autowired
	IDisenioComposicionCuidadoService composicioncuidado;

	@Autowired
	private IUploadService uploadFileService;

	@GetMapping(value = "/uploads/cuidados/{filename:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String filename) {

		Resource recurso = null;

		try {
			recurso = uploadFileService.loadfile(filename,1);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"")
				.body(recurso);
	}
	
	@RequestMapping(value = "/verifduplicado", method = RequestMethod.GET)
	@ResponseBody
	public boolean verificaduplicado(String Lookup) {
        return catalogo.findDuplicate(Lookup);
		
	}

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

	@RequestMapping(value = "/composicioneslook", method = RequestMethod.GET)
	@ResponseBody
	public List<DisenioLookup> composicion() {

		return catalogo.findAllComposicion();
	}

	@RequestMapping(value = { "/catalogos" }, method = RequestMethod.GET)
	public String catalogo() {

		return "catalogos";
	}

	@PostMapping("/bajacatalogo")
	public String bajacatalogo(Long idcatalogo) {
		DisenioLookup catalogo2 = null;
		catalogo2 = catalogo.findOne(idcatalogo);
		catalogo2.setEstatus(0);
		catalogo.save(catalogo2);
		return "redirect:catalogos";

	}

	@PostMapping("/eliminarcomposicioncuidado")
	@ResponseBody
	public DisenioLookup eliminarcomposicioncuidado(Long id) {
		DisenioComposicionIcuidado composicioncuidado1 = composicioncuidado.findOne(id);
		DisenioLookup composicion = catalogo.findOne(composicioncuidado1.getIdComposicion());
		composicioncuidado.delete(id);
		return composicion;

	}

	@PostMapping("/guardarcatalogo")
	public String guardacatalogo(String Marca, String Descripcion, String Color, String PiezaTrazo,
			String FamiliaPrenda, String FamiliaGenero, String FamiliaComposicion, String InstruccionCuidado,
			String UnidadMedida, String Material, HttpServletRequest request, String Marcador, String CodigoColor,String Posicion,
			@RequestParam(required = false) MultipartFile iconocuidado, Long Idcuidado, String Simbolo,
			String Composicion) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (Marca != null) {
			DisenioLookup marca = new DisenioLookup();
			marca.setIdText("MAR004");
			marca.setNombreLookup(StringUtils.capitalize(Marca));
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
			DisenioLookup ultimoid = null;
			try {
				ultimoid = catalogo.findLastColor();

			} catch (Exception e) {

				System.out.println(e);
			}

			if (ultimoid == null) {
				color.setIdText("COL" + 1001);
			} else {

				String str = ultimoid.getIdText();
				String[] part = str.split("(?<=\\D)(?=\\d)");
				Integer cont = Integer.parseInt(part[1]);
				color.setIdText("COL" + (cont + 1001));
			}

			color.setNombreLookup(StringUtils.capitalize(Color));
			color.setTipoLookup("Color");
			color.setCreadoPor(auth.getName());
			color.setFechaCreacion(date);
			color.setEstatus(1);
			color.setAtributo1(CodigoColor);
			catalogo.save(color);
			return "/catalogos";
		}
		if (PiezaTrazo != null) {
			DisenioLookup piezatrazo = new DisenioLookup();
			DisenioLookup ultimoid = null;
			try {
				ultimoid = catalogo.findLastPzasTrazo();

			} catch (Exception e) {

				System.out.println(e);
			}

			if (ultimoid == null) {
				piezatrazo.setIdText("PZTR1001");
			} else {

				String str = ultimoid.getIdText();
				String[] part = str.split("(?<=\\D)(?=\\d)");
				Integer cont = Integer.parseInt(part[1]);
				piezatrazo.setIdText("PZTR" + (cont + 1001));
			}

			piezatrazo.setNombreLookup(StringUtils.capitalize(PiezaTrazo));
			piezatrazo.setTipoLookup("Pieza Trazo");
			piezatrazo.setCreadoPor(auth.getName());
			piezatrazo.setFechaCreacion(date);
			piezatrazo.setEstatus(1);
			catalogo.save(piezatrazo);
			return "/catalogos";
		}
		if (FamiliaPrenda != null) {
			DisenioLookup familiaprenda = new DisenioLookup();
			DisenioLookup ultimoid = null;
			try {
				ultimoid = catalogo.findLastFamPrendas();

			} catch (Exception e) {

				System.out.println(e);
			}

			if (ultimoid == null) {
				familiaprenda.setIdText("FAMPR1001");
			} else {

				String str = ultimoid.getIdText();
				String[] part = str.split("(?<=\\D)(?=\\d)");
				Integer cont = Integer.parseInt(part[1]);
				familiaprenda.setIdText("FAMPR" + (cont + 1001));
			}

			familiaprenda.setNombreLookup(StringUtils.capitalize(FamiliaPrenda));
			familiaprenda.setTipoLookup("Familia Prenda");
			familiaprenda.setCreadoPor(auth.getName());
			familiaprenda.setAtributo1(Posicion);
			familiaprenda.setFechaCreacion(date);
			familiaprenda.setEstatus(1);
			catalogo.save(familiaprenda);
			return "/catalogos";
		}
		if (FamiliaGenero != null) {
			DisenioLookup familiagenero = new DisenioLookup();
			DisenioLookup ultimoid = null;
			try {
				ultimoid = catalogo.findLastFamGenero();

			} catch (Exception e) {

				System.out.println(e);

			}

			if (ultimoid == null) {
				familiagenero.setIdText("FAMGE1001");
			} else {

				String str = ultimoid.getIdText();
				String[] part = str.split("(?<=\\D)(?=\\d)");
				Integer cont = Integer.parseInt(part[1]);
				familiagenero.setIdText("FAMGE" + (cont + 1001));
			}

			familiagenero.setNombreLookup(StringUtils.capitalize(FamiliaGenero));
			familiagenero.setTipoLookup("Familia Genero");
			familiagenero.setCreadoPor(auth.getName());
			familiagenero.setFechaCreacion(date);
			familiagenero.setEstatus(1);
			catalogo.save(familiagenero);
			return "/catalogos";
		}

		if (InstruccionCuidado != null) {
			DisenioLookup instruccioncuidado = new DisenioLookup();
			DisenioLookup ultimoid = null;
			try {
				ultimoid = catalogo.findLastInstrCuidado();

			} catch (Exception e) {

				System.out.println(e);

			}

			if (ultimoid == null) {
				instruccioncuidado.setIdText("INSTRCU1001");
			} else {

				String str = ultimoid.getIdText();
				String[] part = str.split("(?<=\\D)(?=\\d)");
				Integer cont = Integer.parseInt(part[1]);
				instruccioncuidado.setIdText("INSTRCU" + (cont + 1001));
			}

			instruccioncuidado.setNombreLookup(StringUtils.capitalize(InstruccionCuidado));
			instruccioncuidado.setTipoLookup("Instruccion Cuidado");
			instruccioncuidado.setCreadoPor(auth.getName());
			instruccioncuidado.setFechaCreacion(date);
			instruccioncuidado.setEstatus(1);
			String uniqueFilename = null;
			try {
				uniqueFilename = uploadFileService.copyfile(iconocuidado,1);
			} catch (IOException e) {
				e.printStackTrace();
			}

			instruccioncuidado.setAtributo1(uniqueFilename);
			catalogo.save(instruccioncuidado);
			return "/catalogos";
		}
		if (UnidadMedida != null) {
			DisenioLookup unidadmedida = new DisenioLookup();
			DisenioLookup ultimoid = null;
			try {
				ultimoid = catalogo.findLastUnidadMedida();

			} catch (Exception e) {

				System.out.println(e);

			}

			if (ultimoid == null) {
				unidadmedida.setIdText("UMED1001");
			} else {

				String str = ultimoid.getIdText();
				String[] part = str.split("(?<=\\D)(?=\\d)");
				Integer cont = Integer.parseInt(part[1]);
				unidadmedida.setIdText("UMED" + (cont + 1001));
			}

			unidadmedida.setNombreLookup(StringUtils.capitalize(UnidadMedida));
			unidadmedida.setTipoLookup("Unidad Medida");
			unidadmedida.setDescripcionLookup(Simbolo);
			unidadmedida.setCreadoPor(auth.getName());
			unidadmedida.setFechaCreacion(date);
			unidadmedida.setEstatus(1);
			catalogo.save(unidadmedida);
			return "/catalogos";
		}
		if (Material != null) {
			DisenioLookup material = new DisenioLookup();
			DisenioLookup ultimoid = null;
			try {
				ultimoid = catalogo.findLastMaterial();

			} catch (Exception e) {

				System.out.println(e);

			}

			if (ultimoid == null) {
				material.setIdText("MAT1001");
			} else {

				String str = ultimoid.getIdText();
				String[] part = str.split("(?<=\\D)(?=\\d)");
				Integer cont = Integer.parseInt(part[1]);
				material.setIdText("MAT" + (cont + 1001));
			}

			material.setNombreLookup(StringUtils.capitalize(Material));
			material.setTipoLookup("Material");
			material.setCreadoPor(auth.getName());
			material.setFechaCreacion(date);
			material.setEstatus(1);
			catalogo.save(material);
			return "/catalogos";
		}
		if (Marcador != null) {
			DisenioLookup marcador = new DisenioLookup();
			DisenioLookup ultimoid = null;
			try {
				ultimoid = catalogo.findLastMarcador();

			} catch (Exception e) {

				System.out.println(e);

			}

			if (ultimoid == null) {
				marcador.setIdText("MARC1001");
			} else {

				String str = ultimoid.getIdText();
				String[] part = str.split("(?<=\\D)(?=\\d)");
				Integer cont = Integer.parseInt(part[1]);
				marcador.setIdText("MARC" + (cont + 1001));
			}

			marcador.setNombreLookup(StringUtils.capitalize(Marcador));
			marcador.setTipoLookup("Marcador");
			marcador.setCreadoPor(auth.getName());
			marcador.setFechaCreacion(date);
			marcador.setEstatus(1);
			catalogo.save(marcador);
			return "/catalogos";
		}
		if (Composicion != null) {
			DisenioLookup composicion = new DisenioLookup();
			DisenioLookup ultimoid = null;
			try {
				ultimoid = catalogo.findLastComposicion();

			} catch (Exception e) {

				System.out.println(e);
			}

			if (ultimoid == null) {
				composicion.setIdText("COMP1001");
			} else {

				String str = ultimoid.getIdText();
				String[] part = str.split("(?<=\\D)(?=\\d)");
				Integer cont = Integer.parseInt(part[1]);
				composicion.setIdText("COMP" + (cont + 1001));
			}

			composicion.setNombreLookup(StringUtils.capitalize(Composicion));
			composicion.setTipoLookup("Composicion");
			composicion.setCreadoPor(auth.getName());
			composicion.setFechaCreacion(date);
			composicion.setEstatus(1);
			catalogo.save(composicion);
			return "/catalogos";
		}
		return "redirect:catalogos";

	}

	@RequestMapping(value = "/composicioncuidadorest", method = RequestMethod.POST)
	@ResponseBody
	public String[] composicioncuidado(Long idcuidado, String FamiliaComposicion, Long idcomposicion) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String[] result = new String[2];
		if (FamiliaComposicion != null && FamiliaComposicion.length() > 0) {
			DisenioLookup familiacomposicion = new DisenioLookup();
			familiacomposicion.setIdText("Fam004");
			familiacomposicion.setNombreLookup(FamiliaComposicion);
			familiacomposicion.setTipoLookup("Familia Composicion");
			familiacomposicion.setCreadoPor(auth.getName());
			familiacomposicion.setFechaCreacion(date);
			familiacomposicion.setEstatus(1);
			catalogo.save(familiacomposicion);
			familiacomposicion.setIdText("FAMCOMP" + (familiacomposicion.getIdLookup() + 1001));
			catalogo.save(familiacomposicion);
			DisenioComposicionIcuidado diseniocomposicioncuidado = new DisenioComposicionIcuidado();
			diseniocomposicioncuidado.setIdComposicion(familiacomposicion.getIdLookup());
			diseniocomposicioncuidado.setIdInstruccionesCuidado(idcuidado);
			composicioncuidado.save(diseniocomposicioncuidado);
			result[0] = familiacomposicion.getIdLookup().toString();
			result[1] = familiacomposicion.getNombreLookup();
		} else {

			DisenioComposicionIcuidado diseniocomposicioncuidado = new DisenioComposicionIcuidado();
			diseniocomposicioncuidado.setIdComposicion(idcomposicion);
			diseniocomposicioncuidado.setIdInstruccionesCuidado(idcuidado);
			composicioncuidado.save(diseniocomposicioncuidado);
			DisenioLookup famcomp = catalogo.findOne(diseniocomposicioncuidado.getIdComposicion());
			result[0] = famcomp.getIdLookup().toString();
			result[1] = famcomp.getNombreLookup();

		}

		return result;
	}

	@RequestMapping(value = "/composicionescuidadosrest", method = RequestMethod.POST)
	@ResponseBody
	public List<Object> composicionescuidados(Long FamiliaComposicion) {
		return composicioncuidado.composicioncuidado(FamiliaComposicion);

	}

	@PostMapping("/editarcatalogo")
	public String editacatalogo(Model model, final Long idLookup, String Marca, String Color, String PiezaTrazo,
			String FamiliaPrenda, String Descripcion, String FamiliaGenero, String FamiliaComposicion,
			String InstruccionCuidado, String UnidadMedida, String Material, String Marcador, String CodigoColor,String Posicion,
			String Simbolo, String Composicion) {
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
		DisenioLookup composicion = null;
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
			color.setAtributo1(CodigoColor);
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
			familiaprenda.setAtributo1(Posicion);
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
			unidadmedida.setDescripcionLookup(Simbolo);
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
		if (Composicion != null && idLookup > 0) {
			composicion = catalogo.findOne(idLookup);
			composicion.setNombreLookup(Composicion);
			composicion.setUltimaFechaModificacion(date);
			composicion.setActualizadoPor(auth.getName());
			catalogo.save(composicion);
			return "redirect:catalogos";
		}
		return "redirect:catalogos";
	}

	@RequestMapping(value = { "/imprimir/{lookup}" }, method = RequestMethod.GET)
	public String ver(@PathVariable(value = "lookup") String lookup, Model model) {

		if (lookup.equals("marca")) {
			List<DisenioLookup> lookup1 = catalogo.findAllColor();
			model.addAttribute("lookup", lookup1);
		}

		return "/imprimir";
	}
}
