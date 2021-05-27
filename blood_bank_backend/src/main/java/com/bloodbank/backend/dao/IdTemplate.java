package com.bloodbank.backend.dao;

public class IdTemplate {
    private Long idValue;

    public IdTemplate() {
    }

    public IdTemplate(Long idValue) {
        this.idValue = idValue;
    }

    public Long getIdValue() {
        return idValue;
    }

    public void setIdValue(Long idValue) {
        this.idValue = idValue;
    }
}
