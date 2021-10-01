package com.openclassroom.p11.model.jsonModel;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class InfoHopitalTest {
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
    void getNom() {
    }

    @Test
    void getAdresse() {
    }

    @Test
    void getCodePostale() {
    }

    @Test
    void getVille() {
    }

    @Test
    void getDistance() {
    }

    @Test
    void setNom() {
    }

    @Test
    void setAdresse() {
    }

    @Test
    void setCodePostale() {
    }

    @Test
    void setVille() {
    }

    @Test
    void setDistance() {
    }
}