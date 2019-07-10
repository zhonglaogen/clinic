package com.zlx.clinic.controller;

import com.zlx.clinic.dto.SimplePatientInfo;
import com.zlx.clinic.dto.TreateMedicineInfo;
import com.zlx.clinic.service.TreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TreateController {

    @Autowired
    private TreateService treateService;

    @ResponseBody
    @RequestMapping(value = "/treate/payInfo",name = "ymmm")
    public Map<String,Object> payInfo(@RequestParam("id") String id){
        Map<String,Object> map=new HashMap<>();
        Integer tId=Integer.parseInt(id);
        Integer totalPrice=treateService.selectTotalPrice(tId);
        TreateMedicineInfo treateMedicineInfo = treateService.selectMedicineByTId(tId);
        SimplePatientInfo selectSimplePatient = treateService.selectSimplePatient(tId);
        map.put("totalPrice",totalPrice);
        map.put("medicines",treateMedicineInfo);
        map.put("patient",selectSimplePatient);
        return map;
    }

    @ResponseBody
    @RequestMapping("/treate/pay")
    public Integer pay(Integer tId){
        Integer flag=0;
        try{
            treateService.payTotalPrice(tId);
            flag=1;
        } catch (Exception e){
           e.printStackTrace();
           return flag;
        }
        return flag;
    }
}
