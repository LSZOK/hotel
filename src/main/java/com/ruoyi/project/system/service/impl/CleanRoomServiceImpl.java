package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.CleanRoomMapper;
import com.ruoyi.project.system.domain.CleanRoom;
import com.ruoyi.project.system.service.ICleanRoomService;

/**
 * 清洁房间信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-10-22
 */
@Service
public class CleanRoomServiceImpl implements ICleanRoomService 
{
    @Autowired
    private CleanRoomMapper cleanRoomMapper;

    /**
     * 查询清洁房间信息
     * 
     * @param cleanRoomId 清洁房间信息ID
     * @return 清洁房间信息
     */
    @Override
    public CleanRoom selectCleanRoomById(String cleanRoomId)
    {
        return cleanRoomMapper.selectCleanRoomById(cleanRoomId);
    }

    /**
     * 查询清洁房间信息列表
     * 
     * @param cleanRoom 清洁房间信息
     * @return 清洁房间信息
     */
    @Override
    public List<CleanRoom> selectCleanRoomList(CleanRoom cleanRoom)
    {
        return cleanRoomMapper.selectCleanRoomList(cleanRoom);
    }

    /**
     * 新增清洁房间信息
     * 
     * @param cleanRoom 清洁房间信息
     * @return 结果
     */
    @Override
    public int insertCleanRoom(CleanRoom cleanRoom)
    {
        return cleanRoomMapper.insertCleanRoom(cleanRoom);
    }

    /**
     * 修改清洁房间信息
     * 
     * @param cleanRoom 清洁房间信息
     * @return 结果
     */
    @Override
    public int updateCleanRoom(CleanRoom cleanRoom)
    {
        return cleanRoomMapper.updateCleanRoom(cleanRoom);
    }

    /**
     * 批量删除清洁房间信息
     * 
     * @param cleanRoomIds 需要删除的清洁房间信息ID
     * @return 结果
     */
    @Override
    public int deleteCleanRoomByIds(String[] cleanRoomIds)
    {
        return cleanRoomMapper.deleteCleanRoomByIds(cleanRoomIds);
    }

    /**
     * 删除清洁房间信息信息
     * 
     * @param cleanRoomId 清洁房间信息ID
     * @return 结果
     */
    @Override
    public int deleteCleanRoomById(String cleanRoomId)
    {
        return cleanRoomMapper.deleteCleanRoomById(cleanRoomId);
    }
}
