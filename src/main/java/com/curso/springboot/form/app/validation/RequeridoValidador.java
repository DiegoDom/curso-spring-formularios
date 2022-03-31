package com.curso.springboot.form.app.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RequeridoValidador implements ConstraintValidator<Requerido, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if (value == null || value.trim().isEmpty()) {
			return false;
		}

		return true;
	}

}
