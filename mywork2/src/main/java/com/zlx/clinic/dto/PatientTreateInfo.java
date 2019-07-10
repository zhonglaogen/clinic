package com.zlx.clinic.dto;

import java.util.Date;
import java.util.List;

public class PatientTreateInfo {
    private Integer tId;
    private Integer pId;
    private String pName;

    private String tResult;
    private Boolean tType;
    private Boolean tBed;
    private Date tDate;
    private Integer tTotalPrice;
    private Boolean tPay;

    private List<MedicineInfo> medicineInfos;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String gettResult() {
        return tResult;
    }

    public void settResult(String tResult) {
        this.tResult = tResult;
    }

    public Boolean gettType() {
        return tType;
    }

    public void settType(Boolean tType) {
        this.tType = tType;
    }

    public Boolean gettBed() {
        return tBed;
    }

    public void settBed(Boolean tBed) {
        this.tBed = tBed;
    }

    public Date gettDate() {
        return tDate;
    }

    public void settDate(Date tDate) {
        this.tDate = tDate;
    }

    public Integer gettTotalPrice() {
        return tTotalPrice;
    }

    public void settTotalPrice(Integer tTotalPrice) {
        this.tTotalPrice = tTotalPrice;
    }

    public Boolean gettPay() {
        return tPay;
    }

    public void settPay(Boolean tPay) {
        this.tPay = tPay;
    }

    public List<MedicineInfo> getMedicineInfos() {
        return medicineInfos;
    }

    public void setMedicineInfos(List<MedicineInfo> medicineInfos) {
        this.medicineInfos = medicineInfos;
    }

    @Override
    public String toString() {
        return "PatientTreateInfo{" +
                "tId=" + tId +
                ", pId=" + pId +
                ", pName='" + pName + '\'' +
                ", tResult='" + tResult + '\'' +
                ", tType=" + tType +
                ", tBed=" + tBed +
                ", tDate=" + tDate +
                ", tTotalPrice=" + tTotalPrice +
                ", tPay=" + tPay +
                ", medicineInfos=" + medicineInfos +
                '}';
    }
}
