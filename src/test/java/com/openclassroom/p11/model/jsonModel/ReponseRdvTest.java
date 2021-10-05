package com.openclassroom.p11.model.jsonModel;

import com.openclassroom.p11.model.HistoriquePathologies;
import com.openclassroom.p11.model.Hopital;
import com.openclassroom.p11.model.Specialite;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ReponseRdvTest {
    private static Instant startedAt;
    private ReponseRdv reponseRdv;

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
        reponseRdv=new ReponseRdv();
        reponseRdv.setAdresse("adresse");
        reponseRdv.setNomSpe("test");
        reponseRdv.setPrenom("categ");
        reponseRdv.setNom("nom");
        reponseRdv.setAge(25);
        reponseRdv.setNumero(25L);
        assertThat(reponseRdv.getNom()).isEqualTo("nom");
        assertThat(reponseRdv.getPrenom()).isEqualTo("categ");
        assertThat(reponseRdv.getNomSpe()).isEqualTo("test");
        assertThat(reponseRdv.getAdresse()).isEqualTo("adresse");
        assertThat(reponseRdv.getAge()).isEqualTo(25);
        assertThat(reponseRdv.getNumero()).isEqualTo(25L);

    }
}