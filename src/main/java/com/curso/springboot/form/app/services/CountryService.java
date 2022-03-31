package com.curso.springboot.form.app.services;

import java.util.List;

import com.curso.springboot.form.app.models.domain.Country;

public interface CountryService {

	public List<Country> listar();

	public Country getById(Integer id);
}
