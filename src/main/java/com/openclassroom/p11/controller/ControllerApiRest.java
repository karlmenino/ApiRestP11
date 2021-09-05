package com.openclassroom.p11.controller;

import com.openclassroom.p11.model.jsonModel.ReponseRdv;
import com.openclassroom.p11.service.InfoPatientService;
import com.openclassroom.p11.service.PriseRdvService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

@RestController
public class ControllerApiRest {
    @Autowired
    InfoPatientService infoPatientService;
    @Autowired
    PriseRdvService priseRdvService;


    @GetMapping("/{numero}")
    public Object Patient(@PathVariable("numero") Long secuSocial) {
        try {
            return infoPatientService.infoPatient(secuSocial);
        } catch (Exception e) {
            return HttpStatus.I_AM_A_TEAPOT;
        }
    }

    @PostMapping("/rdv")
    public Object priseRDV(@RequestBody ReponseRdv json) {
        try {
            return priseRdvService.priseRdv(json);
        } catch (JSONException e) {
            e.printStackTrace();
            return HttpStatus.I_AM_A_TEAPOT;
        } catch (Exception e) {
            e.printStackTrace();
            return HttpStatus.I_AM_A_TEAPOT;
        }
    }
}
