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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

@Controller
public class Screen {

    @Autowired
    private ScreenService screenService;

    /** @RequestBody String rName
     * 通过rName拿到所有科室的排队信息
     * @param
     * @return
     */
    @RequestMapping("showNum")
    public @ResponseBody List<PatientQueue> getDoctor(){


        List<PatientQueue> patientQueues=new ArrayList<>();


//        第一个queue
        PatientQueue patientQueue1=new PatientQueue();


        Patient p11=new Patient();
        p11.setpName("name11");
        Patient p12=new Patient();
        p12.setpName("name12");

        Doctor doctor11=new Doctor();
        doctor11.setdId(11);
        doctor11.setdName("docName11");

        Doctor doctor12=new Doctor();
        doctor12.setdId(12);
        doctor12.setdName("docName12");

        MyArrange myArrange11=new MyArrange();
        myArrange11.setPatient(p11);
        myArrange11.setDoctor(doctor11);

        MyArrange myArrange12=new MyArrange();
        myArrange12.setPatient(p12);
        myArrange12.setDoctor(doctor12);


        patientQueue1.getPatientQueue().add(myArrange11);
        patientQueue1.getPatientQueue().add(myArrange12);


//        第二个queue
        PatientQueue patientQueue2=new PatientQueue();


        Patient p21=new Patient();
        p21.setpName("name21");
        Patient p22=new Patient();
        p22.setpName("name22");

        Doctor doctor21=new Doctor();
        doctor21.setdId(21);
        doctor21.setdName("docName21");

        Doctor doctor22=new Doctor();
        doctor22.setdId(22);
        doctor22.setdName("docName22");

        MyArrange myArrange21=new MyArrange();
        myArrange21.setPatient(p21);
        myArrange21.setDoctor(doctor21);

        MyArrange myArrange22=new MyArrange();
        myArrange22.setPatient(p22);
        myArrange22.setDoctor(doctor22);


        patientQueue2.getPatientQueue().add(myArrange21);
        patientQueue2.getPatientQueue().add(myArrange22);

        patientQueues.add(patientQueue1);
        patientQueues.add(patientQueue2);
        patientQueues.add(patientQueue1);


        return patientQueues;
//       return  screenService.getDoctors(rName);
    }



}
