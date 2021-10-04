package com.openclassroom.p11.service;

import com.openclassroom.p11.manager.PatientManager;
import com.openclassroom.p11.model.HistoriquePathologies;
import com.openclassroom.p11.model.Patient;
import com.openclassroom.p11.model.jsonModel.InfoPatient;
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
@SpringBootTest
class InfoPatientServiceTest {
    @Autowired
    private InfoPatientService service;
    @Autowired
    private PatientManager patientManager;
    private HistoriquePathologies historiquePathologies;
    private Patient patient;
    private InfoPatient result;
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
    void infoPatient() {

        patient=patientManager.findByNumber(1830393053093l);
        result=service.infoPatient(1830393053093l);
        assertThat(result.getNom()).isEqualTo(patient.getNom());
        assertThat(result.getPrenom()).isEqualTo(patient.getPrenom());
        assertThat(result.getNumero()).isEqualTo(patient.getNumero());
    }
}