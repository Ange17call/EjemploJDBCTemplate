package com.distribuida.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class Complementaria {
	
	private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public List<Persona> listar() {
		String sql = "select * from persona p, direccion d where p.direccionid=d.id ";

        return this.jdbcTemplate.query(sql, new RowMapper<Persona>() {
            @Override
            public Persona mapRow(ResultSet rs, int i) throws SQLException {
                Persona p = new Persona();
                Direccion d =  new Direccion();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setTelefono(rs.getString("telefono"));
                d.setId(rs.getInt("direccionid"));
                d.setCalleprimaria(rs.getString("calleprimaria"));
                d.setCallesecundaria(rs.getString("callesecundaria"));
                d.setNumero(rs.getInt("numero"));
                p.setDireccion(d);
                return p;
            }
        });
	}

}
