package com.openclassroom.p11.dao;

import com.openclassroom.p11.model.HistoriquePathologies;
import com.openclassroom.p11.model.Hopital;
import com.openclassroom.p11.model.Pathologies;
import com.openclassroom.p11.model.Patient;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
@DynamicUpdate
public interface HistoriquePathologiesDao extends CrudRepository<HistoriquePathologies,Long> {
     public List<HistoriquePathologies> findAllByPatient_Numero(int numero);
}
