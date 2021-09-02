package com.openclassroom.p11.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
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
    @Column(name = "codePostale")
    private int codePostale;
    @Basic
    @Column(name = "ville", length = 60)
    private String ville;
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
    private List<Specialite> specialites;

@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<Medecin> medecins;

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

    public int getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(int codePostale) {
        this.codePostale = codePostale;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
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

    public List<Specialite> getSpecialites() {
        return specialites;
    }

    public void setSpecialites(List<Specialite> specialites) {
        this.specialites = specialites;
    }

    public List<Medecin> getMedecins() {
        return medecins;
    }

    public void setMedecins(List<Medecin> medecins) {
        this.medecins = medecins;
    }
}


