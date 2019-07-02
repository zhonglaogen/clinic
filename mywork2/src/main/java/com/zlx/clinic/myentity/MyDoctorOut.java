package com.zlx.clinic.myentity;

import com.zlx.clinic.entity.Doctor;
import com.zlx.clinic.entity.ItemOutTreate;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDoctorOut {
    private Doctor doctor;
    private ItemOutTreate itemOutTreate;
    private String itemDate;

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
        SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return s.format(date);

    }
}
