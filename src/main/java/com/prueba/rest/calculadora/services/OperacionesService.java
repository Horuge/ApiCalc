package com.prueba.rest.calculadora.services;

import com.prueba.rest.calculadora.models.Result;
import com.prueba.rest.calculadora.models.operationstype.operations.OperationImpl;

import java.math.BigDecimal;

public interface OperacionesService {

    /**
     * Servicio para realizar la operación y separar capas.
     * @param tipo tipo de operacion
     * @param operation operadores de la operación a realizar.
     * @return Result Resultado de la operación
     */
    Result operacionBasica(String tipo, OperationImpl operation);

    /**
     * Operacion realizada desde parámetros.
     * @param tipo tipo de operacion, suma o resta
     * @param ope1 operador 1
     * @param ope2 operador 2
     * @return Resultado de la operación
     */
    Result operacionBasicaParam(String tipo, BigDecimal ope1, BigDecimal ope2);
}
