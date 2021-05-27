package com.bloodbank.backend.dao;

import com.bloodbank.backend.models.Hospital;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class CreateAppointment {
    private  String title,address;
    private IdTemplate hospital;
    private Timestamp date;

    public CreateAppointment(String title, String address, IdTemplate hospital, Timestamp date) {
        this.title = title;
        this.address = address;
        this.hospital = hospital;
        this.date = date;
    }

    public CreateAppointment() {
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

    public IdTemplate getHospital() {
        return hospital;
    }

    public void setHospital(IdTemplate hospital) {
        this.hospital = hospital;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
