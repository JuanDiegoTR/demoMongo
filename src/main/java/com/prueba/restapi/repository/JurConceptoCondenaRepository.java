package com.prueba.restapi.repository;

import com.prueba.restapi.entity.JurConceptoCondenaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JurConceptoCondenaRepository extends MongoRepository<JurConceptoCondenaEntity, String> {
    @Query(value = "{ 'conceptoCondenaId' : { $in : ?0 }, 'nombreCondena': {$in:['Costas','Intereses moratorios','Indexacion','Retroactivo']} }",
            fields = "{ 'conceptoCondenaId' : 1, 'nombreCondena' : 1, '_id' : 0 }")
    List<JurConceptoCondenaEntity> findByConceptoCondenaIdInAndNombreCondenaIn(List<String> conceptoCondenaId);
}
