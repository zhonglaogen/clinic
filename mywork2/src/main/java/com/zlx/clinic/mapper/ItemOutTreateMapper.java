package com.zlx.clinic.mapper;

import com.zlx.clinic.entity.ItemOutTreate;
import com.zlx.clinic.entity.ItemOutTreateExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemOutTreateMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_out_treate
     *
     * @mbggenerated Fri Jun 28 08:40:04 CST 2019
     */
    int countByExample(ItemOutTreateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_out_treate
     *
     * @mbggenerated Fri Jun 28 08:40:04 CST 2019
     */
    int deleteByExample(ItemOutTreateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_out_treate
     *
     * @mbggenerated Fri Jun 28 08:40:04 CST 2019
     */
    int deleteByPrimaryKey(Integer iId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_out_treate
     *
     * @mbggenerated Fri Jun 28 08:40:04 CST 2019
     */
    int insert(ItemOutTreate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_out_treate
     *
     * @mbggenerated Fri Jun 28 08:40:04 CST 2019
     */
    int insertSelective(ItemOutTreate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_out_treate
     *
     * @mbggenerated Fri Jun 28 08:40:04 CST 2019
     */
    List<ItemOutTreate> selectByExample(ItemOutTreateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_out_treate
     *
     * @mbggenerated Fri Jun 28 08:40:04 CST 2019
     */
    ItemOutTreate selectByPrimaryKey(Integer iId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_out_treate
     *
     * @mbggenerated Fri Jun 28 08:40:04 CST 2019
     */
    int updateByExampleSelective(@Param("record") ItemOutTreate record, @Param("example") ItemOutTreateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_out_treate
     *
     * @mbggenerated Fri Jun 28 08:40:04 CST 2019
     */
    int updateByExample(@Param("record") ItemOutTreate record, @Param("example") ItemOutTreateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_out_treate
     *
     * @mbggenerated Fri Jun 28 08:40:04 CST 2019
     */
    int updateByPrimaryKeySelective(ItemOutTreate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_out_treate
     *
     * @mbggenerated Fri Jun 28 08:40:04 CST 2019
     */
    int updateByPrimaryKey(ItemOutTreate record);
}