package com.openclassroom.p11.manager;

import com.openclassroom.p11.dao.PathologiesDao;
import com.openclassroom.p11.model.Pathologies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PathologiesManager {

    @Autowired
    private PathologiesDao pathologiesDao;

    public void save(Pathologies pathologies){
       pathologiesDao.save(pathologies);
    }
    public Pathologies findByName(String nom){return pathologiesDao.findPathologiesByNom(nom);}

}
