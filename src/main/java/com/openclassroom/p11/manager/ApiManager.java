package com.openclassroom.p11.manager;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.openclassroom.p11.model.jsonModel.LocalisationPatient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Component
public class ApiManager {
    @Value("${key}")
    private String apiKey;

    public LocalisationPatient localiserPatientGps(String adresse) throws JSONException {
        RestTemplate template= new RestTemplate();
        LocalisationPatient localisationPatient=new LocalisationPatient();
        ResponseEntity<String> response;
        String ressourceUrl= "https://maps.googleapis.com/maps/api/geocode/json?address="+adresse+"&key="+apiKey;

        response = template.getForEntity(ressourceUrl, String.class);
        JSONObject localisation= new JSONObject(response.getBody());
        JSONArray results= (JSONArray) localisation.get("results");
        JSONObject resultsFinal= (JSONObject) results.get(0);
        JSONObject location= (JSONObject) resultsFinal.getJSONObject("geometry").getJSONObject("location");

        localisationPatient.setLatitude(location.getDouble("lat"));
        localisationPatient.setLongitude(location.getDouble("lng"));

        return localisationPatient;
    }
}
