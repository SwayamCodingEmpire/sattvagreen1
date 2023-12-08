package com.medninja.sattvagreen.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class LocalRemedies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long remid;
    private String remedySource;

    public String getRemedy() {
        return remedy;
    }

    public void setRemedy(String remedy) {
        this.remedy = remedy;
    }

    private String remedy;
    public long getRemid() {
        return remid;
    }

    public void setRemid(long remid) {
        this.remid = remid;
    }

    public String getRemedySource() {
        return remedySource;
    }

    public void setRemedySource(String remedySource) {
        this.remedySource = remedySource;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    private String disease;

    public LocalRemedies(long remid, String remedySource, String disease,String remedy) {
        this.remid = remid;
        this.remedySource = remedySource;
        this.disease = disease;
        this.remedy = remedy;
    }

    public LocalRemedies() {
    }
}
