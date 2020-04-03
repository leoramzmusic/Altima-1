package com.altima.springboot.app.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.altima.springboot.app.dto.ChangePasswordForm;
import com.altima.springboot.app.models.entity.Rol;
import com.altima.springboot.app.models.entity.Usuario;
import com.altima.springboot.app.models.service.IHrEmpleadoService;
import com.altima.springboot.app.models.service.IRolService;
import com.altima.springboot.app.models.service.IUsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	IRolService rolService;
	@Autowired
	IUsuarioService usuarioService;
	@Autowired
	IHrEmpleadoService empleadoService;

	@GetMapping("/administracion_usuarios")
	public String login(Model model, RedirectAttributes flash) {

		model.addAttribute("usuarios", usuarioService.findUserRol());

		return "administracion_usuarios";
	}

	@GetMapping("/agregar_usuario")
	public String getUser(Model model, Map<String, Object> m) {
		List<String> roles = new ArrayList<String>();
		Usuario usuario = new Usuario();
		m.put("passwordForm",new ChangePasswordForm());
		m.put("usuario", usuario);
		for (Rol r : rolService.findAll()) {
			roles.add(r.getDescripcionRol());
		}
		
		model.addAttribute("empleados", empleadoService.findEmpleadoPersona());
		model.addAttribute("usuarios", null);
		model.addAttribute("permiso_material", rolService.findBySeccionRol("MATERIALES").get(0));
		model.addAttribute("permiso_material_id", rolService.findBySeccionRol("MATERIALES").get(1));
		model.addAttribute("departamento", roles);
		return "agregar_usuario";
	}

	@PostMapping("agregar_usuario")
	public String postUser(Model model, Map<String, Object> m, Usuario usuario,
			@RequestParam(name = "rol_value", required = false) String rol_value,
			@RequestParam(name = "pass", required = false) String pass) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		for(String rol_split:rol_value.split(",")){
			usuario.getRoles().add(rolService.findOne(Long.parseLong(rol_split)));
		}
		usuario.setIdText("Id");
		usuario.setCreadoPor(auth.getName());
		usuarioService.save(usuario);
		usuario.setIdText("user_" + (1000 + usuario.getIdUsuario()));
		usuarioService.save(usuario);


		return "redirect:/administracion_usuarios";
	}
	
	@GetMapping("/editar_usuario/{id}")
	public String patchUser(Model model, Map<String, Object> m,@PathVariable Long id,RedirectAttributes redirectAttrs) {
		List<String> roles = new ArrayList<String>();
		Usuario usuario = new Usuario();
		usuario=usuarioService.findOne(id);
		
		m.put("usuario", usuario);
		m.put("passwordForm",new ChangePasswordForm(usuario.getIdUsuario()));
		for (Rol r : rolService.findAll()) {
			roles.add(r.getDescripcionRol());
		}
		model.addAttribute("empleados", empleadoService.findEmpleadoPersona());
		model.addAttribute("roles", roles);
		model.addAttribute("usuarios", usuario);
		model.addAttribute("permiso_material", rolService.findBySeccionRol("MATERIALES").get(0));
		model.addAttribute("permiso_material_id", rolService.findBySeccionRol("MATERIALES").get(1));
		model.addAttribute("departamento", roles);
		System.out.println("hola");
		
		return "agregar_usuario";
	}
	@PostMapping("/editar_contra")
	public String patchContraseña(Model model,ChangePasswordForm passwordForm, Errors errors,RedirectAttributes redirectAttrs) {
		System.out.println("jalo alv"+" "+passwordForm.getConfirmPassword());

			try {
				usuarioService.changePassword(passwordForm);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				redirectAttrs.addFlashAttribute("title", usuarioService.getMensajeError()).addFlashAttribute("icon", "error");
				return "redirect:/editar_usuario/"+passwordForm.getId();
			}
			
		return "redirect:/administracion_usuarios";
	}
	

}