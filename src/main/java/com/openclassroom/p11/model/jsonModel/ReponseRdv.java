package com.openclassroom.p11.model.jsonModel;

import lombok.Data;

@Data
public class ReponseRdv {
    private String nom;
    private String prenom;
    private int age;
    private Long numero;
    private String adresse;
    private String nomSpe;
}
