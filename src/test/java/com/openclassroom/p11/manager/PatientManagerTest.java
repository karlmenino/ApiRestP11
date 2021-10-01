package com.openclassroom.p11.manager;

import com.openclassroom.p11.model.Patient;
import lombok.SneakyThrows;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PatientManagerTest {
    private static Instant startedAt;
    private static Patient patient;
    @Autowired
    private PatientManager patientManager;


    @BeforeAll
    static public void initStartingTime() {
        System.out.println("Appel avant tous les tests");
        startedAt = Instant.now();
        patient = new Patient();
        patient.setNom("testNom");
        patient.setAge(25);
        patient.setNumero(25252525);
        patient.setPrenom("testPrenom");
    }


    @AfterAll
    static public void showTestDuration() {
        System.out.println("Appel après tous les tests");
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
    }


    @Test
    @Order(1)
    void save() {
        assertThat(patientManager.save(patient)).isNotNull();
    }

    @SneakyThrows
    @Test
    @Order(2)
    void findByNumber() {
        assertThat(patientManager.findByNumber(Long.valueOf(25252525)).getNom()).isEqualTo(patient.getNom());
    }
    @SneakyThrows
    @Test
    @Order(3)
    void notFindPatientByNumero(){
        assertThat(patientManager.findByNumber(Long.valueOf(2525))).isNull();
    }

    @SneakyThrows
    @Test
    @Order(4)
    void delete() {
        patientManager.delete(patient);
        assertThat(patientManager.findByNumber(Long.valueOf(25252525))).isNull();
    }
}