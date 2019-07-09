package com.zlx.clinic.controller;

import com.zlx.clinic.entity.*;
import com.zlx.clinic.myentity.MyDoctorOut;
import com.zlx.clinic.myentity.MyRoomDate;
import com.zlx.clinic.service.AdminService;
import com.zlx.clinic.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminOptions {
    @Autowired
    private AdminService adminService;


    @RequestMapping(value = "/adminLogin", method = {RequestMethod.GET, RequestMethod.POST})
    public String adminLogin(Model model, HttpSession httpSession, Admin admin) throws Exception {
        Admin admin1 = adminService.adminLogin(admin);
        if (admin1 != null) {
            Byte aByte = admin1.getaGrade();
            switch (aByte) {
                case 1:
                    //导诊
                    httpSession.setAttribute("arrangeAdmin", admin1);
                    Room room = adminService.findRoomByAId(admin1.getaId());
                    httpSession.setAttribute("aroom", room);
                    return "WEB-INF/jsp/admin/num/numArrange";
                case 2:
                    //药品管理员
                    List<Medicine> medicineByAsc =
                            adminService.findMedicineByAsc();
                    httpSession.setAttribute("medicAdmin",admin1);
                    model.addAttribute("medics", medicineByAsc);
                    model.addAttribute("test", "test");
                    return "/WEB-INF/jsp/admin/medic/medic";
                case 3:
                    //科室管理员
                    List<String> sevenDate = adminService.getSevenDate();
                    httpSession.setAttribute("roomAdmin",admin1);
                    model.addAttribute("dates", sevenDate);
                    return "/WEB-INF/jsp/admin/room/room";
                case 4:
                    httpSession.setAttribute("allAdmin",admin1);
                    return "/WEB-INF/jsp/admin/all/allAdmin";
                default:
                    //没有权限
                    System.out.println("没有权限");
                    model.addAttribute("error", "have no authority");
                    return "/adminlogin";
            }

        }
        //用户名或密码错误
        System.out.println("用户名或密码错误");
        model.addAttribute("error", "user or password error");
        return "/adminlogin";
    }

    /**
     * @param model       排号结果
     * @param httpSession 导诊自身信息，获取科室名
     * @param phone       查询是否有此人
     * @return
     * @throws Exception
     * @RequestParam 表示前端参数名和controller不同，用这个注解来绑定，required为true，如果参数未传入，报错
     * 导诊排号
     */
    @RequestMapping(value = "/arrange", method = {RequestMethod.GET, RequestMethod.POST})
    public String arrange(Model model, HttpSession httpSession, @RequestParam(value = "aPhone", required = true) String phone) throws Exception {
        Admin arrangeUser = (Admin) httpSession.getAttribute("arrangeAdmin");

        //将科室管理员和手机号传入service
        if (adminService.arrangeQueue(phone, arrangeUser)) {
            //安排成功
            model.addAttribute("result", "排号成功");
            return "/WEB-INF/jsp/patient/apply";
        } else {
            //安排失败，今日无此人预约
            model.addAttribute("result", "检查是否已经预约，或是否已经排号");
            return "/WEB-INF/jsp/patient/fail";
        }
    }


    /**本科室
     * 根据前段传的date和上午下午找到出诊信息
     *
     * @param model
     * @param myRoomDate
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "showDoctor", method = {RequestMethod.GET, RequestMethod.POST})
    public String showDoctor(Model model,HttpSession session, MyRoomDate myRoomDate) throws Exception {
        Admin roomAdmin = (Admin) session.getAttribute("roomAdmin");
        session.setAttribute("myRoomDate",myRoomDate);
        List<MyDoctorOut> outDoctors = adminService.getDoctorByDate(myRoomDate,roomAdmin);
        List<Doctor> notOutDoctor = adminService.getNotOutDoctor(myRoomDate, roomAdmin);
        //未出诊
        model.addAttribute("noDoctors", notOutDoctor);
        //已经出诊
        model.addAttribute("oDoctors", outDoctors);
        return "/WEB-INF/jsp/admin/room/showMessage";
    }

    /**
     * 添加可预约数目
     * @param itemOutTreate iId dAllCount(增加的数目)
     * @return
     */
    @RequestMapping(value = "addCount",method = {RequestMethod.GET,RequestMethod.POST})
    public String  addCount(ItemOutTreate itemOutTreate){
        adminService.addOutCount(itemOutTreate);
        System.out.println(itemOutTreate.getdAllCount());
        System.out.println(itemOutTreate);
        return null;
    }


    /**
     * 添加出诊信息
     * @param itemOutTreate 包含医生id 和预约数目
     */
    @RequestMapping(value = "addOutTreat",method = {RequestMethod.GET,RequestMethod.POST})
    public String addOutTreat(HttpSession session,ItemOutTreate itemOutTreate) throws ParseException {
        MyRoomDate myRoomDate = (MyRoomDate) session.getAttribute("myRoomDate");
       //将日期传入service
        adminService.addOutTreat(itemOutTreate,myRoomDate);
        return null;
    }



}
