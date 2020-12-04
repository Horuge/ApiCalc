package com.prueba.rest.calculadora.models.operationstype.operations;

import com.prueba.rest.calculadora.models.operationstype.Operation;

import io.corp.calculator.TracerImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;


/**
 * Implementa la interface de Operacion y añade las operaciones en las otras clases
 */
public abstract class OperationImpl implements Operation {

    @Autowired
    private TracerImpl tracer;

    private static final Logger log = LogManager.getLogger(OperationImpl.class);

    /**
     * Operador 1
     */
    protected BigDecimal ope1;

    /**
     * Operador 2
     */
    protected BigDecimal ope2;



    public TracerImpl getTracer() {
        return tracer;
    }

    public void setTracer(TracerImpl tracer) {
        this.tracer = tracer;
    }

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

    public static Logger getLogger() {
        return log;
    }
}
