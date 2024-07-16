package com.prueba.restapi.service.Impl;

import com.prueba.restapi.dto.AfiliadoDTO;
import com.prueba.restapi.entity.AfiliadoEntity;
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

    @Test
    void findByNumIdentAndTipoIdent() throws Exception {

        Mockito.when(afiliadoRepository
                        .findByTipoIdentificacionAndNumeroIdentificacion(
                                Mockito.anyString(), Mockito.anyString()))
                .thenReturn(Optional.of(new AfiliadoEntity()));

        AfiliadoDTO resp = afiliadoService.findByNumIdentAndTipoIdent("CC", "91280385");
        Assertions.assertNotNull(resp);
    }
}