package com.bloodbank.backend.repositories;

import com.bloodbank.backend.models.Appointment;
import com.bloodbank.backend.models.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    List<Appointment> findByHospital(Hospital hospital);
}
