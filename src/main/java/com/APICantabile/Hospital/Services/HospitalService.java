package com.APICantabile.Hospital.Services;

import com.APICantabile.Hospital.Models.Hospital;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HospitalService {
    private List<Hospital> hospitalList = new ArrayList<>(Arrays.asList(
            new Hospital(1001, "Apollo Hospital", "Chennai", 3.8),
            new Hospital(1002, "Global Hospital", "Chennai", 3.5),
            new Hospital(1003, "VCare Hospital", "Bangalore", 3)
    ));

    public List<Hospital> getAllHospitals() {
        return hospitalList;
    }

    public Hospital getHospital(int id){
        return hospitalList.stream().filter(c -> c.getId() == (id)).findFirst().get();
    }
}
