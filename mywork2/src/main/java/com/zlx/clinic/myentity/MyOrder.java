package com.zlx.clinic.myentity;

import java.util.Date;

public class MyOrder {
    private Integer userID;
    private Integer doctorID;
    private Integer  iId;
    private Integer roomID;



    public MyOrder(Integer userID, Integer doctorID, Integer roomID) {
        this.userID = userID;
        this.doctorID = doctorID;


        this.roomID = roomID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Integer doctorID) {
        this.doctorID = doctorID;
    }

    public Integer getRoomID() {
        return roomID;
    }

    public void setRoomID(Integer roomID) {
        this.roomID = roomID;
    }

    public Integer getiId() {
        return iId;
    }

    public void setiId(Integer iId) {
        this.iId = iId;
    }
}
