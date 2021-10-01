package com.openclassroom.p11.model;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class LitTest {
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
    void litdispo() {
    }

    @Test
    void getUrgence() {
    }

    @Test
    void setUrgence() {
    }

    @Test
    void getDentaire() {
    }

    @Test
    void setDentaire() {
    }

    @Test
    void getMedecine() {
    }

    @Test
    void setMedecine() {
    }

    @Test
    void getPediatrie() {
    }

    @Test
    void setPediatrie() {
    }

    @Test
    void getPathologie() {
    }

    @Test
    void setPathologie() {
    }

    @Test
    void getPsychiatrie() {
    }

    @Test
    void setPsychiatrie() {
    }

    @Test
    void getRadio() {
    }

    @Test
    void setRadio() {
    }

    @Test
    void getChirurgie() {
    }

    @Test
    void setChirurgie() {
    }
}