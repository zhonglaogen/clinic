package com.zlx.clinic.dto;

public class SimplePatientInfo {
    private Integer tId;
    private String pName;
    private String pGender;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpGender() {
        return pGender;
    }

    public void setpGender(String pGender) {
        this.pGender = pGender;
    }

    @Override
    public String toString() {
        return "SimplePatientInfo{" +
                "tId=" + tId +
                ", pName='" + pName + '\'' +
                ", pGender='" + pGender + '\'' +
                '}';
    }
}
