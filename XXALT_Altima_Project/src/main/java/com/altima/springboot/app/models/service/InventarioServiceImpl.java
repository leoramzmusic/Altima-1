package com.altima.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altima.springboot.app.models.entity.ProduccionDetallePedido;
import com.altima.springboot.app.repository.ComercialInventarioRepository;

@Service
public class InventarioServiceImpl implements IInventarioService {
	
	@Autowired
	private  ComercialInventarioRepository repository;

	@Autowired
	private EntityManager em;
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<ProduccionDetallePedido> listInventario(){
	
		return em.createNativeQuery("SELECT \r\n" + 
				"po.id_detalle_pedido AS Id,\r\n" + 
				"po.id_text as codigo,\r\n" + 
				"dl2.tipo_lookup as Prenda,\r\n" + 
				"po.talla as talla, \r\n" + 
				"po.largo as largo,\r\n" + 
				"dt.nombre_tela as tela,\r\n" + 
				"dl.nombre_lookup as genero,\r\n" + 
				"po.costo as price,\r\n" + 
				"pi.imagen as img,\r\n" + 
				"po. estatus_confeccion as estatus_confeccion\r\n" + 
				"\r\n" + 
				"FROM alt_produccion_detalle_pedido po \r\n" + 
				"\r\n" + 
				"INNER JOIN\r\n" + 
				"alt_disenio_tela dt on dt.id_tela= po.id_tela\r\n" + 
				"INNER JOIN\r\n" + 
				"alt_disenio_lookup dl on dl.id_lookup= po.id_familia_genero\r\n" + 
				"\r\n" + 
				"INNER JOIN\r\n" + 
				"alt_disenio_lookup dl2 on dl2.id_lookup= po.id_prenda\r\n" + 
				"INNER JOIN \r\n" + 
				"alt_produccion_inventario pi on pi.id_inventario= po.id_inventario;\r\n" + 
				"").getResultList();
	}
	

}
