package com.altima.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altima.springboot.app.models.entity.ComercialMovimiento;
import com.altima.springboot.app.repository.ComercialMovimientoRepository;

@Service
@SuppressWarnings("unchecked")
public class ComercialMovimientoServiceImpl implements IComercialMovimientoService {

	@Autowired
	private ComercialMovimientoRepository repository;
	
	@Autowired
	private EntityManager em;
	
	@Override
	@Transactional
	public void save(ComercialMovimiento movimiento) {
		repository.save(movimiento);
	}
	
	@Override
	@Transactional
	public ComercialMovimiento findOne(Long id) {
		
		return em.find(ComercialMovimiento.class, id);
	}

	@Override
	@Transactional
	public List<Object> listarMuestras() {
		return em.createNativeQuery("select prenda.descripcion_prenda, pedido.talla, telas.nombre_tela, pedido.id_pedido from alt_produccion_detalle_pedido pedido" + 
									"	INNER JOIN alt_disenio_prenda prenda ON pedido.id_prenda = prenda.id_prenda" + 
									"	INNER JOIN alt_disenio_tela telas ON pedido.id_tela = telas.id_tela").getResultList();
	}
	
	@Override
	@Transactional
	public Object EncontrarMuestra(Long id) {
		return em.createNativeQuery("select prenda.descripcion_prenda, pedido.talla, telas.nombre_tela, pedido.id_pedido from alt_produccion_detalle_pedido pedido" + 
									"	INNER JOIN alt_disenio_prenda prenda ON pedido.id_prenda = prenda.id_prenda" + 
									"	INNER JOIN alt_disenio_tela telas ON pedido.id_tela = telas.id_tela" +
									"   WHERE pedido.id_pedido ="+id).getSingleResult();
	}
	
	@Override
	@Transactional
	public List<Object> findAllWithNames(){
		
		
		return em.createNativeQuery("SELECT movimiento.id_movimiento, movimiento.id_text, cliente.nombre,cliente.apellido_paterno, cliente.apellido_materno, movimiento.vendedor, movimiento.fecha_salida, movimiento.fecha_entrega, movimiento.estatus \r\n" + 
										"from alt_comercial_movimiento as movimiento\r\n" + 
										"INNER JOIN alt_comercial_cliente cliente ON movimiento.empresa = id_cliente ORDER BY movimiento.id_text").getResultList();
	}

}
