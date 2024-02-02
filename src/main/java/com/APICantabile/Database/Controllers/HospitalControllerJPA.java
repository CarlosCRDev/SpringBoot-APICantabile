package com.APICantabile.Database.Controllers;

import com.APICantabile.Database.Entities.Hospital;
import com.APICantabile.Database.Services.HospitalServiceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/hospitals/{id}", method = RequestMethod.GET)
    public Hospital getOneHospital(@PathVariable int id)throws Exception{
        return this.hospitalService2.getOneHospital(id);
    }

    @RequestMapping(value = "/hospitals", method = RequestMethod.POST)
    public Hospital saveHospital(@RequestBody Hospital hospital)throws Exception{
        return this.hospitalService2.saveHospital(hospital);
    }
}
