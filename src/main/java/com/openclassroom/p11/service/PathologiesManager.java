package com.openclassroom.p11.service;

import com.openclassroom.p11.dao.PathologiesDao;
import com.openclassroom.p11.model.Pathologies;
import com.openclassroom.p11.model.Specialite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PathologiesManager {

    @Autowired
    private PathologiesDao pathologiesDao;

    public void save(Pathologies pathologies){
       pathologiesDao.save(pathologies);
    }

    
}
