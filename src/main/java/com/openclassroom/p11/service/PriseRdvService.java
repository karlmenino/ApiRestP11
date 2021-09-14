package com.openclassroom.p11.service;

import com.openclassroom.p11.manager.HistoriquePathologiesManager;
import com.openclassroom.p11.manager.PatientManager;
import com.openclassroom.p11.manager.SpecialiteManager;
import com.openclassroom.p11.model.Patient;
import com.openclassroom.p11.model.Specialite;
import com.openclassroom.p11.model.jsonModel.InfoHopital;
import com.openclassroom.p11.model.jsonModel.LocalisationPatient;
import com.openclassroom.p11.model.jsonModel.ReponseRdv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PriseRdvService {
    @Autowired
    HistoriquePathologiesManager historiquePathologiesManager;
    @Autowired
    InfoHopitalProcheService infoHopitalProcheService;
    @Autowired
    PatientManager patientManager;
    @Autowired
    SpecialiteManager  specialiteManager;

    public InfoHopital priseRdv(ReponseRdv json) throws Exception {
        Patient patient =null;
        LocalisationPatient localisationPatient=new LocalisationPatient();
        localisationPatient.setLongitude(json.getLng());
        localisationPatient.setLatitude(json.getLat());

        Specialite specialite;
        specialite=specialiteManager.findByName(json.getNomSpe());

        patient=patientManager.findByNumber(json.getNumero());
        if(null == patient){
            patient=new Patient(json.getNumero(),json.getNom(),json.getPrenom(),json.getAge());
            patientManager.save(patient);}
        historiquePathologiesManager.save(patient,specialite);
        return infoHopitalProcheService.infoHopital(specialite.getNom(),localisationPatient);

    }
}
