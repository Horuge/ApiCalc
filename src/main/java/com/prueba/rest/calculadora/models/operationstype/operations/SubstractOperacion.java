package com.prueba.rest.calculadora.models.operationstype.operations;

import com.prueba.rest.calculadora.common.Constants;
import com.prueba.rest.calculadora.common.Error;
import com.prueba.rest.calculadora.models.Result;

import java.math.BigDecimal;

public class SubstractOperacion extends OperationImpl {

    @Override
    public Result run() throws Exception {
        Result result = new Result();
        result.setOperacion(Constants.RESTA);
        getTracer().trace(Constants.RESTA);

        if(null == this.ope1 || null == this.ope2 ) {
            // Alguno de los operadores es nulo.
            result.setMensaje(Error.ERROR_SUBS.getError());
            result.setOk(Boolean.FALSE);
            // Trazamos la operación y el error.
            getTracer().trace(Error.ERROR_SUBS.getError());
        } else {
            result.setResultado(ope1.subtract(ope2));
            result.setMensaje(ope1.toString() + " - " + operandoToStringNegativo(ope2) + " = " + result.toString());
            getTracer().trace(Constants.OK);
        }

        return result;
    }

    /**
     * Método para indicar la resta con un sustraendo negativo, si es negativo lo pone entre parentesis.
     * @param ope Bigdecimal
     * @return String del operador, si es negativo entre paréntesis.
     */
    private String operandoToStringNegativo(BigDecimal ope) {
        return ope.compareTo(BigDecimal.ZERO) == -1 ? "(".concat(ope.toString()).concat(")") : ope.toString();
    }

    @Override
    public String toString() {
        return "AddOperacion: {minuendo=" + ope1.toString() +
                ", sustraendo=" + ope2.toString() + "}";
    }
}
