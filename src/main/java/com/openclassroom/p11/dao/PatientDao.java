package com.openclassroom.p11.dao;

import com.openclassroom.p11.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDao extends CrudRepository<Patient,Long> {

}
