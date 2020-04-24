package com.altima.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altima.springboot.app.models.entity.DisenioLookup;
import com.altima.springboot.app.models.entity.DisenioTela;
import com.altima.springboot.app.models.entity.DisenioTelaPrenda;
import com.altima.springboot.app.repository.DisenioTelaPrendaRepository;
import com.altima.springboot.app.repository.DisenioTelaRepository;


@Service
public class DisenioTelaServiceImpl implements IDisenioTelaService {
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private DisenioTelaRepository repository;
	
	@Autowired
	private DisenioTelaPrendaRepository repositoryTelaPrenda;

	
	@Override
	@Transactional(readOnly=true)
	public List<DisenioTela> findAll() {
		// TODO Auto-generated method stub
		return (List<DisenioTela>) repository.findAll();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object []> findAllBotones(Long id) {
		List<Object[]> re= em.createNativeQuery("SELECT material.id_material, material.nombre_material from alt_disenio_material as material, alt_disenio_lookup as lookup\r\n" + 
				"				where 1=1\r\n" + 
				"				and material.id_tipo_material= lookup.id_lookup\r\n" + 
				"				and lookup.nombre_lookup='boton'\r\n" + 
				"                and NOT EXISTS(\r\n" + 
				"                    select MT.id_material, material.nombre_material   from alt_disenio_material_tela as MT\r\n" + 
				"                    where MT.id_material=material.id_material\r\n" + 
				"                    and MT.id_tela="+id+"\r\n" + 
				"                )").getResultList();
		return re;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object []> materialesDisponibles(Long id, String tipo) {
		/*List<Object[]> re= em.createNativeQuery("SELECT material.id_material, material.nombre_material from alt_disenio_material as material, alt_disenio_lookup as lookup\r\n" + 
				"				where 1=1\r\n" + 
				"				and material.id_tipo_material= lookup.id_lookup\r\n" + 
				"				and lookup.nombre_lookup='"+tipo+"'\r\n" + 
				"                and NOT EXISTS(\r\n" + 
				"                    select MT.id_material, material.nombre_material   from alt_disenio_material_tela as MT\r\n" + 
				"                    where MT.id_material=material.id_material\r\n" + 
				"                    and MT.id_tela="+id+"\r\n" + 
				"                    and MT.tipo='"+tipo+"' )").getResultList();
		
		*/
		
		
		List<Object[]> re= em.createNativeQuery("SELECT material.id_material,CONCAT(material.id_text,' ',material.nombre_material,' ',\r\n" + 
				"(select lookup2.nombre_lookup from alt_disenio_lookup as lookup2 where 1=1 and lookup2.id_lookup=material.id_color) ) As inf \r\n" + 
				"from alt_disenio_material as material, alt_disenio_lookup as lookup \r\n" + 
				"								where 1=1\r\n" + 
				"								and material.id_tipo_material= lookup.id_lookup\r\n" + 
				"								and material.estatus=1\r\n" + 
				"								and material.estatus_material=1\r\n" + 
				"								and lookup.nombre_lookup='"+tipo+"'\r\n" + 
				"				                and NOT EXISTS(\r\n" + 
				"				                    select MT.id_material, material.nombre_material   from alt_disenio_material_tela as MT\r\n" + 
				"				                    where MT.id_material=material.id_material\r\n" + 
				"                    				and MT.id_tela="+id+"\r\n" + 
				"				                    and MT.tipo='"+tipo+"')\r\n" + 
				"									ORDER BY inf").getResultList();
		return re;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object []> materialesSeleccionados(Long id, String tipo) {
		/*List<Object[]> re= em.createNativeQuery("select MT.id_material, material.nombre_material\r\n" + 
				"				from alt_disenio_material_tela as MT, alt_disenio_material as material\r\n" + 
				"				where 1=1\r\n" + 
				"				and MT.id_material=material.id_material\r\n" + 
				"				and MT.id_tela="+id+"\r\n" + 
				"				and MT.tipo='"+tipo+"';").getResultList();*/
		
		
		List<Object[]> re= em.createNativeQuery("select MT.id_material, CONCAT(material.id_text,' ',material.nombre_material,' ',\r\n" + 
				"				(select lookup2.nombre_lookup from alt_disenio_lookup as lookup2 where 1=1 and lookup2.id_lookup=material.id_color) ) As inf\r\n" + 
				"												from alt_disenio_material_tela as MT, alt_disenio_material as material\r\n" + 
				"												where 1=1\r\n" + 
				"												and MT.id_material=material.id_material\r\n" + 
				"												and material.estatus=1\r\n" + 
				"												and material.estatus_material=1\r\n" + 
				"                    							and MT.id_tela="+id+"\r\n" + 
				"												and MT.tipo='"+tipo+"'\r\n" + 
				"				ORDER BY inf").getResultList();
		return re;
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object []> TelasAutorizadas() {
		List<Object[]> re= em.createNativeQuery("SELECT tela.id_tela , tela.nombre_tela\r\n" + 
				"from alt_disenio_tela as tela\r\n" + 
				"WHERE  1=1\r\n" + 
				"and tela.estatus_tela=1\r\n" + 
				"and tela.estatus=1\r\n" + 
				"ORDER BY tela.nombre_tela").getResultList();
		return re;
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisenioLookup> findAllColores() {
		// TODO Auto-generated method stub
		return em.createQuery("from DisenioLookup where tipo_lookup = 'Color'").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisenioLookup> findAllFamilaComposicion() {
		// TODO Auto-generated method stub
		return em.createQuery("from DisenioLookup where tipo_lookup = 'Familia Composicion' and estatus=1 ORDER BY nombre_lookup ").getResultList();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisenioLookup> findAllComposicion() {
		// TODO Auto-generated method stub
		return em.createQuery("from DisenioLookup where tipo_lookup = 'Composicion' and estatus=1 ORDER BY nombre_lookup ").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisenioLookup> findAllPrenda() {
		// TODO Auto-generated method stub
		return em.createQuery("from DisenioLookup where tipo_lookup='Familia Prenda' and estatus=1 ORDER BY nombre_lookup ").getResultList();
	}
	
	
	
	@Override
	@Transactional
	public void save(DisenioTela diseniotela) {
		// TODO Auto-generated method stub
		repository.save(diseniotela);

	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public DisenioTela findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object[]> ComposicionTelaMN(Long id) {
		
		
		List<Object[]> re= em.createNativeQuery("select alt_disenio_familia_composicion_tela.porcentaje_composicion ,\r\n" + 
				"				alt_disenio_lookup.id_lookup ,alt_disenio_lookup.nombre_lookup \r\n" + 
				"				from alt_disenio_familia_composicion_tela, alt_disenio_lookup \r\n" + 
				"				where alt_disenio_lookup.id_lookup=alt_disenio_familia_composicion_tela.id_composicion \r\n" + 
				"				and alt_disenio_lookup.estatus=1\r\n" + 
				"				and alt_disenio_familia_composicion_tela.id_tela="+id+"\r\n" + 
				"				ORDER BY alt_disenio_lookup.nombre_lookup").getResultList();
		return re;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object[]> ComposicionForroMN(Long id) {
		List<Object[]> re= em.createNativeQuery("Select alt_disenio_familia_composicion_forro.composicion, \r\n" + 
				"alt_disenio_lookup.id_lookup, \r\n" + 
				"alt_disenio_lookup.nombre_lookup \r\n" + 
				"				from alt_disenio_familia_composicion_forro , alt_disenio_lookup \r\n" + 
				"				where alt_disenio_lookup.id_lookup=alt_disenio_familia_composicion_forro.id_familia_composicion \r\n" + 
				"				and alt_disenio_familia_composicion_forro.id_forro="+id+"\r\n" + 
				"				and alt_disenio_lookup.estatus=1\r\n" + 
				"				ORDER BY alt_disenio_lookup.nombre_lookup ").getResultList();
		return re;
	}


	@Override
	@Transactional
	public void borrarBotonesTela(Long id) {
		// TODO Auto-generated method stub
		Query query = em.createNativeQuery("DELETE FROM alt_disenio_material_tela WHERE alt_disenio_material_tela.id_tela="+id);
		
		query.executeUpdate();
		
	}


	@Override
	@Transactional
	public void borrarForroTela(Long id) {
		// TODO Auto-generated method stub
		Query query = em.createNativeQuery("DELETE FROM alt_disenio_tela_forro WHERE alt_disenio_tela_forro.id_tela="+id);
		
		query.executeUpdate();
		
	}


	@Override
	@Transactional
	public void borrarComposicionTela(Long id) {
		// TODO Auto-generated method stub
		Query query = em.createNativeQuery("DELETE FROM alt_disenio_familia_composicion_tela WHERE alt_disenio_familia_composicion_tela.id_tela="+id);
		
		query.executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object []> BonotesSeleccionados(Long id) {
		List<Object[]> re= em.createNativeQuery("select alt_disenio_material_tela.id_material, alt_disenio_material.nombre_material\r\n" + 
				"from alt_disenio_material_tela,alt_disenio_material\r\n" + 
				"where 1=1\r\n" + 
				"and alt_disenio_material_tela.id_material=alt_disenio_material.id_material\r\n" + 
				"and alt_disenio_material_tela.id_tela="+id).getResultList();
		return re;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object []> ForrosSeleccionados(Long id) {
		// TODO Auto-generated method stub
		
		
		List<Object[]> re= em.createNativeQuery("select tf.id_forro, CONCAT(forro.id_text,' ',forro.nombre_forro,' ', forro.color) As inf from \r\n" + 
				"						alt_disenio_tela_forro  as tf ,alt_disenio_forro as forro\r\n" + 
				"						where 1=1\r\n" + 
				"						and tf.id_forro=forro.id_forro\r\n" + 
				"						and forro.estatus=1\r\n" + 
				"						and forro.estatus_forro=1\r\n" + 
				"						and tf.id_tela="+id+"\r\n" + 
				"						ORDER BY inf").getResultList();
		return re;
	}

	@Override
	public void saveTelaPrenda(DisenioTelaPrenda telaPrenda) {
		// TODO Auto-generated method stub
		repositoryTelaPrenda.save(telaPrenda);
	}
	
	@Override
	@Transactional
	public void borrarTelaPrenda(Long id) {
		// TODO Auto-generated method stub
		Query query = em.createNativeQuery("DELETE FROM alt_disenio_tela_prenda WHERE alt_disenio_tela_prenda.id_tela="+id);
		
		query.executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object[]> VistaTelaPrenda(Long id) {
		List<Object[]> re= em.createNativeQuery("select tp.id_prenda, l.nombre_lookup  from alt_disenio_tela_prenda as tp , alt_disenio_lookup as l\r\n" + 
				"				where 1=1 \r\n" + 
				"				and tp.id_prenda= l.id_lookup\r\n" + 
				"				and l.estatus=1\r\n" + 
				"				and tp.id_tela="+id+"\r\n" + 
				"				ORDER BY l.nombre_lookup").getResultList();
		return re;
	}
	@Override
	public Object findPrendaById(Long id){
		return em.createNativeQuery("SELECT adt.id_text,adt.nombre_tela,adl1.nombre_lookup n1,adt.ancho,adt.costo_por_metro,adt.estampado,adt.color,adt.codigo_color,adl3.nombre_lookup n2,adt.indicacion FROM alt_disenio_tela adt INNER JOIN alt_disenio_lookup adl1 ON	adl1.id_lookup = adt.id_familia_composicion AND adl1.tipo_lookup = 'Familia Composicion' LEFT JOIN alt_disenio_lookup adl2 ON adl2.id_lookup=adt.id_proveedor AND adl2.tipo_lookup='Marca' LEFT	 JOIN alt_disenio_lookup adl3 on adl3.id_lookup=adt.id_unidad_medida and adl3.tipo_lookup='Unidad Medida' where adt.id_tela="+id).getSingleResult();
	}
}


