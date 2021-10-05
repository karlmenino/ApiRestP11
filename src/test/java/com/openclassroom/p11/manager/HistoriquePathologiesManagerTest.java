package com.openclassroom.p11.manager;

import com.openclassroom.p11.dao.HistoriquePathologiesDao;
import com.openclassroom.p11.dao.PatientDao;
import com.openclassroom.p11.dao.SpecialiteDao;
import com.openclassroom.p11.model.HistoriquePathologies;
import com.openclassroom.p11.model.Patient;
import com.openclassroom.p11.model.Specialite;
import com.openclassroom.p11.model.jsonModel.LocalisationPatient;
import lombok.SneakyThrows;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class HistoriquePathologiesManagerTest {
    @Autowired
    private HistoriquePathologiesManager historiquePathologiesManager;
    @Autowired
    private HistoriquePathologiesDao historiquePathologiesDao;
    @Autowired
    private  PatientDao patientDao;
    @Autowired
    private  SpecialiteDao specialiteDao;
    private static Instant startedAt;
    private HistoriquePathologies resultat;
    private  Patient patient;
    private  Specialite specialite;

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
    void save() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        patient=new Patient();
        patient=patientDao.findPatientByNumero(1830393053093L);

        specialite=new Specialite();
        specialite=specialiteDao.findByNom("urgence");
        resultat= new HistoriquePathologies();
        resultat.setPatient(patient);
        resultat.setSpecialite(specialite);
        resultat.setDate(date.format(formatter));
        HistoriquePathologies test=historiquePathologiesManager.save(patient,specialite);
        assertThat(test).isEqualTo(resultat);
        historiquePathologiesDao.delete(test);
    }

}