
package com.example.CRUD.ServicesImp;

import com.example.CRUD.Services.CrudService;
import com.example.CRUD.dto.ListRespuestaPolizaDTO;
import com.example.CRUD.dto.RespuestaConsultarDTO;
import com.example.CRUD.dto.RespuestaGralDTO;
import com.example.CRUD.dto.RespuestaPolizaDTO;
import com.example.CRUD.repositories.CrudRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jesus Aispuro
 */
@CommonsLog
@Service
public class CrudImp implements CrudService {
       
    @Autowired
    private CrudRepository repository;
    
    @Override
    public RespuestaPolizaDTO consultarPoliza(int id) {
        RespuestaPolizaDTO objRespuesta;    
        log.info("Servicio de implementacion envia la informacion al repesitorio consultarPoliza "+ id);
       objRespuesta = repository.consultarPoliza(id); 
       return objRespuesta;
    }
    
    @Override
    public ListRespuestaPolizaDTO consultarTodos(int id) {
        ListRespuestaPolizaDTO listPoliza;  
         log.info("Servicio de implementacion envia la informacion al repesitorio consultarTodos "+ id);
       listPoliza = repository.consultarTodos(id); 
       return listPoliza;
    }
    
    @Override
    public RespuestaGralDTO grabarPoliza(String json) {
        RespuestaGralDTO objRespuesta;    
        log.info("Servicio de implementacion envia la informacion al repesitorio grabarPoliza "+ json);
       objRespuesta = repository.grabarPoliza(json);  
       return objRespuesta;
    }
    
    @Override
    public RespuestaGralDTO actualizarPoliza(String json) {
        RespuestaGralDTO objRespuesta;                     
       log.info("Servicio de implementacion envia la informacion al repesitorio actualizarPoliza "+ json);
       objRespuesta = repository.actualizarPoliza(json); 
       return objRespuesta;
    }
    
    @Override
    public RespuestaGralDTO eliminarPoliza(String json) {
        RespuestaGralDTO objRespuesta;    
       log.info("Servicio de implementacion envia la informacion al repesitorio eliminarPoliza "+ json);
       objRespuesta = repository.eliminarPoliza(json);
       return objRespuesta;
    }
    
}
