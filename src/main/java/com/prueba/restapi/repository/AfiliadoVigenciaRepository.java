package com.prueba.restapi.repository;

import com.prueba.restapi.entity.AfiliadoVigenciaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AfiliadoVigenciaRepository extends MongoRepository<AfiliadoVigenciaEntity, String> {

    @Query(value = "{ 'tipoIdentificacionId': ?0, 'numeroIdentificacion': ?1 }", sort = "{ 'secuencia': -1 }")
    List<AfiliadoVigenciaEntity> findByTipoIdentificacionIdAndNumeroIdentificacion(String tipoIdentificacion, String numeroIdentificacion);
}
