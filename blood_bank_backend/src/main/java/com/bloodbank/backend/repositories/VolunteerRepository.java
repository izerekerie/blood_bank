package com.bloodbank.backend.repositories;


import com.bloodbank.backend.models.Hospital;
import com.bloodbank.backend.models.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer,Long> {
}
