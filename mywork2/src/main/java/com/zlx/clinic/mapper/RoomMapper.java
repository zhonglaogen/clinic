package com.zlx.clinic.mapper;

import com.zlx.clinic.entity.Room;
import com.zlx.clinic.entity.RoomExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table room
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    int countByExample(RoomExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table room
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    int deleteByExample(RoomExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table room
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    int deleteByPrimaryKey(Integer rId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table room
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    int insert(Room record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table room
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    int insertSelective(Room record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table room
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    List<Room> selectByExample(RoomExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table room
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    Room selectByPrimaryKey(Integer rId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table room
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    int updateByExampleSelective(@Param("record") Room record, @Param("example") RoomExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table room
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    int updateByExample(@Param("record") Room record, @Param("example") RoomExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table room
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    int updateByPrimaryKeySelective(Room record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table room
     *
     * @mbggenerated Wed Jun 26 08:33:50 CST 2019
     */
    int updateByPrimaryKey(Room record);
}