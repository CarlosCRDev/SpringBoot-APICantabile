package com.APICantabile.Database.Repositories;

import com.APICantabile.Database.Entities.Hospital;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HospitalRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private HospitalRepository hospitalRepository;

    @Test
    public void testFindById(){
        entityManager.persist(new Hospital(1003, "Vcare Hospital","Mumbai",3.1));
        Optional<Hospital> hospital = hospitalRepository.findById(1003);
        assertEquals("Vcare Hospital", hospital.get().getName());
    }
}