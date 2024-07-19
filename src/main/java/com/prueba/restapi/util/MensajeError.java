package com.prueba.restapi.util;

public final class MensajeError {

    public static final String ERROR_CONSULTA_AFILIADO = "No se ah encontrado infomacion del afiliado a consultar.";
    public static final String ERROR_CONSULTA_DEMANDA = "No se ah encontrado infomacion de la demanda a consultar.";

    public static class ErrorTipoIdentificaion {
        public static final String ERROR_NOT_BLANCK= "El parametro tipo de identificacion es obligatorio.";
        public static final String ERROR_SIZE = "Error al ingresar el parametro obligatorio tipo de identificacion.";
        public static final String ERROR_PATRON = "El tipo de identificación debe contener solo letras.";

        private ErrorTipoIdentificaion() {
        }
    }

    public static class ErrorNumeroIdentificacion {
        public static final String ERROR_NOT_BLANCK= "El parametro numero de identificacion es obligatorio.";
        public static final String ERROR_SIZE = "Error al ingresar el parametro obligatorio numero de identificacion.";
        public static final String ERROR_PATRON = "El numero de identificación debe contener solo números.";

        private ErrorNumeroIdentificacion() {
        }
    }

    public static class ErrorDemandaId {
        public static final String ERROR_NOT_BLANCK= "El parametro demanda id es obligatorio.";
        public static final String ERROR_PATRON = "El parametro demanda id debe contener solo números.";

        private ErrorDemandaId() {
        }
    }

    private MensajeError() {
    }
}
