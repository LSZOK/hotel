package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 房间图片对象 room_pictures
 * 
 * @author lusenzhu
 * @date 2020-11-18
 */
public class RoomPictures
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 房间类型编号 */
    @Excel(name = "房间类型编号")
    private String roomTypeId;

    /** 照片 */
    @Excel(name = "照片")
    private String pictures;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRoomTypeId(String roomTypeId) 
    {
        this.roomTypeId = roomTypeId;
    }

    public String getRoomTypeId() 
    {
        return roomTypeId;
    }
    public void setPictures(String pictures) 
    {
        this.pictures = pictures;
    }

    public String getPictures() 
    {
        return pictures;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("roomTypeId", getRoomTypeId())
            .append("pictures", getPictures())
            .toString();
    }
}
