package com.bloodbank.backend.controllers;

import com.bloodbank.backend.models.Donor;
import com.bloodbank.backend.repositories.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping
    public Donor createDonor(@RequestBody Donor newDonor){
        Donor donor=donorRepository.save(newDonor);
        return donor;

    }

}
