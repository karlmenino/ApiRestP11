package com.openclassroom.p11.dao;

import com.openclassroom.p11.model.Hopital;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@DynamicUpdate
public interface HopitalDao extends CrudRepository<Hopital,Long> {
    public List<Hopital> findAllBySpecialitesIsContaining (String name);
}
