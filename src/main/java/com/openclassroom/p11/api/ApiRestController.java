package com.openclassroom.p11.api;

import com.openclassroom.p11.dao.HopitalDao;
import com.openclassroom.p11.dao.SpecialiteDao;
import com.openclassroom.p11.manager.ApiManager;
import com.openclassroom.p11.manager.SpecialiteManager;
import com.openclassroom.p11.model.Hopital;
import com.openclassroom.p11.model.Lit;
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



    @GetMapping("/install")
    public void test(){
//        List<Hopital> listHopital= (List<Hopital>) hopitalDao.findAll();
////        ArrayList<Specialite> specialite= (ArrayList<Specialite>) specialiteDao.findAll();
//        for (Hopital hopital: listHopital
//             ) {
//            String adresse = hopital.getNom()+", "+hopital.getVille();
//            try {
//
//
//
//                    LocalisationPatient localisation = apiManager.localiserPatientGps(adresse);
//                    if (hopital.getLattitude()!= localisation.getLatitude()){
//                    hopital.setLattitude(localisation.getLatitude());
//                    hopital.setLongitude(localisation.getLongitude());

//                    hopitalDao.save(hopital);
//                }
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//            hopital.setSpecialites(specialite);
//            hopitalDao.save(hopital);
//
//            hopital.getLit().setRadio(30);
//            hopitalDao.save(hopital);

//            if(hopital.getId()%2==0){
//                hopital.getLit().setChirurgie(50);
//                hopitalDao.save(hopital);
//            }
//            hopital.getLit().setMedecine(30);
//            hopitalDao.save(hopital);
//
//            if(hopital.getId()%3==1) {
//                hopital.getLit().setPathologie(50);
//                hopitalDao.save(hopital);
//            }
//            if(hopital.getId()%3==2) {
//                hopital.getLit().setPediatrie(50);
//                hopitalDao.save(hopital);
//            }
//            if(hopital.getId()%2==1) {
//                hopital.getLit().setPsychiatrie(50);
//                hopitalDao.save(hopital);
//            }
//        }
        Hopital hopital=new Hopital();

//        for (int i=0; i<50; i++){
//            try{hopitalDao.save(hopital);} catch (Exception e) {
//                e.printStackTrace();
//            }
//    }
        hopitalDao.save(hopital);


    }
}
