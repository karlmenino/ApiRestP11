package com.openclassroom.p11.model;

import javax.persistence.*;
import java.util.Date;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Pathologies getPathologie() {
        return pathologie;
    }

    public void setPathologie(Pathologies pathologie) {
        this.pathologie = pathologie;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

}
