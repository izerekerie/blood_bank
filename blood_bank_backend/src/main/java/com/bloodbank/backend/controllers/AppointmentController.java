package com.bloodbank.backend.controllers;

import com.bloodbank.backend.dao.CreateAppointment;
import com.bloodbank.backend.models.Appointment;
import com.bloodbank.backend.models.Hospital;
import com.bloodbank.backend.repositories.AppointmentRepository;
import com.bloodbank.backend.repositories.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private HospitalRepository hospitalRepository;

    @GetMapping
    public List<Appointment> getAppointments(){
        return  appointmentRepository.findAll();
     }
     @GetMapping("/{id}")
     public Object getOne(@PathVariable Long id){
         Optional<Appointment> found=appointmentRepository.findById(id);
         if(found.isEmpty()) return  "Appointment  does not exist in our system";
         return found.get();
     }
     @GetMapping("/by_hospital/{id}")
     public List<Appointment> getByHospital(@PathVariable Long id){
         Optional<Hospital> hospitalOptional = hospitalRepository.findById(id);

         return appointmentRepository.findByHospital(hospitalOptional.get());

     }
     @PostMapping
     public Appointment createOne(@RequestBody CreateAppointment newAppoint){

        Optional<Hospital> hospitalOptional = hospitalRepository.findById(newAppoint.getHospital().getIdValue());

//         Appointment appointment=  appointmentRepository.save(newAppoint);
//         String address, String title, Hospital hospital, Timestamp date

         Appointment newAppointment=new Appointment(
                 newAppoint.getAddress(),
                 newAppoint.getTitle(), hospitalOptional.get(),newAppoint.getDate()
         );

       return  appointmentRepository.save(newAppointment);
     }

     @DeleteMapping("/{id}")
     public String deleteOne(@PathVariable Long id){
         Optional<Appointment> found=appointmentRepository.findById(id);
         if(found.isEmpty()) return  "Appointments does not exist in our system";
         appointmentRepository.deleteById(id);
         return  "Appointment deleted successfully";
     }


}
