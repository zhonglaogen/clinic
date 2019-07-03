package com.zlx.clinic.controller;

import com.zlx.clinic.entity.Doctor;
import com.zlx.clinic.entity.Patient;
import com.zlx.clinic.entity.PatientOrder;
import com.zlx.clinic.myentity.MyDoctorOut;
import com.zlx.clinic.myentity.MyOrder;
import com.zlx.clinic.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/patient")
public class UserOptions {


    @Autowired
    private PatientService patientService;

    /**
     *  patient login
     * @param modelAndView
     * @param patient
     * @return
     */
    @RequestMapping("/userlogin")
    public String userLogin(ModelAndView modelAndView, HttpSession session, Patient patient){
        if( patientService.patientLogin(patient)){
            System.out.println("login succeess");
            patient= patientService.findByPhone(patient.getpPhone());
//            将patient信息完整存入session中
            session.setAttribute("patient",patient);
            return "patient/index";
        }else {
            modelAndView.addObject("error","user or password error");
            return "patient/userlogin";
        }

    }

    /**
     * 用户选择相应的科室后，列出该科室具体的出诊医师
     * @param  modelAndView
     * @param    rID  科室id
     * @return
     */
    @RequestMapping("/chooseroom")
    public String chooseRoom(HttpSession session,int rId){
      List<MyDoctorOut> doctors = patientService.findDoctorByRID(rId);
     session.setAttribute("doctors",doctors);
      return "patient/doctor";
  }


    /**
     * 用户申请
     * 需要包含用户id，医生id，科室id
     * @return
     */
    @RequestMapping("/apply")
    public String userApply(HttpSession session,MyOrder myOrder) throws Exception {
        Patient patient = (Patient) session.getAttribute("patient");
        myOrder.setUserID(patient.getpId());
        System.out.println("+++++++++++++++++="+myOrder.getDoctorID());
        boolean b = patientService.patientApply(myOrder);
        if(b){
            return "patient/apply";
        }else {
            return "patient/fail";
        }

    }

    /**
     *  查看已预约条目
     * @param pID 病人id
     * @return
     */
    @RequestMapping("/showapply")
    public String showApply(HttpSession session,ModelAndView modelAndView){
        Patient patient= (Patient) session.getAttribute("patient");
        List<MyDoctorOut> orders= patientService.findOrderByPID(patient.getpId());
        session.setAttribute("orders",orders);
        return "patient/showorder";
    }




}
