package com.distribuida.dto;

import java.io.Serializable;
import java.util.List;


public class Direccion implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String calleprimaria;

	private String callesecundaria;

	private Integer numero;

	private List<Persona> personas;

	public Direccion() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCalleprimaria() {
		return this.calleprimaria;
	}

	public void setCalleprimaria(String calleprimaria) {
		this.calleprimaria = calleprimaria;
	}

	public String getCallesecundaria() {
		return this.callesecundaria;
	}

	public void setCallesecundaria(String callesecundaria) {
		this.callesecundaria = callesecundaria;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public List<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public Persona addPersona(Persona persona) {
		getPersonas().add(persona);
		persona.setDireccion(this);

		return persona;
	}

	public Persona removePersona(Persona persona) {
		getPersonas().remove(persona);
		persona.setDireccion(null);

		return persona;
	}

}