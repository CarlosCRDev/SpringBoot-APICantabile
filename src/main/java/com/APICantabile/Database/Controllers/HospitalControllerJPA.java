package com.APICantabile.Database.Controllers;

import com.APICantabile.Database.Entities.Hospital;
import com.APICantabile.Database.Services.HospitalServiceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/testdb")
public class HospitalControllerJPA {
    @Autowired
    private HospitalServiceJPA hospitalService2;

    @RequestMapping(value = "/hospitals", method = RequestMethod.GET)
    public List<Hospital> getAllHospitals()throws Exception{
        return this.hospitalService2.getAllHospitals();
    }
}
