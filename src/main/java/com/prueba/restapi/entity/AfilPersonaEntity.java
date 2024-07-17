package com.prueba.restapi.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "afilPersona")
public class AfilPersonaEntity {

    @Id
    private String id;
    @Field(value = "tipoIdentificacion")
    private String tipoIdentificacion;
    @Field(value = "numeroIdentificacion")
    private String numeroIdentificacion;
    @Field(value = "personaId")
    private String idPersona;

}
