package com.openclassroom.p11.service;

import com.openclassroom.p11.dao.MedecinDao;
import com.openclassroom.p11.model.Medecin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MedecinManager {

    @Autowired
    private MedecinDao medecinDao;


    public Medecin save(Medecin medecin){
        return medecinDao.save(medecin);
    }

    public Optional<Medecin> findById(Long ID){
        return medecinDao.findById(ID);
    }

}
