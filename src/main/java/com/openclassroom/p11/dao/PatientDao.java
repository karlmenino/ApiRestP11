package com.openclassroom.p11.dao;

import com.openclassroom.p11.model.Patient;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@DynamicUpdate
public interface PatientDao extends CrudRepository<Patient,Long> {
    public Optional<Patient> findPatientByNumero(int numero);
}
