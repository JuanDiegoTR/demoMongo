package com.prueba.restapi.repository;

import com.prueba.restapi.entity.JurCumpliminetoCXPEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JurCumpliminetoCXPRepository extends MongoRepository<JurCumpliminetoCXPEntity, String> {
    List<JurCumpliminetoCXPEntity> findBydemandaIdAndEstado(String demandaId, String estado);
}
