package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.RoomPictures;

/**
 * 房间图片Service接口
 * 
 * @author lusenzhu
 * @date 2020-11-18
 */
public interface IRoomPicturesService 
{
    /**
     * 查询房间图片
     * 
     * @param id 房间图片ID
     * @return 房间图片
     */
    public RoomPictures selectRoomPicturesById(Long id);

    /**
     * 查询房间图片列表
     * 
     * @param roomPictures 房间图片
     * @return 房间图片集合
     */
    public List<RoomPictures> selectRoomPicturesList(RoomPictures roomPictures);

    /**
     * 新增房间图片
     * 
     * @param roomPictures 房间图片
     * @return 结果
     */
    public int insertRoomPictures(RoomPictures roomPictures);

    /**
     * 修改房间图片
     * 
     * @param roomPictures 房间图片
     * @return 结果
     */
    public int updateRoomPictures(RoomPictures roomPictures);

    /**
     * 批量删除房间图片
     * 
     * @param ids 需要删除的房间图片ID
     * @return 结果
     */
    public int deleteRoomPicturesByIds(Long[] ids);

    /**
     * 删除房间图片信息
     * 
     * @param id 房间图片ID
     * @return 结果
     */
    public int deleteRoomPicturesById(Long id);
}
