package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.models.entity.DisenioLookup;

public interface ICatalogoService {

	List<DisenioLookup> findAll();

	void save(DisenioLookup diseniolookup);

	void delete(Long id);

	DisenioLookup findOne(Long id);

	List<DisenioLookup> findAllColor();

	List<DisenioLookup> findAllMarca();

	List<DisenioLookup> findAllPzasTrazo();

	List<DisenioLookup> findAllFamPrendas();

	List<DisenioLookup> findAllFamGenero();

	List<DisenioLookup> findAllFamComposicion();

	List<DisenioLookup> findAllInstrCuidado();

	List<DisenioLookup> findAllUnidadMedida();

	List<DisenioLookup> findAllMaterial();

	List<DisenioLookup> findAllMarcador();

	List<DisenioLookup> findAllComposicion();

	DisenioLookup findLastComposicion();

	DisenioLookup findLastMarcador();

	DisenioLookup findLastMaterial();

	DisenioLookup findLastUnidadMedida();

	DisenioLookup findLastInstrCuidado();

	DisenioLookup findLastFamComposicion();

	DisenioLookup findLastFamGenero();

	DisenioLookup findLastFamPrendas();

	DisenioLookup findLastPzasTrazo();

	DisenioLookup findLastColor();

}
