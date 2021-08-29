package com.openclassroom.p11.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name="medecin")
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "nom", length = 60)
    private String nom;
    @Basic
    @Column(name = "prenom", length = 60)
    private String prenom;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Specialite specialite;


}
