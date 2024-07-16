package com.prueba.restapi.entity;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "afiliado")
public class AfiliadoEntity {

    @Id
    private String id;
    @Field(value = "FONDO_ID")
    private String fondoId;
    @Field(value = "AFILIADO_FONDO_ID")
    private String afiliadoFondoId;
    @Field(value = "TIPO_IDENTIFICACION")
    private String tipoIdentificacion;
    @Field(value = "NUMERO_IDENTIFICACION")
    private String numeroIdentificacion;
    @Field(value = "PROBLEMAS_REGISTRADURIA")
    private String problemasRegistraduria;
    @Field(value = "PRIMER_APELLIDO")
    private String primerApellido;
    @Field(value = "SEGUNDO_APELLIDO")
    private String segundoApellido;
    @Field(value = "PRIMER_NOMBRE")
    private String primerNombre;
    @Field(value = "SEGUNDO_NOMBRE")
    private String segundoNombre;
    @Field(value = "CODIGO_SOUNDEX")
    private String codigoSoundex;
    @Field(value = "SEXO")
    private String sexo;
    @Field(value = "NACIONALIDAD")
    private String nacionalidad;
    @Field(value = "INDICADOR_CARNET")
    private String indicadorCarnet;
    @Field(value = "OCUPACION_CARGO_ACTUAL")
    private String ocupacionCargoActual;
    @Field(value = "INDICADOR_CORRESPONDENCIA")
    private String indicadorCorrespondencia;
    @Field(value = "INDICADOR_ENVIO_ELECTRONICO")
    private String indicadorEnvioElectronico;
    @Field(value = "DIRECCION")
    private String direccion;
    @Field(value = "TELEFONO")
    private String telefono;
    @Field(value = "BARRIO")
    private String barrio;
    @Field(value = "APARTADO_AEREO")
    private String apartadoAereo;
    @Field(value = "CODIGO_CIUDAD")
    private String codigoCiudad;
    @Field(value = "DIRECCION_EMAIL")
    private String direccionEmail;
    @Field(value = "FECHA_NACIMIENTO")
    private LocalDateTime fechaNacimiento;
    @Field(value = "FECHA_SINIESTRO")
    private LocalDateTime fechaSiniestro;
    @Field(value = "ESTADO_PENSION")
    private String estadoPension;
    @Field(value = "TIPO_SINIESTRO")
    private String tipoSiniestro;
    @Field(value = "ULTIMA_LIQUIDACION_OBP")
    private String ultimaLiquidacionObp;
    @Field(value = "USUARIO_CREACION")
    private String usuarioCreacion;
    @Field(value = "FECHA_CREACION")
    private LocalDateTime fechaCreacion;
    @Field(value = "USUARIO_ULTIMA_MODIFICACION")
    private String usuarioUltimaModificacion;
    @Field(value = "FECHA_ULTIMA_MODIFICACION")
    private LocalDateTime fechaUltimaModificacion;
    @Field(value = "MFONDOS_SCN")
    private String mfondosScn;
    @Field(value = "CELULAR")
    private String celular;

}
