package com.openclassroom.p11.manager;

import com.openclassroom.p11.dao.PatientDao;
import com.openclassroom.p11.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientManager {

    @Autowired
    private PatientDao patientDao;

    public Patient save(Patient patient){
        return patientDao.save(patient);
    }
    public Patient findByNumber(Long number) throws Exception {
        return patientDao.findPatientByNumero(number);
    }
    public void delete(Patient patient){
        patientDao.delete(patient);
    }

}
