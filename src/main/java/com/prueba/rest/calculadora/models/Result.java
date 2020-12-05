package com.prueba.rest.calculadora.models;

import java.math.BigDecimal;

/**
 * Resultado de la operación. Objeto devuelto por el servicio.
 */
public class Result {

    /**
     * Resultado de la operación.
     */
    private BigDecimal resultado;

    /**
     * Indicador de que el servicio ha ido correctamente o ha habido algún error.
     */
    private Boolean ok = Boolean.TRUE;

    /**
     * Mensaje descriptivo de la operación o del error si lo hubiera.
     */
    private String mensaje;

    /**
     * Tipo de operación que se ha realizado.
     */
    private String operacion;

    /**
     * empty constructor
     */
    public Result() {
    }

    /**
     * Contructor
     * @param resultado BigDecimal
     * @param ok Boolean
     * @param mensaje String
     * @param operacion String
     */
    public Result(BigDecimal resultado, Boolean ok, String mensaje, String operacion) {
        this.resultado = resultado;
        this.ok = ok;
        this.mensaje = mensaje;
        this.operacion = operacion;
    }

    /*
    Getters and Setters
     */

    public BigDecimal getResultado() {
        return resultado;
    }

    public void setResultado(BigDecimal resultado) {
        this.resultado = resultado;
    }

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }


    @Override
    public String toString() {
        return "Result: {Ok= "+ this.ok + " operacion=" + this.operacion +" Mensaje=" + this.mensaje + " resultado=" + this.resultado + "}";
    }

}
