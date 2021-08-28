package com.openclassroom.p11.dao;

import com.openclassroom.p11.model.Pathologies;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PathologiesDao extends CrudRepository<Pathologies,Long> {

}
