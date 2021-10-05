package com.openclassroom.p11.service;

import com.openclassroom.p11.manager.ApiManager;
import com.openclassroom.p11.model.Specialite;
import com.openclassroom.p11.model.jsonModel.InfoHopital;
import com.openclassroom.p11.model.jsonModel.LocalisationPatient;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class InfoHopitalProcheServiceTest {
    @Autowired
    private ApiManager apiManager;
    @Autowired
    private InfoHopitalProcheService service;

    private LocalisationPatient localisationPatient;
    private String specialite;
    private int rayon;
    private static Instant startedAt;
    private InfoHopital infoHopital;
    private InfoHopital result;

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
    void infoHopital() {
        infoHopital=new InfoHopital();
        infoHopital.setNom("HU PARIS CENTRE SITE HOTEL DIEU APHP");
        infoHopital.setDistance(0.33704447226836054);
        specialite="urgence";
        localisationPatient=apiManager.localiserPatientGps("hotel de ville, paris");
        rayon=50;
        result=service.infoHopital(specialite,localisationPatient,rayon);
        assertThat(result.getNom()).isEqualTo(infoHopital.getNom());
        assertThat(result.getDistance()).isEqualTo(infoHopital.getDistance());

    }

}