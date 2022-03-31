package com.curso.springboot.form.app.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.curso.springboot.form.app.models.domain.Country;

@Service
public class CountryServiceImpl implements CountryService {
	
	private List<Country> list;

	public CountryServiceImpl() {
		this.list = Arrays.asList(
			new Country(1, "ES", "España"),
			new Country(2, "MX", "México"),
			new Country(3, "CN", "Canada"),
			new Country(4, "US", "Estados Unidos"),
			new Country(5, "CH", "Chile"),
			new Country(6, "AR", "Argentina"),
			new Country(7, "CO", "Colombia")
		);
	}

	@Override
	public List<Country> listar() {
		return list;
	}

	@Override
	public Country getById(Integer id) {
		
		Country result = null;
		
		for (Country country: this.list) {
			 if (id == country.getId()) {
				 result = country;
				 break;
			 } 
		}
		
		return result;
	}

	
}
