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
@Document(collection = "JUR_CUMPLIMIENTO_CXP")
public class JurCumpliminetoCXPEntity {

    @Id
    private String id;
    @Field(value = "CUMPLIMIENTO_CXP_ID")
    private String cumplimientoCxpId;
    @Field(value = "DEMANDA_ID")
    private String demandaId;
    @Field(value = "ESTADO")
    private String estado;
    @Field(value = "FORMA_PAGO_ID")
    private String formaPagoId;
    @Field(value = "OFICINA_PORVENIR_ID")
    private String oficinaPorvenirId;
    @Field(value = "CONCEPTO_ID")
    private String conceptoId;
    @Field(value = "CUENTA_PROVISION")
    private String cuentaProvision;
    @Field(value = "VALOR_PAGO")
    private String valorPago;
    @Field(value = "FECHA_CREACION_CXP")
    private String fechaCreacionCxp;
    @Field(value = "FECHA_CREACION")
    private String fechaCreacion;
    @Field(value = "USUARIO_CREACION")
    private String usuarioCreacion;
    @Field(value = "USUARIO_ULTIMA_MODIFICACION")
    private String usuarioUltimaModificacion;
    @Field(value = "FECHA_ULTIMA_MODIFICACION")
    private String fechaUltimaModificacion;
    @Field(value = "ASIENTO_CONTABLE")
    private String asientoContable;
    @Field(value = "MFONDOS_SCN")
    private String mfondosScn;
    @Field(value = "CODIGO_JUZGADO")
    private String codigoJuzgado;
    @Field(value = "CODIGO_SBAN")
    private String codigoSban;
    @Field(value = "LIQUIDACION_ID")
    private String liquidacionId;
    @Field(value = "ASIENTO_CONTABLE_ADICIONAL")
    private String asientoContableAdicional;
}
