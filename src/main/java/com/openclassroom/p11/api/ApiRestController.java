package com.openclassroom.p11.api;

import com.openclassroom.p11.manager.ApiManager;
import com.openclassroom.p11.model.jsonModel.LocalisationPatient;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiRestController {
    @Autowired
    ApiManager apiManager;

    @GetMapping("/{adresse}")
    public LocalisationPatient localisation(@PathVariable("adresse") String adresse) throws JSONException {
        return apiManager.localiserPatientGps(adresse);
    }
}
