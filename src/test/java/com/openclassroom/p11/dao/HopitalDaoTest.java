package com.openclassroom.p11.dao;

import com.openclassroom.p11.model.Hopital;
import com.openclassroom.p11.model.Lit;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HopitalDaoTest {
    private static Instant startedAt;
    private static Hopital hopital;
    @Autowired
    private HopitalDao hopitalDao;
    @Autowired
    private LitDao litDao;
    @BeforeAll
    static public void initStartingTime() {
        System.out.println("Appel avant tous les tests");
        startedAt = Instant.now();
        hopital=new Hopital();
        hopital.setNom("aaaTestNom");
        hopital.setLattitude(1.0);
        hopital.setLongitude(1.0);
        hopital.setCodePostale(94420);
    }

    @AfterAll
    static public void showTestDuration() {
        System.out.println("Appel après tous les tests");
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
    }

    @Test
    @Order(1)
    public void save ()  {
        hopital=hopitalDao.save(hopital);
        assertThat(hopital).isNotNull();


    }
    @Test
    @Order(2)
    void findAllByLattitudeBetweenAndLongitudeBetween() {

        assertThat(hopitalDao.findAllByLattitudeBetweenAndLongitudeBetween(0.5,1.5,0.5,1.5).get(0).getNom()).isEqualTo(hopital.getNom());
    }
    @Test
    @Order(3)
    void notFindAllByLattitudeBetweenAndLongitudeBetween() {
        assertThat(hopitalDao.findAllByLattitudeBetweenAndLongitudeBetween(0.0,0.5,0.0,0.5)).isEmpty();
    }
    @Test
    @Order(4)
    void delete() throws Exception {
        hopitalDao.delete(hopital);
        assertThat(hopitalDao.findAllByLattitudeBetweenAndLongitudeBetween(0.5,1.5,0.5,1.5)).isEmpty();
    }
}