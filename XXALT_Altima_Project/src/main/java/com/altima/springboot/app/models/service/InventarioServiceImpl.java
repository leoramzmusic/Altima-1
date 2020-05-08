package com.altima.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altima.springboot.app.models.entity.DisenioMaterial;
import com.altima.springboot.app.models.entity.DiseñoPrendaImagen;
import com.altima.springboot.app.models.entity.ProduccionDetallePedido;
import com.altima.springboot.app.repository.ComercialInventarioRepository;
import com.altima.springboot.app.repository.DisenioImagenPrendaRepository;

@Service
public class InventarioServiceImpl implements IInventarioService {
	
	@Autowired
	private  ComercialInventarioRepository repository;
	
	
	@Autowired
	private  DisenioImagenPrendaRepository diseño;

	@Autowired
	private EntityManager em;
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<ProduccionDetallePedido> listInventario(){
	
		return em.createNativeQuery("	SELECT \r\n" + 
				"				po.id_detalle_pedido AS Id, \r\n" + 
				"				po.id_text as codigo,\r\n" + 
				"				dl2.nombre_lookup as Prenda,\r\n" + 
				"				po.talla as talla,\r\n" + 
				"				po.largo as largo,\r\n" + 
				"				dt.nombre_tela as tela,\r\n" + 
				"			    dl.nombre_lookup as Genero,\r\n" + 
				"				po.costo as price,                  \r\n" + 
				"                IFNULL (pi.ruta_prenda, 0) as img,			 \r\n" + 
				"				po.estatus_confeccion as estatus_confeccion,               \r\n" + 
				"                pre3.id_prenda				\r\n" + 
				"				FROM alt_produccion_detalle_pedido po \r\n" + 
				"                \r\n" + 
				"                \r\n" + 
				"                 INNER JOIN\r\n" + 
				"                \r\n" + 
				"                alt_disenio_prenda pre3 on pre3.id_prenda= po.id_prenda                                                          \r\n" + 
				"			    LEFT JOIN \r\n" + 
				"				alt_disenio_prenda_imagen pi on  pi.id_prenda= pre3.id_prenda and                                              pi.nombre_prenda='Inventario'\r\n" + 
				"                \r\n" + 
				"               \r\n" + 
				"				 INNER JOIN \r\n" + 
				"				alt_disenio_tela dt on dt.id_tela= po.id_tela\r\n" + 
				"				                                                                     \r\n" + 
				"                 INNER JOIN\r\n" + 
				"				alt_disenio_lookup dl2 on dl2.id_lookup=po.id_familia_prenda\r\n" + 
				"                \r\n" + 
				"                     INNER JOIN\r\n" + 
				"				alt_disenio_lookup dl on dl.id_lookup=po.id_familia_genero;").getResultList();
	}
	
	
	
	@Override
	public Object findOnePreImg(Long id) {
		// TODO Auto-generated method stub
		return em.createNativeQuery("SELECT * FROM alt_disenio_prenda_imagen WHERE id_prenda="+id+" and nombre_prenda='Inventario';").getResultList();
	}
	
	
	@Override
	@Transactional
	public void save(DiseñoPrendaImagen diseñoPrendaImagen) {
		// TODO Auto-generated method stub
		diseño.save(diseñoPrendaImagen);
	
}



	@Override
	public DiseñoPrendaImagen findOne(Long Id) {
		// TODO Auto-generated method stub
		return diseño.findById(Id).orElse(null);
	}
	
	
	
	
	
	
	
}
