package com.openclassroom.p11.service;

import com.openclassroom.p11.dao.PatientDao;
import com.openclassroom.p11.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PatientManager {

    @Autowired
    private PatientDao patientDao;

    public void save(Patient patient){
        patientDao.save(patient);
    }
    public Optional<Patient> findByNumber(int number){
        return patientDao.findPatientByNumero(number);
    }
    public Optional<Patient> findById(Long id){
        return patientDao.findById(id);
    }


}
