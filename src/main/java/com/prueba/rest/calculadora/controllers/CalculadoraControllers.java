package com.prueba.rest.calculadora.controllers;

import com.prueba.rest.calculadora.common.Constants;
import com.prueba.rest.calculadora.common.Error;
import com.prueba.rest.calculadora.models.Result;
import com.prueba.rest.calculadora.models.operationstype.operations.OperationImpl;
import com.prueba.rest.calculadora.services.OperacionesService;
import io.corp.calculator.TracerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * Controller. Definicion servicios REST.
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

    @PostMapping({"/{tipo}"})
    public Result operacion(@PathVariable String tipo, @RequestBody OperationImpl operation) {
        Result result = new Result();
        if(null != operation && null != tipo) {
            result = operacionesService.operacionBasica(tipo, operation);
        } else {
            result.setOk(Boolean.FALSE);
            result.setMensaje(Error.ERROR_OPE_EXECUTION.getError());
        }
        return result;
    }

    /**
     * Servicio de suma
     * @param operation AddOperation
     * @return Resultado de la operación de suma
     */
    /*@PostMapping(Constants.URL_ADD)
    public Result add(@RequestBody AddOperation operation) {
        Result result = new Result();

        tracer.trace("Operación de suma IN");

        if(null != operation) {
            // Si no es nulo realiza la operación de suma.
            result = this.doOperacion(operation);
        } else {
            // Operación no se ha recibido
            tracer.trace("No ha llegado la operación de suma.");
            result.setMensaje(Error.ERROR_OPERACION.getError());
        }

        tracer.trace("Operación de suma OUT");
        return result;
    }*/

    /**
     * Servicio de resta
     * @param operation SubstractOperacion
     * @return Resultado de la operación de resta
     */
    /*@PostMapping(Constants.URL_SUBS)
    public Result subtract(@RequestBody SubtractOperacion operation) {
        Result result = new Result();

        tracer.trace("Operación de resta IN");

        if(null != operation) {
            // Si no es nulo realiza la operación de resta.
            result = this.doOperacion(operation);
        } else {
            // Operación no se ha recibido
            result.setMensaje(Error.ERROR_OPERACION.getError());
            result.setOk(Boolean.FALSE);
        }

        tracer.trace("Operación de resta OUT");
        return result;
    }*/

}
