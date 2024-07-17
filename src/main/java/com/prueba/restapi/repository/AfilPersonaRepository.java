package com.prueba.restapi.repository;

import com.prueba.restapi.entity.AfilPersonaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AfilPersonaRepository extends MongoRepository<AfilPersonaEntity, String> {
    Optional<AfilPersonaEntity> findByTipoIdentificacionAndNumeroIdentificacion(String tipoIdentificacion, String numeroIdentificacion);
}
