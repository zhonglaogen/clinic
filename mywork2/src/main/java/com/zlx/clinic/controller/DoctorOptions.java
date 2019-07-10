package com.zlx.clinic.controller;

import com.zlx.clinic.entity.Doctor;
import com.zlx.clinic.entity.Patient;
import com.zlx.clinic.entity.Treat;
import com.zlx.clinic.exception.MyException;
import com.zlx.clinic.myentity.MyArrange;
import com.zlx.clinic.service.DoctorService;
import com.zlx.clinic.util.mydata.MyNumMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @ResponseBody
    @RequestMapping(value = "doctorLogin",method = {RequestMethod.GET,RequestMethod.POST})
    public boolean doctorLogin(Model model, HttpSession session, @RequestBody Doctor doctor){
        Doctor doctor1 = doctorService.doctorLogin(doctor);
        boolean result=false;
        if(doctor1!=null){
            session.setAttribute("doctor",doctor1);
            result = true;
            return result;
        }
        //密码错误
        return result;
    }




    /**
     * 叫号
     * @param model
     * @param session
     */
    @ResponseBody
    @RequestMapping(value = "callNum",method = {RequestMethod.GET,RequestMethod.POST})
    public MyArrange callNum(Model model,HttpSession session) throws MyException {
        //将医生信息传入service，叫号
        Doctor doctor = (Doctor) session.getAttribute("doctor");
        if (doctor == null) {
            throw new MyException("未登录");
        }
        MyArrange myArrange = doctorService.callNum(doctor);
        return myArrange;
    }

    /**
     * 叫号三次没来，加入队列尾部
     * @param model
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "nextNum",method = {RequestMethod.GET,RequestMethod.POST})
    public boolean  nextNum(Model model,HttpSession session) throws MyException {
        Doctor doctor = (Doctor) session.getAttribute("doctor");
        if (doctor == null) {
            throw new MyException("未登录");
        }
        doctorService.nextNum(doctor);
        return true;
    }

    /**
     * 进入诊治界面
     * @param model
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "showTreat",method = {RequestMethod.GET,RequestMethod.POST})
    public boolean showTreat(Model model,HttpSession session) throws MyException {
        Doctor doctor = (Doctor) session.getAttribute("doctor");
        if (doctor == null) {
        throw new MyException("未登录");
        }
        MyArrange myArrange = doctorService.callNum(doctor);
        if(myArrange!=null){
            Treat treat = doctorService.getTreat(myArrange);
            session.setAttribute("treat",treat);
            session.setAttribute("myArrange",myArrange);
            return true;
        }
        model.addAttribute("result","无人排号");
       return false;
    }

    /**
     * 返回当前的诊治预约
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getTreat",method = {RequestMethod.GET,RequestMethod.POST})
    public Map<String,Object> getArrangeTreat(HttpSession session){
        MyArrange myArrange = (MyArrange) session.getAttribute("myArrange");
        Treat treat = (Treat) session.getAttribute("treat");
        Map<String,Object> arrangeTreat=new HashMap<>();
        arrangeTreat.put("myArrange",myArrange);
        arrangeTreat.put("treat",treat);
        return arrangeTreat;
    }

    /**
     * 诊治结束
     * @param session
     * @param treat
     * @return
     */
    @RequestMapping(value = "outResult",method = {RequestMethod.GET,RequestMethod.POST})
    public boolean outResult(HttpSession session,Treat treat) throws MyException {
        Doctor doctor = (Doctor) session.getAttribute("doctor");
        if (doctor == null) {
            throw new MyException("未登录");
        }
        boolean result=true;
        doctorService.postTreat(treat,doctor);
        //清除session
        session.removeAttribute("myArrange");
        session.removeAttribute("treat");
        return result;
    }

    /**
     * 显示队列
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "showQueue",method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody List<MyArrange> getPatientQueue(HttpSession session) throws Exception {
        Doctor doctor = (Doctor) session.getAttribute("doctor");
        if (doctor == null) {
            throw new MyException("未登录");
        }
        List<MyArrange> patientQueue = doctorService.getPatientQueue(doctor);

        return patientQueue;
    }
}
