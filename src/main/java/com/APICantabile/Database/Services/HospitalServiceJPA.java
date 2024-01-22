package com.APICantabile.Database.Services;

import com.APICantabile.Database.Entities.Hospital;
import com.APICantabile.Database.Repositories.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HospitalServiceJPA {
    @Autowired
    private HospitalRepository hospitalRepository;

    public List<Hospital> getAllHospitals(){
        List<Hospital> hospitalList = new ArrayList<Hospital>();
        hospitalRepository.findAll().forEach(hospitalList::add);
        return hospitalList;
    }
}
