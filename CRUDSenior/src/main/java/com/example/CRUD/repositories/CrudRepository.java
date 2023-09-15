
package com.example.CRUD.repositories;

import com.example.CRUD.Mappers.ConsultaMapper;
import com.example.CRUD.Mappers.ConsultarTodosMapper;
import com.example.CRUD.Mappers.PolizaMapper;
import com.example.CRUD.dto.ListRespuestaPolizaDTO;
import com.example.CRUD.dto.RespuestaConsultarDTO;
import com.example.CRUD.dto.RespuestaGralDTO;
import com.example.CRUD.dto.RespuestaPolizaDTO;
import java.util.List;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Jesus Aispuro
 */
@CommonsLog
@Repository
public class CrudRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
        

    public RespuestaPolizaDTO consultarPoliza(int id) {
        
        RespuestaPolizaDTO respuesta = new RespuestaPolizaDTO();
        String query = "SELECT iestado, cmensaje, cjson FROM fun_consultarpoliza(?);" ;
        
        try{
            log.info("Se ejecuta la funcion fun_consultarpoliza con los datos " + id);
            respuesta = jdbcTemplate.queryForObject(query, new Object[] { id }, new ConsultaMapper());
            
        }
        catch(DataAccessException e){
            log.error("Error al ejecutar la funcion fun_consultarpoliza", e);
        }
	return respuesta;
        
	
    }
    
    public ListRespuestaPolizaDTO consultarTodos(int id) {
        
        List<RespuestaConsultarDTO> respUsuarios;
        ListRespuestaPolizaDTO listPoliza = new ListRespuestaPolizaDTO();
        String query = "SELECT idpolizas, empleado,sku,nombreproducto,cantidad,empleadogenero FROM fun_consultaGeneralPoliza(?);" ;
        
        try{
            log.info("Se ejecuta la funcion fun_consultaGeneralPoliza con los datos " + id);
        respUsuarios = jdbcTemplate.query(query, new Object[] { id }, new ConsultarTodosMapper());
        
                if (!respUsuarios.isEmpty()) {
                    listPoliza.setListPoliza(respUsuarios);
                }
        }
        catch(DataAccessException e){
            log.error("Error al ejecutar la funcion fun_consultaGeneralPoliza", e);
        }
         return listPoliza;
	
    }
    
    public RespuestaGralDTO grabarPoliza(String json) {
        
        RespuestaGralDTO respuesta = new RespuestaGralDTO();
        String query = "SELECT iestado, cmensaje FROM fun_generaciondepoliza(?::json);" ;
        
        try{
            log.info("Se ejecuta la funcion fun_generaciondepoliza con los datos " + json);
            respuesta =  jdbcTemplate.queryForObject(query, new Object[] {json}, new PolizaMapper());
            
            
        }
        catch(DataAccessException e){
            log.error("Error al ejecutar la funcion fun_consultaGeneralPoliza", e);
        }
        return respuesta;
	
    }
    
    public RespuestaGralDTO actualizarPoliza(String json) {
        
        RespuestaGralDTO respuesta = new RespuestaGralDTO();
        String query = "SELECT iestado, cmensaje FROM fun_actualizapoliza(?::json);" ;
	try{
            log.info("Se ejecuta la funcion fun_actualizapoliza con los datos " + json);
            respuesta =  jdbcTemplate.queryForObject(query, new Object[] {json}, new PolizaMapper());
            
        }
        catch(DataAccessException e){
            log.error("Error al ejecutar la funcion fun_actualizapoliza", e);
        }
	return respuesta;
	
    }
    
    public RespuestaGralDTO eliminarPoliza(String json) {
        
        RespuestaGralDTO respuesta = new RespuestaGralDTO();
        String query = "SELECT iestado, cmensaje FROM fun_eliminarpoliza(?::json);" ;
        try{
            log.info("Se ejecuta la funcion fun_actualizapoliza con los datos " + json);
            respuesta =  jdbcTemplate.queryForObject(query, new Object[] {json}, new PolizaMapper());
            
        }
        catch(DataAccessException e){
            log.error("Error al ejecutar la funcion fun_eliminarpoliza", e);
        }
	return respuesta;
	
    }

    
}
