package com.distribuida;




import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.distribuida.dto.Direccion;
import com.distribuida.dto.Persona;
import com.distribuida.dto.Servicio;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


@SpringBootApplication
public class EjemploJdbcTemplateApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(EjemploJdbcTemplateApplication.class, args);
		Servicio servicio = (Servicio) ctx.getBean("servicio");
		
	System.out.println(servicio.listarJson());
	JsonParser parser = new JsonParser();
	JsonElement array =parser.parse(servicio.listarJson());
	Gson json= new Gson();
	Persona[] persona= json.fromJson(array, Persona[].class);
	for (Persona persona2 : persona) {
		System.out.println(persona2.getNombre());
		
	}
		
	}
}
