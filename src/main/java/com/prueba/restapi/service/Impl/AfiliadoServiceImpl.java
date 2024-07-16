package com.prueba.restapi.service.Impl;

import com.prueba.restapi.dto.AfilPersonaDTO;
import com.prueba.restapi.dto.AfiliadoDTO;
import com.prueba.restapi.entity.AfilPersonaEntity;
import com.prueba.restapi.entity.AfilPersonaNaturalEntity;
import com.prueba.restapi.entity.AfiliadoEntity;
import com.prueba.restapi.repository.AfilPersonaNaturalRepository;
import com.prueba.restapi.repository.AfilPersonaRepository;
import com.prueba.restapi.repository.AfiliadoRepository;
import com.prueba.restapi.service.AfiliadoService;
import com.prueba.restapi.util.MensajeError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AfiliadoServiceImpl implements AfiliadoService {

    private final AfiliadoRepository afiliadoRepository;
    private final AfilPersonaRepository afilPersonaRepository;
    private final AfilPersonaNaturalRepository afilPersonaNaturalRepository;

    @Override
    public AfiliadoDTO findByNumIdentAndTipoIdent(String tipoIdentificacion, String numeroIdentificacion) throws Exception {

        AfiliadoEntity afiliado = afiliadoRepository
                .findByTipoIdentificacionAndNumeroIdentificacion(tipoIdentificacion, numeroIdentificacion)
                .orElseThrow(
                        () -> new Exception(MensajeError.ERROR_CONSULTA_AFILIADO)
                );

        return mapperRespTask1(afiliado);
    }

    @Override
    public AfilPersonaDTO findPersonaByNumIdentAndTipoIdent(String tipoIdentificacion, String numeroIdentificacion) throws Exception {

        AfilPersonaEntity afilPersona = afilPersonaRepository
                .findByTipoIdentificacionAndNumeroIdentificacion(tipoIdentificacion, numeroIdentificacion)
                .orElseThrow(
                        () -> new Exception(MensajeError.ERROR_CONSULTA_AFILIADO)
                );

        AfilPersonaNaturalEntity afilPersonaNatural = afilPersonaNaturalRepository.findByIdPersona(afilPersona.getIdPersona())
                .orElseThrow(
                        () -> new Exception(MensajeError.ERROR_CONSULTA_AFILIADO)
                );

        return mapperRespTask2(afilPersona, afilPersonaNatural);
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
