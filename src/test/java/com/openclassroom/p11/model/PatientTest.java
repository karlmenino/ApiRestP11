package com.openclassroom.p11.model;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PatientTest {
    private static Instant startedAt;
    private Patient patient;
    private List<HistoriquePathologies> historiquePathologies;

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
        patient=new Patient();
        historiquePathologies=new ArrayList<HistoriquePathologies>();
        patient.setNumero(25);
        patient.setPrenom("testpre");
        patient.setAge(25);
        patient.setNom("testNom");
        patient.setHistoriquePathologies(historiquePathologies);
        assertThat(patient.getNom()).isEqualTo("testNom");
        assertThat(patient.getPrenom()).isEqualTo("testpre");
        assertThat(patient.getAge()).isEqualTo(25);
        assertThat(patient.getNumero()).isEqualTo(25);
        assertThat(patient.getNumero()).isEqualTo(25);
        assertThat(patient.getHistoriquePathologies()).isEqualTo(historiquePathologies);
    }

}