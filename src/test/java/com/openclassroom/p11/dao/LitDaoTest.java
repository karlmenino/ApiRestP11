package com.openclassroom.p11.dao;

import com.openclassroom.p11.model.Lit;
import com.openclassroom.p11.model.Specialite;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LitDaoTest {
    @Autowired
    private LitDao litDao;
    private static Lit lit;
    private static Instant startedAt;

    @BeforeAll
    static public void initStartingTime() {
        System.out.println("Appel avant tous les tests");
        startedAt = Instant.now();
        lit = new Lit();
        lit.setPsychiatrie(50);
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
        lit=litDao.save(lit);
        assertThat(litDao.findById(lit.getId())).isNotNull();
        litDao.delete(lit);
        assertThat(litDao.findById(lit.getId())).isEmpty();
    }

}