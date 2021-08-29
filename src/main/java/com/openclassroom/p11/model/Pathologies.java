package com.openclassroom.p11.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="pathologies")
public class Pathologies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "nom", length = 60)
    private String nom;
    @Basic
    @Column(name = "description", length = 255)
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    private Specialite specialite;
    @OneToMany(mappedBy = "pathologie", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<HistoriquePathologies> historiquePathologies;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public List<HistoriquePathologies> getHistoriquePathologies() {
        return historiquePathologies;
    }

    public void setHistoriquePathologies(List<HistoriquePathologies> historiquePathologies) {
        this.historiquePathologies = historiquePathologies;
    }
}
