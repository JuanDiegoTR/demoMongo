package com.prueba.restapi.service.Impl;

import com.prueba.restapi.dto.AfilPersonaDTO;
import com.prueba.restapi.dto.AfiliadoDTO;
import com.prueba.restapi.entity.AfilPersonaEntity;
import com.prueba.restapi.entity.AfilPersonaNaturalEntity;
import com.prueba.restapi.entity.AfiliadoEntity;
import com.prueba.restapi.repository.AfilPersonaNaturalRepository;
import com.prueba.restapi.repository.AfilPersonaRepository;
import com.prueba.restapi.repository.AfiliadoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class AfiliadoServiceImplTest {

    @InjectMocks
    private AfiliadoServiceImpl afiliadoService;
    @Mock
    private AfiliadoRepository afiliadoRepository;
    @Mock
    private AfilPersonaRepository afilPersonaRepository;
    @Mock
    private AfilPersonaNaturalRepository afilPersonaNaturalRepository;

    final String TIPO_DOC = "CC";
    final String NUM_DOC = "91280385";

    @Test
    void findByNumIdentAndTipoIdent() throws Exception {
        Mockito.when(afiliadoRepository
                        .findByTipoIdentificacionAndNumeroIdentificacion(
                                Mockito.anyString(), Mockito.anyString()))
                .thenReturn(Optional.of(new AfiliadoEntity()));

        AfiliadoDTO resp = afiliadoService.findByNumIdentAndTipoIdent(TIPO_DOC, NUM_DOC);
        Assertions.assertNotNull(resp);
    }

    @Test
    void findPersonaByNumIdentAndTipoIdent() throws Exception {
        AfilPersonaEntity afilPersona = new AfilPersonaEntity();
        afilPersona.setIdPersona("1");

        Mockito.when(afilPersonaRepository
                        .findByTipoIdentificacionAndNumeroIdentificacion(
                                Mockito.anyString(), Mockito.anyString()))
                .thenReturn(Optional.of(afilPersona));

        Mockito.when(afilPersonaNaturalRepository
                        .findByIdPersona(Mockito.anyString()))
                .thenReturn(Optional.of(new AfilPersonaNaturalEntity()));

        AfilPersonaDTO resp = afiliadoService.findPersonaByNumIdentAndTipoIdent(TIPO_DOC, NUM_DOC);
        Assertions.assertNotNull(resp);
    }

}