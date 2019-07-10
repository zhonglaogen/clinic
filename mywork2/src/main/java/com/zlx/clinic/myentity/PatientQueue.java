package com.zlx.clinic.myentity;

import java.util.ArrayList;
import java.util.List;

/**
 * 每个医生的病人队列
 */
public class PatientQueue {

    private List<MyArrange> patientQueue =new ArrayList<>();

    public List<MyArrange> getPatientQueue() {
        return patientQueue;
    }

    public void setPatientQueue(List<MyArrange> patientQueue) {
        this.patientQueue = patientQueue;
    }
}
