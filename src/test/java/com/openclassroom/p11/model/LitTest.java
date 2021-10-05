package com.openclassroom.p11.model;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class LitTest {
    private static Instant startedAt;
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
       lit=new Lit();
       lit.setUrgence(50);
       lit.setPsychiatrie(50);
       lit.setChirurgie(50);
       lit.setRadio(50);
       lit.setDentaire(50);
       lit.setMedecine(50);

       assertThat(lit.getChirurgie()).isEqualTo(50);
       assertThat(lit.getDentaire()).isEqualTo(50);
       assertThat(lit.getMedecine()).isEqualTo(50);
       assertThat(lit.getRadio()).isEqualTo(50);
       assertThat(lit.getPsychiatrie()).isEqualTo(50);
       assertThat(lit.getUrgence()).isEqualTo(50);
   }
}