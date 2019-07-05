package com.zlx.clinic.myentity;

import com.zlx.clinic.entity.Doctor;
import com.zlx.clinic.entity.Patient;
import com.zlx.clinic.entity.PatientOrder;

/**
 * 前台导诊输出映射，查询到的预约单,医生，病人
 */
public class MyArrange {
    //记录病人信息
    private Patient patient;
    //记录医生
    private Doctor doctor;
    //记录预约信息
    private  PatientOrder patientOrder;


    public PatientOrder getPatientOrder() {
        return patientOrder;
    }

    public void setPatientOrder(PatientOrder patientOrder) {
        this.patientOrder = patientOrder;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "MyArrange{" +
                "patient=" + patient +
                ", doctor=" + doctor +
                ", patientOrder=" + patientOrder +
                '}';
    }
}
