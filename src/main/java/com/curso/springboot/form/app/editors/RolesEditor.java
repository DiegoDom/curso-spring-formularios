package com.curso.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.curso.springboot.form.app.services.RoleService;

@Component
public class RolesEditor extends PropertyEditorSupport {
	
	@Autowired
	private RoleService roleService;


	@Override
	public void setAsText(String idString) throws IllegalArgumentException {
		try {
			Integer id = Integer.parseInt(idString);
			this.setValue(roleService.getById(id));
		} catch (NumberFormatException e) {
			this.setValue(null);
		}
	}

	
	
}
