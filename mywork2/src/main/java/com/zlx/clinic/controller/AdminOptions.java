package com.zlx.clinic.controller;

import com.zlx.clinic.entity.*;
import com.zlx.clinic.exception.MyException;
import com.zlx.clinic.myentity.MyDoctorOut;
import com.zlx.clinic.myentity.MyRoomDate;
import com.zlx.clinic.service.AdminService;
import com.zlx.clinic.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminOptions {
    @Autowired
    private AdminService adminService;


    @ResponseBody
    @RequestMapping(value = "/adminLogin", method = {RequestMethod.GET, RequestMethod.POST})
    public Integer adminLogin(Model model, HttpSession httpSession,@RequestBody Admin admin) throws Exception {
        int i=0;
        Admin admin1 = adminService.adminLogin(admin);
        if (admin1 != null) {
            Byte aByte = admin1.getaGrade();
            switch (aByte) {
                case 1:
                    //导诊
                    httpSession.setAttribute("arrangeAdmin", admin1);
//                    Room room = adminService.findRoomByAId(admin1.getaId());
//                    httpSession.setAttribute("aroom", room);
                    return 1;
                case 2:
                    //药品管理员
                    httpSession.setAttribute("medicAdmin",admin1);
//                    List<Medicine> medicineByAsc = adminService.findMedicineByAsc();
//                    model.addAttribute("medics", medicineByAsc);
                    return 2;
                case 3:
                    //科室管理员
                    httpSession.setAttribute("roomAdmin",admin1);
//                    List<String> sevenDate = adminService.getSevenDate();
//                    model.addAttribute("dates", sevenDate);
                    return 3;
                case 4:
                    httpSession.setAttribute("allAdmin",admin1);
                    return 4;
                default:
                    //没有权限
                    System.out.println("没有权限");
                    return 5;
            }

        }
        //用户名或密码错误
        System.out.println("用户名或密码错误");
        return 0;
    }

    /**
     * 获取导诊科室
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getRname",method = {RequestMethod.GET,RequestMethod.POST})
    public Room getRname(HttpSession session) throws MyException {
        Admin arrangeAdmin = (Admin) session.getAttribute("arrangeAdmin");
        if(arrangeAdmin==null){
            throw new MyException("未登录");
        }
        Room room = adminService.findRoomByAId(arrangeAdmin.getaId());
        return room;
    }




    /** 导诊排号
     * @param model       排号结果
     * @param httpSession 导诊自身信息，获取科室名
     * @param phone       查询是否有此人
     * @return
     * @throws Exception  @RequestParam(value = "aPhone", required = true)
     * @RequestParam 表示前端参数名和controller不同，用这个注解来绑定，required为true，如果参数未传入，报错
     * 导诊排号
     */
    @ResponseBody
    @RequestMapping(value = "/arrange", method = {RequestMethod.GET, RequestMethod.POST})
    public boolean arrange(Model model, HttpSession httpSession,  String pPhone) throws Exception {
        Admin arrangeUser = (Admin) httpSession.getAttribute("arrangeAdmin");
        if(arrangeUser==null){
            throw new MyException("未登录");
        }
        boolean result=false;
        //将科室管理员和手机号传入service
        if (adminService.arrangeQueue(pPhone, arrangeUser)) {
            //安排成功
            result =true;
            return result;
        } else {
            //安排失败，今日无此人预约
            return false;
        }
    }


    /**
     * 获取以后七天日期
     * @param session
     * @return
     * @throws MyException
     */
    @ResponseBody
    @RequestMapping(value = "getSevenDate",method = {RequestMethod.GET,RequestMethod.POST})
    public List<String> getSevenDate(HttpSession session) throws MyException {
        Admin roomAdmin = (Admin) session.getAttribute("roomAdmin");
        if(roomAdmin==null){
            throw new MyException("未登录");
        }
        List<String> sevenDate = adminService.getSevenDate();
        return sevenDate;
    }


    /**科室管理员
     * 根据前段传的date和上午下午找到出诊信息
     *
     * @param model
     * @param myRoomDate
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "showDoctor", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String,Object> showDoctor(Model model, HttpSession session, @RequestBody MyRoomDate myRoomDate) throws Exception {
        Admin roomAdmin = (Admin) session.getAttribute("roomAdmin");
        if(roomAdmin==null){
            throw new MyException("未登录");
        }
        Map<String,Object> result=new HashMap<>();
        session.setAttribute("myRoomDate",myRoomDate);
        List<MyDoctorOut> outDoctors = adminService.getDoctorByDate(myRoomDate,roomAdmin);
        List<Doctor> notOutDoctor = adminService.getNotOutDoctor(myRoomDate, roomAdmin);
        //未出诊
        model.addAttribute("noDoctors", notOutDoctor);
        result.put("noDoctors",notOutDoctor);
        //已经出诊
        result.put("oDoctors", outDoctors);
        return result;
    }


    /**
     * ！！！！！！！！！！不返回页面
     */


    /** 科室管理员
     * 添加可预约数目
     * @param itemOutTreate iId dAllCount(增加的数目)
     * @return
     */
    @RequestMapping(value = "addCount",method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody  boolean addCount(HttpSession session,ItemOutTreate itemOutTreate) throws Exception {
        Admin roomAdmin = (Admin) session.getAttribute("roomAdmin");
        if(roomAdmin==null){
            throw new MyException("未登录");
        }
        boolean result;

        adminService.addOutCount(itemOutTreate);
        System.out.println(itemOutTreate.getdAllCount());
        System.out.println(itemOutTreate);
        result =true;
        return result;
    }


    /** 科室管理员
     * 添加出诊信息
     * @param itemOutTreate 包含医生id 和预约数目
     */
    @RequestMapping(value = "addOutTreat",method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    boolean addOutTreat(HttpSession session, ItemOutTreate itemOutTreate) throws Exception{
        boolean result;
        Admin roomAdmin = (Admin) session.getAttribute("roomAdmin");
        if(roomAdmin==null){
            throw new MyException("未登录");
        }
        MyRoomDate myRoomDate = (MyRoomDate) session.getAttribute("myRoomDate");
       //将日期传入service
        adminService.addOutTreat(itemOutTreate,myRoomDate);
        result =true;
       return result;
    }



}
