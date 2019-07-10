package com.zlx.clinic.service;

import com.zlx.clinic.dto.MedicineInfo;
import com.zlx.clinic.dto.SimplePatientInfo;
import com.zlx.clinic.dto.TreateMedicineInfo;
import com.zlx.clinic.entity.Treat;
import com.zlx.clinic.mapper.TreatMapper;
import com.zlx.clinic.mymapper.MyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreateService {
    @Autowired
    private MyMapper myMapper;

    @Autowired
    private TreatMapper treatMapper;

    public void payTotalPrice(Integer tId){
        Treat treat=new Treat();
        treat.settId(tId);
        treat.settPay(true);
        treatMapper.updateByPrimaryKeySelective(treat);
    }

    public void updateTotalPrice(Integer tId){
        TreateMedicineInfo treateMedicineInfo = myMapper.selectMedInfoByTId(tId);
        Integer id = treateMedicineInfo.gettId();
        Integer total = getTotalPrice(treateMedicineInfo);
        System.out.println("total:"+total);
        Treat treat=new Treat();
        treat.settId(id);
        treat.settTotalPrice(total);
        treatMapper.updateByPrimaryKeySelective(treat);
    }

    private Integer getTotalPrice(TreateMedicineInfo treateMedicineInfo) {
        List<MedicineInfo> medicineInfos = treateMedicineInfo.getMedicineInfos();
        Integer total=0;
        for (MedicineInfo medicineInfo:medicineInfos){
            Integer count=medicineInfo.getmCount();
            Integer price = medicineInfo.getmPrice();
            total+=count * price;
        }
        return total;
    }

    public Integer selectTotalPrice(Integer tId) {
        Treat treat = treatMapper.selectByPrimaryKey(tId);
        return treat.gettTotalPrice();
    }

    public TreateMedicineInfo selectMedicineByTId(Integer tId) {
        return myMapper.selectMedInfoByTId(tId);
    }

    public SimplePatientInfo selectSimplePatient(Integer tId) {
        return myMapper.selectSimplePatient(tId);
    }
}
