package com.prueba.rest.calculadora.controllers;

import com.prueba.rest.calculadora.common.Constants;
import com.prueba.rest.calculadora.common.Error;
import com.prueba.rest.calculadora.models.Result;
import com.prueba.rest.calculadora.models.operationstype.Operation;
import com.prueba.rest.calculadora.models.operationstype.operations.AddOperation;
import com.prueba.rest.calculadora.models.operationstype.operations.SubstractOperacion;
import org.springframework.web.bind.annotation.*;

/**
 * Controller. Definicion servicios REST.
 */
@RestController
@RequestMapping(Constants.URL)
// Permitimos Cross Origin.
@CrossOrigin()
public class CalculadoraControllers {

    /**
     * Servicio de suma
     * @param operation
     * @return Resultado de la operación de suma
     */
    @PostMapping(Constants.URL_ADD)
    public Result add(@RequestBody AddOperation operation) {
        Result result = new Result();

        if(null != operation) {
            // Si no es nulo realiza la operación de suma.
            result = this.doOperacion(operation);
        } else {
            // Operación no se ha recibido
            result.setMensaje(Error.ERROR_OPERACION.getError());
        }

        return result;
    }

    /**
     * Servicio de resta
     * @param operation
     * @return Resultado de la operación de resta
     */
    @PostMapping(Constants.URL_SUBS)
    public Result substract(@RequestBody SubstractOperacion operation) {
        Result result = new Result();

        if(null != operation) {
            // Si no es nulo realiza la operación de resta.
            result = this.doOperacion(operation);
        } else {
            // Operación no se ha recibido
            result.setMensaje(Error.ERROR_OPERACION.getError());
            result.setOk(Boolean.FALSE);
        }

        return result;
    }

    /**
     * Ejecuta la operación.
     * @param operation
     * @return Result Resultado con la operación o con el error.
     */
    private Result doOperacion(Operation operation) {
        Result result  = new Result();
        try {
            // Obtencion del resultado de la operación.
            result = operation.run();
        } catch(Exception e) {
            // Error en operation.
            result.setMensaje(Error.ERROR_OPE_EXECUTION.getError());
        }

        return result;
    }

}
