package com.zlx.clinic.entity;

import java.util.Date;

public class Treat {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column treat.t_id
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    private Integer tId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column treat.p_id
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    private Integer pId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column treat.d_id
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    private Integer dId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column treat.t_result
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    private String tResult;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column treat.t_type
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    private Byte tType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column treat.t_bed
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    private Boolean tBed;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column treat.t_date
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    private Date tDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column treat.t_total_price
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    private Integer tTotalPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column treat.t_pay
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    private Boolean tPay;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column treat.t_id
     *
     * @return the value of treat.t_id
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    public Integer gettId() {
        return tId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column treat.t_id
     *
     * @param tId the value for treat.t_id
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    public void settId(Integer tId) {
        this.tId = tId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column treat.p_id
     *
     * @return the value of treat.p_id
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    public Integer getpId() {
        return pId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column treat.p_id
     *
     * @param pId the value for treat.p_id
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    public void setpId(Integer pId) {
        this.pId = pId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column treat.d_id
     *
     * @return the value of treat.d_id
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    public Integer getdId() {
        return dId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column treat.d_id
     *
     * @param dId the value for treat.d_id
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    public void setdId(Integer dId) {
        this.dId = dId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column treat.t_result
     *
     * @return the value of treat.t_result
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    public String gettResult() {
        return tResult;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column treat.t_result
     *
     * @param tResult the value for treat.t_result
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    public void settResult(String tResult) {
        this.tResult = tResult == null ? null : tResult.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column treat.t_type
     *
     * @return the value of treat.t_type
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    public Byte gettType() {
        return tType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column treat.t_type
     *
     * @param tType the value for treat.t_type
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    public void settType(Byte tType) {
        this.tType = tType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column treat.t_bed
     *
     * @return the value of treat.t_bed
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    public Boolean gettBed() {
        return tBed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column treat.t_bed
     *
     * @param tBed the value for treat.t_bed
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    public void settBed(Boolean tBed) {
        this.tBed = tBed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column treat.t_date
     *
     * @return the value of treat.t_date
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    public Date gettDate() {
        return tDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column treat.t_date
     *
     * @param tDate the value for treat.t_date
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    public void settDate(Date tDate) {
        this.tDate = tDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column treat.t_total_price
     *
     * @return the value of treat.t_total_price
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    public Integer gettTotalPrice() {
        return tTotalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column treat.t_total_price
     *
     * @param tTotalPrice the value for treat.t_total_price
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    public void settTotalPrice(Integer tTotalPrice) {
        this.tTotalPrice = tTotalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column treat.t_pay
     *
     * @return the value of treat.t_pay
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    public Boolean gettPay() {
        return tPay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column treat.t_pay
     *
     * @param tPay the value for treat.t_pay
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    public void settPay(Boolean tPay) {
        this.tPay = tPay;
    }
}