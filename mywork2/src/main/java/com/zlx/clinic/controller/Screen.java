package com.zlx.clinic.controller;

import com.zlx.clinic.entity.Doctor;
import com.zlx.clinic.entity.Patient;
import com.zlx.clinic.myentity.MyArrange;
import com.zlx.clinic.myentity.PatientQueue;
import com.zlx.clinic.service.ScreenService;
import com.zlx.clinic.util.mydata.MyNumMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

@Controller
public class Screen {

    @Autowired
    private ScreenService screenService;

    /**
     * 通过rName拿到所有科室的排队信息
     * @param rName
     * @return
     */
    @RequestMapping("showNum")
    public @ResponseBody List<PatientQueue> getDoctor(@RequestBody String rName){

       return  screenService.getDoctors(rName);
    }



}
