package com.curso.springboot.form.app.models.domain;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

// import org.springframework.format.annotation.DateTimeFormat;

import com.curso.springboot.form.app.validation.IdentifierRegex;
import com.curso.springboot.form.app.validation.Requerido;

public class Usuario {

	// @Pattern(regexp = "[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")
	@IdentifierRegex
	private String identifier;

	// @NotEmpty
	private String name;

	@Requerido
	private String lastname;

	@NotBlank
	@Size(min = 3, max = 8)
	private String username;

	@Requerido
	@Email
	private String email;

	@NotEmpty
	private String password;

	@NotNull
	@Min(5)
	@Max(99)
	private Integer account;

	@NotNull
	@Past
	// @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date bornDate;

	@NotNull
	private Country country;

	@NotEmpty(message = "Select at leats one role")
	private List<Role> roles;

	private Boolean subscribe;

	@NotEmpty
	private String gender;

	private String secret;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public Integer getAccount() {
		return account;
	}

	public void setAccount(Integer account) {
		this.account = account;
	}

	public Date getBornDate() {
		return bornDate;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Boolean getSubscribe() {
		return subscribe;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setSubscribe(Boolean subscribe) {
		this.subscribe = subscribe;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

}
