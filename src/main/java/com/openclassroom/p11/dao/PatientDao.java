package com.openclassroom.p11.dao;

import com.openclassroom.p11.model.Patient;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@DynamicUpdate
public interface PatientDao extends CrudRepository<Patient,Long> {
    public Patient findPatientByNumero(Long numero) throws Exception ;
}
