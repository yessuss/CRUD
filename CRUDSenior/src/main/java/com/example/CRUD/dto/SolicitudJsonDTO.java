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
@Data public class SolicitudJsonDTO {
    
    protected int id;
    protected int idEmpleado;
    protected int idSKU;
    protected int cantidad;
       
}
