package com.prueba.restapi.service;

import com.prueba.restapi.dto.AfilPersonaDTO;
import com.prueba.restapi.dto.AfiliadoDTO;

public interface AfiliadoService {

    /**
     * Metodo que consulta por tipo y numero de identificacion
     *
     * @param tipoIdentificacion tipo de identificacion del usuario
     * @param numeroIdentificacion numero de identificacion del usuario
     * @return informacion del usuario
     * @throws Exception error
     */
    AfiliadoDTO findByNumIdentAndTipoIdent(String tipoIdentificacion, String numeroIdentificacion) throws Exception;

    /**
     * Metodo que consulta por tipo y numero de identificacion
     *
     * @param tipoIdentificacion tipo de identificacion del usuario
     * @param numeroIdentificacion numero de identificacion del usuario
     * @return informacion del usuario
     * @throws Exception error
     */
    AfilPersonaDTO findPersonaByNumIdentAndTipoIdent(String tipoIdentificacion, String numeroIdentificacion) throws Exception;

}
