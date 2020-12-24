package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.RoomPicturesMapper;
import com.ruoyi.project.system.domain.RoomPictures;
import com.ruoyi.project.system.service.IRoomPicturesService;

/**
 * 房间图片Service业务层处理
 * 
 * @author lusenzhu
 * @date 2020-11-18
 */
@Service
public class RoomPicturesServiceImpl implements IRoomPicturesService 
{
    @Autowired
    private RoomPicturesMapper roomPicturesMapper;

    /**
     * 查询房间图片
     * 
     * @param id 房间图片ID
     * @return 房间图片
     */
    @Override
    public RoomPictures selectRoomPicturesById(Long id)
    {
        return roomPicturesMapper.selectRoomPicturesById(id);
    }

    /**
     * 查询房间图片列表
     * 
     * @param roomPictures 房间图片
     * @return 房间图片
     */
    @Override
    public List<RoomPictures> selectRoomPicturesList(RoomPictures roomPictures)
    {
        return roomPicturesMapper.selectRoomPicturesList(roomPictures);
    }

    /**
     * 新增房间图片
     * 
     * @param roomPictures 房间图片
     * @return 结果
     */
    @Override
    public int insertRoomPictures(RoomPictures roomPictures)
    {
        return roomPicturesMapper.insertRoomPictures(roomPictures);
    }

    /**
     * 修改房间图片
     * 
     * @param roomPictures 房间图片
     * @return 结果
     */
    @Override
    public int updateRoomPictures(RoomPictures roomPictures)
    {
        return roomPicturesMapper.updateRoomPictures(roomPictures);
    }

    /**
     * 批量删除房间图片
     * 
     * @param ids 需要删除的房间图片ID
     * @return 结果
     */
    @Override
    public int deleteRoomPicturesByIds(Long[] ids)
    {
        return roomPicturesMapper.deleteRoomPicturesByIds(ids);
    }

    /**
     * 删除房间图片信息
     * 
     * @param id 房间图片ID
     * @return 结果
     */
    @Override
    public int deleteRoomPicturesById(Long id)
    {
        return roomPicturesMapper.deleteRoomPicturesById(id);
    }
}
