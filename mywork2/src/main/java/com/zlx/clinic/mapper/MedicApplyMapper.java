package com.zlx.clinic.mapper;

import com.zlx.clinic.entity.MedicApply;
import com.zlx.clinic.entity.MedicApplyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MedicApplyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medic_apply
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    int countByExample(MedicApplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medic_apply
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    int deleteByExample(MedicApplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medic_apply
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    int deleteByPrimaryKey(Integer maId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medic_apply
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    int insert(MedicApply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medic_apply
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    int insertSelective(MedicApply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medic_apply
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    List<MedicApply> selectByExample(MedicApplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medic_apply
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    MedicApply selectByPrimaryKey(Integer maId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medic_apply
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    int updateByExampleSelective(@Param("record") MedicApply record, @Param("example") MedicApplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medic_apply
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    int updateByExample(@Param("record") MedicApply record, @Param("example") MedicApplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medic_apply
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    int updateByPrimaryKeySelective(MedicApply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medic_apply
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    int updateByPrimaryKey(MedicApply record);
}