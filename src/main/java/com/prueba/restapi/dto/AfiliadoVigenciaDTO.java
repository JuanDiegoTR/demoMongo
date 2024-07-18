package com.prueba.restapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AfiliadoVigenciaDTO {

    private String id;
    private String afiliadoFondoId;
    private String cuentaId;
    private String secuencia;
    private String fechaSolicitudEntrada;
    private String fechaEfectividadEntrada;
    private String tipoVinculacionId;
    private String codigoEntidadOrigen;
    private String fechaSolicitudSalida;
    private String fechaEfectividadSalida;
    private String codigoEntidadSalida;
    private String fechaPago;
    private String fechaDesistimiento;
    private String radicado;
    private String folioAfiliacion;
    private String folioSalida;
    private String tipoIdentificacionId;
    private String numeroIdentificacion;
    private String estadoAfiliadoFondoId;
    private String subestadoAfiliadoFondoId;
    private String problemasRegistraduria;
    private String indicadorEmbargo;
    private String validezVigencia;
    private String estadoReconstruccion;
    private String fuenteActualizacion;
    private String fechaSolPriIngRai;
    private String fechaEfePriIngRai;
    private String fechaSolUltIngRai;
    private String fechaEfeUltIngRai;
    private String fechaCreacion;
    private String usuarioCreacion;
    private String fechaUltimaModificacion;
    private String usuarioUltimaModificacion;
    private String mfondoScn;
    private String codigoAdministradora;
    private String vigenciaCertificada;
    private String fechaCertificacion;

}
