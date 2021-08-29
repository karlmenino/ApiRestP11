package com.openclassroom.p11.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "numero", nullable = true)
    private int numero;
    @Basic
    @Column(name = "nom", length = 60)
    private String nom;
    @Basic
    @Column(name = "prenom", length = 60)
    private String prenom;
    @Basic
    @Column(name = "age", nullable = true)
    private int age;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HistoriquePathologies> historiquePathologies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<HistoriquePathologies> getHistoriquePathologies() {
        return historiquePathologies;
    }

    public void setHistoriquePathologies(List<HistoriquePathologies> historiquePathologies) {
        this.historiquePathologies = historiquePathologies;
    }
}
