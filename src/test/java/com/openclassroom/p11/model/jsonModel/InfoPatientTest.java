package com.openclassroom.p11.model.jsonModel;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class InfoPatientTest {
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
    void getPrenom() {
    }

    @Test
    void getNumero() {
    }

    @Test
    void getPathologies() {
    }

    @Test
    void setNom() {
    }

    @Test
    void setPrenom() {
    }

    @Test
    void setNumero() {
    }

    @Test
    void setPathologies() {
    }
}