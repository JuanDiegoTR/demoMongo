package com.prueba.restapi.service.Impl;

import com.prueba.restapi.dto.AfiliadoDTO;
import com.prueba.restapi.entity.AfiliadoEntity;
import com.prueba.restapi.repository.AfiliadoRepository;
import com.prueba.restapi.service.AfiliadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AfiliadoServiceImpl implements AfiliadoService {

    private final AfiliadoRepository afiliadoRepository;

    @Override
    public AfiliadoDTO findByNumIdentAndTipoIdent(String tipoIdentificacion, String numeroIdentificacion) throws Exception {

        AfiliadoEntity afiliado = afiliadoRepository
                .findByTipoIdentificacionAndNumeroIdentificacion(tipoIdentificacion, numeroIdentificacion)
                .orElseThrow(
                        () -> new Exception("No se ah encontrado infomacion del afiliado a consulta.")
                );

        return mapperResponse(afiliado);
    }

    private AfiliadoDTO mapperResponse(AfiliadoEntity afiliadoEntity) {

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

}
