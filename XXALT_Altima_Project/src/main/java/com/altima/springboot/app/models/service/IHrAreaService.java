package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.models.entity.HrArea;

public interface IHrAreaService {

	List<HrArea> findAll();

	void save(HrArea hrarea);

	void delete(Long id);

	HrArea findOne(Long id);

}
