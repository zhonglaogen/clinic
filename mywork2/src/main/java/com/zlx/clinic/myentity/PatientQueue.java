package com.zlx.clinic.myentity;

import java.util.List;

/**
 * 每个医生的病人队列
 */
public class PatientQueue {

    private List<MyArrange> PatientQueue;

    public List<MyArrange> getPatientQueue() {
        return PatientQueue;
    }

    public void setPatientQueue(List<MyArrange> patientQueue) {
        PatientQueue = patientQueue;
    }
}
