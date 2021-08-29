package com.openclassroom.p11.service;

import com.openclassroom.p11.dao.SpecialiteDao;
import com.openclassroom.p11.model.Specialite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SpecialiteManager {
    @Autowired
    private SpecialiteDao specialiteDao;

    public void save (Specialite specialite){
        specialiteDao.save(specialite);
    }
    public Optional<Specialite> findById(Long id){
        return specialiteDao.findById(id);
    }
}
