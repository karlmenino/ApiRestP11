package com.openclassroom.p11.manager;

import com.openclassroom.p11.dao.HopitalDao;
import com.openclassroom.p11.model.Hopital;
import com.openclassroom.p11.model.jsonModel.LocalisationPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HopitalManager {
    @Autowired
    HopitalDao hopitalDao;

    public List<Hopital> HopitalProche(LocalisationPatient localisationPatient,double rayon){
        double value=rayon/100;
        Double latMin=localisationPatient.getLatitude()-value;
        Double latMax=localisationPatient.getLatitude()+value;
        Double lngMin=localisationPatient.getLongitude()-value;
        Double lngMax=localisationPatient.getLongitude()+value;
        return hopitalDao.findAllByLattitudeBetweenAndLongitudeBetween(latMin,latMax,lngMin,lngMax);

    }
}
