package com.zlx.clinic.mymapper;

import com.zlx.clinic.entity.Doctor;
import com.zlx.clinic.myentity.MyDoctorOut;
import com.zlx.clinic.myentity.MyRoomDate;

import java.util.Date;
import java.util.List;

/**
 * 科室管理员
 */
public interface MyRoomAdminMapper {
    /**
     * 查找该日期所有出诊的医生
     * @throws Exception
     */
    public List<MyDoctorOut> findItemDoctor(MyRoomDate myRoomDate)throws  Exception;

    /** 查找该日期所有未出诊的医生
     *
     * @param myRoomDate
     * @return
     * @throws Exception
     */
    public List<Doctor> findDcotorByNoOut(MyRoomDate myRoomDate)throws Exception;

}
