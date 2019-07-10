package com.zlx.clinic.dto;

import java.util.List;

public class POrderInfo {
    private Integer pId;
    private String pName;

    private List<OutTreateInfo> outTreateInfos;

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

    public List<OutTreateInfo> getOutTreateInfos() {
        return outTreateInfos;
    }

    public void setOutTreateInfos(List<OutTreateInfo> outTreateInfos) {
        this.outTreateInfos = outTreateInfos;
    }

    @Override
    public String toString() {
        return "POrderInfo{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", outTreateInfos=" + outTreateInfos +
                '}';
    }
}
