package com.openclassroom.p11.model;

import javax.persistence.*;
import java.util.Set;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Hopital> getHopitals() {
        return hopitals;
    }

    public void setHopitals(Set<Hopital> hopitals) {
        this.hopitals = hopitals;
    }
}
