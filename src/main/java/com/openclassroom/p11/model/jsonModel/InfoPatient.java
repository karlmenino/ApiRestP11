package com.openclassroom.p11.model.jsonModel;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Data
public class InfoPatient {
    private String nom;
    private String prenom;
    private Long numero;
    private HashMap<String,String> pathologies;

}
