package br.com.regissanme.auth.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Projeto: REST-Spring
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 09/08/2022
 * Hora: 10:20
 */
@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deveRetornarSucessoComCredenciaisValidas() throws Exception {
        URI uri = new URI("/auth/signin");
        String content = "{\"username\" : \"regissanme\", \"senha\" : \"admin\"}";

        mockMvc.perform(MockMvcRequestBuilders
                .post(uri)
                .content(content)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers
                .status()
                .is(200)
        );
    }

    @Test
    public void deveRetornarErroComCredenciaisInvalidas() throws Exception {
        URI uri = new URI("/auth/signin");
        String content = "{\"username\" : \"asdf\", \"senha\" : \"admin\"}";

        mockMvc.perform(MockMvcRequestBuilders
                .post(uri)
                .content(content)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect((ResultMatcher) MockMvcResultMatchers
                .content()
        );
    }
}