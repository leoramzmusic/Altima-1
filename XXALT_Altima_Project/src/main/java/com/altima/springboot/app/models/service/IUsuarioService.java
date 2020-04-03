package com.altima.springboot.app.models.service;

import java.util.List;

import com.altima.springboot.app.dto.ChangePasswordForm;
import com.altima.springboot.app.models.entity.Usuario;

public interface IUsuarioService {

	public List<Usuario> findAll();
	
	public List<Object[]> findUserRol();

	public void save(Usuario usuario);

	public void delete(Long id_usuario);

	public Usuario findOne(Long id_usuario);
	
	public String getMensajeError();
	
	Usuario changePassword(ChangePasswordForm form) throws Exception;

}
