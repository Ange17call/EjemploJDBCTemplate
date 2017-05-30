package com.distribuida.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;



@Component("servicio")
public class ServicioImpl implements Servicio {
	
	@Autowired
	Complementaria complementaria;
	
	private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	
	
	public String listarJson(){
		Gson json= new Gson();
		String resultado;
		resultado=json.toJson(complementaria.listar());
		
		return resultado;
		
	}

	@Override
	public void insertarPersona(Persona persona) {
		
		persona.setDireccion(buscarDireccion(9));
		String sql = "insert into persona (id, nombre, direccionid,telefono) values (?, ?, ?, ?)";
        this.jdbcTemplate.update(sql,
                persona.getId(),
                persona.getNombre(),
                persona.getDireccion(),
                persona.getTelefono());
	}
	@Override
	public void insertarDireccion(Direccion direccion) {
		String sql= "insert into direccion id, calleprimaria, callesecundaria, numero) values (?, ?, ?, ?)";
		
		  this.jdbcTemplate.update(sql,
                direccion.getId(),
                direccion.getCalleprimaria(),
                direccion.getCallesecundaria(),
                direccion.getNumero());
	}

	@Override
	public Direccion buscarDireccion(int id) {
		
		String sql = "SELECT * FROM direccion WHERE id = ?";
		Direccion direccion = (Direccion) getJdbcTemplate().queryForObject(
				sql, new Object[] { id },
				new BeanPropertyRowMapper<Direccion>(Direccion.class));

		return direccion;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
			
	}


