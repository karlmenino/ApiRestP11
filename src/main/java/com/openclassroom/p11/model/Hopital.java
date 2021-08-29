package com.openclassroom.p11.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;
@Data
@Entity
@Table(name="hopital")
public class Hopital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "nom", length = 60)
    private String nom;
    @Basic
    @Column(name = "adresse", length = 255)
    private String adresse;
    @Basic
    @Column(name = "nbrDeLitsMax")
    private int nbrDeLitsMax;
    @Basic
    @Column(name = "nbrDeLitsDispo")
    private int nbrDeLitsDispo;
    @Basic
    @Column(name = "lattitude")
    private double lattitude;
    @Basic
    @Column(name = "longitude")
    private double longitude;
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "Hopital_specialite",
            joinColumns = @JoinColumn(name = "hopital_id"),
            inverseJoinColumns = @JoinColumn(name = "specialite_id")
    )
    private Set<Specialite> specialites;

@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private Set<Medecin> medecins;


}


