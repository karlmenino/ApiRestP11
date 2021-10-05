package com.openclassroom.p11.model.jsonModel;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class InfoPatientTest {
    private static Instant startedAt;
    private InfoPatient infoPatient;

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
        infoPatient=new InfoPatient();
        HashMap test =new HashMap();
        infoPatient.setPathologies(test);
        infoPatient.setPrenom("categ");
        infoPatient.setNom("nom");
        infoPatient.setNumero(25L);
        assertThat(infoPatient.getNom()).isEqualTo("nom");
        assertThat(infoPatient.getPrenom()).isEqualTo("categ");
        assertThat(infoPatient.getPathologies()).isEqualTo(test);
        assertThat(infoPatient.getNumero()).isEqualTo(25L);

    }
}