package com.openclassroom.p11.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
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



}
