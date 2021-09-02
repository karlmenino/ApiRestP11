package com.openclassroom.p11.manager;

import com.openclassroom.p11.dao.PatientDao;
import com.openclassroom.p11.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PatientManager {

    @Autowired
    private PatientDao patientDao;

    public void save(Patient patient){
        patientDao.save(patient);
    }
    public Optional<Patient> findByNumber(Long number){
        return patientDao.findPatientByNumero(number);
    }



}
