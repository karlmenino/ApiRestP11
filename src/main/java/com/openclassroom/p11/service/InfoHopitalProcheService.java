package com.openclassroom.p11.service;

import com.openclassroom.p11.manager.HopitalManager;
import com.openclassroom.p11.model.Hopital;
import com.openclassroom.p11.model.jsonModel.InfoHopital;
import com.openclassroom.p11.model.jsonModel.LocalisationPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InfoHopitalProcheService {
    @Autowired
    HopitalManager hopitalManager;



    public InfoHopital infoHopital(String specialite, LocalisationPatient localisationPatient,int rayon) {
        InfoHopital infoHopital = new InfoHopital();
        infoHopital.setDistance(1000.0);
        Double distance;
        List<Hopital> hopitalList = hopitalManager.HopitalProche(localisationPatient,rayon);

        for (Hopital hopital : hopitalList) {
            if((hopital.getLit().litdispo(specialite)!=null)&&(hopital.getLit().litdispo(specialite)!=0)) {
                distance = trouverDistance(hopital.getLattitude(), hopital.getLongitude(), localisationPatient.getLatitude(), localisationPatient.getLongitude());
                if ((distance < infoHopital.getDistance())) {
                    infoHopital.setAdresse(hopital.getAdresse());
                    infoHopital.setCodePostale(hopital.getCodePostale());
                    infoHopital.setVille(hopital.getVille());
                    infoHopital.setNom(hopital.getNom());
                    infoHopital.setDistance(distance);
                }
            }
        }
        return infoHopital;
    }

    public double trouverDistance (double latHop, double longHap,double latPat, double longPat){
        final int R = 6371;
        double latDistance = Math.toRadians(latHop - latPat);
        double lonDistance = Math.toRadians(longHap - longPat);
        double a = Math.sin(latDistance) * Math.sin(latDistance)
                + Math.cos(Math.toRadians(latPat)) * Math.cos(Math.toRadians(latHop))
                * Math.sin(lonDistance) * Math.sin(lonDistance);
        double c = Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return  R * c ;
    }
}