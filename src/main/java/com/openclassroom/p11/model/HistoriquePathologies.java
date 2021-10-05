package com.openclassroom.p11.model;

import javax.persistence.*;
import java.util.Optional;

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
    @JoinColumn(name="specialite_id")
    private Specialite specialite;

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

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HistoriquePathologies that = (HistoriquePathologies) o;

        if (!patient.equals(that.patient)) return false;
        if (!specialite.equals(that.specialite)) return false;
        return Date.equals(that.Date);
    }

    @Override
    public int hashCode() {
        int result = patient.hashCode();
        result = 31 * result + specialite.hashCode();
        result = 31 * result + Date.hashCode();
        return result;
    }
}
