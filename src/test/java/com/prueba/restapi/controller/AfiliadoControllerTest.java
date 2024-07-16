package com.prueba.restapi.controller;

import com.prueba.restapi.dto.AfiliadoDTO;
import com.prueba.restapi.entity.AfiliadoEntity;
import com.prueba.restapi.service.AfiliadoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AfiliadoControllerTest {

    @InjectMocks private AfiliadoController afiliadoController;
    @Mock private AfiliadoService afiliadoService;

    @Test
    void findByNumIdentAndTipoIdent() throws Exception {

        Mockito.when(afiliadoService
                        .findByNumIdentAndTipoIdent(Mockito.anyString(), Mockito.anyString()))
                .thenReturn(new AfiliadoDTO());

        AfiliadoDTO resp = afiliadoController.findByNumIdentAndTipoIdent("CC", "91280385");
        Assertions.assertNotNull(resp);
    }
}