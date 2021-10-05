package com.openclassroom.p11.dao;

import com.openclassroom.p11.model.Patient;

import org.junit.jupiter.api.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PatientDaoTest {
    @Autowired
    private PatientDao patientDao;

    private static Patient patient;
    private static Instant startedAt;

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
    public void save ()  {
        assertThat(patientDao.save(patient)).isNotNull();


    }
    @Test
    @Order(2)
    void findPatientByNumero() throws Exception {
        assertThat(patientDao.findPatientByNumero(Long.valueOf(25252525)).getNom()).isEqualTo(patient.getNom());
    }
    @Test
    @Order(3)
    void notFindPatientByNumero() throws Exception {
        assertThat(patientDao.findPatientByNumero(Long.valueOf(2525))).isNull();
    }
    @Test
    @Order(4)
    void delete() throws Exception {
        patientDao.delete(patient);
        assertThat(patientDao.findPatientByNumero(Long.valueOf(25252525))).isNull();
    }

}