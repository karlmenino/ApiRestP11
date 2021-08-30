package com.openclassroom.p11.controller;

import com.openclassroom.p11.model.InfoPatient;
import com.openclassroom.p11.service.InfoPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controllerApiRest {
    @Autowired
    InfoPatientService infoPatientService;


    @GetMapping("/{numero}")
    public InfoPatient Patient(@PathVariable("numero") Long id){
        return infoPatientService.infoPatient(id);
    }


}
