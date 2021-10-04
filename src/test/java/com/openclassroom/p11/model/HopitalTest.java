package com.openclassroom.p11.model;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class HopitalTest {
    private static Instant startedAt;
    private Hopital hopital;
    private Lit lit;

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
        hopital=new Hopital();
        lit=new Lit();
        List<Specialite> specialites = new ArrayList<>();
        hopital.setLongitude(1.0);
        hopital.setLattitude(1.0);
        hopital.setLit(lit);
        hopital.setNom("test");
        hopital.setAdresse("testAdresse");
        hopital.setSpecialites(specialites);
        hopital.setCodePostale(94500);
        hopital.setVille("champigny");

        assertThat(hopital.getLongitude()).isEqualTo(1.0);
        assertThat(hopital.getLattitude()).isEqualTo(1.0);
        assertThat(hopital.getLit()).isEqualTo(lit);
        assertThat(hopital.getNom()).isEqualTo("test");
        assertThat(hopital.getAdresse()).isEqualTo("testAdresse");
        assertThat(hopital.getSpecialites()).isEqualTo(specialites);
        assertThat(hopital.getCodePostale()).isEqualTo(94500);
        assertThat(hopital.getVille()).isEqualTo("champigny");
    }
}