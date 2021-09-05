package com.openclassroom.p11.api;

import com.openclassroom.p11.dao.HopitalDao;
import com.openclassroom.p11.dao.SpecialiteDao;
import com.openclassroom.p11.manager.ApiManager;
import com.openclassroom.p11.manager.SpecialiteManager;
import com.openclassroom.p11.model.Hopital;
import com.openclassroom.p11.model.Specialite;
import com.openclassroom.p11.model.jsonModel.LocalisationPatient;
import com.openclassroom.p11.service.InfoHopitalProcheService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiRestController {
    @Autowired
    ApiManager apiManager;
    @Autowired
    SpecialiteManager specialiteManager;
    @Autowired
    InfoHopitalProcheService infoHopitalProcheService;
    @Autowired
    HopitalDao hopitalDao;
    @Autowired
    SpecialiteDao specialiteDao;

    @GetMapping("/{adresse}")
    public LocalisationPatient localisation(@PathVariable("adresse") String adresse) throws JSONException {
        return apiManager.localiserPatientGps(adresse);
    }

    @GetMapping("/{adresse}/{pat}")
    public Object infoHopital(@PathVariable("adresse") String adresse, @PathVariable("pat") String pat) throws JSONException {
        LocalisationPatient localisationPatient= apiManager.localiserPatientGps(adresse);
        Specialite specialite= null;
        try {
            specialite = specialiteManager.findByName(pat);
        } catch (Exception e) {
            return HttpStatus.I_AM_A_TEAPOT;
        }
        return infoHopitalProcheService.infoHopital(specialite,localisationPatient);
    }

    @GetMapping("/install")
    public void test(){
        List<Hopital> listHopital= (List<Hopital>) hopitalDao.findAll();
        ArrayList<Specialite> specialite= (ArrayList<Specialite>) specialiteDao.findAll();
        for (Hopital hopital: listHopital
             ) {
//            String adresse = hopital.getAdresse()+","+hopital.getCodePostale()+" "+hopital.getVille();
//            try {
//
//
//
//                    LocalisationPatient localisation = apiManager.localiserPatientGps(adresse);
//                    if (hopital.getLattitude()!= localisation.getLatitude()){
//                    hopital.setLattitude(localisation.getLatitude());
//                    hopital.setLongitude(localisation.getLongitude());
//                    hopital.setNbrDeLitsDispo(250);
//                    hopital.setNbrDeLitsMax(250);
//                    hopitalDao.save(hopital);
//                }
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
            hopital.setSpecialites(specialite);
            hopitalDao.save(hopital);


        }


    }
}
