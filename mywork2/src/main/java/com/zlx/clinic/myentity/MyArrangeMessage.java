package com.zlx.clinic.myentity;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Date;

/** 前台导诊输入映射
 * 排号时传入给Mapper手机号和当天时间，
 */
public class MyArrangeMessage {
    private String iDate;
    private String pPhone;
    private Integer rId;

    public MyArrangeMessage() {
    }

    public MyArrangeMessage(String iDate, String pPhone, Integer rId) {
        this.iDate = iDate;
        this.pPhone = pPhone;
        this.rId = rId;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getiDate() {
        return iDate;
    }

    public void setiDate(String iDate) {
        this.iDate = iDate;
    }

    public String getpPhone() {
        return pPhone;
    }

    public void setpPhone(String pPhone) {
        this.pPhone = pPhone;
    }
}
