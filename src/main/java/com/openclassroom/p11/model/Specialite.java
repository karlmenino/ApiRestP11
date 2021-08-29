package com.openclassroom.p11.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;
@Data
@Entity
@Table(name="specialite")
public class Specialite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "categories", length = 60)
    private String categories;
    @Basic
    @Column(name = "nom", length = 60)
    private String nom;

    @ManyToMany(mappedBy = "specialites")
    private Set<Hopital> hopitals;


}
