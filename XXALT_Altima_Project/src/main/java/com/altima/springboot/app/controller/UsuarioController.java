package com.altima.springboot.app.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.altima.springboot.app.models.entity.Rol;
import com.altima.springboot.app.models.entity.Usuario;
import com.altima.springboot.app.models.service.IRolService;
import com.altima.springboot.app.models.service.IUsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	IRolService rolService;
	@Autowired
	IUsuarioService usuarioService;
	
	@GetMapping("/administracion_usuarios")
	public String login(Model model, RedirectAttributes flash) {
			
		model.addAttribute("usuarios",usuarioService.findUserRol());
		
		return "administracion_usuarios";
	}
	
	@GetMapping("/agregar_usuario")
	public String getUser(Model model,Map<String, Object> m) {
			String[] roles ={"ADMINISTRADOR", "DISEÑO"};
			Usuario usuario= new Usuario();
			Rol rol =new Rol();
			m.put("usuario", usuario);
			m.put("rol", rol);
			model.addAttribute("roles",roles);
		return "agregar_usuario";
	}
	
	@PostMapping("agregar_usuario")
	public String postUser(Model model,Map<String, Object> m,Usuario usuario,Rol rol,
			@RequestParam(name="role", required=false) String role,
			@RequestParam(name="pass", required = false) String pass) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(role.equals("DISEÑO")) {
			role="DISENIO";
		}
		usuario.setIdText("Id");
		usuario.setCreadoPor(auth.getName());
		usuarioService.save(usuario);
		usuario.setIdText("user_"+(1000+usuario.getIdUsuario()));
		usuarioService.save(usuario);
		rol.setCreadoPor(auth.getName());
		rol.setNombreRol(role);
		rol.setDescripcionRol("ROLE_"+role);
		rol.setIdText("rol");
		rolService.save(rol);
		rol.setIdText("rol_"+(1000+rol.getIdRol()));
		rolService.save(rol);
		return "redirect:/administracion_usuarios";
}

}
