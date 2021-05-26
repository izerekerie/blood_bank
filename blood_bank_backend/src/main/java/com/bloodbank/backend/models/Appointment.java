package com.bloodbank.backend.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Appointment {

    public Appointment(Long id, String address, String title, Long hospitalId, Date date) {
        this.id = id;
        this.address = address;
        this.title = title;
        this.hospitalId = hospitalId;
        this.date = date;
    }

    public Appointment() {

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String address,title;
    private  Long hospitalId;
    @JsonFormat(pattern="yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
    private Date  date;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
