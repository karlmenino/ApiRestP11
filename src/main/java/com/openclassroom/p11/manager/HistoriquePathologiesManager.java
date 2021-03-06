package com.openclassroom.p11.manager;

import com.openclassroom.p11.dao.HistoriquePathologiesDao;
import com.openclassroom.p11.model.HistoriquePathologies;
import com.openclassroom.p11.model.Patient;
import com.openclassroom.p11.model.Specialite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class HistoriquePathologiesManager {

    @Autowired
    private HistoriquePathologiesDao historiquePathologiesDao;

    public HistoriquePathologies save (Patient patient, Specialite specialite){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        HistoriquePathologies historique=new HistoriquePathologies();

        historique.setSpecialite(specialite);
        historique.setPatient(patient);
        historique.setDate(date.format(formatter));
        return historiquePathologiesDao.save(historique);
    }
}
