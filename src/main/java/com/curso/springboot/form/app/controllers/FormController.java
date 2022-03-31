package com.curso.springboot.form.app.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.curso.springboot.form.app.editors.CapitalizeEditor;
import com.curso.springboot.form.app.editors.CountryPropertyEditor;
import com.curso.springboot.form.app.editors.RolesEditor;
import com.curso.springboot.form.app.models.domain.Country;
import com.curso.springboot.form.app.models.domain.Role;
import com.curso.springboot.form.app.models.domain.Usuario;
import com.curso.springboot.form.app.services.CountryService;
import com.curso.springboot.form.app.services.RoleService;
import com.curso.springboot.form.app.validation.UsuarioValidador;

@Controller
@SessionAttributes("usuario")
public class FormController {

	@Autowired
	private UsuarioValidador validador;

	@Autowired
	private CountryService countryService;
	
	@Autowired
	private RoleService roleService;

	@Autowired
	private CountryPropertyEditor countryEditor;
	
	@Autowired
	private RolesEditor roleEditor;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validador);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(String.class, "username", new CapitalizeEditor());
		binder.registerCustomEditor(String.class, "name", new CapitalizeEditor());
		binder.registerCustomEditor(String.class, "lastname", new CapitalizeEditor());
		binder.registerCustomEditor(Country.class, "country", countryEditor);
		binder.registerCustomEditor(Role.class, "roles", roleEditor);
	}

	@ModelAttribute("countriesList")
	public List<Country> countriesList() {
		return countryService.listar();
	}

	@ModelAttribute("countries")
	public List<String> countries() {
		return Arrays.asList("España", "México", "Canada", "Estados Unidos", "Chile", "Argentina", "Colombia");
	}

	@ModelAttribute("countriesMap")
	public Map<String, String> countriesMap() {

		Map<String, String> countries = new HashMap<String, String>();

		countries.put("ES", "España");
		countries.put("MX", "México");
		countries.put("CN", "Canada");
		countries.put("US", "Estados Unidos");
		countries.put("CH", "Chile");
		countries.put("AR", "Argentina");
		countries.put("CO", "Colombia");

		return countries;
	}
	
	@ModelAttribute("rolesList")
	public List<Role> rolesList() {
		return roleService.listar();
	}

	@ModelAttribute("rolesListString")
	public List<String> rolesListString() {
		ArrayList<String> roles = new ArrayList<>();
		roles.add("ROLE_ADMIN");
		roles.add("ROLE_MODERATOR");
		roles.add("ROLE_USER");

		return roles;
	}
	
	@ModelAttribute("rolesListMap")
	public Map<String, String> rolesListMap() {

		Map<String, String> roles = new HashMap<String, String>();

		roles.put("ROLE_ADMIN", "Administrator");
		roles.put("ROLE_MODERATOR", "Moderator");
		roles.put("ROLE_USER", "User");

		return roles;
	}

	@GetMapping("/form")
	public String form(Model model) {

		Usuario usuario = new Usuario();
		usuario.setName("Diego");
		usuario.setLastname("Dominguez");
		usuario.setEmail("ddominguez@gmail.com");
		usuario.setIdentifier("23.456.789-D");

		model.addAttribute("titulo", "Create user");
		model.addAttribute("usuario", usuario);
		return "form";
	}

	@PostMapping("/form")
	// BindingResult result SIEMPRE se ubica al lado del objeto que se valida
	public String procesar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {

		// validador.validate(usuario, result);

		if (result.hasErrors()) {

			model.addAttribute("titulo", "Create user");

			/*
			 * Map<String, String> errores = new HashMap<>();
			 * result.getFieldErrors().forEach(err -> { errores.put(err.getField(),
			 * "El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()
			 * )); });
			 * 
			 * model.addAttribute("error", errores);
			 */

			return "form";
		}

		model.addAttribute("titulo", " Form result");
		model.addAttribute("usuario", usuario);
		status.setComplete();
		return "resultado";
	}
}
