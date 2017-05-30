package com.distribuida.dto;

import java.util.List;

public interface Servicio {
	
	public String listarJson();
	public void insertarPersona(Persona persona);
	public void insertarDireccion(Direccion direccion);
	public Direccion buscarDireccion( int id );
	

}
