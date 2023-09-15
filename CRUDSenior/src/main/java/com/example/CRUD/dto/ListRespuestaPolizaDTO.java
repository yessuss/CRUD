
package com.example.CRUD.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Jesus Aispuro
 */

@AllArgsConstructor
@NoArgsConstructor
@Data public class ListRespuestaPolizaDTO {
     
    protected List<RespuestaConsultarDTO> listPoliza;
}

