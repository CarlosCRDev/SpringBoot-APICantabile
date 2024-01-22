package com.APICantabile.Database.Repositories;

import com.APICantabile.Database.Entities.Hospital;
import org.springframework.data.repository.CrudRepository;

public interface HospitalRepository extends CrudRepository<Hospital,Integer> {
}
