package com.prueba.restapi.controller;

import com.prueba.restapi.service.AfiliadoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class AfiliadoControllerTest {

    @InjectMocks private AfiliadoController afiliadoController;
    @Mock private AfiliadoService afiliadoService;

    final String TIPO_DOC = "CC";
    final String NUM_DOC = "91280385";

    @Test
    void findByNumIdentAndTipoIdent() throws Exception {
        Mockito.when(afiliadoService
                        .findByNumIdentAndTipoIdent(Mockito.anyString(), Mockito.anyString()))
                .thenReturn(new ResponseEntity<>(HttpStatus.OK));

        ResponseEntity resp = afiliadoController.findByNumIdentAndTipoIdent(TIPO_DOC, NUM_DOC);
        Assertions.assertNotNull(resp);
    }

    @Test
    void findPersonaByNumIdentAndTipoIdent() throws Exception {
        Mockito.when(afiliadoService
                        .findPersonaByNumIdentAndTipoIdent(Mockito.anyString(), Mockito.anyString()))
                .thenReturn(new ResponseEntity<>(HttpStatus.OK));

        ResponseEntity resp = afiliadoController.findPersonaByNumIdentAndTipoIdent(TIPO_DOC, NUM_DOC);
        Assertions.assertNotNull(resp);
    }

}