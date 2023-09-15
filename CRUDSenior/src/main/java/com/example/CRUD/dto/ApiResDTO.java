package com.example.CRUD.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Jesus Aispuro
 */
@AllArgsConstructor
@NoArgsConstructor
@Data public class ApiResDTO {
    
    protected Object meta;
    protected Object data;
}
