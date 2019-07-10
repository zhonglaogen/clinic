package com.zlx.clinic.service;

import com.zlx.clinic.dto.MedicineInfo;
import com.zlx.clinic.mymapper.MyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InfoService {
    @Autowired
    private MyMapper myMapper;

    public Map<String,Object> selectAllInfo(){
        Map<String,Object> map=new HashMap<>();
        List<MedicineInfo> medicineInfos = myMapper.selectMedicineInfos();
        Integer patient = myMapper.selectToatalOfPatient();
        Integer order = myMapper.selectTotalOfOrder();
        map.put("medicines",medicineInfos);
        map.put("patientTotal",patient);
        map.put("orderTotal",order);
        return map;
    }
}
