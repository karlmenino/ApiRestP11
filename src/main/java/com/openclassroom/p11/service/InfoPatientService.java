package com.openclassroom.p11.service;

import com.openclassroom.p11.manager.HistoriquePathologiesManager;
import com.openclassroom.p11.manager.PatientManager;
import com.openclassroom.p11.model.HistoriquePathologies;
import com.openclassroom.p11.model.jsonModel.InfoPatient;
import com.openclassroom.p11.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class InfoPatientService {
    @Autowired
    HistoriquePathologiesManager historiquePathologiesManager;
    @Autowired
    PatientManager patientManager;

    public InfoPatient infoPatient(Long number) throws Exception {
        InfoPatient infoPatient= new InfoPatient();
        Patient  patient = patientManager.findByNumber(number);
        if (patient != null){
            infoPatient.setNom(patient.getNom());
            infoPatient.setPrenom(patient.getPrenom());
            infoPatient.setNumero(patient.getNumero());
            HashMap <String,String> liste =  new HashMap();
            infoPatient.setPathologies(liste);
            for (HistoriquePathologies pathos: patient.getHistoriquePathologies()) {
                String pathologie=pathos.getSpecialite().getNom();
                String date= pathos.getDate();
                infoPatient.getPathologies().put(date,pathologie);
            }
        }
        return infoPatient;
    }
}
