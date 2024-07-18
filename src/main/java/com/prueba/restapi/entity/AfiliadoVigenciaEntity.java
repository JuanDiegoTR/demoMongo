package com.prueba.restapi.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "CTA_AFILIADO_VIGENCIA")
public class AfiliadoVigenciaEntity {

    @Id
    @Field(value = "AFILIADO_VIGENCIA_ID")
    private String id;

    @Field(value = "AFILIADO_FONDO_ID")
    private String afiliadoFondoId;

    @Field(value = "CUENTA_ID")
    private String cuentaId;

    @Field(value = "SECUENCIA")
    private String secuencia;

    @Field(value = "FECHA_SOLICITUD_ENTRADA")
    private String fechaSolicitudEntrada;

    @Field(value = "FECHA_EFECTIVIDAD_ENTRADA")
    private String fechaEfectividadEntrada;

    @Field(value = "TIPO_VINCULACION_ID")
    private String tipoVinculacionId;

    @Field(value = "CODIGO_ENTIDAD_ORIGEN")
    private String codigoEntidadOrigen;

    @Field(value = "FECHA_SOLICITUD_SALIDA")
    private String fechaSolicitudSalida;

    @Field(value = "FECHA_EFECTIVIDAD_SALIDA")
    private String fechaEfectividadSalida;

    @Field(value = "CODIGO_ENTIDAD_SALIDA")
    private String codigoEntidadSalida;

    @Field(value = "FECHA_PAGO")
    private String fechaPago;

    @Field(value = "FECHA_DESISTIMIENTO")
    private String fechaDesistimiento;

    @Field(value = "RADICADO")
    private String radicado;

    @Field(value = "FOLIO_AFILIACION")
    private String folioAfiliacion;

    @Field(value = "FOLIO_SALIDA")
    private String folioSalida;

    @Field(value = "TIPO_IDENTIFICACION_ID")
    private String tipoIdentificacionId;

    @Field(value = "NUMERO_IDENTIFICACION")
    private String numeroIdentificacion;

    @Field(value = "ESTADO_AFILIADO_FONDO_ID")
    private String estadoAfiliadoFondoId;

    @Field(value = "SUBESTADO_AFILIADO_FONDO_ID")
    private String subestadoAfiliadoFondoId;

    @Field(value = "PROBLEMAS_REGISTRADURIA")
    private String problemasRegistraduria;

    @Field(value = "INDICADOR_EMBARGO")
    private String indicadorEmbargo;

    @Field(value = "VALIDEZ_VIGENCIA")
    private String validezVigencia;

    @Field(value = "ESTADO_RECONSTRUCCION")
    private String estadoReconstruccion;

    @Field(value = "FUENTE_ACTUALIZACION")
    private String fuenteActualizacion;

    @Field(value = "FECHA_SOL_PRI_ING_RAI")
    private String fechaSolPriIngRai;

    @Field(value = "FECHA_EFE_PRI_ING_RAI")
    private String fechaEfePriIngRai;

    @Field(value = "FECHA_SOL_ULT_ING_RAI")
    private String fechaSolUltIngRai;

    @Field(value = "FECHA_EFE_ULT_ING_RAI")
    private String fechaEfeUltIngRai;

    @Field(value = "FECHA_CREACION")
    private String fechaCreacion;

    @Field(value = "USUARIO_CREACION")
    private String usuarioCreacion;

    @Field(value = "FECHA_ULTIMA_MODIFICACION")
    private String fechaUltimaModificacion;

    @Field(value = "USUARIO_ULTIMA_MODIFICACION")
    private String usuarioUltimaModificacion;

    @Field(value = "MFONDO_SCN")
    private String mfondoScn;

    @Field(value = "CODIGO_ADMINISTRADORA")
    private String codigoAdministradora;

    @Field(value = "VIGENCIA_CERTIFICADA")
    private String vigenciaCertificada;

    @Field(value = "FECHA_CERTIFICACION")
    private String fechaCertificacion;

}
