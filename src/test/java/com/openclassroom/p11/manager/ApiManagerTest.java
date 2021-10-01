package com.openclassroom.p11.manager;

import com.openclassroom.p11.model.jsonModel.LocalisationPatient;
import org.json.JSONException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApiManagerTest {
    @Autowired
    private ApiManager apiManager;
    private static LocalisationPatient resultat;
    private static Instant startedAt;

    @BeforeAll
    static public void initStartingTime() {
        System.out.println("Appel avant tous les tests");
        startedAt = Instant.now();
        resultat=new LocalisationPatient();
        resultat.setLatitude(48.8564826);
        resultat.setLongitude(2.3524135);

    }


    @AfterAll
    static public void showTestDuration() {
        System.out.println("Appel après tous les tests");
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
    }

    @Test
    void localiserPatientGps() {
        LocalisationPatient localisationPatient=new LocalisationPatient();
        try {
             localisationPatient = apiManager.localiserPatientGps("hotel de ville, paris");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        assertThat(localisationPatient).isEqualTo(resultat);
    }
    @Test
    void notLocaliserPatientGps() {
        LocalisationPatient localisationPatient=new LocalisationPatient();
        try {
             localisationPatient = apiManager.localiserPatientGps("hotel de ville,caen");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        assertThat(localisationPatient).isNotEqualTo(resultat);
    }
}