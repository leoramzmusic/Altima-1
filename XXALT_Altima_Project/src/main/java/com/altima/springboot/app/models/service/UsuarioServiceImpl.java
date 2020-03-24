package com.altima.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Override
	@Transactional(readOnly=true)
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuario.findAll();
	}
	
	@Override
	@Transactional
	public void save(Usuario usuarioxd) {
		// TODO Auto-generated method stub
		if(usuarioxd.getIdUsuario()==null) {
		usuarioxd.setContraseña(passwordEncoder.encode(usuarioxd.getContraseña()));
		}
		usuario.save(usuarioxd);
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
}
