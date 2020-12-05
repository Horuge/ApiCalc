package com.prueba.rest.calculadora.controllers;

import com.prueba.rest.calculadora.common.Constants;
import com.prueba.rest.calculadora.common.Error;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(CalculadoraControllers.class)
class CalculadoraControllersTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CalculadoraControllers calculadoraControllers;

    /**
     * Test suma simple.
     * @throws Exception Excepción genérica al mockear.
     */
    @Test
    public void addTest() throws Exception {
        String body = "{\"ope1\":1,\"ope2\":2}";

        RequestBuilder rb = MockMvcRequestBuilders.post(Constants.URL + Constants.URL_ADD).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON).content(body);
        MvcResult result = mockMvc.perform(rb).andReturn();

        MockHttpServletResponse resp = result.getResponse();

        // Comprueba estatus 200
        assertEquals(HttpStatus.OK.value(), resp.getStatus());
        // Comprueba resultado operación
        assertTrue(resp.getContentAsString().contains("3"));
    }

    /**
     * Test suma con sumando negativo.
     * @throws Exception Excepción genérica al mockear.
     */
    @Test
    public void addNegativoTest() throws Exception {
        String body = "{\"ope1\":1,\"ope2\":-2}";

        RequestBuilder rb = MockMvcRequestBuilders.post(Constants.URL + Constants.URL_ADD).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON).content(body);
        MvcResult result = mockMvc.perform(rb).andReturn();

        MockHttpServletResponse resp = result.getResponse();

        // Comprueba estatus 200
        assertEquals(HttpStatus.OK.value(), resp.getStatus());
        // Comprueba resultado operación
        assertTrue(resp.getContentAsString().contains("-1"));
        assertTrue(resp.getContentAsString().contains("(-2)"));
    }

    /**
     * Suma con operador nulo.
     * @throws Exception Excepción genérica al mockear.
     */
    @Test
    public void addNullTest() throws Exception {
        String body = "{\"ope2\":-2}";

        RequestBuilder rb = MockMvcRequestBuilders.post(Constants.URL + Constants.URL_ADD).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8").content(body);
        MvcResult result = mockMvc.perform(rb).andReturn();

        MockHttpServletResponse resp = result.getResponse();

        // Comprueba estatus 200
        assertEquals(HttpStatus.OK.value(), resp.getStatus());
        // Comprueba resultado operación
        assertTrue(resp.getContentAsString().contains("\"ok\":false"));
        //assertTrue(resp.getContentAsString().contains(Error.ERROR_ADD.getError()));
    }

    @Test
    public void SubstTest() throws Exception {
        String body = "{\"ope1\":2,\"ope2\":1}";

        RequestBuilder rb = MockMvcRequestBuilders.post(Constants.URL + Constants.URL_SUBS).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON).content(body);
        MvcResult result = mockMvc.perform(rb).andReturn();

        MockHttpServletResponse resp = result.getResponse();

        // Comprueba estatus 200
        assertEquals(HttpStatus.OK.value(), resp.getStatus());
        // Comprueba resultado operación
        assertTrue(resp.getContentAsString().contains("1"));
    }

    @Test
    public void SubstNegativoTest() throws Exception {
        String body = "{\"ope1\":1,\"ope2\":-2}";

        RequestBuilder rb = MockMvcRequestBuilders.post(Constants.URL + Constants.URL_SUBS).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON).content(body);
        MvcResult result = mockMvc.perform(rb).andReturn();

        MockHttpServletResponse resp = result.getResponse();

        // Comprueba estatus 200
        assertEquals(HttpStatus.OK.value(), resp.getStatus());
        // Comprueba resultado operación
        assertTrue(resp.getContentAsString().contains("3"));
        assertTrue(resp.getContentAsString().contains("(-2)"));
    }

    @Test
    public void SubstNullTest() throws Exception {
        String body = "{\"ope2\":-2}";

        RequestBuilder rb = MockMvcRequestBuilders.post(Constants.URL + Constants.URL_SUBS).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8").content(body);
        MvcResult result = mockMvc.perform(rb).andReturn();

        MockHttpServletResponse resp = result.getResponse();

        // Comprueba estatus 200
        assertEquals(HttpStatus.OK.value(), resp.getStatus());
        // Comprueba resultado operación
        assertTrue(resp.getContentAsString().contains("\"ok\":false"));
        // assertTrue(resp.getContentAsString().contains(Error.ERROR_SUBS.getError()));
    }

}
