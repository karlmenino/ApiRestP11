package com.openclassroom.p11.dao;

import com.openclassroom.p11.model.Hopital;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HopitalDao extends CrudRepository<Hopital,Long> {
    public List<Hopital> findAllBySpecialitesIsContaining (String name);
}
