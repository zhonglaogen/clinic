package com.zlx.clinic.dto;

import java.util.Date;

public class TreateHistory {
    private Integer tId;
    private String pName;
    private String dName;
    private String tResult;
    private Boolean tType;
    private Integer tBed;
    private Date tDate;
    private Integer tTotalPrice;
    private String mName;
    private Integer mCount;

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

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
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

    public Integer gettBed() {
        return tBed;
    }

    public void settBed(Integer tBed) {
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

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public Integer getmCount() {
        return mCount;
    }

    public void setmCount(Integer mCount) {
        this.mCount = mCount;
    }

    @Override
    public String toString() {
        return "TreateHistory{" +
                "tId=" + tId +
                ", pName='" + pName + '\'' +
                ", dName='" + dName + '\'' +
                ", tResult='" + tResult + '\'' +
                ", tType=" + tType +
                ", tBed=" + tBed +
                ", tDate=" + tDate +
                ", tTotalPrice=" + tTotalPrice +
                ", mName='" + mName + '\'' +
                ", mCount=" + mCount +
                '}';
    }
}
