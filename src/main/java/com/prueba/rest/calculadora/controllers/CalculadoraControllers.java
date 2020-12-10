package com.prueba.rest.calculadora.controllers;

import com.prueba.rest.calculadora.common.Constants;
import com.prueba.rest.calculadora.common.Error;
import com.prueba.rest.calculadora.models.Result;
import com.prueba.rest.calculadora.models.operationstype.Operation;
import com.prueba.rest.calculadora.models.operationstype.operations.AddOperation;
import com.prueba.rest.calculadora.models.operationstype.operations.SubtractOperacion;
import io.corp.calculator.TracerImpl;
import org.springframework.web.bind.annotation.*;

/**
 * Controller. Definicion servicios REST.
 */
@RestController
@RequestMapping(Constants.URL)
// Permitimos Cross Origin.
@CrossOrigin()
public class CalculadoraControllers {

    //@Autowired
    //private TracerImpl tracer;
    TracerImpl tracer = new TracerImpl();

    /**
     * Servicio de suma
     * @param operation AddOperation
     * @return Resultado de la operación de suma
     */
    @PostMapping(Constants.URL_ADD)
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
    }

    /**
     * Servicio de resta
     * @param operation SubstractOperacion
     * @return Resultado de la operación de resta
     */
    @PostMapping(Constants.URL_SUBS)
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
    }

    /**
     * Ejecuta la operación.
     * @param operation Operation
     * @return Result Resultado con la operación o con el error.
     */
    private Result doOperacion(Operation operation) {
        Result result  = new Result();
        try {
            // Obtencion del resultado de la operación.
            tracer.trace("Ejecutando operación.");
            result = operation.run();
        } catch(Exception e) {
            tracer.trace("Error durante la ejecución del servicio: ");
            tracer.trace(e);
            // Error en operation.
            result.setMensaje(Error.ERROR_OPE_EXECUTION.getError());
        }

        tracer.trace(result);

        return result;
    }

}
