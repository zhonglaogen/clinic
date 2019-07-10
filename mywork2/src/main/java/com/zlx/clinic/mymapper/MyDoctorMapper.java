package com.zlx.clinic.mymapper;

public interface MyDoctorMapper {
    /**
     * 根据医生id查询科室姓名
     * @param dId
     * @return
     * @throws Exception
     */
    public String findrNamebydId(int dId)throws Exception;
}
