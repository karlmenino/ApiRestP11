package com.openclassroom.p11.manager;

import com.openclassroom.p11.model.Hopital;
import com.openclassroom.p11.model.jsonModel.LocalisationPatient;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class HopitalManagerTest {
    private static Instant startedAt;
    @Autowired
    private HopitalManager hopitalManager;

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
    void hopitalProche() {
        List<Hopital> list;
        LocalisationPatient localisationPatient=new LocalisationPatient();
        localisationPatient.setLatitude(5.15);
        localisationPatient.setLongitude(-52.65);
        list=hopitalManager.HopitalProche(localisationPatient,30);
        Hopital hopital=list.get(0);
        assertThat(hopital.getId()).isEqualTo(703);
    }
    @Test
    void notHopitalProche() {
        List<Hopital> list;
        LocalisationPatient localisationPatient=new LocalisationPatient();
        localisationPatient.setLatitude(5.15);
        localisationPatient.setLongitude(-52.65);
        list=hopitalManager.HopitalProche(localisationPatient,30);
        Hopital hopital=list.get(0);
        assertThat(hopital.getId()).isNotEqualTo(155);
    }
}