package com.ruoyi.project.system.service.impl;

import java.util.List;

import com.ruoyi.project.system.domain.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.RoomInfoMapper;
import com.ruoyi.project.system.domain.RoomInfo;
import com.ruoyi.project.system.service.IRoomInfoService;

/**
 * 客房信息Service业务层处理
 * 
 * @author lusenzhu
 * @date 2020-10-13
 */
@Service
public class RoomInfoServiceImpl implements IRoomInfoService 
{
    @Autowired
    private RoomInfoMapper roomInfoMapper;

    /**
     * 查询客房信息
     * 
     * @param roomId 客房信息ID
     * @return 客房信息
     */
    @Override
    public RoomInfo selectRoomInfoById(Long roomId)
    {
        return roomInfoMapper.selectRoomInfoById(roomId);
    }

    /**
     * 查询客房信息列表
     * 
     * @param roomInfo 客房信息
     * @return 客房信息
     */
    @Override
    public List<RoomInfo> selectRoomInfoList(RoomInfo roomInfo)
    {
        return roomInfoMapper.selectRoomInfoList(roomInfo);
    }

    @Override
    public List<RoomType> selectRoomType() {
        return roomInfoMapper.selectRoomType();
    }

    /**
     * 新增客房信息
     * 
     * @param roomInfo 客房信息
     * @return 结果
     */
    @Override
    public int insertRoomInfo(RoomInfo roomInfo)
    {
        return roomInfoMapper.insertRoomInfo(roomInfo);
    }

    /**
     * 修改客房信息
     * 
     * @param roomInfo 客房信息
     * @return 结果
     */
    @Override
    public int updateRoomInfo(RoomInfo roomInfo)
    {
        return roomInfoMapper.updateRoomInfo(roomInfo);
    }

    /**
     * 批量删除客房信息
     * 
     * @param roomIds 需要删除的客房信息ID
     * @return 结果
     */
    @Override
    public int deleteRoomInfoByIds(Long[] roomIds)
    {
        return roomInfoMapper.deleteRoomInfoByIds(roomIds);
    }

    /**
     * 删除客房信息信息
     * 
     * @param roomId 客房信息ID
     * @return 结果
     */
    @Override
    public int deleteRoomInfoById(Long roomId)
    {
        return roomInfoMapper.deleteRoomInfoById(roomId);
    }

    @Override
    public List selectMaxRoomNum(String floor) {
        return roomInfoMapper.selectMaxRoomNum(floor);
    }
}
