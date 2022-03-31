package com.curso.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

public class CapitalizeEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (!text.trim().isEmpty()) {			
			setValue(text.substring(0, 1).toUpperCase() + text.substring(1));
		}
	}
}
