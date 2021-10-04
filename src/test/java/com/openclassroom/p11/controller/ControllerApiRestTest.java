package com.openclassroom.p11.controller;

import com.openclassroom.p11.service.InfoHopitalProcheService;
import com.openclassroom.p11.service.InfoPatientService;
import com.openclassroom.p11.service.PriseRdvService;
import lombok.SneakyThrows;
import org.json.JSONObject;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;

import org.springframework.test.web.servlet.MockMvc;


import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@DisplayName("Tests sur la class ControllerApiRest")
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class ControllerApiRestTest {
    @Autowired
    public MockMvc mockMvc;
    @Mock
    private static InfoPatientService patient;
    @Mock
    private PriseRdvService priseRdvService;
    @Mock
    private InfoHopitalProcheService infoHopitalProcheService;
    private static Instant startedAt;
    @BeforeAll
    static public void initStartingTime() {
        System.out.println("Appel avant tous les tests");
        startedAt = Instant.now();
    }
    @AfterAll
    static public void showTestDuration() {
        System.out.println("Appel après tous les tests");
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
    }

    @SneakyThrows
    @Test
    @WithMockUser(username = "recup",password = "recup")
    void patient() {
        //given
//        verify(patient).infoPatient(1830393053093l);
//        System.out.println(patient.infoPatient(1830393053093l));

        //when
        MockHttpServletResponse response=mockMvc.perform(get("/1830393053093")
                .accept(MediaType.APPLICATION_JSON).header("key","openclassroom")).andReturn().getResponse();
        JSONObject json = new JSONObject(response.getContentAsString());

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(json.getLong("numero")).isEqualTo(1830393053093l);
        assertThat(json.getString("nom")).isEqualTo("nino");
        assertThat(json.getString("prenom")).isEqualTo("alex");


    }
    @SneakyThrows
    @Test
    @WithMockUser(username = "recup",password = "recup")
    void priseRDV() {
        //given
//        verify(priseRdvService);

        //when

        MockHttpServletResponse response=mockMvc.perform(post("/rdv").contentType(MediaType.APPLICATION_JSON).header("key","openclassroom").content("{\n" +
                "    \"nom\":\"jacky\",\n" +
                "    \"prenom\":\"revet\",\n" +
                "    \"age\":\"25\",\n" +
                "    \"numero\":\"1920391111222\",\n" +
                "    \"adresse\":\"hotel de ville, paris\",\n" +
                "    \"nomSpe\":\"urgence\"\n" +
                "}")).andReturn().getResponse();
        JSONObject json = new JSONObject(response.getContentAsString());

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(json.getLong("codePostale")).isEqualTo(75181);
        assertThat(json.getString("nom")).isEqualTo("HU PARIS CENTRE SITE HOTEL DIEU APHP");
        assertThat(json.getString("adresse")).isEqualTo("AVENUE PASTEUR");
        assertThat(json.getDouble("distance")).isEqualTo(0.33704447226836054);

    }

    @SneakyThrows
    @Test
    @WithMockUser(username = "recup",password = "recup")
    void infoHopital() {
        //given
//        verify(infoHopitalProcheService);

        //when
        MockHttpServletResponse response=mockMvc.perform(get("/hotel de ville, paris/urgence/50")
                .accept(MediaType.APPLICATION_JSON).header("key","openclassroom")).andReturn().getResponse();
        JSONObject json = new JSONObject(response.getContentAsString());
        System.out.println(json);
        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(json.getLong("codePostale")).isEqualTo(75181);
        assertThat(json.getString("nom")).isEqualTo("HU PARIS CENTRE SITE HOTEL DIEU APHP");
        assertThat(json.getString("adresse")).isEqualTo("AVENUE PASTEUR");
        assertThat(json.getDouble("distance")).isEqualTo(0.33704447226836054);


    }

}