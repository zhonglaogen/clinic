package com.zlx.clinic.service;

import com.zlx.clinic.entity.Doctor;
import com.zlx.clinic.entity.DoctorExample;
import com.zlx.clinic.util.MyUtil;
import org.apache.commons.codec.binary.Hex;

public class Login {


    public boolean myLogin()throws Exception{
        Hex.encodeHexString( MyUtil.getcode("aaa"));
        DoctorExample d=new DoctorExample();
        return false;
    }
}
