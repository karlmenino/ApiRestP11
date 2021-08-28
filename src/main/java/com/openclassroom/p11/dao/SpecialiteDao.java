package com.openclassroom.p11.dao;

import com.openclassroom.p11.model.Specialite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialiteDao extends CrudRepository<Specialite,Long> {
}
