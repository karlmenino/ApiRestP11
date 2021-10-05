package com.openclassroom.p11.model.jsonModel;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class InfoHopitalTest {
    private static Instant startedAt;
    private InfoHopital infoHopital;

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
        infoHopital=new InfoHopital();
        infoHopital.setDistance(1.0);
        infoHopital.setAdresse("test");
        infoHopital.setVille("categ");
        infoHopital.setNom("nom");
        infoHopital.setCodePostale(25);
        assertThat(infoHopital.getNom()).isEqualTo("nom");
        assertThat(infoHopital.getVille()).isEqualTo("categ");
        assertThat(infoHopital.getAdresse()).isEqualTo("test");
        assertThat(infoHopital.getDistance()).isEqualTo(1.0);
        assertThat(infoHopital.getCodePostale()).isEqualTo(25);

    }
}
