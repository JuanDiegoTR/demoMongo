package com.prueba.restapi.repository;

import com.prueba.restapi.entity.AfiliadoVigenciaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AfiliadoVigenciaRepository extends MongoRepository<AfiliadoVigenciaEntity, String> {
}
