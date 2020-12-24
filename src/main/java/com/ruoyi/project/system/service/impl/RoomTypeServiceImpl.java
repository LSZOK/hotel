package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.RoomTypeMapper;
import com.ruoyi.project.system.domain.RoomType;
import com.ruoyi.project.system.service.IRoomTypeService;

/**
 * 房间类型Service业务层处理
 * 
 * @author lusenzhu
 * @date 2020-10-12
 */
@Service
public class RoomTypeServiceImpl implements IRoomTypeService
{
    @Autowired
    private RoomTypeMapper roomTypeMapper;




    /**
     * 查询房间类型
     * 
     * @param id 房间类型ID
     * @return 房间类型
     */
    @Override
    public RoomType selectRoomTypeById(Long id)
    {
        return roomTypeMapper.selectRoomTypeById(id);
    }

    /**
     * 查询房间类型列表
     * 
     * @param roomType 房间类型
     * @return 房间类型
     */
    @Override
    public List<RoomType> selectRoomTypeList(RoomType roomType)
    {
        return roomTypeMapper.selectRoomTypeList(roomType);
    }

    /**
     * 新增房间类型
     * 
     * @param roomType 房间类型
     * @return 结果
     */
    @Override
    public int insertRoomType(RoomType roomType)
    {
        return roomTypeMapper.insertRoomType(roomType);
    }

    /**
     * 修改房间类型
     * 
     * @param roomType 房间类型
     * @return 结果
     */
    @Override
    public int updateRoomType(RoomType roomType)
    {
        return roomTypeMapper.updateRoomType(roomType);
    }

    /**
     * 批量删除房间类型
     * 
     * @param ids 需要删除的房间类型ID
     * @return 结果
     */
    @Override
    public int deleteRoomTypeByIds(Long[] ids)
    {
        return roomTypeMapper.deleteRoomTypeByIds(ids);
    }

    /**
     * 删除房间类型信息
     * 
     * @param id 房间类型ID
     * @return 结果
     */
    @Override
    public int deleteRoomTypeById(Long id)
    {
        return roomTypeMapper.deleteRoomTypeById(id);
    }
}
