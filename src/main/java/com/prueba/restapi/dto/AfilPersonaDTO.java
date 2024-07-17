package com.prueba.restapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AfilPersonaDTO {
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
}
