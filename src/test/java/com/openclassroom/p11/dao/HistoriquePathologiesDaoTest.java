package com.openclassroom.p11.dao;

import com.openclassroom.p11.model.HistoriquePathologies;
import com.openclassroom.p11.model.Lit;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HistoriquePathologiesDaoTest {
    @Autowired
    private HistoriquePathologiesDao historiquePathologiesDao;
    private static HistoriquePathologies historiquePathologies;
    private static Instant startedAt;

    @BeforeAll
    static public void initStartingTime() {
        System.out.println("Appel avant tous les tests");
        startedAt = Instant.now();
        historiquePathologies = new HistoriquePathologies();
        historiquePathologies.setDate("22/03/2011");
    }

    @AfterAll
    static public void showTestDuration() {
        System.out.println("Appel après tous les tests");
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
    }

    @Test
    public void saveAndDelete() {
        historiquePathologies = historiquePathologiesDao.save(historiquePathologies);
        assertThat(historiquePathologiesDao.findById(historiquePathologies.getId())).isNotNull();
        historiquePathologiesDao.delete(historiquePathologies);
        assertThat(historiquePathologiesDao.findById(historiquePathologies.getId())).isEmpty();
    }
}