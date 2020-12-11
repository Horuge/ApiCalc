package com.prueba.rest.calculadora.models.operationstype.operations;

import com.prueba.rest.calculadora.models.operationstype.Operation;

import java.math.BigDecimal;


/**
 * Implementa la interface de Operacion y añade las operaciones en las otras clases
 */
public abstract class OperationImpl implements Operation {

    /**
     * Operador 1
     */
    protected BigDecimal ope1;

    /**
     * Operador 2
     */
    protected BigDecimal ope2;


    public BigDecimal getOpe1() {
        return ope1;
    }

    public void setOpe1(BigDecimal ope1) {
        this.ope1 = ope1;
    }

    public BigDecimal getOpe2() {
        return ope2;
    }

    public void setOpe2(BigDecimal ope2) {
        this.ope2 = ope2;
    }

}
