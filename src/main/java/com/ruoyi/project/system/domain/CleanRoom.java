package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 清洁房间信息对象 clean_room
 * 
 * @author ruoyi
 * @date 2020-10-22
 */
public class CleanRoom extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 清洁房间编号 */
    private String cleanRoomId;

    /** 酒店订单号 */
    @Excel(name = "酒店订单号")
    private String orderId;

    /** 房间编号 */
    @Excel(name = "房间编号")
    private String roomCode;

    /** 房号 */
    @Excel(name = "房号")
    private Long roomNum;

    /** 入住人 */
    @Excel(name = "入住人")
    private String user;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 添加时间 */
    @Excel(name = "添加时间")
    private String addTime;
    private String bookCleanTime;

    public void setCleanRoomId(String cleanRoomId) 
    {
        this.cleanRoomId = cleanRoomId;
    }

    public String getCleanRoomId() 
    {
        return cleanRoomId;
    }
    public void setOrderId(String orderId) 
    {
        this.orderId = orderId;
    }

    public String getOrderId() 
    {
        return orderId;
    }
    public void setRoomCode(String roomCode) 
    {
        this.roomCode = roomCode;
    }

    public String getRoomCode() 
    {
        return roomCode;
    }
    public void setRoomNum(Long roomNum) 
    {
        this.roomNum = roomNum;
    }

    public Long getRoomNum() 
    {
        return roomNum;
    }
    public void setUser(String user) 
    {
        this.user = user;
    }

    public String getUser() 
    {
        return user;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setAddTime(String addTime) 
    {
        this.addTime = addTime;
    }

    public String getAddTime() 
    {
        return addTime;
    }

    public String getBookCleanTime() {
        return bookCleanTime;
    }

    public void setBookCleanTime(String bookCleanTime) {
        this.bookCleanTime = bookCleanTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cleanRoomId", getCleanRoomId())
            .append("orderId", getOrderId())
            .append("roomCode", getRoomCode())
            .append("roomNum", getRoomNum())
            .append("user", getUser())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("addTime", getAddTime())
            .append("bookCleanTime",getBookCleanTime())
            .toString();
    }
}
