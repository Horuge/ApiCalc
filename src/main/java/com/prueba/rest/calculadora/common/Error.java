package com.prueba.rest.calculadora.common;

/**
 * Enumerado para controlar los errores.
 */
public enum Error {

    /**
     * Error: no se han introducido valores númericos.
     */
    ERROR_NOT_NUMBER("Error: no se han introducido valores númericos.");
    private String error;

    Error(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
