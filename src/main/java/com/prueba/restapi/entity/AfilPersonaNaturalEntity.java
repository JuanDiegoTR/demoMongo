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
@Document(collection = "afilPersonaNatural")
public class AfilPersonaNaturalEntity {

    @Id
    private String id;
    @Field(value = "primerNombre")
    private String primerNombre;
    @Field(value = "segundoNombre")
    private String segundoNombre;
    @Field(value = "primerApellido")
    private String primerApellido;
    @Field(value = "segundoApellido")
    private String segundoApellido;
    @Field(value = "personaId")
    private String idPersona;

}
