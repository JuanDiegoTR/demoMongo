package com.prueba.restapi.repository;

import com.prueba.restapi.entity.AfilPersonaNaturalEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AfilPersonaNaturalRepository extends MongoRepository<AfilPersonaNaturalEntity, String> {
    Optional<AfilPersonaNaturalEntity> findByIdPersona(String idPersona);
}
