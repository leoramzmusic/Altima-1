package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.models.entity.DisenioLookup;
import com.altima.springboot.app.models.entity.DisenioMaterial;


public interface IDisenioMaterialService {

	List<DisenioMaterial> findAll();

	void save(DisenioMaterial diseniomaterial);

	void delete(Long id);

	DisenioMaterial findOne(Long id);
	
	List<DisenioLookup> findListaLookupMat();
	
	List<DisenioLookup> findListaLookupMed();
	
	List<DisenioLookup> findListaMarcas();
	
	List<DisenioLookup> findListaClasificacion();
	
	public List <Object []> disenioMaterial ();
	
	List<DisenioLookup> findLookUps();
	
	Object findLookUp(Long id);
	
	Object findUno(Long id);
	
	List<DisenioMaterial> findAllForCreate();

	List<DisenioLookup> findListaColor();
	
	List<DisenioMaterial> findAllFromPrenda(Long id);
	
	List<DisenioLookup> findAllPatronajeFromPrenda(Long id);
	
	List<DisenioLookup> findAllFamiliaPrenda();
	
	List<DisenioLookup> findListaLookupPro();
	
	List<Object> findAllByTipoMaterial(Long id);

	Object findByIdMaterial(Long id);

	List<Object[]> findLastMaterial(Long tipo_material);
	

	public int count(Long id);
	
	public int count2(Long id);
	

	
	public String findunique(Long id);

}

