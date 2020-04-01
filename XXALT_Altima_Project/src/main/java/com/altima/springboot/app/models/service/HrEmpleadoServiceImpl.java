package com.altima.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.altima.springboot.app.models.entity.HrEmpleado;
import com.altima.springboot.app.repository.HrEmpleadoRepository;


@Service
public class HrEmpleadoServiceImpl implements IHrEmpleadoService {
	@Autowired
	private HrEmpleadoRepository repository;
	@Autowired
	private EntityManager em;
	@Override
	@Transactional(readOnly=true)
	public List<HrEmpleado> findAll() {
		// TODO Auto-generated method stub
		return (List<HrEmpleado>) repository.findAll();
	}

	@Override
	@Transactional
	public void save(HrEmpleado hrempleado) {
		// TODO Auto-generated method stub
		repository.save(hrempleado);

	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public HrEmpleado findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object> findAllByPuesto(Long id) {
		// TODO Auto-generated method stub
		return em.createNativeQuery("select emp.id_empleado, per.nombre_persona, per.apellido_paterno, per.apellido_materno from \r\n" + 
									"(select id_empleado, id_persona from alt_hr_empleado where id_puesto = "+id+") as emp\r\n" + 
									"INNER JOIN alt_hr_persona per on emp.id_persona = per.id_persona").getResultList();
				
	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object> findEmpleadoPersona() {
		// TODO Auto-generated method stub
		return em.createQuery("Select idEmpleado,concat(hp.nombrePersona,' 'hp.apellidoPaterno,' ',hp.apellidoMaterno) from HrEmpleado he inner join HrPersona hp on hp.idPersona=he.idPersona").getResultList();
				
	
	}

}
