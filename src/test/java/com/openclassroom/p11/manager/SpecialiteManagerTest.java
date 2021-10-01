package com.openclassroom.p11.manager;

import com.openclassroom.p11.dao.SpecialiteDao;
import com.openclassroom.p11.model.Specialite;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SpecialiteManagerTest {

    @Autowired
    private SpecialiteManager specialiteManager;
    private static Specialite specialite;
    private static Instant startedAt;
    @BeforeAll
    static public void initStartingTime() {
        System.out.println("Appel avant tous les tests");
        startedAt = Instant.now();
        specialite=new Specialite();
        specialite.setNom("testNom");
        specialite.setCategories("testCat");
        specialite.setDescription("testDes");
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
        assertThat(specialiteManager.save(specialite)).isNotNull();


    }
    @Test
    @Order(2)
    void findByName() throws Exception {
        assertThat(specialiteManager.findByName("testNom").getNom()).isEqualTo(specialite.getNom());
    }
    @Test
    @Order(3)
    void notFindByName() throws Exception {
        assertThat(specialiteManager.findByName("testNom1")).isNull();
    }
    @Test
    @Order(4)
    void delete() throws Exception {
        specialiteManager.delete(specialite);
        assertThat(specialiteManager.findByName("testNom")).isNull();
    }
}