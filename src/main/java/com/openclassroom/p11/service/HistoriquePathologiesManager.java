package com.openclassroom.p11.service;

import com.openclassroom.p11.dao.HistoriquePathologiesDao;
import com.openclassroom.p11.model.HistoriquePathologies;
import com.openclassroom.p11.model.Pathologies;
import com.openclassroom.p11.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Component
public class HistoriquePathologiesManager {

    @Autowired
    private HistoriquePathologiesDao historiquePathologiesDao;

    public void save (Patient patient, Pathologies pathologies){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        HistoriquePathologies historique=new HistoriquePathologies();

        historique.setPathologie(pathologies);
        historique.setPatient(patient);
        historique.setDate(date.format(formatter));
        historiquePathologiesDao.save(historique);
    }
    public List<HistoriquePathologies> getHistoryByPatientNumber(int number){
        return historiquePathologiesDao.findAllByPatient_Numero(number);
    }
}
