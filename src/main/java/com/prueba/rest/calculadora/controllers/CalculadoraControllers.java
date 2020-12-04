package com.prueba.rest.calculadora.controllers;

import com.prueba.rest.calculadora.common.Constants;
import com.prueba.rest.calculadora.common.Error;
import com.prueba.rest.calculadora.models.Result;
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

    @PostMapping(Constants.URL_ADD)
    public Result add(@RequestBody AddOperation operation) {
        Result result = new Result();

        if(null != operation) {

        } else {
            // Operación no se ha recibido
            result.setMensaje(Error.ERROR_OPERACION.getError());
        }

        return result;
    }

    @PostMapping(Constants.URL_SUBS)
    public Result substract(@RequestBody SubstractOperacion operation) {
        Result result = new Result();

        if(null != operation) {

        } else {
            // Operación no se ha recibido
            result.setMensaje(Error.ERROR_OPERACION.getError());
            result.setOk(Boolean.FALSE);
        }

        return result;
    }


}
