package com.prueba.restapi.util;

public final class MensajeError {

    public static final String ERROR_CONSULTA_AFILIADO = "No se ah encontrado infomacion del afiliado a consulta.";

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

    private MensajeError() {
    }
}
