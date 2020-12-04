package com.prueba.rest.calculadora.common;

/**
 * Enumerado para controlar los errores.
 */
public enum Error {

    /**
     * Error: no se han introducido valores númericos.
     */
    ERROR_ADD("Error: no se han introducido valores númericos en alguno de los sumandos."),
    ERROR_SUBS("Error: minuendo o sustraendo no son valores númericos."),
    ERROR_OPERACION("Error: Operación no inicializada."),
    ERROR_OPE_EXECUTION("Error: Error ejecutando operacion");
    private String error;

    Error(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
