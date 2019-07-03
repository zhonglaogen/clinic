package com.zlx.clinic.service;

import com.zlx.clinic.entity.*;
import com.zlx.clinic.mapper.*;
import com.zlx.clinic.myentity.MyDoctorOut;
import com.zlx.clinic.myentity.MyOrder;
import com.zlx.clinic.mymapper.MyPatientFindMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
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
     * @param patient
     * @return
     */
    public boolean patientLogin(Patient patient)throws Exception{
        PatientExample patientExample=new PatientExample();
        PatientExample.Criteria criteria=patientExample.createCriteria();
        criteria.andPPhoneEqualTo(patient.getpPhone());
        List<Patient> patients = patientMapper.selectByExample(patientExample);
        Patient patient1 = patients.get(0);
        //查询手机号是否存在
        if(patient1!=null){
            if (patient.getpPassword().equals(patient1.getpPassword())){
                return true;
            }
            //password not exist
            return false;
        }
        //phone not exist
        return false;
    }

    /**
     * 查询该用户所有信息
     * @param phone
     * @return
     */
    public Patient findByPhone(String phone)throws Exception{
        PatientExample patientExample=new PatientExample();
        PatientExample.Criteria criteria=patientExample.createCriteria();
        criteria.andPPhoneEqualTo(phone);
        List<Patient> patients = patientMapper.selectByExample(patientExample);
        return patients.get(0);

    }

    /**
     *
     * @param rId 根据roomid查询近七日所有该科室的出诊医师
     * @return
     */
    public List<MyDoctorOut> findDoctorByRID(int rId)throws Exception{
        List<MyDoctorOut> doctors = myPatientFindMapper.findDoctorByRId(rId);
        return doctors;
    }


    /**
     * 申请
     * @param  ，包含病人id，医生id
     * @return
     */
    public  boolean patientApply(MyOrder myOrder)throws Exception{
        //查出当前iId的医生剩余名额信息
        MyDoctorOut myDoctorOut = myPatientFindMapper.findCountByDidDate(myOrder.getiId());
        PatientOrderExample patientOrderExample=new PatientOrderExample();
        PatientOrderExample.Criteria criteria=patientOrderExample.createCriteria();
        criteria.andIIdEqualTo(myOrder.getiId());
        //检查是否是黑名单成员
        //检查是否已经预约过
        List<PatientOrder> patientOrders = patientOrderMapper.selectByExample(patientOrderExample);
        if(patientOrders.size()==0){
            ItemOutTreate itemOutTreate = myDoctorOut.getItemOutTreate();
            //预约数目>0， 可以预约
            if(itemOutTreate.getdCount()>0){
                //减少可预约约人数
                int count=itemOutTreate.getdCount();
                itemOutTreate.setdCount(--count);
                itemOutTreateMapper.updateByPrimaryKey(itemOutTreate);
                //增加预约申请记录
                PatientOrder o1=new PatientOrder();
                o1.setpId(myOrder.getUserID());
                o1.setiId(itemOutTreate.getiId());
                o1.setoDate(new Date());
                o1.setoGo(true);
                orderMapper.insert(o1);
                return true;
            }else {
                //预约人数以满
                return false;
            }
        }
        //已经预约过
        return false;

    }

    /**
     * 查询该用户的所有预约单
     * @param
     * @return
     */
    public List<MyDoctorOut> findOrderByPID(int pId)throws Exception{
        List<MyDoctorOut> orderByPid = myPatientFindMapper.findOrderByPid(pId);

        return orderByPid;
    }


    /**
     * 取消oId订单
     * @param
     * @return
     * @throws Exception
     */
    public boolean deleteOrder(PatientOrder patientOrder)throws Exception{
        patientOrder= orderMapper.selectByPrimaryKey(patientOrder.getoId());
        //检查是否超过一天
        Date date = patientOrder.getoDate();
        //当前日期
        Date date1=new Date();
        long time = date.getTime();
        long time1 = date1.getTime();
        if((time1-time)/(60*60*1000)>24){
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

