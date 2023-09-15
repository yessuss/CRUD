
package com.example.CRUD.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jesus Aispuro
 */
@AllArgsConstructor
@NoArgsConstructor
@Component
@Data public class RespuestaConsultarDTO {
    
    protected int idPoliza;
    protected String empleadogenero;
    protected int idSKU;
    protected String nombreProducto;
    protected int cantidad;
    protected int idempleadogenero;
    
    
}
