package com.openclassroom.p11.dao;

import com.openclassroom.p11.model.HistoriquePathologies;
import com.openclassroom.p11.model.Hopital;
import com.openclassroom.p11.model.Pathologies;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoriquePathologiesDao extends CrudRepository<HistoriquePathologies,Long> {
    public List<Pathologies> findAllByPatientNDeSécuritéSocial(int number);
}
