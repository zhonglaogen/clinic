package com.zlx.clinic.mymapper;

import com.zlx.clinic.entity.ItemOutTreate;
import com.zlx.clinic.myentity.MyDoctorOut;


import java.util.List;

public interface MyPatientFindMapper {

    /**
     * 根据科室查询近七日医生
     * @param rid
     * @return
     */
    public List<MyDoctorOut> findDoctorByRId(int rid)throws Exception;

    /**
     * 根据日期查询是否还有剩余名额
     * @param i_id
     * @return
     */
    public MyDoctorOut findCountByDidDate(int iId)throws Exception;

    /**
     * 查询预约单
     * @param pId
     * @return
     */
    public List<MyDoctorOut> findOrderByPid(int pId)throws Exception;
}
