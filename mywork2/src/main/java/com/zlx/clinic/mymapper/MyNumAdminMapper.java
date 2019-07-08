package com.zlx.clinic.mymapper;

import com.zlx.clinic.entity.Medicine;
import com.zlx.clinic.entity.Treat;
import com.zlx.clinic.myentity.MyArrange;
import com.zlx.clinic.myentity.MyArrangeMessage;

import java.util.List;

/**
 * 前台导诊
 */
public interface MyNumAdminMapper {


    /**
     * 查找此手机号在今日当前此科室是否有预约
     * @param phone 病人手机号
     * @param date 当前日期
     * @return
     * @throws Exception
     */
    public MyArrange findOrderByPhoneDate(MyArrangeMessage myArrangeMessage) throws Exception;

    /**
     * 返回自增的主键
     * @param treat
     * @return
     */
    public Integer myInsert(Treat treat)throws Exception;

    /**
     * 生序查看药品
     * @return
     * @throws Exception
     */
    public List<Medicine> findMedicineByAsc()throws Exception;
}
