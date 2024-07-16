package com.prueba.restapi.controller;

import com.prueba.restapi.dto.AfiliadoDTO;
import com.prueba.restapi.service.AfiliadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/afiliados")
public class AfiliadoController {

    @Autowired
    private AfiliadoService afiliadoService;

    /**
     * Servicio para consultar el afiliado por tipo y numero de idetificacion
     *
     * @param tipoIdentificacion tipo de identificacion del usuario
     * @param numeroIdentificacion numero de identificacion del usuario
     * @return informacion del usuario
     * @throws Exception error
     */
    @GetMapping
    public AfiliadoDTO findByNumIdentAndTipoIdent(@RequestHeader("tipoIdentificacion") String tipoIdentificacion,
                                                  @RequestHeader("numeroIdentificacion") String numeroIdentificacion) throws Exception {
        return afiliadoService.findByNumIdentAndTipoIdent(tipoIdentificacion, numeroIdentificacion);
    }
}
