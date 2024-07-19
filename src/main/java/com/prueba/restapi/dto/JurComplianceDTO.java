package com.prueba.restapi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class JurComplianceDTO {
    private String conceptoId;
    private String valorPago;
    private String nombreCondena;
}
