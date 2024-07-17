package com.prueba.restapi.service.Impl;

import com.prueba.restapi.entity.AfilPersonaEntity;
import com.prueba.restapi.entity.AfilPersonaNaturalEntity;
import com.prueba.restapi.entity.AfiliadoEntity;
import com.prueba.restapi.repository.AfilPersonaNaturalRepository;
import com.prueba.restapi.repository.AfilPersonaRepository;
import com.prueba.restapi.repository.AfiliadoRepository;
import com.prueba.restapi.util.MensajeError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

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

        ResponseEntity resp = afiliadoService.findByNumIdentAndTipoIdent(TIPO_DOC, NUM_DOC);
        Assertions.assertNotNull(resp);
    }

    @Test
    void findByNumIdentAndTipoIdentException() {
        Mockito.when(afiliadoRepository.findByTipoIdentificacionAndNumeroIdentificacion(TIPO_DOC, NUM_DOC))
                .thenReturn(Optional.empty());
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            afiliadoService.findByNumIdentAndTipoIdent(TIPO_DOC, NUM_DOC);
        });
        Assertions.assertEquals(MensajeError.ERROR_CONSULTA_AFILIADO, exception.getMessage());
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

        ResponseEntity resp = afiliadoService.findPersonaByNumIdentAndTipoIdent(TIPO_DOC, NUM_DOC);
        Assertions.assertNotNull(resp);
    }

    @Test
    void findPersonaByNumIdentAndTipoIdentExcepUno() {
        Mockito.when(afilPersonaRepository.findByTipoIdentificacionAndNumeroIdentificacion(TIPO_DOC, NUM_DOC))
                .thenReturn(Optional.empty());
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            afiliadoService.findPersonaByNumIdentAndTipoIdent(TIPO_DOC, NUM_DOC);
        });
        Assertions.assertEquals(MensajeError.ERROR_CONSULTA_AFILIADO, exception.getMessage());
    }

    @Test
    void findPersonaByNumIdentAndTipoIdentExcepDos() {
        AfilPersonaEntity afilPersona = new AfilPersonaEntity();
        afilPersona.setIdPersona("1");

        Mockito.when(afilPersonaRepository
                        .findByTipoIdentificacionAndNumeroIdentificacion(
                                Mockito.anyString(), Mockito.anyString()))
                .thenReturn(Optional.of(afilPersona));

        Mockito.when(afilPersonaNaturalRepository.findByIdPersona(Mockito.anyString()))
                .thenReturn(Optional.empty());
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            afiliadoService.findPersonaByNumIdentAndTipoIdent(TIPO_DOC, NUM_DOC);
        });
        Assertions.assertEquals(MensajeError.ERROR_CONSULTA_AFILIADO, exception.getMessage());
    }

}