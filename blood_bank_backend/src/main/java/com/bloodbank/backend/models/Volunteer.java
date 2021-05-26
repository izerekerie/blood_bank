package com.bloodbank.backend.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table
public class Volunteer {

    public  Volunteer(){}
    public  Volunteer(String sur_name,String last_name,String email,String district,int phone,String password,String gender, String status){

        this.sur_name=sur_name;
        this.last_name=last_name;
        this.email=email;
        this.district=district;
        this.phone=phone;
        this.password=password;
        this.gender=gender;
        this.status=status;


    }

    public  Volunteer(Long id,String sur_name,String last_name,String email,String district,int phone,String password,String gender, String status){

        this.id=id;
        this.sur_name=sur_name;
        this.last_name=last_name;
        this.email=email;
        this.district=district;
        this.phone=phone;
        this.password=password;
        this.gender=gender;
        this.status=status;


    }


    //properties

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String sur_name;

    @NotNull
    private String last_name;

    @NotNull
    private String email;

    @NotNull
    private String district;

    @NotNull
    private int phone;

    @NotNull
    private String password;

    @NotNull
    private String gender;

    @NotNull
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSur_name() {
        return sur_name;
    }

    public void setSur_name(String sur_name) {
        this.sur_name = sur_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
