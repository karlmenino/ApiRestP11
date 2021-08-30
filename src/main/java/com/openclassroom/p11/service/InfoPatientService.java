package com.openclassroom.p11.service;

import com.openclassroom.p11.manager.HistoriquePathologiesManager;
import com.openclassroom.p11.manager.PatientManager;
import com.openclassroom.p11.model.HistoriquePathologies;
import com.openclassroom.p11.model.InfoPatient;
import com.openclassroom.p11.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class InfoPatientService {
    @Autowired
    HistoriquePathologiesManager historiquePathologiesManager;
    @Autowired
    PatientManager patientManager;


    public InfoPatient infoPatient(Long number){
        InfoPatient infoPatient= new InfoPatient();
        Optional<Patient> patient = patientManager.findByNumber(number);
        System.out.println(patient);
        if (patient != null){
            infoPatient.setNom(patient.get().getNom());
            infoPatient.setPrenom(patient.get().getPrenom());
            infoPatient.setNumero(patient.get().getNumero());
            System.out.println(patient.get().getHistoriquePathologies());


            for (HistoriquePathologies pathos: patient.get().getHistoriquePathologies()) {
                String pathologie=pathos.getPathologie().getNom();
                List<String> liste= (List<String>) infoPatient.getPathologies();
                if (liste == null){
                   liste =  new ArrayList<String>();
                }
                liste.add((String)pathologie);
                infoPatient.setPathologies((List<String>) liste);

            }
        }
        return infoPatient;
    }
}
