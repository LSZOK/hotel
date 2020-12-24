package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.RoomType;

/**
 * 房间类型Mapper接口
 * 
 * @author lusenzhu
 * @date 2020-10-12
 */
public interface RoomTypeMapper 
{
    /**
     * 查询房间类型
     * 
     * @param id 房间类型ID
     * @return 房间类型
     */
    public RoomType selectRoomTypeById(Long id);

    /**
     * 查询房间类型列表
     * 
     * @param roomType 房间类型
     * @return 房间类型集合
     */
    public List<RoomType> selectRoomTypeList(RoomType roomType);

    /**
     * 新增房间类型
     * 
     * @param roomType 房间类型
     * @return 结果
     */
    public int insertRoomType(RoomType roomType);

    /**
     * 修改房间类型
     * 
     * @param roomType 房间类型
     * @return 结果
     */
    public int updateRoomType(RoomType roomType);

    /**
     * 删除房间类型
     * 
     * @param id 房间类型ID
     * @return 结果
     */
    public int deleteRoomTypeById(Long id);

    /**
     * 批量删除房间类型
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRoomTypeByIds(Long[] ids);
}
