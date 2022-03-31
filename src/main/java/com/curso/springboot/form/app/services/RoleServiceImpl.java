package com.curso.springboot.form.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.curso.springboot.form.app.models.domain.Role;

@Service
public class RoleServiceImpl implements RoleService {

	 private List<Role> roles;
	
	public RoleServiceImpl() {
		this.roles = new ArrayList<Role>();
		roles.add(new Role(1,"Administrador","ROLE_ADMIN"));
		roles.add(new Role(2,"Moderador","ROLE_MODERATOR"));
		roles.add(new Role(3,"Usuario","ROLE_USER"));
		
	}

	@Override
	public List<Role> listar() {
		return roles;
	}

	@Override
	public Role getById(Integer id) {
		Role result = null;
		
		for (Role role: roles) {
			 if (id == role.getId()) {
				 result = role;
				 break;
			 } 
		}
		
		return result;
	}

}
