package com.openclassroom.p11.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="specialite")
public class Specialite {
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

    @Basic
    @Column(name = "categories", length = 60)
    private String categories;

    @ManyToMany(mappedBy = "specialites")
    private List<Hopital> hopitals;

    @OneToMany(mappedBy = "specialite", cascade = CascadeType.ALL, orphanRemoval = false)
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

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public List<Hopital> getHopitals() {
        return hopitals;
    }

    public void setHopitals(List<Hopital> hopitals) {
        this.hopitals = hopitals;
    }

    public List<HistoriquePathologies> getHistoriquePathologies() {
        return historiquePathologies;
    }

    public void setHistoriquePathologies(List<HistoriquePathologies> historiquePathologies) {
        this.historiquePathologies = historiquePathologies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specialite that = (Specialite) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
