package com.zlx.clinic.dto;

import java.util.Date;
import java.util.List;

public class OutTreateInfo {
    private Integer oId;
    private Integer rId;
    private String rName;
    private Date oDate;
    private String oTime;

    private List<ItemTreateInfo> infos;

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public Date getoDate() {
        return oDate;
    }

    public void setoDate(Date oDate) {
        this.oDate = oDate;
    }

    public String getoTime() {
        return oTime;
    }

    public void setoTime(String oTime) {
        this.oTime = oTime;
    }

    public List<ItemTreateInfo> getInfos() {
        return infos;
    }

    public void setInfos(List<ItemTreateInfo> infos) {
        this.infos = infos;
    }

    @Override
    public String toString() {
        return "OutTreateInfo{" +
                "oId=" + oId +
                ", rId=" + rId +
                ", rName='" + rName + '\'' +
                ", oDate=" + oDate +
                ", oTime='" + oTime + '\'' +
                ", infos=" + infos +
                '}';
    }
}
