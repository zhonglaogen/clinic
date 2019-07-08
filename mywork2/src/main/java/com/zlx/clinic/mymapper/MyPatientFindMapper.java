package com.zlx.clinic.mymapper;

import com.zlx.clinic.entity.ItemOutTreate;
import com.zlx.clinic.myentity.MyArrangeMessage;
import com.zlx.clinic.myentity.MyDoctorOut;
import com.zlx.clinic.myentity.MyOrder;


import java.util.Date;
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
     * 查询有效预约单
     * @param pId
     * @return
     */
    public List<MyDoctorOut> findValidOrderByPid(int pId)throws Exception;


    /**
     * 查无效预约
     * @param pId
     * @return
     * @throws Exception
     */
    public List<MyDoctorOut> findInvalidOrderByPid(int pId)throws Exception;


    //检查是否是黑名单过期订单是否超过七天成员 top
    public Integer findOldSevenOrder(int pId)throws Exception;


    //检查今日预约次数
    public Integer findOrderCount(int pId)throws Exception;



    //检查是否已经预约过同一天同一个科室(doctor:rid,item_out_treat:i_date,patient_order:p_id)
    /**
     * 根据科室id查询该用户当日已预约当前科室的次数
     * @param rId
     * @return
     * @throws Exception
     */
    public Integer findOrderCountByRoomId(MyOrder myOrder)throws Exception;


//    拿到预约的date，拿到科室的id，
    public MyOrder findDateRidByIid(int iId)throws Exception;
}
