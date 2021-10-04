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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SpecialiteTest {
    private static Instant startedAt;
    private Specialite specialite;
    private List<HistoriquePathologies> historiquePathologies;
    private List<Hopital> hopital;

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
        specialite=new Specialite();
        hopital=new ArrayList<Hopital>();
        historiquePathologies=new ArrayList<HistoriquePathologies>();
        specialite.setHopitals(hopital);
        specialite.setHistoriquePathologies(historiquePathologies);
        specialite.setDescription("test");
        specialite.setCategories("categ");
        specialite.setNom("nom");
        assertThat(specialite.getNom()).isEqualTo("nom");
        assertThat(specialite.getCategories()).isEqualTo("categ");
        assertThat(specialite.getDescription()).isEqualTo("test");
        assertThat(specialite.getHopitals()).isEqualTo(hopital);
        assertThat(specialite.getHistoriquePathologies()).isEqualTo(historiquePathologies);

    }


}