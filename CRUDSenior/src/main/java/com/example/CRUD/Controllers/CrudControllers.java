package com.example.CRUD.Controllers;

import com.example.CRUD.Services.CrudService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.CRUD.dto.ApiResDTO;
import com.example.CRUD.dto.EliminarPolizaDTO;
import com.example.CRUD.dto.SolicitudJsonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.google.gson.Gson;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.extern.apachecommons.CommonsLog;

/**
 *
 * @author Jesus Aispuro
 */
@CommonsLog
@RestController
@RequestMapping("api/v1/Poliza")
public class CrudControllers {  
    

    
    @Autowired
    private CrudService servicio;
        
    @GetMapping(value = "/Consultar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET})
    
    public @ResponseBody ApiResDTO consultarPoliza(@PathVariable("id") int id) {
            log.info("Desde controlador se manda llamar el servico consultarPoliza con el id "+ id);
            return new ApiResDTO(HttpStatus.OK,servicio.consultarPoliza(id));
            
    }
    
    @GetMapping(value = "/ConsultarT/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET})
    public @ResponseBody ApiResDTO consultarTodos(@PathVariable("id") int id, HttpServletResponse response) {
        log.info("Desde controlador se manda llamar el servico consultarTodos con el id "+ id);
            return new ApiResDTO(response.getStatus(),servicio.consultarTodos(id));
            
    }
    
    
    @PostMapping( value = "/Grabar", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*", methods= {RequestMethod.POST})
    public @ResponseBody ApiResDTO grabarPoliza(@RequestBody SolicitudJsonDTO solicitud){
        Gson gson = new Gson();
        String json = gson.toJson(solicitud);
        log.info("Desde controlador se manda llamar el servico grabarPoliza con el id "+ json);
            return new ApiResDTO(HttpStatus.OK,servicio.grabarPoliza(json));
            
    }
    
    @PostMapping( value = "/Actualizar", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*", methods= {RequestMethod.POST})
    public @ResponseBody ApiResDTO actualizarPoliza(@RequestBody SolicitudJsonDTO solicitud){
        Gson gson = new Gson();
        String json = gson.toJson(solicitud);
            log.info("Desde controlador se manda llamar el servico actualizarPoliza con el id "+ json);
            return new ApiResDTO(HttpStatus.OK,servicio.actualizarPoliza(json));
    }
        
    @PostMapping( value = "/Eliminar", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*", methods= {RequestMethod.POST})
    public @ResponseBody ApiResDTO eliminarPoliza(@RequestBody EliminarPolizaDTO solicitud){
        Gson gson = new Gson();
        String json = gson.toJson(solicitud);
            log.info("Desde controlador se manda llamar el servico eliminarPoliza con el id "+ json);
            return new ApiResDTO(HttpStatus.OK,servicio.eliminarPoliza(json));
    }
    
    
    
}
