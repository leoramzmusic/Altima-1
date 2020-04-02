package com.altima.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altima.springboot.app.models.entity.DisenioControlHora;
import com.altima.springboot.app.models.entity.DisenioControlProduccionMuestra;
import com.altima.springboot.app.repository.DisenioControlHoraRepository;
import com.altima.springboot.app.repository.DisenioControlProduccionMuestraRepository;

@Service
public class DisenioControlProduccionMuestraServiceImpl implements IDisenioControlProduccionMuestraService {
	//vhhbj
	//cgvhbjnk
	@Autowired 
	private DisenioControlProduccionMuestraRepository repository;
	
	@Autowired 
	private DisenioControlHoraRepository repositoryHora;
	
	 @PersistenceContext
	private EntityManager em;
	 @SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisenioControlProduccionMuestra> findAll(Long id) {
		
		return em.createQuery("from DisenioControlProduccionMuestra where id_pedido="+id).getResultList();
	}

	@Override
	public void save(DisenioControlProduccionMuestra DisenioControlProduccionMuestra) {
		// TODO Auto-generated method stub
		repository.save(DisenioControlProduccionMuestra);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public DisenioControlProduccionMuestra findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object []> Operadores() {
		// TODO Auto-generated method stub
		
		
		List<Object[]> re= em.createNativeQuery("select empleado.id_empleado, persona.nombre_persona from alt_hr_empleado as empleado, alt_hr_persona as persona \r\n" + 
				"where 1=1 \r\n" + 
				"and empleado.id_persona= persona.id_persona\r\n" + 
				"and empleado.id_puesto=1").getResultList();
		return re;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object []> OperacionesTrazo(Long id) {
		// TODO Auto-generated method stub
		List<Object[]> re= em.createNativeQuery("select persona.nombre_persona , Date_format(muestra.fecha_recepcion,'%Y/%M/%d %h:%i:%s %p'),Date_format(muestra.fecha_entrega,'%Y/%M/%d %h:%i:%s %p'), TIMESTAMPDIFF(DAY, muestra.fecha_recepcion, muestra.fecha_entrega), muestra.id_control_produccion_muestra, muestra.estatus_tiempo\r\n" + 
				"from alt_hr_empleado as empleado, alt_disenio_control_produccion_muestra  as muestra, alt_hr_persona as persona\r\n" + 
				"where 1=1\r\n" + 
				"and empleado.id_empleado=muestra.id_operario\r\n" + 
				"and empleado.id_persona=persona.id_persona\r\n" + 
				"and muestra.tipo=1\r\n" + 
				"and muestra.id_pedido="+id).getResultList();
		return re;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object[]> OperacionesCorte(Long id) {
		// TODO Auto-generated method stub
		List<Object[]> re= em.createNativeQuery("select persona.nombre_persona , Date_format(muestra.fecha_recepcion,'%Y/%M/%d %h:%i:%s %p'),Date_format(muestra.fecha_entrega,'%Y/%M/%d %h:%i:%s %p'), TIMESTAMPDIFF(DAY, muestra.fecha_recepcion, muestra.fecha_entrega), muestra.id_control_produccion_muestra, muestra.estatus_tiempo\r\n" + 
				"from alt_hr_empleado as empleado, alt_disenio_control_produccion_muestra  as muestra, alt_hr_persona as persona\r\n" + 
				"where 1=1\r\n" + 
				"and empleado.id_empleado=muestra.id_operario\r\n" + 
				"and empleado.id_persona=persona.id_persona\r\n" + 
				"and muestra.tipo=2\r\n" + 
				"and muestra.id_pedido="+id).getResultList();
		return re;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object[]> OperacionesCofeccion(Long id) {
		// TODO Auto-generated method stub
		List<Object[]> re= em.createNativeQuery("select persona.nombre_persona , Date_format(muestra.fecha_recepcion,'%Y/%M/%d %h:%i:%s %p'),Date_format(muestra.fecha_entrega,'%Y/%M/%d %h:%i:%s %p'), TIMESTAMPDIFF(DAY, muestra.fecha_recepcion, muestra.fecha_entrega), muestra.id_control_produccion_muestra, muestra.estatus_tiempo\r\n" + 
				"from alt_hr_empleado as empleado, alt_disenio_control_produccion_muestra  as muestra, alt_hr_persona as persona\r\n" + 
				"where 1=1\r\n" + 
				"and empleado.id_empleado=muestra.id_operario\r\n" + 
				"and empleado.id_persona=persona.id_persona\r\n" + 
				"and muestra.tipo=3\r\n" + 
				"and muestra.id_pedido="+id).getResultList();
		return re;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object[]> OperacionesPlanchado(Long id) {
		// TODO Auto-generated method stub
		List<Object[]> re= em.createNativeQuery("select persona.nombre_persona , Date_format(muestra.fecha_recepcion,'%Y/%M/%d %h:%i:%s %p'),Date_format(muestra.fecha_entrega,'%Y/%M/%d %h:%i:%s %p'), TIMESTAMPDIFF(DAY, muestra.fecha_recepcion, muestra.fecha_entrega), muestra.id_control_produccion_muestra, muestra.estatus_tiempo\r\n" + 
				"from alt_hr_empleado as empleado, alt_disenio_control_produccion_muestra  as muestra, alt_hr_persona as persona\r\n" + 
				"where 1=1\r\n" + 
				"and empleado.id_empleado=muestra.id_operario\r\n" + 
				"and empleado.id_persona=persona.id_persona\r\n" + 
				"and muestra.tipo=4\r\n" + 
				"and muestra.id_pedido="+id).getResultList();
		return re;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object[]> OperacionesTerminado(Long id) {
		// TODO Auto-generated method stub
		List<Object[]> re= em.createNativeQuery("select persona.nombre_persona , Date_format(muestra.fecha_recepcion,'%Y/%M/%d %h:%i:%s %p'),Date_format(muestra.fecha_entrega,'%Y/%M/%d %h:%i:%s %p'), TIMESTAMPDIFF(DAY, muestra.fecha_recepcion, muestra.fecha_entrega), muestra.id_control_produccion_muestra, muestra.estatus_tiempo\r\n" + 
				"from alt_hr_empleado as empleado, alt_disenio_control_produccion_muestra  as muestra, alt_hr_persona as persona\r\n" + 
				"where 1=1\r\n" + 
				"and empleado.id_empleado=muestra.id_operario\r\n" + 
				"and empleado.id_persona=persona.id_persona\r\n" + 
				"and muestra.tipo=5\r\n" + 
				"and muestra.id_pedido="+id).getResultList();
		return re;
	}

	@Override
	public void saveHora(DisenioControlHora DisenioControlHora) {
		// TODO Auto-generated method stub
		repositoryHora.save(DisenioControlHora);
		
	}
	
	@Override
	public DisenioControlHora findOneHora(Long id) {
		// TODO Auto-generated method stub
		return repositoryHora.findById(id).orElse(null);
	}
	

	@Transactional(readOnly=true)
	@Override
	public Integer Pausa(Long id) {
		
		System.out.println("SSoy pausa del service ");
		Integer re =(Integer) em.createNativeQuery("select   MAX(alt_disenio_control_hora.id_control_hora) from alt_disenio_control_hora\r\n" + 
				"where  alt_disenio_control_hora.estatus=\"Play\"\r\n" + 
				"and  alt_disenio_control_hora.id_control_produccion_muestra="+id).getSingleResult();
		return re;
	
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object[]> ContadorHoras(Long id) {
		List<Object[]> re= em.createNativeQuery("SELECT hora.id_control_hora, Date_format( hora.fecha_inicio,'%Y/%M/%d %h:%i:%s %p'), Date_format( hora.fecha_fin,'%Y/%M/%d %h:%i:%s %p'),\r\n" + 
				"CASE\r\n" + 
				"	WHEN hora.tipo = 1 THEN 'Trazo'\r\n" + 
				"    WHEN hora.tipo = 2 THEN 'Corte'\r\n" + 
				"    WHEN hora.tipo = 3 THEN 'Confección'\r\n" + 
				"    WHEN hora.tipo = 4 THEN 'Planchado'\r\n" + 
				"    WHEN hora.tipo = 5 THEN 'Terminado'\r\n" + 
				"    ELSE 'null'\r\n" + 
				"END  ,TIMESTAMPDIFF (MINUTE,hora.fecha_inicio, hora.fecha_fin )  as tiempo, hora.estatus\r\n" + 
				"from alt_disenio_control_hora as hora ,alt_disenio_control_produccion_muestra as muestra\r\n" + 
				"where 1=1\r\n" + 
				"and muestra.id_control_produccion_muestra= hora.id_control_produccion_muestra\r\n" + 
				"\r\n" + 
				"and hora.id_control_produccion_muestra="+id).getResultList();
		return re;
	}

}
