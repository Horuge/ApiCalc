package com.prueba.rest.calculadora.services;

import com.prueba.rest.calculadora.models.Result;
import com.prueba.rest.calculadora.models.operationstype.operations.OperationImpl;

public interface OperacionesService {

    /**
     * Servicio para realizar la operación y separar capas.
     * @param tipo tipo de operacion
     * @param operation operadores de la operación a realizar.
     * @return Result Resultado de la operación
     */
    Result operacionBasica(String tipo, OperationImpl operation);
}
