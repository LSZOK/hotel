package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.RoomInfo;
import com.ruoyi.project.system.domain.RoomType;

/**
 * 客房信息Service接口
 * 
 * @author lusenzhu
 * @date 2020-10-13
 */
public interface IRoomInfoService 
{
    /**
     * 查询客房信息
     * 
     * @param roomId 客房信息ID
     * @return 客房信息
     */
    public RoomInfo selectRoomInfoById(Long roomId);

    /**
     * 查询客房信息列表
     * 
     * @param roomInfo 客房信息
     * @return 客房信息集合
     */
    public List<RoomInfo> selectRoomInfoList(RoomInfo roomInfo);


    /*
    * 查询客房类型
    * */
    public List<RoomType> selectRoomType();
    /**
     * 新增客房信息
     * 
     * @param roomInfo 客房信息
     * @return 结果
     */
    public int insertRoomInfo(RoomInfo roomInfo);

    /**
     * 修改客房信息
     * 
     * @param roomInfo 客房信息
     * @return 结果
     */
    public int updateRoomInfo(RoomInfo roomInfo);

    /**
     * 批量删除客房信息
     * 
     * @param roomIds 需要删除的客房信息ID
     * @return 结果
     */
    public int deleteRoomInfoByIds(Long[] roomIds);

    /**
     * 删除客房信息信息
     * 
     * @param roomId 客房信息ID
     * @return 结果
     */
    public int deleteRoomInfoById(Long roomId);

    List selectMaxRoomNum(String floor);
}
