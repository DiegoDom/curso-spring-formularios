package com.curso.springboot.form.app.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.curso.springboot.form.app.models.domain.Usuario;

@Component
public class UsuarioValidador implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		// Usuario usuario = (Usuario) target;

		// Error code apunta a properties
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty", "This field is required");

		/*
		 * if
		 * (!usuario.getIdentifier().matches("[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}"
		 * )) { errors.rejectValue("identifier", "Pattern.usuario.identifier",
		 * "The identifier does not satisface the ID-SESAE standar"); }
		 */
	}

}
