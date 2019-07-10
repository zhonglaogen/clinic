package com.zlx.clinic.dto;

public class MedicineInfo {
    private Integer moId;
    private Integer mId;
    private String mName;
    private Integer mCount;
    private Integer mPrice;

    public Integer getMoId() {
        return moId;
    }

    public void setMoId(Integer moId) {
        this.moId = moId;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
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

    public Integer getmPrice() {
        return mPrice;
    }

    public void setmPrice(Integer mPrice) {
        this.mPrice = mPrice;
    }

    @Override
    public String toString() {
        return "MedicineInfo{" +
                "moId=" + moId +
                ", mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mCount=" + mCount +
                ", mPrice=" + mPrice +
                '}';
    }
}
