package com.altima.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altima.springboot.app.models.entity.ControlHora;
import com.altima.springboot.app.models.entity.ControlProduccionMuestra;
import com.altima.springboot.app.repository.ControlHoraRepository;
import com.altima.springboot.app.repository.ControlProduccionMuestraRepository;

@Service
public class ControlProduccionMuestraServiceImpl implements IControlProduccionMuestraService {
	//vhhbj
	//cgvhbjnk
	@Autowired 
	private ControlProduccionMuestraRepository repository;
	
	@Autowired 
	private ControlHoraRepository repositoryHora;
	
	 @PersistenceContext
	private EntityManager em;
	 @SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<ControlProduccionMuestra> findAll(Long id) {
		
		return em.createQuery("from DisenioControlProduccionMuestra where id_pedido="+id).getResultList();
	}

	@Override
	public void save(ControlProduccionMuestra DisenioControlProduccionMuestra) {
		// TODO Auto-generated method stub
		repository.save(DisenioControlProduccionMuestra);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public ControlProduccionMuestra findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object []> Operadores() {
		// TODO Auto-generated method stub
		
		
		List<Object[]> re= em.createNativeQuery("select empleado.id_empleado,  CONCAT( persona.nombre_persona,' ',  persona.apellido_paterno) as nombre from alt_hr_empleado as empleado, alt_hr_persona as persona \r\n" + 
				"				where 1=1\r\n" + 
				"				and empleado.id_persona= persona.id_persona\r\n" + 
				"				and empleado.id_puesto=1\r\n" + 
				"                ORDER BY persona.nombre_persona").getResultList();
		return re;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object []> OperacionesTrazo(Long id) {
		// TODO Auto-generated method stub
		List<Object[]> re= em.createNativeQuery("select persona.nombre_persona , Date_format(muestra.fecha_recepcion,'%Y/%M/%d %h:%i:%s %p'),Date_format(muestra.fecha_entrega,'%Y/%M/%d %h:%i:%s %p'), TIMESTAMPDIFF(DAY, muestra.fecha_recepcion, muestra.fecha_entrega), muestra.id_control_produccion_muestra, muestra.estatus_tiempo\r\n" + 
				"				from alt_hr_empleado as empleado, alt_control_produccion_muestra  as muestra, alt_hr_persona as persona \r\n" + 
				"				where 1=1\r\n" + 
				"				and empleado.id_empleado=muestra.id_operario \r\n" + 
				"				and empleado.id_persona=persona.id_persona \r\n" + 
				"				and muestra.tipo=1 \r\n" + 
				
				"				and muestra.id_pedido="+id).getResultList();
		return re;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object[]> OperacionesCorte(Long id) {
		// TODO Auto-generated method stub
		List<Object[]> re= em.createNativeQuery("select persona.nombre_persona , Date_format(muestra.fecha_recepcion,'%Y/%M/%d %h:%i:%s %p'),Date_format(muestra.fecha_entrega,'%Y/%M/%d %h:%i:%s %p'), TIMESTAMPDIFF(DAY, muestra.fecha_recepcion, muestra.fecha_entrega), muestra.id_control_produccion_muestra, muestra.estatus_tiempo\r\n" + 
				"from alt_hr_empleado as empleado, alt_control_produccion_muestra  as muestra, alt_hr_persona as persona\r\n" + 
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
				"from alt_hr_empleado as empleado, alt_control_produccion_muestra  as muestra, alt_hr_persona as persona\r\n" + 
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
				"from alt_hr_empleado as empleado, alt_control_produccion_muestra  as muestra, alt_hr_persona as persona\r\n" + 
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
				"from alt_hr_empleado as empleado, alt_control_produccion_muestra  as muestra, alt_hr_persona as persona\r\n" + 
				"where 1=1\r\n" + 
				"and empleado.id_empleado=muestra.id_operario\r\n" + 
				"and empleado.id_persona=persona.id_persona\r\n" + 
				"and muestra.tipo=5\r\n" + 
				
				"and muestra.id_pedido="+id).getResultList();
		return re;
	}

	@Override
	public void saveHora(ControlHora DisenioControlHora) {
		// TODO Auto-generated method stub
		repositoryHora.save(DisenioControlHora);
		
	}
	
	@Override
	public ControlHora findOneHora(Long id) {
		// TODO Auto-generated method stub
		return repositoryHora.findById(id).orElse(null);
	}
	

	@Transactional(readOnly=true)
	@Override
	public Integer Pausa(Long id) {
		
		System.out.println("SSoy pausa del service ");
		Integer re =(Integer) em.createNativeQuery("select   MAX(alt_control_hora.id_control_hora) from alt_control_hora\r\n" + 
				"where  alt_control_hora.estatus=\"Play\"\r\n" + 
				"and  alt_control_hora.id_control_produccion_muestra="+id).getSingleResult();
		return re;
	
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object[]> ContadorHoras(Long id) {
		List<Object[]> re= em.createNativeQuery("SELECT hora.id_control_hora, Date_format( hora.fecha_inicio,'%Y/%M/%d %h:%i:%s %p'),  IFNULL(Date_format( hora.fecha_fin,'%Y/%M/%d %h:%i:%s %p'),'En proceso') , \r\n" + 
				"								CASE\r\n" + 
				"									WHEN hora.tipo = 1 THEN 'Trazo' \r\n" + 
				"								    WHEN hora.tipo = 2 THEN 'Corte' \r\n" + 
				"								    WHEN hora.tipo = 3 THEN 'Confección' \r\n" + 
				"								    WHEN hora.tipo = 4 THEN 'Planchado'\r\n" + 
				"								    WHEN hora.tipo = 5 THEN 'Terminado'  \r\n" + 
				"								    ELSE 'Null'\r\n" + 
				"								END  ,    \r\n" + 
				"                                IFNULL( \r\n" + 
				"                                     IF( TIMESTAMPDIFF (HOUR,hora.fecha_inicio, hora.fecha_fin )  =0, \r\n" + 
				"                                        CONCAT( TIMESTAMPDIFF (  MINUTE,hora.fecha_inicio, hora.fecha_fin ),' Minutos'), \r\n" + 
				"                                  		CONCAT( TIMESTAMPDIFF (HOUR,hora.fecha_inicio, hora.fecha_fin ),' Horas')),'En proceso') as tiempo,\r\n" + 
				"                                        hora.estatus \r\n" + 
				"								from alt_control_hora as hora ,alt_control_produccion_muestra as muestra \r\n" + 
				"								where 1=1\r\n" + 
				"								and muestra.id_control_produccion_muestra= hora.id_control_produccion_muestra\r\n" + 
				"								and muestra.id_pedido="+id).getResultList();
		return re;
	}
	
	//njjjj
	
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object[]> ListarPedidos() {
		List<Object[]> re= em.createNativeQuery("select\r\n" + 
				"	pedido.id_pedido,\r\n" + 
				"	pedido.id_text,\r\n" + 
				"	pedido.fecha_creacion_pedido, \r\n" + 
				"	pedido.descripcion_pedido, \r\n" + 
				"	( IFNULL((select(CASE \r\n" + 
				"						WHEN muestra.tipo = 1 THEN 'Trazo' \r\n" + 
				"						WHEN muestra.tipo = 2 THEN 'Corte' \r\n" + 
				"						WHEN muestra.tipo = 3 THEN 'Confección' \r\n" + 
				"						WHEN muestra.tipo = 4 THEN 'Planchado' \r\n" + 
				"						WHEN muestra.tipo = 5 THEN 'Terminado' \r\n" + 
				"						ELSE 'Nuevo' \r\n" + 
				"						END  )from alt_control_produccion_muestra as muestra where muestra.estatus_tiempo ='Play' and muestra.id_pedido= pedido.id_pedido  LIMIT 1), 'Sin proceso asignado')) as proceso \r\n" + 
				"	from alt_pedido as pedido").getResultList();
		return re;
	}
}