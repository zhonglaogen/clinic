package com.zlx.clinic.service;

import com.zlx.clinic.entity.Medicine;
import com.zlx.clinic.mapper.MedicineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcelService {

    @Autowired
    private MedicineMapper medicineMapper;

    public void saveBath(List<String[]> list) {
        for (String[] strings : list) {
            Medicine medicine=new Medicine();
            medicine.setmName(strings[0]);
            medicine.setmCount(Integer.parseInt(strings[1]));
            medicine.setmPrice(Integer.parseInt(strings[2]));
            int save = this.save(medicine);
            System.out.println(medicine);
            System.out.println(save);
        }
    }

    private int save(Medicine medicine) {
        return medicineMapper.insert(medicine);
    }
}
