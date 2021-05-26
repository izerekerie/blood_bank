package com.bloodbank.backend.controllers;

import com.bloodbank.backend.models.Volunteer;
import com.bloodbank.backend.repositories.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@RestController

public class VolunteerController {
    @Autowired
    private VolunteerRepository volunteerRepository;

    @PostMapping("/bloodbank/volunteer")
    public Volunteer addVolunteer(@RequestBody Volunteer volunteer) {
        return volunteerRepository.save(volunteer);
    }

    @GetMapping("bloodbank/volunteer/{id}")
    public Volunteer getVolunteerById(@PathVariable Long id) {
        return volunteerRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));

    }

    @GetMapping("/bloodbank/volunteer")
    public List<Volunteer> getALlVolunteers(){
        return volunteerRepository.findAll();
    }


    @PutMapping("/bloodbank/volunteer/{id}")
    public ResponseEntity<Volunteer> updateVolunteerById(@PathVariable Long id, @RequestBody Volunteer volunteer){
        Optional<Volunteer> VolunteerDate = volunteerRepository.findById(id);

        if(VolunteerDate.isPresent()){
            Volunteer _volunteer = VolunteerDate.get();
            _volunteer.setId(volunteer.getId());
            _volunteer.setSur_name(volunteer.getSur_name());
            _volunteer.setLast_name(volunteer.getLast_name());
            _volunteer.setEmail(volunteer.getEmail());
            _volunteer.setDistrict(volunteer.getDistrict());
            _volunteer.setPhone(volunteer.getPhone());
            _volunteer.setPassword(volunteer.getPassword());
            _volunteer.setGender(volunteer.getGender());
            _volunteer.setStatus(volunteer.getStatus());

            return new ResponseEntity<>(volunteerRepository.save(_volunteer),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/bloodbank/volunteer/{id}")
    public void deleteVolunteerById(@PathVariable Long id) {
        volunteerRepository.deleteById(id);
    }
}

