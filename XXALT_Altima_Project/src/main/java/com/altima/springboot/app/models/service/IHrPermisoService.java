package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.models.entity.HrPermiso;

public interface IHrPermisoService {

	List<HrPermiso> findAll();

	void save(HrPermiso hrpermiso);

	void delete(Long id);

	HrPermiso findOne(Long id);

}
