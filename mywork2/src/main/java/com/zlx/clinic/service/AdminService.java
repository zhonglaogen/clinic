package com.zlx.clinic.service;

import com.zlx.clinic.entity.*;
import com.zlx.clinic.mapper.*;
import com.zlx.clinic.myentity.MyArrange;
import com.zlx.clinic.myentity.MyArrangeMessage;
import com.zlx.clinic.myentity.MyDoctorOut;
import com.zlx.clinic.myentity.MyRoomDate;
import com.zlx.clinic.mymapper.MyNumAdminMapper;
import com.zlx.clinic.mymapper.MyRoomAdminMapper;
import com.zlx.clinic.util.mydata.MyNumMap;
import com.zlx.clinic.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Transactional
public class AdminService {
    @Autowired
    private MyNumAdminMapper myNumAdminMapper;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private PatientOrderMapper patientOrderMapper;
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private TreatMapper treatMapper;
    @Autowired
    private MedicineMapper medicineMapper;
    @Autowired
    private MyRoomAdminMapper myRoomAdminMapper;


    /**
     * admin 登录密码判定
     *
     * @param admin
     * @return
     */
    public Admin adminLogin(Admin admin) {
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andAPhoneEqualTo(admin.getaPhone());
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        Admin admin1 = null;
        if (admins.size() == 1) {
            admin1 = admins.get(0);
        }
        if (admin1 != null) {
            if (admin.getaPassword().equals(admin1.getaPassword())) {
                //验证通过
                return admin1;
            }
        }
            //密码错误，手机号不存在
            return null;
    }


    /**
     * 当前科室导诊关联科室id（每个科室管理员只能安排当前科室的排号）
     * 通过科室id，手机号和当前日期查询预约单是否有此人，
     * 如果存在，放入队列中
     *
     * @param phone
     * @return
     */
    public boolean arrangeQueue(String phone, Admin admin) throws Exception {
        // 当前日期
        String date = MyUtil.changeDate(new Date());
        //获取管理员所管理科室
        RoomExample roomExample = new RoomExample();
        RoomExample.Criteria criteria = roomExample.createCriteria();
        criteria.andAIdEqualTo(admin.getaId());
        List<Room> rooms = roomMapper.selectByExample(roomExample);
        Room room=rooms.get(0);

        MyArrange myArrange = myNumAdminMapper.findOrderByPhoneDate(new MyArrangeMessage(date, phone, room.getrId()));
        //查询是否当日有此人预约此科室,
        if(myArrange != null ){
            Boolean aBoolean = myArrange.getPatientOrder().getoGo();
            //是否已经排过号
            if (!aBoolean) {
                //将预约单的排号状态改为true
                PatientOrder patientOrder = patientOrderMapper.selectByPrimaryKey(myArrange.getPatientOrder().getoId());
                patientOrder.setoGo(true);
                //updateByPrimaryKey将pojo的所有属性更新，包括空的属性

                //插入诊治医疗单,需要病人id，医生id，
                Treat treat=new Treat();
                treat.setpId(myArrange.getPatient().getpId());
                treat.setdId(myArrange.getDoctor().getdId());
                treat.settPay(false);
                //插入一条treat，并将主键放入treat中
                myNumAdminMapper.myInsert(treat);
                System.out.println(treat.gettId());
                //插入tid到patientOrder中

                patientOrder.settId(treat.gettId());
                patientOrderMapper.updateByPrimaryKey(patientOrder);
                //将更新后的patientOrder的tid放入myArrange中
                myArrange.setPatientOrder(patientOrder);
                //获取管理员所管理的科室
                //将myArrange将入排号队列
                MyNumMap.insertPatient(room.getrName(), myArrange);
                //排号成功
                return true;
            }
            //此预约已经排过号
            return false;
        }
        //无此人预约，今日，此科室，无此人，预约
        return false;



    }

    /**
     * 科室管理员和导诊登录后都会查询他们管理对应科室，其中科室和管理员都是1v1
     * @param aId
     * @return
     */
    public Room findRoomByAId(int aId){
        //根据aId获取科室
        RoomExample roomExample=new RoomExample();
        RoomExample.Criteria criteria = roomExample.createCriteria();
        criteria.andAIdEqualTo(aId);
        List<Room> rooms = roomMapper.selectByExample(roomExample);
        return rooms.get(0);
    }

    /**
     * 生序排列显示药品信息
     * @return
     * @throws Exception
     */
    public List<Medicine> findMedicineByAsc() throws Exception {
        return myNumAdminMapper.findMedicineByAsc();
    }


    /**
     * 拿到近七天的日期字符串
     * @return
     */
    public List<String> getSevenDate(){
        List<String> dates=new ArrayList<>();
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Calendar now = Calendar.getInstance();
        for(int i=0;i<7;i++){
            dates.add(simpleDateFormat.format( now.getTime()));
            int day = now.get(Calendar.DAY_OF_YEAR);
            now.set(Calendar.DAY_OF_YEAR,day+1);
        }
    return dates;

    }

    public List<MyDoctorOut> getDoctorByDate(MyRoomDate myRoomDate) throws Exception {
      return   myRoomAdminMapper.findItemDoctor(myRoomDate);
    }
}
