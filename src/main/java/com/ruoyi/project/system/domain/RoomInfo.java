package com.ruoyi.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.TreeEntity;

/**
 * 客房信息对象 room_info
 * 
 * @author lusenzhu
 * @date 2020-10-13
 */
public class RoomInfo extends TreeEntity
{
    private static final long serialVersionUID = 1L;


   private Long parentId;

    private Long roomId;

    /** 房号 */
    @Excel(name = "房号")
    private Long roomNum;

    /** 楼层 */
    @Excel(name = "楼层")
    private String floor;

    /** 价格 */
    @Excel(name = "价格")
    private Long price;

    /** 房间类型 */
    @Excel(name = "房间类型")
    private Long roomType;

    /** 床型 */
    @Excel(name = "床型")
    private String bedType;

    /** 是否有窗 */
    @Excel(name = "是否有窗")
    private Integer havewindow;

    /** 建筑面积 */
    @Excel(name = "建筑面积")
    private String roomArea;

    /** 房间照 */
    @Excel(name = "房间照")
    private String roomPicture;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 房间简介 */
    @Excel(name = "房间简介")
    private String roomIntroduce;

    /** 添加时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date addtime;

    public void setRoomId(Long roomId) 
    {
        this.roomId = roomId;
    }

    public Long getRoomId() 
    {
        return roomId;
    }
    public void setRoomNum(Long roomNum) 
    {
        this.roomNum = roomNum;
    }

    public Long getRoomNum() 
    {
        return roomNum;
    }
    public void setFloor(String  floor)
    {
        this.floor = floor;
    }

    public String getFloor()
    {
        return floor;
    }
    public void setPrice(Long price) 
    {
        this.price = price;
    }

    public Long getPrice() 
    {
        return price;
    }
    public void setRoomType(Long roomType) 
    {
        this.roomType = roomType;
    }

    public Long getRoomType() 
    {
        return roomType;
    }
    public void setBedType(String bedType) 
    {
        this.bedType = bedType;
    }

    public String getBedType() 
    {
        return bedType;
    }
    public void setHavewindow(Integer havewindow) 
    {
        this.havewindow = havewindow;
    }

    public Integer getHavewindow() 
    {
        return havewindow;
    }
    public void setRoomArea(String roomArea) 
    {
        this.roomArea = roomArea;
    }

    public String getRoomArea() 
    {
        return roomArea;
    }
    public void setRoomPicture(String roomPicture) 
    {
        this.roomPicture = roomPicture;
    }

    public String getRoomPicture() 
    {
        return roomPicture;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setRoomIntroduce(String roomIntroduce) 
    {
        this.roomIntroduce = roomIntroduce;
    }

    public String getRoomIntroduce() 
    {
        return roomIntroduce;
    }
    public void setAddtime(Date addtime) 
    {
        this.addtime = addtime;
    }

    public Date getAddtime() 
    {
        return addtime;
    }

    @Override
    public Long getParentId() {
        return parentId;
    }

    @Override
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("roomId", getRoomId())
            .append("parentId", getParentId())
            .append("roomNum", getRoomNum())
            .append("floor", getFloor())
            .append("price", getPrice())
            .append("roomType", getRoomType())
            .append("bedType", getBedType())
            .append("havewindow", getHavewindow())
            .append("roomArea", getRoomArea())
            .append("roomPicture", getRoomPicture())
            .append("status", getStatus())
            .append("roomIntroduce", getRoomIntroduce())
            .append("addtime", getAddtime())
            .toString();
    }
}
