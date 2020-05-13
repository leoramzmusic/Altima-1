package com.altima.springboot.app.controller;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.altima.springboot.app.models.entity.ComercialPedidoInformación;
import com.altima.springboot.app.models.service.ICargaPedidoService;
import com.altima.springboot.app.models.service.IControlProduccionMuestraService;

@CrossOrigin(origins = { "*" })
@Controller
public class CargaPedidoController {
	@Autowired
	private  IControlProduccionMuestraService DCPM;
	
	@Autowired
	private  ICargaPedidoService cargaPedidoService;

	
	@RequestMapping(value = "/mostrar-pedidos", method = RequestMethod.GET)
	@ResponseBody
	public List<Object []> operadores(Long id) {
		
		return  DCPM.Operadores();
	}
	
	@PostMapping("/guardar-carga-pedido")
	public String guardacatalogo(Long cargaEmpresa, String cargaTipopedido,Long id_pedido,HttpServletRequest request  ) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		System.out.println("Hola pinche putita, te pones bien cachonda hija de tu puta madre: ");
		System.out.println("Id de la empresa es: " +cargaEmpresa);
		System.out.println("Tipo de pedido es: " +cargaTipopedido);
		System.out.println(" pedido es: " +id_pedido);
		ComercialPedidoInformación pedido = new ComercialPedidoInformación();
		
		pedido.setIdEmpresa(cargaEmpresa);
		pedido.setTipoPedido(cargaTipopedido);
		pedido.setIdPedido(id_pedido);
		
		pedido.setCreadoPor(auth.getName());
		pedido.setFechaCreacion(hourdateFormat.format(date));
		pedido.setUltimaFechaCreacion(hourdateFormat.format(date));
		cargaPedidoService.save(pedido);
		pedido.setIdText("noSeq"+pedido.getIdPedidoInformacion());
		cargaPedidoService.save(pedido);
		return "redirect:/carga-de-pedidos";
		
	}
}
