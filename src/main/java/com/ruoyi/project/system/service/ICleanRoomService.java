package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.CleanRoom;

/**
 * 清洁房间信息Service接口
 * 
 * @author ruoyi
 * @date 2020-10-22
 */
public interface ICleanRoomService 
{
    /**
     * 查询清洁房间信息
     * 
     * @param cleanRoomId 清洁房间信息ID
     * @return 清洁房间信息
     */
    public CleanRoom selectCleanRoomById(String cleanRoomId);

    /**
     * 查询清洁房间信息列表
     * 
     * @param cleanRoom 清洁房间信息
     * @return 清洁房间信息集合
     */
    public List<CleanRoom> selectCleanRoomList(CleanRoom cleanRoom);

    /**
     * 新增清洁房间信息
     * 
     * @param cleanRoom 清洁房间信息
     * @return 结果
     */
    public int insertCleanRoom(CleanRoom cleanRoom);

    /**
     * 修改清洁房间信息
     * 
     * @param cleanRoom 清洁房间信息
     * @return 结果
     */
    public int updateCleanRoom(CleanRoom cleanRoom);

    /**
     * 批量删除清洁房间信息
     * 
     * @param cleanRoomIds 需要删除的清洁房间信息ID
     * @return 结果
     */
    public int deleteCleanRoomByIds(String[] cleanRoomIds);

    /**
     * 删除清洁房间信息信息
     * 
     * @param cleanRoomId 清洁房间信息ID
     * @return 结果
     */
    public int deleteCleanRoomById(String cleanRoomId);
}
