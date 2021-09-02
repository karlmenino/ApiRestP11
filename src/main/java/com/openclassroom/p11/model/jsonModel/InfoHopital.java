package com.openclassroom.p11.model.jsonModel;

import lombok.Data;

@Data
public class InfoHopital {
    private String nom;
    private String adresse;
    private int codePostale;
    private String ville;
    private double distance;
}
