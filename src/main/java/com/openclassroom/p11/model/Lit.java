package com.openclassroom.p11.model;

import javax.persistence.*;

@Entity
@Table(name="lit")
public class Lit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "urgence")
    private Integer urgence;
    @Basic
    @Column(name = "dentaire")
    private Integer dentaire;
    @Basic
    @Column(name = "medecine")
    private Integer medecine;
    @Basic
    @Column(name = "pediatrie")
    private Integer pediatrie;
    @Basic
    @Column(name = "pathologie")
    private Integer pathologie;
    @Basic
    @Column(name = "psychiatrie")
    private Integer psychiatrie;
    @Basic
    @Column(name = "radio")
    private Integer radio;
    @Basic
    @Column(name = "chirurgie")
    private Integer chirurgie;
//    @OneToOne(mappedBy = "lit")
//    Hopital hopital;

    public Integer litdispo(String specialite){
        if (specialite.equalsIgnoreCase("urgence")){
            return this.getUrgence();
        }else if(specialite.equalsIgnoreCase("dentaire")) {
            return this.getDentaire();
        }else if(specialite.equalsIgnoreCase("medecine")) {
            return this.getMedecine();
        }else if(specialite.equalsIgnoreCase("pediatrie")) {
            return this.getPediatrie();
        }else if(specialite.equalsIgnoreCase("pathologie")) {
            return this.getPathologie();
        }else if(specialite.equalsIgnoreCase("psychiatrie")) {
            return this.getPsychiatrie();
        }else if(specialite.equalsIgnoreCase("radio")) {
            return this.getRadio();
        }else if(specialite.equalsIgnoreCase("chirurgie")) {
            return this.getChirurgie();
        }else {
            return null;
        }
    }

    public Integer getUrgence() {
        return urgence;
    }

    public void setUrgence(Integer urgence) {
        this.urgence = urgence;
    }

    public Integer getDentaire() {
        return dentaire;
    }

    public void setDentaire(Integer dentaire) {
        this.dentaire = dentaire;
    }

    public Integer getMedecine() {
        return medecine;
    }

    public void setMedecine(Integer medecine) {
        this.medecine = medecine;
    }

    public Integer getPediatrie() {
        return pediatrie;
    }

    public void setPediatrie(Integer pediatrie) {
        this.pediatrie = pediatrie;
    }

    public Integer getPathologie() {
        return pathologie;
    }

    public void setPathologie(Integer pathologie) {
        this.pathologie = pathologie;
    }

    public Integer getPsychiatrie() {
        return psychiatrie;
    }

    public void setPsychiatrie(Integer psychiatrie) {
        this.psychiatrie = psychiatrie;
    }

    public Integer getRadio() {
        return radio;
    }

    public void setRadio(Integer radio) {
        this.radio = radio;
    }

    public Integer getChirurgie() {
        return chirurgie;
    }

    public void setChirurgie(Integer chirurgie) {
        this.chirurgie = chirurgie;
    }

    public Long getId() {
        return id;
    }
}
