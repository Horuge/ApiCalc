package com.prueba.rest.calculadora.services;

import com.prueba.rest.calculadora.common.Constants;
import com.prueba.rest.calculadora.common.Error;
import com.prueba.rest.calculadora.models.Result;
import com.prueba.rest.calculadora.models.operationstype.Operation;
import com.prueba.rest.calculadora.models.operationstype.operations.AddOperation;
import com.prueba.rest.calculadora.models.operationstype.operations.OperationImpl;
import com.prueba.rest.calculadora.models.operationstype.operations.SubtractOperacion;
import io.corp.calculator.TracerImpl;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@Service
public class OperacionesServiceImpl implements OperacionesService{

    // @Autowired
    // private TracerImpl tracer;

    TracerImpl tracer = new TracerImpl();

    @Override
    public Result operacionBasica(String tipo, OperationImpl operation) throws ResponseStatusException{

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
            default:
                tracer.trace(Error.ERROR_OPERACION_NO_ENCONTRADA.getError());
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, Error.ERROR_OPERACION_NO_ENCONTRADA.getError());
        }

        return result;
    }

    @Override
    public Result operacionBasicaParam(String tipo, BigDecimal ope1, BigDecimal ope2) throws ResponseStatusException {
        Result result = new Result();

        // Comprueba que tipo de operación se ha solicitado.
        switch (tipo.toUpperCase()) {
            // Suma
            case Constants.ADD:
                tracer.trace("Operación: " + Constants.ADD);
                AddOperation addOperation = new AddOperation();
                addOperation.setOpe1(ope1);
                addOperation.setOpe2(ope2);
                result = doOperacion(addOperation);
                break;
            // Resta
            case Constants.RESTA:
                tracer.trace("Operación: " + Constants.RESTA);
                SubtractOperacion restaOperation = new SubtractOperacion();
                restaOperation.setOpe1(ope1);
                restaOperation.setOpe2(ope2);
                result = doOperacion(restaOperation);
                break;
            default:
                tracer.trace(Error.ERROR_OPERACION_NO_ENCONTRADA.getError());
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, Error.ERROR_OPERACION_NO_ENCONTRADA.getError());
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
