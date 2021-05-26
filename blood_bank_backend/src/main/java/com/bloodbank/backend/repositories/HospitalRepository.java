package com.bloodbank.backend.repositories;


import com.bloodbank.backend.models.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface HospitalRepository extends JpaRepository<Hospital,Long> {

}
