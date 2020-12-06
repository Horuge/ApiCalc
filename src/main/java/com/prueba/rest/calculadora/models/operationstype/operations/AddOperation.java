package com.prueba.rest.calculadora.models.operationstype.operations;

import com.prueba.rest.calculadora.common.Constants;
import com.prueba.rest.calculadora.common.Error;
import com.prueba.rest.calculadora.models.Result;
import io.corp.calculator.TracerImpl;

import java.math.BigDecimal;

/**
 * Implementación de la operación de suma.
 */
public class AddOperation extends OperationImpl {

    // @Autowired
    // private TracerImpl tracer;

    TracerImpl tracer = new TracerImpl();

    @Override
    public Result run() throws Exception {
        Result result = new Result();
        result.setOperacion(Constants.ADD);
        tracer.trace(Constants.ADD);

        if(null == this.ope1  || null == this.ope2) {
            // Alguno de los operadores es nulo.
            result.setMensaje(Error.ERROR_ADD.getError());
            result.setOk(Boolean.FALSE);
            // Trazamos la operación y el error.
            tracer.trace(Error.ERROR_ADD.getError());
        } else {
            final BigDecimal resultado = ope1.add(ope2);
            result.setResultado(resultado);
            result.setMensaje(ope1.toString() + " + " + operandoToStringNegativo(ope2) + " = " + resultado);
            tracer.trace(Constants.OK);
        }

        return result;
    }

    /**
     * Método para indicar la suma con un sumando negativo si es negativo lo pone entre parentesis.
     * @param ope Bigdecimal
     * @return String del operador, si es negativo entre parentesis.
     */
    private String operandoToStringNegativo(BigDecimal ope) {
        return ope.compareTo(BigDecimal.ZERO) < 0 ? "(".concat(ope.toString()).concat(")") : ope.toString();
    }

    @Override
    public String toString() {
        return "AddOperacion: {sumando=" + ope1.toString() +
                ", sumador=" + ope2.toString() + "}";
    }
}
