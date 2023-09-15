package com.example.CRUD.Mappers;

import com.example.CRUD.dto.RespuestaPolizaDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Jesus Aispuro
 */
@CommonsLog
public class ConsultaMapper implements RowMapper<RespuestaPolizaDTO> {
    
    @Override
    public RespuestaPolizaDTO mapRow(ResultSet rs, int i) throws SQLException{
        log.info("Mapeo de los datos ConsultaMapper ");
        RespuestaPolizaDTO respuesta = new RespuestaPolizaDTO();
        respuesta.setEstado(rs.getInt("iestado"));
        respuesta.setCjson(rs.getString("cjson"));
        return respuesta;
    }
    
}
