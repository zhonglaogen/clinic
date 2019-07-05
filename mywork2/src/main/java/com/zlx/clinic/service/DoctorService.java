package com.zlx.clinic.service;

import com.zlx.clinic.entity.Doctor;
import com.zlx.clinic.entity.DoctorExample;
import com.zlx.clinic.entity.Room;
import com.zlx.clinic.entity.Treat;
import com.zlx.clinic.mapper.DoctorMapper;
import com.zlx.clinic.mapper.RoomMapper;
import com.zlx.clinic.mapper.TreatMapper;
import com.zlx.clinic.myentity.MyArrange;
import com.zlx.clinic.util.mydata.MyNumMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
public class DoctorService {

    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private TreatMapper treatMapper;

    /**
     * 登录
     * @param doctor
     * @return
     */
    public Doctor doctorLogin(Doctor doctor){
        DoctorExample doctorExample=new DoctorExample();
        DoctorExample.Criteria criteria = doctorExample.createCriteria();
        criteria.andDPhoneEqualTo(doctor.getdPhone());
        List<Doctor> doctors = doctorMapper.selectByExample(doctorExample);
        Doctor doctor1=null;
        if(doctors.size()!=0){
            //账号有效
            doctor1=doctors.get(0);
        }
        if(doctor1!=null){
            //密码有效
            if(doctor1.getdPassword().equals(doctor.getdPassword())){
                //验证通过
                return doctor1;
            }
        }
        //账号或密码有错
        return null;
    }

    private Room getRoom(Doctor doctor){
        return roomMapper.selectByPrimaryKey(doctor.getrId());
    }

    /**
     * 叫号
     * @param doctor
     * @return
     */
    public MyArrange callNum(Doctor doctor){
        Room room = getRoom(doctor);
        String dId = doctor.getdId().toString();
        MyArrange myArrange = MyNumMap.callNum(room.getrName(),dId);
        return myArrange;
    }

    /**
     * 叫号三次没来，加入队列尾部
     * @param doctor
     */
    public void nextNum(Doctor doctor){
        Room room = getRoom(doctor);
        String dId = doctor.getdId().toString();
        MyNumMap.nextNum(room.getrName(),dId);
    }

    /**
     * 拿到就诊单
     * @param myArrange
     */
    public Treat getTreat(MyArrange myArrange){
        Integer tid = myArrange.getPatientOrder().gettId();
        Treat treat = treatMapper.selectByPrimaryKey(tid);
        return treat;

    }

    /**
     * 将诊治单添置数据库，将此人从排号队列移除
     * @param treat
     */
    public void postTreat(Treat treat,Doctor doctor){
        treatMapper.updateByPrimaryKeySelective(treat);
        if (treat.gettType()!=0){
            //通知药房管理员查看诊单(0,1代表有没有付款)
        }
        //将排号从队列中移除
        Room room = getRoom(doctor);
        String dId = doctor.getdId().toString();
        MyNumMap.removeNum(room.getrName(),dId);

    }

}
