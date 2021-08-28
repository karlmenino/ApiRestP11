package com.openclassroom.p11.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNbrDeLitsMax() {
        return nbrDeLitsMax;
    }

    public void setNbrDeLitsMax(int nbrDeLitsMax) {
        this.nbrDeLitsMax = nbrDeLitsMax;
    }

    public int getNbrDeLitsDispo() {
        return nbrDeLitsDispo;
    }

    public void setNbrDeLitsDispo(int nbrDeLitsDispo) {
        this.nbrDeLitsDispo = nbrDeLitsDispo;
    }

    public double getLattitude() {
        return lattitude;
    }

    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Set<Medecin> getMedecins() {
        return medecins;
    }

    public void setMedecins(Set<Medecin> medecins) {
        this.medecins = medecins;
    }

    public Set<Specialite> getSpecialites() {
        return specialites;
    }

    public void setSpecialites(Set<Specialite> specialites) {
        this.specialites = specialites;
    }
}


