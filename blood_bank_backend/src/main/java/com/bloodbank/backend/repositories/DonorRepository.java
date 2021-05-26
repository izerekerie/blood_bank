package com.bloodbank.backend.repositories;

import com.bloodbank.backend.models.Donor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonorRepository  extends JpaRepository<Donor,Long> {
    List<Donor> findDonorsByDistrict(String district);
    List<Donor> findDonorsByGender(String gender);
    List<Donor> findDonorsByBloodGroup(String blood);
}
