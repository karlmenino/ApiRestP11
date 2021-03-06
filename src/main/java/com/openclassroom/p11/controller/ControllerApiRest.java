package com.openclassroom.p11.controller;

import com.openclassroom.p11.manager.ApiManager;
import com.openclassroom.p11.manager.PatientManager;
import com.openclassroom.p11.model.Patient;
import com.openclassroom.p11.model.jsonModel.LocalisationPatient;
import com.openclassroom.p11.model.jsonModel.ReponseRdv;
import com.openclassroom.p11.service.InfoHopitalProcheService;
import com.openclassroom.p11.service.InfoPatientService;
import com.openclassroom.p11.service.PriseRdvService;
import lombok.experimental.Delegate;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerApiRest {
    @Autowired
    InfoPatientService infoPatientService;
    @Autowired
    PriseRdvService priseRdvService;
    @Autowired
    ApiManager apiManager;
    @Autowired
    InfoHopitalProcheService infoHopitalProcheService;
    @Autowired
    PatientManager patientManager;


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
            return HttpStatus.I_AM_A_TEAPOT;
        } catch (Exception e) {
            return HttpStatus.I_AM_A_TEAPOT;
        }
    }

    @GetMapping("/{adresse}/{pat}/{rayon}")
    public Object infoHopital(@PathVariable("adresse") String adresse, @PathVariable("pat") String pat,@PathVariable("rayon")int rayon) {
        LocalisationPatient localisationPatient= null;
        try {
            localisationPatient = apiManager.localiserPatientGps(adresse);
        } catch (JSONException e) {
            return HttpStatus.I_AM_A_TEAPOT;
        }
        return infoHopitalProcheService.infoHopital(pat,localisationPatient,rayon);
    }
    @GetMapping("/adresse/{adresse}")
    public Object localisation(@PathVariable("adresse") String adresse){
        try {
            return apiManager.localiserPatientGps(adresse);
        } catch (JSONException e) {
            return HttpStatus.I_AM_A_TEAPOT;
        }
    }
    @GetMapping("/delete/{numero}")
    public void delete(@PathVariable("numero") Long numero) {
        Patient patient = null;
        try {
            patient = patientManager.findByNumber(numero);
        } catch (Exception e) {
        }
        if (patient != null) {
            patientManager.delete(patient);
        }
    }
}
