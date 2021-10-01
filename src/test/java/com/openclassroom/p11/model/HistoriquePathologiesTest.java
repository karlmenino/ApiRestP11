package com.openclassroom.p11.model;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class HistoriquePathologiesTest {
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

    @Test
    void getId() {
    }

    @Test
    void setId() {
    }

    @Test
    void getPatient() {
    }

    @Test
    void setPatient() {
    }

    @Test
    void getSpecialite() {
    }

    @Test
    void setSpecialite() {
    }

    @Test
    void getDate() {
    }

    @Test
    void setDate() {
    }
}