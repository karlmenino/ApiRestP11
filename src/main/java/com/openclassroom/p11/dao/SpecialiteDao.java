package com.openclassroom.p11.dao;

import com.openclassroom.p11.model.Specialite;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
@DynamicUpdate
public interface SpecialiteDao extends CrudRepository<Specialite,Long> {
    public Specialite findByNom(String nom);

}
