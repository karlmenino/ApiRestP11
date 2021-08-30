package com.openclassroom.p11.controller;

import com.openclassroom.p11.model.jsonModel.InfoPatient;
import com.openclassroom.p11.service.InfoPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerApiRest {
    @Autowired
    InfoPatientService infoPatientService;


    @GetMapping("/{numero}")
    public InfoPatient Patient(@PathVariable("numero") Long secuSocial){
        return infoPatientService.infoPatient(secuSocial);
    }


}
