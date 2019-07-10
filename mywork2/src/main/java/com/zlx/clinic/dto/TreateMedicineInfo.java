package com.zlx.clinic.dto;

import java.util.List;

public class TreateMedicineInfo {
    private Integer tId;
    private List<MedicineInfo> medicineInfos;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public List<MedicineInfo> getMedicineInfos() {
        return medicineInfos;
    }

    public void setMedicineInfos(List<MedicineInfo> medicineInfos) {
        this.medicineInfos = medicineInfos;
    }

    @Override
    public String toString() {
        return "TreateMedicineInfo{" +
                "tId=" + tId +
                ", medicineInfos=" + medicineInfos +
                '}';
    }
}
