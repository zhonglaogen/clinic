package com.zlx.clinic.controller;

import com.zlx.clinic.entity.Patient;
import com.zlx.clinic.entity.PatientOrder;
import com.zlx.clinic.exception.MyException;
import com.zlx.clinic.myentity.MyDoctorOut;
import com.zlx.clinic.myentity.MyOrder;
import com.zlx.clinic.myentity.MyRoomDate;
import com.zlx.clinic.service.AdminService;
import com.zlx.clinic.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/patient")
public class UserOptions {


    @Autowired
    private PatientService patientService;

    /**
     * 页面中input的name和controller的pojo形参中的属性名称一致，将页面中数据绑定到pojo。
     * patient login
     *
     * @param
     * @param patient
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/userLogin",method = {RequestMethod.GET,RequestMethod.POST})
    public  boolean  userLogin(Model model, HttpSession session, @RequestBody Patient patient) throws Exception {
        Patient patient1 = patientService.patientLogin(patient);
        boolean result;
        if (patient1!=null) {
//            将patient信息完整存入session中
            session.setAttribute("patient", patient1);
            result=true;
            return result;
//            return "/index";
        }
        model.addAttribute("result","fail");
        result=false;
        return result;
//            return "/userlogin";
    }

    @ResponseBody
    @RequestMapping(value = "getUserSession",method = {RequestMethod.GET,RequestMethod.POST})
    public Patient getUserSession(HttpSession session){
        Patient patient = (Patient) session.getAttribute("patient");
        return patient;
    }


    /**
     * 用户选择相应的科室后，列出该科室具体的出诊医师
     *
     * @param
     * @param rID          科室id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/chooseroom",method = {RequestMethod.GET,RequestMethod.POST})
    public List<MyDoctorOut> chooseRoom(Model model,  Integer rId) throws Exception {

        List<MyDoctorOut> doctors = patientService.findDoctorByRID(rId);
        return doctors;
    }


    /**
     * 用户申请
     * 需要包含用户id，医生id，科室id
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/apply",method = {RequestMethod.GET,RequestMethod.POST})
    public boolean userApply(HttpSession session,@RequestBody MyOrder myOrder) throws Exception {
        boolean result=false;
        Patient patient = (Patient) session.getAttribute("patient");
        if(patient==null){
//            throw new MyException("未登录");
            return result;
        }
        myOrder.setpId(patient.getpId());
        System.out.println("+++++++++++++++++=" + myOrder.getdId());
         result = patientService.patientApply(myOrder);
        if (result) {
            return result;
        } else {
            return result;
        }

    }

    /**
     * 查看已预约条目
     *
     * @param pID 病人id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/showvalidapply",method = {RequestMethod.GET,RequestMethod.POST})
    public List<MyDoctorOut> showValidApply(HttpSession session, Model model) throws Exception {
        Patient patient = (Patient) session.getAttribute("patient");
        if(patient==null){
            throw new MyException("未登录");
        }
        List<MyDoctorOut>  validOrders= patientService.findValidOrderByPid(patient.getpId());
       return validOrders;
    }
    @ResponseBody
    @RequestMapping(value = "/showinvalidapply",method = {RequestMethod.GET,RequestMethod.POST})
    public List<MyDoctorOut> showInvalidApply(HttpSession session, Model model) throws Exception {
        Patient patient = (Patient) session.getAttribute("patient");
        if(patient==null){
            throw new MyException("未登录");
        }
        List<MyDoctorOut> invalidOrders = patientService.findInvalidOrderByPid(patient.getpId());
       return invalidOrders;

    }





    /**
     * 取消预约
     *
     * @param patientOrder
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/cancelorder",method = {RequestMethod.GET,RequestMethod.POST})
    public boolean cancleOrder(HttpSession session,@RequestBody PatientOrder patientOrder) throws Exception {
        Patient patient = (Patient) session.getAttribute("patient");
        if(patient==null){
            throw new MyException("未登录");
        }
        boolean result = false;
        if (patientService.deleteOrder(patientOrder)) {
            result= true;
            return result;
        }
        return result;

    }




}
