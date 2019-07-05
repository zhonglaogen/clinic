package com.zlx.clinic.controller;

import com.zlx.clinic.entity.Doctor;
import com.zlx.clinic.entity.Treat;
import com.zlx.clinic.myentity.MyArrange;
import com.zlx.clinic.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/doctor")
public class DoctorOptions {

    @Autowired
    private DoctorService doctorService;

    /**
     * 登录
     * @param model
     * @param session
     * @param doctor
     * @return
     */
    @RequestMapping(value = "doctorLogin",method = {RequestMethod.GET,RequestMethod.POST})
    public String doctorLogin(Model model, HttpSession session, Doctor doctor){
        Doctor doctor1 = doctorService.doctorLogin(doctor);
        if(doctor1!=null){
            session.setAttribute("doctor",doctor1);
            return "/WEB-INF/jsp/doctor/dshow";
        }
        model.addAttribute("result","fail");
        return "/doctorlogin";
    }

    /**
     * 叫号
     * @param model
     * @param session
     */
    @RequestMapping(value = "callNum",method = {RequestMethod.GET,RequestMethod.POST})
    public String callNum(Model model,HttpSession session){
        //将医生信息传入service，叫号
        Doctor doctor = (Doctor) session.getAttribute("doctor");
        MyArrange myArrange = doctorService.callNum(doctor);
        session.setAttribute("myArrange",myArrange);
        return "/WEB-INF/jsp/doctor/dshow";
    }

    /**
     * 叫号三次没来，加入队列尾部
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "nextNum",method = {RequestMethod.GET,RequestMethod.POST})
    public String  nextNum(Model model,HttpSession session){
        Doctor doctor = (Doctor) session.getAttribute("doctor");
        doctorService.nextNum(doctor);
        session.removeAttribute("myArrange");
        return "/WEB-INF/jsp/doctor/dshow";
    }

    /**
     * 进入诊治界面
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "showTreat",method = {RequestMethod.GET,RequestMethod.POST})
    public String showTreat(Model model,HttpSession session){
        MyArrange myArrange = (MyArrange) session.getAttribute("myArrange");
        if(myArrange!=null){
//            Treat treat = doctorService.getTreat(myArrange);
//            session.setAttribute("treat",treat);
            return "/WEB-INF/jsp/doctor/treat";
        }
        model.addAttribute("result","无人排号");
       return "/WEB-INF/jsp/doctor/dshow";
    }

    /**
     * 诊治结束
     * @param session
     * @param treat
     * @return
     */
    @RequestMapping(value = "outResult",method = {RequestMethod.GET,RequestMethod.POST})
    public String outResult(HttpSession session,Treat treat){
        MyArrange myArrange = (MyArrange) session.getAttribute("myArrange");
        treat.settId(myArrange.getPatientOrder().gettId());
        doctorService.postTreat(treat,myArrange.getDoctor());
        //从session中移除此预约排号
        session.removeAttribute("myArrange");
        return "/WEB-INF/jsp/doctor/dshow";
    }

}
