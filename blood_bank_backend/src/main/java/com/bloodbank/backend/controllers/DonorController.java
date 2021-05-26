package com.bloodbank.backend.controllers;

import com.bloodbank.backend.models.Donor;
import com.bloodbank.backend.repositories.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/donors")
public class DonorController {
    @Autowired
    private DonorRepository donorRepository;

    @GetMapping
    public List<Donor> getAllDonors(){
        return  donorRepository.findAll();
    }
    @GetMapping("/{id}")
    public Donor getOne(@PathVariable Long id){
        Optional<Donor> donor = donorRepository.findById(id);
        return donor.get();
    }
    @GetMapping("by_district/{district}")
    public List<Donor> getByDistrict(@PathVariable String district){
        return donorRepository.findDonorsByDistrict(district);


    }
    @GetMapping("by_gender/{gender}")
    public List<Donor> getByGender(@PathVariable String gender){
        return donorRepository.findDonorsByGender(gender);

    }
    @GetMapping("by_type/{blood}")
    public List<Donor> getByBlood(@PathVariable String blood){
        return donorRepository.findDonorsByBloodGroup(blood);

    }

    @PostMapping
    public Donor createDonor(@RequestBody Donor newDonor){
        Donor donor=donorRepository.save(newDonor);
        return donor;

    }
    @DeleteMapping
    public void deleteAll(){
        donorRepository.deleteAll();
    }
    @DeleteMapping("/{id}")
  public String deleteOne(@PathVariable Long id){
        Optional<Donor> found=donorRepository.findById(id);
        if(found.isEmpty()) return  "donors does not exist in our system";
        donorRepository.deleteById(id);
        return  "donor deleted successfully";
    }

}
