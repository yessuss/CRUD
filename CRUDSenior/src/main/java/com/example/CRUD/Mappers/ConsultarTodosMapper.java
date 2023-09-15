
package com.example.CRUD.Mappers;

import com.example.CRUD.dto.RespuestaConsultarDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Jesus Aispuro
 */
@CommonsLog
public class ConsultarTodosMapper implements RowMapper<RespuestaConsultarDTO> {
    
    @Override
    public RespuestaConsultarDTO mapRow(ResultSet rs, int i) throws SQLException{
        log.info("Mapeo de los datos ConsultarTodosMapper ");
        RespuestaConsultarDTO respuesta = new RespuestaConsultarDTO();
        respuesta.setIdPoliza(rs.getInt("idPolizas"));
        respuesta.setEmpleadogenero(rs.getString("empleado"));
        respuesta.setIdSKU(rs.getInt("sku"));
        respuesta.setNombreProducto(rs.getString("nombreproducto"));
        respuesta.setCantidad(rs.getInt("cantidad"));
        respuesta.setIdempleadogenero(rs.getInt("empleadogenero"));
        return respuesta;
    }
    
    
}
