package com.zlx.clinic.entity;

public class Medicine {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column medicine.m_id
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    private Integer mId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column medicine.m_name
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    private String mName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column medicine.m_count
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    private Integer mCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column medicine.m_price
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    private Integer mPrice;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column medicine.m_id
     *
     * @return the value of medicine.m_id
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    public Integer getmId() {
        return mId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column medicine.m_id
     *
     * @param mId the value for medicine.m_id
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    public void setmId(Integer mId) {
        this.mId = mId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column medicine.m_name
     *
     * @return the value of medicine.m_name
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    public String getmName() {
        return mName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column medicine.m_name
     *
     * @param mName the value for medicine.m_name
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    public void setmName(String mName) {
        this.mName = mName == null ? null : mName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column medicine.m_count
     *
     * @return the value of medicine.m_count
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    public Integer getmCount() {
        return mCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column medicine.m_count
     *
     * @param mCount the value for medicine.m_count
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    public void setmCount(Integer mCount) {
        this.mCount = mCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column medicine.m_price
     *
     * @return the value of medicine.m_price
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    public Integer getmPrice() {
        return mPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column medicine.m_price
     *
     * @param mPrice the value for medicine.m_price
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    public void setmPrice(Integer mPrice) {
        this.mPrice = mPrice;
    }
}