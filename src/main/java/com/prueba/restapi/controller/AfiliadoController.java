package com.prueba.restapi.controller;

import com.prueba.restapi.service.AfiliadoService;
import com.prueba.restapi.util.MensajeError;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/afiliados")
@RequiredArgsConstructor
@Validated
public class AfiliadoController {

    private final AfiliadoService afiliadoService;

    /**
     * Servicio para consultar el afiliado por tipo y numero de idetificacion
     *
     * @param tipoIdentificacion   tipo de identificacion del usuario
     * @param numeroIdentificacion numero de identificacion del usuario
     * @return informacion del usuario
     * @throws Exception error
     */
    @GetMapping("task1")
    public ResponseEntity findByNumIdentAndTipoIdent(@RequestHeader("tipoIdentificacion") String tipoIdentificacion,
                                                     @RequestHeader("numeroIdentificacion") String numeroIdentificacion) throws Exception {
        return afiliadoService.findByNumIdentAndTipoIdent(tipoIdentificacion, numeroIdentificacion);
    }

    /**
     * Servicio para consultar el afiliado por tipo y numero de idetificacion
     *
     * @param tipoIdentificacion   tipo de identificacion del usuario
     * @param numeroIdentificacion numero de identificacion del usuario
     * @return informacion del usuario
     * @throws Exception error
     */
    @GetMapping("task2")
    public ResponseEntity findPersonaByNumIdentAndTipoIdent(@RequestParam("tipoIdentificacion")
                                                            @NotBlank(message = MensajeError.ErrorTipoIdentificaion.ERROR_NOT_BLANCK)
                                                            @Size(min = 2, max = 2, message = MensajeError.ErrorTipoIdentificaion.ERROR_SIZE)
                                                            @Pattern(regexp = "[a-zA-Z]+", message = MensajeError.ErrorTipoIdentificaion.ERROR_PATRON)
                                                            String tipoIdentificacion,
                                                            @RequestParam("numeroIdentificacion")
                                                            @NotBlank(message = MensajeError.ErrorNumeroIdentificacion.ERROR_NOT_BLANCK)
                                                            @Size(max = 10, message = MensajeError.ErrorNumeroIdentificacion.ERROR_SIZE)
                                                            @Pattern(regexp = "\\d+", message = MensajeError.ErrorNumeroIdentificacion.ERROR_PATRON)
                                                            String numeroIdentificacion) throws Exception {
        return afiliadoService.findPersonaByNumIdentAndTipoIdent(tipoIdentificacion, numeroIdentificacion);
    }

    /**
     * Servicio para consultar el afiliado por tipo y numero de idetificacion
     *
     * @param tipoIdentificacion   tipo de identificacion del usuario
     * @param numeroIdentificacion numero de identificacion del usuario
     * @return informacion del usuario
     * @throws Exception error
     */
    @GetMapping("task4")
    public ResponseEntity findAfiliadoVigenciaByNumIdentAndTipoIdent(@RequestParam("tipoIdentificacion")
                                                                     @NotBlank(message = MensajeError.ErrorTipoIdentificaion.ERROR_NOT_BLANCK)
                                                                     @Size(min = 2, max = 2, message = MensajeError.ErrorTipoIdentificaion.ERROR_SIZE)
                                                                     @Pattern(regexp = "[a-zA-Z]+", message = MensajeError.ErrorTipoIdentificaion.ERROR_PATRON)
                                                                     String tipoIdentificacion,
                                                                     @RequestParam("numeroIdentificacion")
                                                                     @NotBlank(message = MensajeError.ErrorNumeroIdentificacion.ERROR_NOT_BLANCK)
                                                                     @Size(max = 10, message = MensajeError.ErrorNumeroIdentificacion.ERROR_SIZE)
                                                                     @Pattern(regexp = "\\d+", message = MensajeError.ErrorNumeroIdentificacion.ERROR_PATRON)
                                                                     String numeroIdentificacion) {
        return afiliadoService.findAfiliadoVigenciaByNumIdentAndTipoIdent(tipoIdentificacion, numeroIdentificacion);
    }

    /**
     * Metodo que consulta por id de demanda
     *
     * @param demandaId id de demanda
     * @return informacion de la demanda
     * @throws Exception error
     */
    @GetMapping("task5")
    public ResponseEntity findAfiliadoVigenciaByNumIdentAndTipoIdent(@RequestParam("demandaId")
                                                                     @NotBlank(message = MensajeError.ErrorDemandaId.ERROR_NOT_BLANCK)
                                                                     @Pattern(regexp = "\\d+", message = MensajeError.ErrorDemandaId.ERROR_PATRON)
                                                                     String demandaId) throws Exception {
        return afiliadoService.findAfiliadoVigenciaByNumIdentAndTipoIdent(demandaId);
    }

}
