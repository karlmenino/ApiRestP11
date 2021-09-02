package com.openclassroom.p11.manager;

import com.openclassroom.p11.dao.SpecialiteDao;
import com.openclassroom.p11.model.Specialite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpecialiteManager {

    @Autowired
    private SpecialiteDao specialiteDao;

    public void save(Specialite specialite){
       specialiteDao.save(specialite);
    }
    public Specialite findByName(String nom){return specialiteDao.findByNom(nom);}

}
