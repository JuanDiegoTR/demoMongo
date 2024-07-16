package com.prueba.restapi.repository;

import com.prueba.restapi.entity.AfiliadoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AfiliadoRepository extends MongoRepository<AfiliadoEntity, String> {

    Optional<AfiliadoEntity> findByTipoIdentificacionAndNumeroIdentificacion(String tipoIdentificacion, String numeroIdentificacion);

}
