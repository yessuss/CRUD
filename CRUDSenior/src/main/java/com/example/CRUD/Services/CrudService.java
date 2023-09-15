
package com.example.CRUD.Services;

import com.example.CRUD.dto.ListRespuestaPolizaDTO;
import com.example.CRUD.dto.RespuestaGralDTO;
import com.example.CRUD.dto.RespuestaPolizaDTO;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jesus Aispuro
 */
@Service
public interface CrudService {
    
    public RespuestaPolizaDTO consultarPoliza(int id); 
    public ListRespuestaPolizaDTO consultarTodos(int id);
    public RespuestaGralDTO grabarPoliza(String json);
    public RespuestaGralDTO actualizarPoliza(String json);
    public RespuestaGralDTO eliminarPoliza(String json);
    
}
