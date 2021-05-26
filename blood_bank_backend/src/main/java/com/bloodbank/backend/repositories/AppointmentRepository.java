package com.bloodbank.backend.repositories;

import com.bloodbank.backend.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

}
