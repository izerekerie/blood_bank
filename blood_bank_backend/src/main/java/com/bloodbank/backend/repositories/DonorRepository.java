package com.bloodbank.backend.repositories;

import com.bloodbank.backend.models.Donor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonorRepository  extends JpaRepository<Donor,Long> {
}
