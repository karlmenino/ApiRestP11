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
    @OneToOne(fetch = FetchType.EAGER)
    private Patient Patient;

    @OneToOne(fetch = FetchType.EAGER)
    private Pathologies Pathologie;
    @Basic
    @Column(name = "Date", nullable = false)
    private Date Date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public com.openclassroom.p11.model.Patient getPatient() {
        return Patient;
    }

    public void setPatient(Patient patient) {
        Patient = patient;
    }

    public Pathologies getPathologie() {
        return Pathologie;
    }

    public void setPathologie(Pathologies pathologie) {
        Pathologie = pathologie;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }
}
