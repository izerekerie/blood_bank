package com.bloodbank.backend.controllers;

import com.bloodbank.backend.models.Appointment;
import com.bloodbank.backend.models.Donor;
import com.bloodbank.backend.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentRepository appointmentRepository;
     @GetMapping

    public List<Appointment> getAll(){
         return  appointmentRepository.findAll();
     }

     @PostMapping
    public Appointment createOne(@RequestBody Appointment newAppoi){
         return  appointmentRepository.save(newAppoi);

     }
     @DeleteMapping("/{id}")
     public String deleteOne(@PathVariable Long id){
         Optional<Appointment> found=appointmentRepository.findById(id);
         if(found.isEmpty()) return  "donors does not exist in our system";
         appointmentRepository.deleteById(id);
         return  "Appointment deleted successfully";
     }

}
