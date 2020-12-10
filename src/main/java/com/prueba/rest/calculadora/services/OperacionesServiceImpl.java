package com.prueba.rest.calculadora.services;

import com.prueba.rest.calculadora.common.Constants;
import com.prueba.rest.calculadora.common.Error;
import com.prueba.rest.calculadora.models.Result;
import com.prueba.rest.calculadora.models.operationstype.Operation;
import com.prueba.rest.calculadora.models.operationstype.operations.AddOperation;
import com.prueba.rest.calculadora.models.operationstype.operations.OperationImpl;
import com.prueba.rest.calculadora.models.operationstype.operations.SubtractOperacion;
import io.corp.calculator.TracerImpl;
import org.springframework.stereotype.Service;

@Service
public class OperacionesServiceImpl implements OperacionesService{

    // @Autowired
    // private TracerImpl tracer;

    TracerImpl tracer = new TracerImpl();

    public Result operacionBasica(String tipo, OperationImpl operation) {

        Result result = new Result();

        // Comprueba que tipo de operación se ha solicitado.
        switch (tipo.toUpperCase()) {
            // Suma
            case Constants.ADD:
                tracer.trace("Operación: " + Constants.ADD);
                result = doOperacion(operation);
                break;
            // Resta
            case Constants.RESTA:
                tracer.trace("Operación: " + Constants.RESTA);
                result = doOperacion(operation);
                break;
            // Por defecto envia ok false y operación.
            default:
                result.setOk(Boolean.FALSE);
                result.setMensaje(Error.ERROR_OPERACION.getError());
                break;
        }

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
