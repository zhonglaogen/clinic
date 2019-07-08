package com.zlx.clinic.service;

import com.zlx.clinic.entity.*;
import com.zlx.clinic.mapper.*;
import com.zlx.clinic.myentity.MyDoctorOut;
import com.zlx.clinic.myentity.MyOrder;
import com.zlx.clinic.mymapper.MyPatientFindMapper;
import com.zlx.clinic.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Transactional
public class PatientService {
    @Autowired
    private ItemOutTreateMapper itemOutTreateMapper;
    @Autowired
    private PatientOrderMapper orderMapper;
    @Autowired
    private PatientMapper patientMapper;
    @Autowired
    private MyPatientFindMapper myPatientFindMapper;
    @Autowired
    private PatientOrderMapper patientOrderMapper;

    /**
     * 用户登录
     *
     * @param patient
     * @return
     */
    public Patient patientLogin(Patient patient) throws Exception {
        PatientExample patientExample = new PatientExample();
        PatientExample.Criteria criteria = patientExample.createCriteria();
        criteria.andPPhoneEqualTo(patient.getpPhone());
        List<Patient> patients = patientMapper.selectByExample(patientExample);
        Patient patient1 = null;
        //是否查到有此用户，不检查会报错IndexOutOfBoundsException
        if (patients.size() == 1) {
            patient1 = patients.get(0);
        }
        //查询手机号是否存在
        if (patient1 != null) {
            if (patient.getpPassword().equals(patient1.getpPassword())) {
                return patient1;
            }
        }
        //手机号不存在,密码错误
        return null;
    }

    /**
     * @param rId 根据roomid查询近七日所有该科室的出诊医师
     * @return
     */
    public List<MyDoctorOut> findDoctorByRID(int rId) throws Exception {
        List<MyDoctorOut> doctors = myPatientFindMapper.findDoctorByRId(rId);
        return doctors;
    }


    /**
     * 申请
     *
     * @param ，包含病人id，出诊id
     * @return
     */
    public boolean patientApply(MyOrder myOrder) throws Exception {
        //查出当前iId的医生剩余名额信息
        MyDoctorOut myDoctorOut = myPatientFindMapper.findCountByDidDate(myOrder.getiId());

        //同一天约两次，一个科室约一次; （参数：rid）根据订单和医生的科室id查询出预约的次数count

        //1检查是否是黑名单过期订单是否超过七天成员,失效订单未超过七天的条数
        Integer oldSevenOrder = myPatientFindMapper.findOldSevenOrder(myOrder.getpId());

        //2检查今日预约次数
        Integer orderCount = myPatientFindMapper.findOrderCount(myOrder.getpId());


        //3检查是否已经预约过同一天同一个科室(doctor:rid,item_out_treat:i_date,patient_order:p_id)
        //根据iid拿到医生表的科室id和出诊表的日期date
        MyOrder sameDateOrder = myPatientFindMapper.findDateRidByIid(myOrder.getiId());
        //将患者id传入sameDateOrder
        sameDateOrder.setpId(myOrder.getpId());
        //要拿到预约的date，拿到科室的id，拿到病人的id，查询同日同科室的预约
        Integer orderCountByRoomId = myPatientFindMapper.findOrderCountByRoomId(sameDateOrder);

        if (oldSevenOrder == 0 && orderCount < 2 && orderCountByRoomId == 0) {
            ItemOutTreate itemOutTreate = myDoctorOut.getItemOutTreate();
            //预约数目等于0， 可以预约
            if (itemOutTreate.getdCount() > 0) {
                //减少可预约约人数
                int count = itemOutTreate.getdCount();
                itemOutTreate.setdCount(--count);
                itemOutTreateMapper.updateByPrimaryKey(itemOutTreate);
                //增加预约申请记录
                PatientOrder o1 = new PatientOrder();
                o1.setpId(myOrder.getpId());
                o1.setiId(itemOutTreate.getiId());
                o1.setoDate(new Date());
                o1.setoGo(false);
                orderMapper.insert(o1);
                return true;
            } else {
                //预约人数以满
                return false;
            }
        }
        //已经预约过
        return false;

    }

    /**
     * 查询该用户的可用预约单
     *
     * @param
     * @return
     */
    public List<MyDoctorOut> findValidOrderByPid(int pId) throws Exception {
        List<MyDoctorOut> orderByPid = myPatientFindMapper.findValidOrderByPid(pId);

        return orderByPid;
    }

    /**
     * 查询该用户的不可用预约单
     *
     * @param
     * @return
     */
    public List<MyDoctorOut> findInvalidOrderByPid(int pId) throws Exception {
        List<MyDoctorOut> orderByPid = myPatientFindMapper.findInvalidOrderByPid(pId);

        return orderByPid;
    }

    /**
     * 取消oId订单
     *
     * @param
     * @return
     * @throws Exception
     */

    public boolean deleteOrder(PatientOrder patientOrder) throws Exception {
        patientOrder = orderMapper.selectByPrimaryKey(patientOrder.getoId());
        ItemOutTreate itemOutTreate1 = itemOutTreateMapper.selectByPrimaryKey(patientOrder.getiId());
        //检查是否是出诊那天(当前日期＋１＞出诊日期，不能取消)
        Date date = itemOutTreate1.getiDate();
        //当前日期
        Calendar c=Calendar.getInstance();
        c.setTime(new Date());
        int i = c.get(Calendar.DATE);
        c.set(Calendar.DATE,++i);
        Date time = c.getTime();



        if (time.compareTo(date)<0) {
            //查询医生名额信息
            ItemOutTreate itemOutTreate = itemOutTreateMapper.selectByPrimaryKey(patientOrder.getiId());
            Integer count = itemOutTreate.getdCount();
            //名额加一
            itemOutTreate.setdCount(++count);
            itemOutTreateMapper.updateByPrimaryKey(itemOutTreate);
            //删除预约记录
            orderMapper.deleteByPrimaryKey(patientOrder.getoId());

            return true;
        }
        //时间未超过一天（24小时）
        return false;

    }

}

