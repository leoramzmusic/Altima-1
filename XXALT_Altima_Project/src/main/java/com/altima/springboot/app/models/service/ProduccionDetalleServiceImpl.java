package com.altima.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altima.springboot.app.models.entity.ProduccionDetallePedido;
import com.altima.springboot.app.repository.ProduccionDetallePedidoRepository;

@Service
public class ProduccionDetalleServiceImpl implements IProduccionDetalleService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private ProduccionDetallePedidoRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<ProduccionDetallePedido> findAll() {
		// TODO Auto-generated method stub
		return (List<ProduccionDetallePedido>) repository.findAll();
	}

	@Override
	public void save(ProduccionDetallePedido Orden) {
		repository.save(Orden);

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public ProduccionDetallePedido findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	} //

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object[]> ListarMuestras(Long id, String tipo) {
		List<Object[]> re = em.createNativeQuery(
				"Select pedido.id_detalle_pedido , pedido.id_text from alt_produccion_detalle_pedido as pedido\r\n"
						+ "where not exists\r\n"
						+ "   (select muestra.id_pedido from alt_control_produccion_muestra as muestra\r\n"
						+ "     where muestra.id_pedido= pedido.id_detalle_pedido and muestra.tipo="
						+ tipo + ")\r\n" + "      and pedido.estatus='1' \r\n"
						+ "     and pedido.id_pedido=" + id)
				.getResultList();
		return re;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object[]> Terminados(Long id, Long tipo) {
		// TODO Auto-generated method stub

		System.out.println(
				"select orden.id_detalle_pedido, orden.id_text from alt_produccion_detalle_pedido as orden  \r\n"
						+ "								where 1=1 \r\n"
						+ "								and  EXISTS (select muestra.id_pedido from alt_control_produccion_muestra as muestra \r\n"
						+ "								           where 1=1\r\n"
						+ "								           and muestra.id_pedido= orden.id_detalle_pedido\r\n"
						+ "								           and orden.id_pedido="
						+ id + " \r\n"
						+ "								           and muestra.estatus_tiempo='Stop' \r\n"
						+ "								           and muestra.tipo="
						+ (tipo - 1) + ") \r\n"
						+ "				                and not  exists\r\n"
						+ "								   			(select muestra.id_pedido from alt_control_produccion_muestra as muestra \r\n"
						+ "								     		where muestra.id_pedido= orden.id_detalle_pedido and muestra.tipo="
						+ tipo + ")\r\n"
						+ "								     and orden.id_pedido="
						+ id);

		List<Object[]> re = em.createNativeQuery(
				"select orden.id_detalle_pedido, orden.id_text from alt_produccion_detalle_pedido as orden  \r\n"
						+ "								where 1=1 \r\n"
						+ "								and  EXISTS (select muestra.id_pedido from alt_control_produccion_muestra as muestra \r\n"
						+ "								           where 1=1\r\n"
						+ "								           and muestra.id_pedido= orden.id_detalle_pedido\r\n"
						+ "								           and orden.id_pedido="
						+ id + " \r\n"
						+ "								           and muestra.estatus_tiempo='Stop' \r\n"
						+ "								           and muestra.tipo="
						+ (tipo - 1) + ") \r\n"
						+ "				                and not  exists\r\n"
						+ "								   			(select muestra.id_pedido from alt_control_produccion_muestra as muestra \r\n"
						+ "								     		where muestra.id_pedido= orden.id_detalle_pedido and muestra.tipo="
						+ tipo + ")\r\n"
						+ "								     and orden.id_pedido="
						+ id)
				.getResultList();
		return re;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object[]> PrendaOrdenes(Long id) {
		// TODO Auto-generated method stub
		List<Object[]> re = em.createNativeQuery(
				"select lookup.nombre_lookup, prenda.descripcion_prenda, orden.costo, SUM(orden.cantidad), orden.talla, orden.largo, orden.id_detalle_pedido, orden.id_prenda, orden.id_pedido\r\n"
						+ "				from alt_disenio_lookup as lookup, \r\n"
						+ "					 alt_disenio_prenda as prenda,  \r\n"
						+ "				   alt_produccion_detalle_pedido   as orden,\r\n"
						+ "				   alt_produccion_pedido as pedido \r\n"
						+ "				where 1=1\r\n"
						+ "				and lookup.id_lookup= prenda.id_familia_prenda \r\n"
						+ "				and pedido.id_pedido=orden.id_pedido \r\n"
						+ "				and prenda.id_prenda = orden.id_prenda\r\n"
						+ "				and orden.estatus='1' \r\n"
						+ "				and pedido.id_pedido=" + id + "\r\n"
						+ "				GROUP BY orden.id_prenda")
				.getResultList();
		return re;
	}

	@Override
	@Transactional
	public void bajasOrdenes(String fecha, String edito, String idPrenda,
			String idPedido, String talla, String largo, String costo) {
		// TODO Auto-generated method stub
		Query query = em.createNativeQuery(
				"UPDATE alt_produccion_detalle_pedido   as orden\r\n"
						+ "SET \r\n" + "estatus=0, \r\n"
						+ "ultima_fecha_modificacion='" + fecha + "',\r\n"
						+ "actualizado_por='" + edito + "'\r\n"
						+ "WHERE  orden.id_prenda=" + idPrenda + "\r\n"
						+ "and orden.id_pedido=" + idPedido + "\r\n"
						+ "and orden.talla='" + talla + "'\r\n"
						+ "and orden.largo='" + largo + "'\r\n"
						+ "and orden.costo=" + costo + "\r\n");

		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> muestrariosCatalogo() {
		List<Object[]> quer = em.createNativeQuery("SELECT\r\n"
				+ "	SUM( pedido.cantidad ) AS stock,\r\n"
				+ "	prenda.id_prenda,\r\n" + "	prenda.descripcion_prenda,\r\n"
				+ "	prenda.id_text AS modelo,\r\n" + "	nombre_tela,\r\n"
				+ "	talla,\r\n" + "	ruta_prenda \r\n" + "FROM\r\n"
				+ "	alt_produccion_detalle_pedido pedido\r\n"
				+ "	INNER JOIN alt_disenio_prenda prenda ON pedido.id_prenda = prenda.id_prenda\r\n"
				+ "	INNER JOIN alt_disenio_tela tela ON tela.id_tela = pedido.id_tela\r\n"
				+ "	LEFT JOIN alt_disenio_prenda_imagen imagen ON imagen.id_prenda = prenda.id_prenda \r\n"
				+ "GROUP BY\r\n" + "	id_prenda,\r\n" + "	modelo,\r\n"
				+ "	nombre_tela,\r\n" + "	talla,\r\n" + "	largo")
				.getResultList();
		return quer;
	}

}
