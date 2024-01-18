package com.APICantabile.Hospital.controller;
import com.APICantabile.Hospital.models.Hospital;
import com.APICantabile.Hospital.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;
    @RequestMapping(value = "/hospitals/{id}", method = RequestMethod.GET)
    public Hospital getHospital(@PathVariable("id") int id){
        Hospital hospital = this.hospitalService.getHospital(id);
        return hospital;
    }

    @RequestMapping(value = "/hospitals", method = RequestMethod.GET)
    public List<Hospital> getAllHospitals()throws Exception{
        return this.hospitalService.getAllHospitals();
    }
}
