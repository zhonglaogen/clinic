package com.zlx.clinic.myentity;

import java.util.Date;

/** 包装前台数据，用来生成预约单
 * 主要用来包装申请预约的信息
 *
 * 要拿到预约的date，拿到科室的id，拿到病人的id，查询同日同科室的预约
 */
public class MyOrder {
    private Integer pId;

    //没啥用
    private Integer dId;


    private Integer  iId;

    //没啥用
    private Integer rId;
    //预约当日的date
    private Date iDate;

    public Date getiDate() {
        return iDate;
    }

    public void setiDate(Date iDate) {
        this.iDate = iDate;
    }


    public MyOrder(Integer pId, Integer dId, Integer rId) {
        this.pId = pId;
        this.dId = dId;
        this.rId = rId;
    }

    public MyOrder(){}

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public Integer getiId() {
        return iId;
    }

    public void setiId(Integer iId) {
        this.iId = iId;
    }
}
