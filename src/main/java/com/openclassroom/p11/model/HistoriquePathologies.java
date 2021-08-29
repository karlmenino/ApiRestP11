package com.openclassroom.p11.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name="historiquesPathologies")
public class HistoriquePathologies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="pathologies_id")
    private Pathologies pathologie;

    @Basic
    @Column(name = "Date", nullable = false)
    private String Date;

}
