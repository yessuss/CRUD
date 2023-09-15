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
@Data public class RespuestaGralDTO {
    
    protected int estado;
    protected String mensaje;
    
}
