package com.zlx.clinic.mymapper;

import com.zlx.clinic.dto.*;

import java.util.List;

public interface MyMapper {

    /**
     * 通过医生id查询某医生受理的挂号信息
     * @param example
     * @return
     */
    DoctorTreateInfo slectTreateInfoByDId(OTSelectExample example);

    /**
     * 查询药物销售数据
     * @return
     */
    List<MedicineInfo> selectMedicineInfos();
    /**
     * 查询未来七天内某科室的全部预约信息（不包括今天）
     * @param example
     * @return
     */
    List<OutTreateInfo> selectByRoomId(OTSelectExample example);

    /**
     * 查询未来七天内某医生的全部预约信息（不包括今天）
     * @param example
     * @return
     */
    List<OutTreateInfo> slectByDoctorId(OTSelectExample example);

    /**
     * 通过病人id查询病人的挂号信息
     * @param example
     * @return
     */
    List<DoctorTreateInfo> slectTreateInfoByPId(OTSelectExample example);

    SimplePatientInfo selectSimplePatient(Integer tId);

    /**
     * 查询某患者的预约成功记录
     * @param example
     * @return
     */
    POrderInfo selectByPId(OTSelectExample example);

    /**
     * 查询已缴费的挂号信息
     * @return
     */
    List<DoctorTreateInfo> selectTreateInfoPaied();

    /**
     * 查询某一挂号单的药品信息
     * @param tId
     * @return
     */
    TreateMedicineInfo selectMedInfoByTId(Integer tId);

    /**
     * 查询预约次数
     * @return
     */
    Integer selectTotalOfOrder();

    /**
     *  查询患者人数
     * @return
     */
    Integer selectToatalOfPatient();

    /**
     * 查看治疗历史
     * @return
     */
    List<TreateHistory> selectTreateHistory();
}
