package com.zlx.clinic.dto;

import java.util.List;

public class DoctorTreateInfo {
    private Integer dId;
    private String dName;

    private List<PatientTreateInfo> patientTreateInfos;

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public List<PatientTreateInfo> getPatientTreateInfos() {
        return patientTreateInfos;
    }

    public void setPatientTreateInfos(List<PatientTreateInfo> patientTreateInfos) {
        this.patientTreateInfos = patientTreateInfos;
    }

    @Override
    public String toString() {
        return "DoctorTreateInfo{" +
                "dId=" + dId +
                ", dName='" + dName + '\'' +
                ", patientTreateInfos=" + patientTreateInfos +
                '}';
    }
}
