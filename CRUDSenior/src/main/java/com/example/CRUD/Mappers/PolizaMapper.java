/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.CRUD.Mappers;

import com.example.CRUD.dto.RespuestaGralDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Jesus Aispuro
 */
@CommonsLog
public class PolizaMapper implements RowMapper<RespuestaGralDTO> {
    
    @Override
    public RespuestaGralDTO mapRow(ResultSet rs, int i) throws SQLException{
        log.info("Mapeo de los datos PolizaMapper ");
        RespuestaGralDTO respuesta = new RespuestaGralDTO();
        respuesta.setEstado(rs.getInt("iestado"));
        respuesta.setMensaje(rs.getString("cmensaje"));
        return respuesta;
    }
    
}
