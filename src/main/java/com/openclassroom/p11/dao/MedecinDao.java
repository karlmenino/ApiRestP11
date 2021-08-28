package com.openclassroom.p11.dao;

import com.openclassroom.p11.model.Medecin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedecinDao extends CrudRepository<Medecin,Long> {
}
