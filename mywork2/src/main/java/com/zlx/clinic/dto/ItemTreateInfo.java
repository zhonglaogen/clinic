package com.zlx.clinic.dto;

public class ItemTreateInfo {
    private Integer iId;
    private Integer dId;
    private String dName;
    private Integer dCount;
    private Integer dAllCount;

    public Integer getiId() {
        return iId;
    }

    public void setiId(Integer iId) {
        this.iId = iId;
    }

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

    public Integer getdCount() {
        return dCount;
    }

    public void setdCount(Integer dCount) {
        this.dCount = dCount;
    }

    public Integer getdAllCount() {
        return dAllCount;
    }

    public void setdAllCount(Integer dAllCount) {
        this.dAllCount = dAllCount;
    }

    @Override
    public String toString() {
        return "ItemTreateInfo{" +
                "iId=" + iId +
                ", dId=" + dId +
                ", dName='" + dName + '\'' +
                ", dCount=" + dCount +
                ", dAllCount=" + dAllCount +
                '}';
    }
}
