package com.prueba.restapi.service;

import org.springframework.http.ResponseEntity;

public interface AfiliadoService {

    /**
     * Metodo que consulta por tipo y numero de identificacion
     *
     * @param tipoIdentificacion tipo de identificacion del usuario
     * @param numeroIdentificacion numero de identificacion del usuario
     * @return informacion del usuario
     * @throws Exception error
     */
    ResponseEntity findByNumIdentAndTipoIdent(String tipoIdentificacion, String numeroIdentificacion);

    /**
     * Metodo que consulta por tipo y numero de identificacion
     *
     * @param tipoIdentificacion tipo de identificacion del usuario
     * @param numeroIdentificacion numero de identificacion del usuario
     * @return informacion del usuario
     * @throws Exception error
     */
    ResponseEntity findPersonaByNumIdentAndTipoIdent(String tipoIdentificacion, String numeroIdentificacion);

    /**
     * Metodo que consulta por tipo y numero de identificacion
     *
     * @param tipoIdentificacion tipo de identificacion del usuario
     * @param numeroIdentificacion numero de identificacion del usuario
     * @return informacion del usuario
     * @throws Exception error
     */
    ResponseEntity findAfiliadoVigenciaByNumIdentAndTipoIdent(String tipoIdentificacion, String numeroIdentificacion);

    /**
     * Metodo que consulta por id de demanda
     *
     * @param demandaId id de demanda
     * @return informacion de la demanda
     * @throws Exception error
     */
    ResponseEntity findAfiliadoVigenciaByNumIdentAndTipoIdent(String demandaId) throws Exception;


}
