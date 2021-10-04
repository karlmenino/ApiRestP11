package com.openclassroom.p11.model;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class HistoriquePathologiesTest {
    private static Instant startedAt;
    private HistoriquePathologies historiquePathologies;
    private Patient patient;
    private Specialite specialite;

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

    @Test
    void getterAndSetter() {
        historiquePathologies=new HistoriquePathologies();
        patient=new Patient();
        specialite=new Specialite();
        String date = "22/01/2021";
        historiquePathologies.setPatient(patient);
        historiquePathologies.setSpecialite(specialite);
        historiquePathologies.setDate(date);
        assertThat(historiquePathologies.getDate()).isEqualTo(date);
        assertThat(historiquePathologies.getPatient()).isEqualTo(patient);
        assertThat(historiquePathologies.getSpecialite()).isEqualTo(specialite);
    }

}