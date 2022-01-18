package com.bloodbank.backend.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table

public class Hospital {

    public Hospital (){}

    public Hospital (String name,String email,String password,String district,String sector,String description){
        this.name=name;
        this.email=email;
        this.password=password;
        this.district=district;
        this.sector=sector;
        this.description=description;

    }

    public Hospital (Long id,String name,String email,String password,String district,String sector,String description){
        this.id=id;
        this.name=name;
        this.email=email;
        this.password=password;
        this.district=district;
        this.sector=sector;
        this.description=description;

    }


    // Properties
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String email;

     @NotNull
    private String password;

    @NotNull
    private String district;

    @NotNull
    private String sector;

    @NotNull
    private String description;

    @ManyToMany
    List<Appointment> appointments;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
