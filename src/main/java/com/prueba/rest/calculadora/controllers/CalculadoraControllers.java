package com.prueba.rest.calculadora.controllers;

import com.prueba.rest.calculadora.common.Constants;
import com.prueba.rest.calculadora.common.Error;
import com.prueba.rest.calculadora.models.Result;
import com.prueba.rest.calculadora.models.operationstype.operations.OperationImpl;
import com.prueba.rest.calculadora.services.OperacionesService;
import io.corp.calculator.TracerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

/**
 * Controller. Definición servicios REST.
 */
@RestController
@RequestMapping(Constants.URL)
// Permitimos Cross Origin.
@CrossOrigin()
public class CalculadoraControllers {

    @Autowired
    private OperacionesService operacionesService;

    //@Autowired
    //private TracerImpl tracer;
    TracerImpl tracer = new TracerImpl();

    @GetMapping({"/{tipo}"})
    public Result operation(@PathVariable String tipo, @RequestBody OperationImpl operation) {
        Result result = new Result();
        if(null != operation && null != tipo) {
            // Si los parámetros no son nulos realizamos la operación.
            result = operacionesService.operacionBasica(tipo, operation);
        } else {
            // Los parámetros recibidos no son correctos.
            tracer.trace(Error.ERROR_OPE_EXECUTION.getError());
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Error.ERROR_OPE_EXECUTION.getError());
        }
        return result;
    }

    @GetMapping({"/{tipo}/ope"})
    public Result getOperationParam(@PathVariable String tipo, @RequestParam BigDecimal ope1, @RequestParam BigDecimal ope2) {
        Result result = new Result();
        if(null != ope1 && null != tipo && null != ope2) {
            // Si los parámetros no son nulos realizamos la operación.
            result = operacionesService.operacionBasicaParam(tipo, ope1, ope2);
        } else {
            // Ha habido un error en la url
            tracer.trace(Error.ERROR_OPE_EXECUTION.getError());
            // throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Error.ERROR_OPE_EXECUTION.getError());
        }
        return result;
    }

}
