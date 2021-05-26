package com.bloodbank.backend.controllers;


import com.bloodbank.backend.models.Hospital;
import com.bloodbank.backend.repositories.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@RestController


public class HospitalController {

    @Autowired
  private HospitalRepository hospitalRepository;
    @PostMapping("/hospital")
    public Hospital addHospital(@RequestBody Hospital hospital){
        return hospitalRepository.save(hospital);
    }


    @GetMapping("/bloodbank/hospital/{id}")
    public Hospital getHospitalById(@PathVariable Long id){
        return hospitalRepository.findById(id)
                .orElseThrow(()->new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }


    @GetMapping("/bloodbank/hospital")
    public List<Hospital> getALlHospitals(){
        return hospitalRepository.findAll();
    }


    @PutMapping("/bloodbank/hospital/{id}")
    public ResponseEntity<Hospital> updateHospitalById(@PathVariable Long id, @RequestBody Hospital hospital){
        Optional<Hospital> HospitalData = hospitalRepository.findById(id);

        if(HospitalData.isPresent()){
            Hospital _hospital = HospitalData.get();
            _hospital.setId(hospital.getId());
            _hospital.setName(hospital.getName());
            _hospital.setEmail(hospital.getEmail());
            _hospital.setDistrict(hospital.getDistrict());
            _hospital.setSector(hospital.getSector());
            _hospital.setDescription(hospital.getDescription());




            return new ResponseEntity<>(hospitalRepository.save(_hospital),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/bloodbank/hospital/{id}")
    public void deleteHospitalById(@PathVariable Long id) {
        hospitalRepository.deleteById(id);
    }
}
