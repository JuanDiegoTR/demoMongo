package com.prueba.restapi.entity;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "JUR_CONCEPTO_CONDENA")
public class JurConceptoCondenaEntity {
    @Id
    private String id;
    @Field(value = "CONCEPTO_CONDENA_ID")
    private String conceptoCondenaId;
    @Field(value = "NOMBRE_CONDENA")
    private String nombreCondena;
    @Field(value = "ESTADO_CONDENA")
    private String estadoCondena;
    @Field(value = "USUARIO_CREACION")
    private String usuarioCreacion;
    @Field(value = "FECHA_CREACION")
    private String fechaCreacion;
    @Field(value = "USUARIO_ULTIMA_MODIFICACION")
    private String usuarioUltimaModificacion;
    @Field(value = "FECHA_ULTIMA_MODIFICACION")
    private String fechaUltimaModificacion;
    @Field(value = "MFONDOS_SCN")
    private String mfondosScn;
    @Field(value = "SUB_AUXILIAR")
    private String subAuxiliar;
}
