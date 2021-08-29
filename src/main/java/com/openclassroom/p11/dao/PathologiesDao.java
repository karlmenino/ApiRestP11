package com.openclassroom.p11.dao;

import com.openclassroom.p11.model.Pathologies;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
@DynamicUpdate
public interface PathologiesDao extends CrudRepository<Pathologies,Long> {
    public Optional<Pathologies> findPathologiesByNom(String nom);

}
