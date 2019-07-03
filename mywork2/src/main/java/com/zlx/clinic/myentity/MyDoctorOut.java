package com.zlx.clinic.myentity;

import com.zlx.clinic.entity.Doctor;
import com.zlx.clinic.entity.ItemOutTreate;
import com.zlx.clinic.entity.PatientOrder;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDoctorOut {
    private Doctor doctor;
    private ItemOutTreate itemOutTreate;
    private PatientOrder patientOrder;

    public PatientOrder getPatientOrder() {
        return patientOrder;
    }

    public void setPatientOrder(PatientOrder patientOrder) {
        this.patientOrder = patientOrder;
    }

    //预约当日的日期
    private String itemDate;
    //预约单是否有效
    private boolean isGo;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public ItemOutTreate getItemOutTreate() {
        return itemOutTreate;
    }

    public void setItemOutTreate(ItemOutTreate itemOutTreate) {
        this.itemOutTreate = itemOutTreate;
    }

    @Override
    public String toString() {
        return "MyDoctorOut{" +
                "doctor=" + doctor +
                ", itemOutTreate=" + itemOutTreate +
                '}';
    }
    public String getItemDate(){
        Date date = itemOutTreate.getiDate();
        SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
        return s.format(date);

    }

    public boolean isGo() {
        return isGo;
    }

    public void setGo(boolean go) {
        isGo = go;
    }
}
