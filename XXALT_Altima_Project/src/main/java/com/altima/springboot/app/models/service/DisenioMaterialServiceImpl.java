
package com.altima.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altima.springboot.app.models.entity.DisenioLookup;
import com.altima.springboot.app.models.entity.DisenioMaterial;
//import com.altima.springboot.app.models.entity.DisenioProceso;
import com.altima.springboot.app.repository.DisenioMaterialRepository;

@Service
public class DisenioMaterialServiceImpl implements IDisenioMaterialService {
	@Autowired
	private DisenioMaterialRepository repository;
	
	@Autowired
	private EntityManager em;
	
	@Override
	@Transactional(readOnly = true)
	public List<DisenioMaterial> findAll() {
		// TODO Auto-generated method stub
		return (List<DisenioMaterial>) repository.findAll();
	}
	
	@Override
	@Transactional
	public void save(DisenioMaterial diseniomaterial) {
		// TODO Auto-generated method stub
		repository.save(diseniomaterial);
		
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
	@Override
	@Transactional
	public DisenioMaterial findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisenioLookup> findListaLookupMat() {
		
		return em.createQuery(
				"SELECT idLookup, nombreLookup, tipoLookup FROM DisenioLookup WHERE tipoLookup= 'Material' and   estatus=1 order by nombreLookup")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisenioLookup> findListaLookupMed() {
		
		return em.createQuery(
				"SELECT idLookup, nombreLookup, tipoLookup FROM DisenioLookup WHERE tipoLookup= 'Unidad Medida' and   estatus=1 order by nombreLookup")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisenioLookup> findListaMarcas() {
		
		return em.createQuery(
				"SELECT idLookup, nombreLookup, tipoLookup FROM DisenioLookup WHERE tipoLookup= 'Marca' and   estatus=1 order by nombreLookup")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisenioLookup> findListaClasificacion() {
		
		return em.createQuery(
				"SELECT idLookup, nombreLookup, tipoLookup FROM DisenioLookup WHERE tipoLookup= 'Clasificacion' and   estatus=1 order by nombreLookup")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> disenioMaterial() {
		
		List<Object[]> mv;
		mv = em.createNativeQuery("{call  alt_pr_materiales}").getResultList();
		return mv;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DisenioLookup> findLookUps() {
		// TODO Auto-generated method stub
		return em.createNativeQuery("SELECT * FROM alt_disenio_lookup WHERE tipo_lookup = 'Pieza Trazo' AND estatus = 1 ;")
				.getResultList();
	}
	
	@Override
	public Object findLookUp(Long id) {
		// TODO Auto-generated method stubString
		return (Object) em
				.createNativeQuery("SELECT * FROM alt_disenio_lookup WHERE tipo_lookup = 'Pieza Trazo' AND id_lookup = " + id
						+ " order by nombre_lookup")
				.getSingleResult();
	}
	
	@Override
	public Object findUno(Long id) {
		// TODO Auto-generated method stub
		return em.createNativeQuery("call alt_pr_onematerial(" + id + ");").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DisenioMaterial> findAllForCreate() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT idMaterial, nombreMaterial FROM DisenioMaterial WHERE estatus = 1").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisenioLookup> findListaColor() {
		
		return em.createQuery(
				"SELECT idLookup, nombreLookup, tipoLookup,atributo1 FROM DisenioLookup WHERE tipoLookup= 'Color' and   estatus=1 order by nombreLookup")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisenioLookup> findListaLookupPro() {
		
		return em.createQuery(
				"SELECT idLookup, nombreLookup, tipoLookup FROM DisenioLookup WHERE tipoLookup= 'Proceso' and   estatus=1 order by nombreLookup")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DisenioMaterial> findAllFromPrenda(Long id) {
		// TODO Auto-generated method stub
		return em.createNativeQuery("call alt_pr_materials_from_prenda(" + id + ");").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DisenioLookup> findAllPatronajeFromPrenda(Long id) {
		// TODO Auto-generated method stub
		return em.createNativeQuery("call alt_pr_patronajes_from_prenda(" + id + ");").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DisenioLookup> findAllFamiliaPrenda() {
		// TODO Auto-generated method stub
		return em.createQuery(
				"SELECT idLookup, nombreLookup, tipoLookup FROM DisenioLookup WHERE tipoLookup= 'Familia Prenda' and   estatus=1 order by nombreLookup")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findAllByTipoMaterial(Long id) {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT idMaterial, nombreMaterial FROM DisenioMaterial WHERE idTipoMaterial=" + id
				+ " AND estatus = 1 order by nombreMaterial").getResultList();
	}
	
	@Override
	public Object findByIdMaterial(Long id) {
		// TODO Auto-generated method stub
		return em.createNativeQuery(
				"Select adm.id_text,adm.nombre_material,adl5.nombre_lookup nl6,ifnull(adl6.nombre_lookup,'Sin color') nl1,adm.tamanio,adl2.nombre_lookup nl2,adm.modelo,adl1.nombre_lookup nl3,adm.precio_unitario,adl4.nombre_lookup nl4,adl3.nombre_lookup nl5,adm.descripcion_material,ifnull(adl6.atributo_1,'#ffffff') from alt_disenio_material adm INNER JOIN alt_disenio_lookup adl1 on adm.id_proceso=adl1.id_lookup and adl1.tipo_lookup='Proceso' INNER JOIN alt_disenio_lookup adl2 on adm.id_unidad_medida=adl2.id_lookup and adl2.tipo_lookup='Unidad Medida' INNER JOIN alt_disenio_lookup adl3 on adm.id_marca=adl3.id_lookup and adl3.tipo_lookup='Marca' INNER JOIN alt_disenio_lookup adl4 on adm.id_clasificacion=adl4.id_lookup and adl4.tipo_lookup='Clasificación' INNER JOIN alt_disenio_lookup adl5 on adm.id_tipo_material=adl5.id_lookup and adl5.tipo_lookup='Material' LEFT JOIN alt_disenio_lookup adl6 on adm.id_color=adl6.id_lookup and adl6.tipo_lookup='Color' where adm.id_material="
						+ id)
				.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findLastMaterial(Long tipo_material) {
		
		return em.createNativeQuery("call alt_idtextprospecto_material('" + tipo_material + "');").getResultList();
		
	}
	
}
