package com.openclassroom.p11.api;

import com.openclassroom.p11.manager.ApiManager;
import com.openclassroom.p11.manager.PathologiesManager;
import com.openclassroom.p11.model.Pathologies;
import com.openclassroom.p11.model.jsonModel.InfoHopital;
import com.openclassroom.p11.model.jsonModel.LocalisationPatient;
import com.openclassroom.p11.service.InfoHopitalProcheService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiRestController {
    @Autowired
    ApiManager apiManager;
    @Autowired
    PathologiesManager pathologiesManager;
    @Autowired
    InfoHopitalProcheService infoHopitalProcheService;

    @GetMapping("/{adresse}")
    public LocalisationPatient localisation(@PathVariable("adresse") String adresse) throws JSONException {
        return apiManager.localiserPatientGps(adresse);
    }

    @GetMapping("/{adresse}/{pat}")
    public InfoHopital infoHopital(@PathVariable("adresse") String adresse, @PathVariable("pat") String pat) throws JSONException {
        LocalisationPatient localisationPatient= apiManager.localiserPatientGps(adresse);
        Pathologies pathologies= pathologiesManager.findByName(pat);
        return infoHopitalProcheService.infoHopital(pathologies,localisationPatient);
    }

}
