package com.prueba.rest.calculadora.models.operationstype;

import com.prueba.rest.calculadora.models.Result;

public interface Operation {

    /**
     * Para ejecutar cada operación de forma secuencial.
     * @return Result resultado de la operación
     * @throws Exception
     */
    public Result run() throws Exception;
}
