package com.openclassroom.p11.service;

import com.openclassroom.p11.model.jsonModel.InfoHopital;
import com.openclassroom.p11.model.jsonModel.ReponseRdv;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PriseRdvServiceTest {
    @Autowired
    private PriseRdvService priseRdvService;
    private InfoHopital result;
    private ReponseRdv reponseRdv;
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
    void priseRdv() {
        reponseRdv=new ReponseRdv();
        reponseRdv.setAdresse("hotel de ville,paris");
        reponseRdv.setNom("jacky");
        reponseRdv.setPrenom("revet");
        reponseRdv.setAge(25);
        reponseRdv.setNumero(1920391111222l);
        reponseRdv.setNomSpe("urgence");
        result=new InfoHopital();
        result.setNom("HU PARIS CENTRE SITE HOTEL DIEU APHP");
        result.setAdresse("AVENUE PASTEUR");
        result.setVille("PARIS CEDEX 04");
        result.setCodePostale(75181);
        result.setDistance(0.3370444722683606);

        assertThat(priseRdvService.priseRdv(reponseRdv)).isEqualTo(result);

    }
}