package com.zlx.clinic.controller;

import com.zlx.clinic.entity.Doctor;
import com.zlx.clinic.entity.Patient;
import com.zlx.clinic.entity.PatientOrder;
import com.zlx.clinic.myentity.MyDoctorOut;
import com.zlx.clinic.myentity.MyOrder;
import com.zlx.clinic.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/patient")
public class UserOptions {


    @Autowired
    private PatientService patientService;

    /**
     * 页面中input的name和controller的pojo形参中的属性名称一致，将页面中数据绑定到pojo。
     * patient login
     *
     * @param modelAndView
     * @param patient
     * @return
     */
    @RequestMapping(value = "/userLogin",method = {RequestMethod.GET,RequestMethod.POST})
    public String userLogin(Model model, HttpSession session, Patient patient) throws Exception {
        Patient patient1 = patientService.patientLogin(patient);
        if (patient1!=null) {
//            将patient信息完整存入session中
            session.setAttribute("patient", patient1);
            return "/index";
        }
        model.addAttribute("result","fail");
            return "/userlogin";
    }

    /**
     * 用户选择相应的科室后，列出该科室具体的出诊医师
     *
     * @param modelAndView
     * @param rID          科室id
     * @return
     */
    @RequestMapping(value = "/chooseroom",method = {RequestMethod.GET,RequestMethod.POST})
    public String chooseRoom(HttpSession session, int rId) throws Exception {
        List<MyDoctorOut> doctors = patientService.findDoctorByRID(rId);
        session.setAttribute("doctors", doctors);
        return "/WEB-INF/jsp/patient/doctor";
    }


    /**
     * 用户申请
     * 需要包含用户id，医生id，科室id
     *
     * @return
     */
    @RequestMapping(value = "/apply",method = {RequestMethod.GET,RequestMethod.POST})
    public String userApply(HttpSession session, MyOrder myOrder) throws Exception {
        Patient patient = (Patient) session.getAttribute("patient");
        myOrder.setUserID(patient.getpId());
        System.out.println("+++++++++++++++++=" + myOrder.getDoctorID());
        boolean b = patientService.patientApply(myOrder);
        if (b) {
            return "/WEB-INF/jsp/patient/apply";
        } else {
            return "/WEB-INF/jsp/patient/fail";
        }

    }

    /**
     * 查看已预约条目
     *
     * @param pID 病人id
     * @return
     */
    @RequestMapping(value = "/showapply",method = {RequestMethod.GET,RequestMethod.POST})
    public String showApply(HttpSession session, ModelAndView modelAndView) throws Exception {
        Patient patient = (Patient) session.getAttribute("patient");
        List<MyDoctorOut> orders = patientService.findOrderByPID(patient.getpId());
        session.setAttribute("orders", orders);
        return "/WEB-INF/jsp/patient/showorder";
    }

    /**
     * 取消预约
     *
     * @param patientOrder
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/cancelorder",method = {RequestMethod.GET,RequestMethod.POST})
    public String cancleOrder(PatientOrder patientOrder) throws Exception {
        if (patientService.deleteOrder(patientOrder)) {
            return "/WEB-INF/jsp/patient/apply";
        } else {
            return "/WEB-INF/jsp/patient/fail";
        }
    }


}
