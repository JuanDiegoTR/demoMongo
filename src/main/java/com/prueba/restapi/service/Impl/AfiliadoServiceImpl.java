package com.prueba.restapi.service.Impl;

import com.prueba.restapi.dto.*;
import com.prueba.restapi.entity.*;
import com.prueba.restapi.repository.*;
import com.prueba.restapi.service.AfiliadoService;
import com.prueba.restapi.util.Constantes;
import com.prueba.restapi.util.MensajeError;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AfiliadoServiceImpl implements AfiliadoService {

    private final AfiliadoRepository afiliadoRepository;
    private final AfilPersonaRepository afilPersonaRepository;
    private final AfilPersonaNaturalRepository afilPersonaNaturalRepository;

    private final AfiliadoVigenciaRepository afiliadoVigenciaRepository;
    private final JurConceptoCondenaRepository jurConceptoCondenaRepository;
    private final JurCumpliminetoCXPRepository jurCumpliminetoCXPRepository;

    @Override
    public ResponseEntity findByNumIdentAndTipoIdent(String tipoIdentificacion, String numeroIdentificacion) {
        try {
            AfiliadoEntity afiliado = afiliadoRepository
                    .findByTipoIdentificacionAndNumeroIdentificacion(tipoIdentificacion, numeroIdentificacion)
                    .orElseThrow(
                            () -> new Exception(MensajeError.ERROR_CONSULTA_AFILIADO)
                    );

            StatusDTO statusDTO = new StatusDTO();
            statusDTO.setStatusCode(String.valueOf(HttpStatus.OK));
            statusDTO.setStatusDescription(Constantes.MSG_EXITOSO_AFILIADO);

            Map<String, Object> resp = new HashMap<>();
            resp.put(Constantes.AFILIADO, mapperRespTask1(afiliado));

            return ResponseEntity.ok(new ResponseDTO(statusDTO, resp));
        } catch (Exception ex) {
            throw new NullPointerException(ex.getMessage());
        }
    }

    @Override
    public ResponseEntity findPersonaByNumIdentAndTipoIdent(String tipoIdentificacion, String numeroIdentificacion) {
        try {
            AfilPersonaEntity afilPersona = afilPersonaRepository
                    .findByTipoIdentificacionAndNumeroIdentificacion(tipoIdentificacion, numeroIdentificacion)
                    .orElseThrow(
                            () -> new Exception(MensajeError.ERROR_CONSULTA_AFILIADO)
                    );

            AfilPersonaNaturalEntity afilPersonaNatural = afilPersonaNaturalRepository.findByIdPersona(afilPersona.getIdPersona())
                    .orElseThrow(
                            () -> new Exception(MensajeError.ERROR_CONSULTA_AFILIADO)
                    );

            StatusDTO statusDTO = new StatusDTO();
            statusDTO.setStatusCode(String.valueOf(HttpStatus.OK));
            statusDTO.setStatusDescription(Constantes.MSG_EXITOSO_AFILIADO);

            Map<String, Object> resp = new HashMap<>();
            resp.put(Constantes.AFILIADO, mapperRespTask2(afilPersona, afilPersonaNatural));

            return ResponseEntity.ok(new ResponseDTO(statusDTO, resp));
        } catch (Exception ex) {
            throw new NullPointerException(ex.getMessage());
        }
    }

    @Override
    public ResponseEntity findAfiliadoVigenciaByNumIdentAndTipoIdent(String tipoIdentificacion, String numeroIdentificacion) {
        try {

            List<AfiliadoVigenciaEntity> afiliadoVigencia = afiliadoVigenciaRepository
                    .findByTipoIdentificacionIdAndNumeroIdentificacion(tipoIdentificacion, numeroIdentificacion);
            if (afiliadoVigencia.isEmpty()) {
                throw new Exception(MensajeError.ERROR_CONSULTA_AFILIADO);
            }

            ModelMapper mapper = new ModelMapper();
            AfiliadoVigenciaDTO afiliadoResp = mapper.map(afiliadoVigencia.get(0), AfiliadoVigenciaDTO.class);

            StatusDTO statusDTO = new StatusDTO();
            statusDTO.setStatusCode(String.valueOf(HttpStatus.OK));
            statusDTO.setStatusDescription(Constantes.MSG_EXITOSO_AFILIADO);

            Map<String, Object> resp = new HashMap<>();
            resp.put(Constantes.AFILIADO, afiliadoResp);

            return ResponseEntity.ok(new ResponseDTO(statusDTO, resp));
        } catch (Exception ex) {
            throw new NullPointerException(ex.getMessage());
        }
    }

    @Override
    public ResponseEntity findAfiliadoVigenciaByNumIdentAndTipoIdent(String demandaId) throws Exception {

        List<JurCumpliminetoCXPEntity> jurCumpliminetos = jurCumpliminetoCXPRepository.findBydemandaIdAndEstado(demandaId, "APLICADO");

        if (jurCumpliminetos.isEmpty()) {
            throw new Exception(MensajeError.ERROR_CONSULTA_DEMANDA);
        }
        List<String> conceptoIds = jurCumpliminetos.stream()
                .map(JurCumpliminetoCXPEntity::getConceptoId)
                .collect(Collectors.toList());

        List<JurConceptoCondenaEntity> conceptosCondena =
                jurConceptoCondenaRepository.findByConceptoCondenaIdInAndNombreCondenaIn(conceptoIds);

        List<JurComplianceDTO> jurCompliances = new ArrayList<>();

        jurCumpliminetos.stream()
                .filter(jc -> conceptosCondena.stream().anyMatch(cc -> cc.getConceptoCondenaId().equals(jc.getConceptoId())))
                .map(jc -> {
                    JurConceptoCondenaEntity conceptoContena = conceptosCondena.stream()
                            .filter(cc -> cc.getConceptoCondenaId().equals(jc.getConceptoId()))
                            .findFirst()
                            .orElse(null);

                    if (conceptoContena != null) {
                        jurCompliances.add(JurComplianceDTO.builder()
                                .conceptoId(jc.getConceptoId())
                                .valorPago(jc.getValorPago())
                                .nombreCondena(conceptoContena.getNombreCondena())
                                .build());
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        StatusDTO statusDTO = new StatusDTO();
        statusDTO.setStatusCode(String.valueOf(HttpStatus.OK));
        statusDTO.setStatusDescription(Constantes.MSG_EXITOSO_DEMANDA);

        return ResponseEntity.ok(new ResponseDTO(statusDTO, jurCompliances));
    }

    private AfiliadoDTO mapperRespTask1(AfiliadoEntity afiliadoEntity) {

        AfiliadoDTO afiliadoDTO = new AfiliadoDTO();
        afiliadoDTO.setTipoId(afiliadoEntity.getTipoIdentificacion());
        afiliadoDTO.setNumeroId(afiliadoEntity.getNumeroIdentificacion());
        afiliadoDTO.setPrimerNombre(afiliadoEntity.getPrimerNombre());
        afiliadoDTO.setPrimerApellido(afiliadoEntity.getPrimerApellido());
        afiliadoDTO.setAfiliadoFondoId(afiliadoEntity.getAfiliadoFondoId());
        afiliadoDTO.setSegundoNombre(afiliadoEntity.getSegundoNombre());
        afiliadoDTO.setSegundoApellido(afiliadoEntity.getSegundoApellido());

        return afiliadoDTO;
    }

    private AfilPersonaDTO mapperRespTask2(AfilPersonaEntity afilPersona
            , AfilPersonaNaturalEntity afilPersonaNatural) {

        AfilPersonaDTO afilPersonaDTO = new AfilPersonaDTO();
        afilPersonaDTO.setPrimerNombre(afilPersonaNatural.getPrimerNombre());
        afilPersonaDTO.setSegundoNombre(afilPersonaNatural.getSegundoNombre());
        afilPersonaDTO.setPrimerApellido(afilPersonaNatural.getPrimerApellido());
        afilPersonaDTO.setSegundoApellido(afilPersonaNatural.getSegundoApellido());
        afilPersonaDTO.setTipoIdentificacion(afilPersona.getTipoIdentificacion());
        afilPersonaDTO.setNumeroIdentificacion(afilPersona.getNumeroIdentificacion());

        return afilPersonaDTO;
    }

}
