package com.altima.springboot.app.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.altima.springboot.app.models.entity.ComercialCalendario;
import com.altima.springboot.app.models.entity.ComercialCliente;
import com.altima.springboot.app.models.service.IComercialCalendarioService;
import com.altima.springboot.app.models.service.IComercialClienteService;

@Controller
public class AgenteVentaController {
	@Autowired
	IComercialCalendarioService calendarioservice;

	@Autowired
	private IComercialClienteService clienteservice;

	@GetMapping("/obtener-clientes")
	@ResponseBody
	public List<Integer> clientes() {
		List<Integer> list = new ArrayList<>();
		for (ComercialCliente cli : clienteservice.findAll()) {
			list.add(cli.getIdCliente().intValue());
		}
		return list;
	}

	@GetMapping("/llamadas-cliente")
	@ResponseBody
	public List<ComercialCalendario> llamadascliente(Long id) {
		return calendarioservice.findByClient(id);

	}

	@PostMapping("/editar-llamadas-cliente")
	@ResponseBody
	public String editarllamadascliente(Long id, String observacion) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		ComercialCalendario llamada = calendarioservice.findOne(id);
		llamada.setDescription(observacion);
		llamada.setActualizadoPor(auth.getName());
		llamada.setUltimaFechaModificacion(dateFormat.format(date));
		calendarioservice.save(llamada);
		return "seguimientos";
	}

	@GetMapping("/seguimientos")
	public String listSeguimientos(Model model) {
		model.addAttribute("Listclientes", clienteservice.findAll());
		model.addAttribute("Listcalendario", calendarioservice.findAll());
		return "seguimientos";
	}

	@PostMapping("/guardar-seguimientos")
	@ResponseBody
	public String guardarseguimiento(String fecha, String observacion, Long idcliente) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		ComercialCalendario llamadas = new ComercialCalendario();
		llamadas.setDescription(observacion);
		llamadas.setTitle("Llamada");
		llamadas.setStart(fecha);
		llamadas.setIdCliente(idcliente);
		llamadas.setCreadoPor(auth.getName());
		llamadas.setFechaCreacion(dateFormat.format(date));
		llamadas.setUltimaFechaModificacion(dateFormat.format(date));
		llamadas.setColor("green");
		llamadas.setEnd(fecha);
		llamadas.setEstatus("1");
		calendarioservice.save(llamadas);
		return "seguimientos";
	}
	
	@GetMapping("/carga-de-pedidos")
	public String listPedidos() {
		return "carga-de-pedidos";
	}
	
}
