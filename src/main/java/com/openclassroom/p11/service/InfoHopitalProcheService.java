package com.openclassroom.p11.service;

import com.openclassroom.p11.manager.HopitalManager;
import com.openclassroom.p11.model.Hopital;
import com.openclassroom.p11.model.Pathologies;
import com.openclassroom.p11.model.jsonModel.InfoHopital;
import com.openclassroom.p11.model.jsonModel.LocalisationPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InfoHopitalProcheService {
    @Autowired
    HopitalManager hopitalManager;

    public InfoHopital infoHopital(Pathologies pathologies, LocalisationPatient localisationPatient) {
        InfoHopital infoHopital = new InfoHopital();
        infoHopital.setDistance(1000.0);
        Double distance;
        List<Hopital> hopitalList = pathologies.getSpecialite().getHopitals();
        final int R = 6371;

        for (Hopital hopital : hopitalList) {
            double latDistance = Math.toRadians(hopital.getLattitude() - localisationPatient.getLatitude());
            double lonDistance = Math.toRadians(hopital.getLongitude() - localisationPatient.getLongitude());
            double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                    + Math.cos(Math.toRadians(localisationPatient.getLatitude())) * Math.cos(Math.toRadians(hopital.getLattitude()))
                    * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            distance = R * c ;
            if ((distance <infoHopital.getDistance())&&(hopital.getNbrDeLitsDispo()!=0)) {
                infoHopital.setAdresse(hopital.getAdresse());
                infoHopital.setNom(hopital.getNom());
                infoHopital.setDistance(distance);
            }
        }
        return infoHopital;
    }
}