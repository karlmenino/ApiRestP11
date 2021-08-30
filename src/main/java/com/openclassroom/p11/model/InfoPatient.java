package com.openclassroom.p11.model;

import lombok.Data;

import java.util.List;
import java.util.Set;


public class InfoPatient {
    private String nom;
    private String prenom;
    private Long numero;
    private List<String> pathologies;

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

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public List<String> getPathologies() {
        return pathologies;
    }

    public void setPathologies(List<String> pathologies) {
        this.pathologies = pathologies;
    }
}
