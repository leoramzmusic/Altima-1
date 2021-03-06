package com.altima.springboot.app.models.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altima.springboot.app.dto.ChangePasswordForm;
import com.altima.springboot.app.models.entity.Rol;
import com.altima.springboot.app.models.entity.Usuario;
import com.altima.springboot.app.repository.UsuarioRepository;


@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired	
	private UsuarioRepository usuario;
	@PersistenceContext
	private EntityManager em;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public String mensajeError;
	
	@Override
	@Transactional(readOnly=true)
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuario.findAll();
	}
	
	@Override
	@Transactional
	public void save(Usuario usuarioxd,ChangePasswordForm form) throws Exception{
		// TODO Auto-generated method stub

		if( !form.getNewPassword().equals(form.getConfirmPassword())) {
			mensajeError=("Nueva Contraseña y Confirmar Contraseña no coinciden.");
			throw new Exception("Nueva Contraseña y Confirmar Contraseña no coinciden.");
		}
		if(usuarioxd.getIdUsuario()==null) {
			String encodePassword = passwordEncoder.encode(form.getNewPassword());
			usuarioxd.setContraseña(encodePassword);
		}
		else {
			Usuario usuario = findOne(usuarioxd.getIdUsuario());
			mapUser(usuario,usuarioxd);
		}
		usuario.save(usuarioxd);
		}
	protected void mapUser(Usuario from, Usuario to) {
		//to.setNombreUsuario(from.getNombreUsuario());
		//to.setFirstName(from.getFirstName());
		//to.setLastName(from.getLastName());
		//to.setEmail(from.getEmail());
		//to.setIdEmpleado(from.getIdEmpleado());
		to.setContraseña(from.getContraseña());
		//to.setEstatus(from.getEstatus());
	}
	
	@Override
	@Transactional
	public void delete(Long id_usuario) {
		// TODO Auto-generated method stub
		usuario.deleteById(id_usuario);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Usuario findOne(Long id_usuario) {
		// TODO Auto-generated method stub
		return usuario.findById(id_usuario).orElse(null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findUserRol() {
		// TODO Auto-generated method stub
		return em.createNativeQuery("call alt_pr_usuarios").getResultList();
	}
	@Override
	public Usuario changePassword(ChangePasswordForm form) throws Exception {
		Usuario user  = findOne(form.getId());
		
		/*
		 * if( !user.getContraseña().equals(form.getCurrentPassword())) { throw new
		 * Exception("Currente Password invalido."); }
		 */
		
		if( passwordEncoder.matches(form.getNewPassword(), user.getContraseña())) {
			mensajeError=("Nueva Contraseña debe ser diferente a la contraseña actual.");
			throw new Exception("Nueva Contraseña debe ser diferente a la contraseña actual.");
		}
		
		if( !form.getNewPassword().equals(form.getConfirmPassword())) {
			mensajeError=("Nueva Contraseña y Confirmar Contraseña no coinciden.");
			throw new Exception("Nueva Contraseña y Confirmar Contraseña no coinciden.");
		}
		
		String encodePassword = passwordEncoder.encode(form.getNewPassword());
		user.setContraseña(encodePassword);
		return usuario.save(user);
	}
	@Override
	public String getMensajeError() {
		return mensajeError;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object[]> FindRolesByUserId(Long id){
		return em.createNativeQuery("SELECT roles.nombre_rol, roles.departamento_rol, roles.seccion_rol FROM alt_hr_usuario_rol AS roluser\r\n" + 
										"INNER JOIN alt_hr_rol roles ON roluser.id_rol = roles.id_rol\r\n" + 
										"WHERE roluser.id_usuario ="+id+"\r\n" + 
											"GROUP BY roles.seccion_rol\r\n" + 
											"ORDER BY roles.departamento_rol, roles.seccion_rol").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object[]> FindPermisosByUserId(Long id){
		return em.createNativeQuery("SELECT roles.id_rol, roles.seccion_rol, roles.permiso_rol  FROM alt_hr_usuario_rol AS roluser \r\n" + 
				"INNER JOIN alt_hr_rol roles ON roluser.id_rol = roles.id_rol\r\n" + 
				"WHERE roluser.id_usuario ="+id).getResultList();
	}

}
