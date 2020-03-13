package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.models.entity.DisenioPruebaContaminacion;

public interface IDisenioPruebaContaminacionService {

	List<DisenioPruebaContaminacion> findAll();

	void save(DisenioPruebaContaminacion diseniopruebacontaminacion);

	void delete(Long id);

	DisenioPruebaContaminacion findOne(Long id);

}
