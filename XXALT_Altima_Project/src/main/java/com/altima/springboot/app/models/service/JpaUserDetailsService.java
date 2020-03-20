package com.altima.springboot.app.models.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altima.springboot.app.models.entity.Rol;
import com.altima.springboot.app.models.entity.Usuario;
import com.altima.springboot.app.repository.UsuarioRepository;


@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService{

	@Autowired
	private UsuarioRepository repository;
	
	private Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class);
	String x=null;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
        Usuario usuario = repository.findBynombreUsuario(username);
        
        if(usuario == null) {
        	x="Usuario no encontrado";
        	logger.error("Usuario no encontrado");
        	throw new UsernameNotFoundException("Usuario no encontrado");
        }
        
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        
        for(Rol role: usuario.getRoles()) {
        	logger.info("Role: ".concat(role.getDescripcionRol()));
        	authorities.add(new SimpleGrantedAuthority(role.getDescripcionRol()));
        }
        if(usuario.getEstatus().equals("0")||usuario.getEstatus()==null) {
        	x="Usuario no activo";
        	logger.error("Usuario no activo");
        	throw new UsernameNotFoundException("Usuario no activo");
        }
        if(authorities.isEmpty()) {
        	x="Acceso denegado";
        	logger.error("Acceso denegado");
        	throw new UsernameNotFoundException("Acceso denegado");
        }
        x=null;
		return new User(usuario.getNombreUsuario(), usuario.getContraseña(), authorities);
	}

	public String getX() {
		
		return x;
	}

}
