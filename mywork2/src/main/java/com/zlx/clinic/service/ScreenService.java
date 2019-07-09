package com.zlx.clinic.service;

import com.zlx.clinic.myentity.MyArrange;
import com.zlx.clinic.myentity.PatientQueue;
import com.zlx.clinic.util.mydata.MyNumMap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

public class ScreenService {


    public List<PatientQueue> getDoctors(String rName) {
        //获取该科室的hashMap
        ConcurrentHashMap<String, LinkedBlockingDeque<MyArrange>> arrange = MyNumMap.getArrange(rName);
        //存储每个医生的病人队列
        List<PatientQueue> list = null;
        if (arrange != null) {
            list = new ArrayList<>();
            //遍历map，把每个医生都取出来放入list
            for (LinkedBlockingDeque l : arrange.values()) {
                PatientQueue patientQueue = new PatientQueue();
                Iterator iterator = l.iterator();
                //遍历队列，取出所有病人，放入病人队列
                if (iterator.hasNext()) {
                    MyArrange next = (MyArrange) iterator.next();
                    patientQueue.getPatientQueue().add(next);
                }
                list.add(patientQueue);
            }
            return list;
        }
        return null;
    }
}
