package com.ruoyi.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 续住信息对象 hotel_continue
 *
 * @author ruoyi
 * @date 2020-10-21
 */
public class HotelContinue
{
    private static final long serialVersionUID = 1L;

    /** 续住编号 */
    private String continueId;

    /** 酒店预订编号 */
    @Excel(name = "酒店预订编号")
    private String orderId;

    /** 顾客编号 */
    @Excel(name = "顾客编号")
    private String clientId;

    /** 房间编号 */
    @Excel(name = "房间编号")
    private String roomCode;

    /** 价格 */
    @Excel(name = "价格")
    private Long price;

    /** 总计 */
    @Excel(name = "总计")
    private Long total;

    /** 房号 */
    @Excel(name = "房号")
    private Long roomNum;

    /** 房间类型 */
    @Excel(name = "房间类型")
    private Long roomType;

    /** 入住时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "入住时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private String liveTime;

    /** 续住时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "续住时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private String continueTime;

    /** 退房时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "退房时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private String outTime;

    /** 续住人 */
    @Excel(name = "续住人")
    private String continueName;

    /** 添加时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private String addTime;

    /** 经办人 */
    @Excel(name = "经办人")
    private String operator;

    public void setContinueId(String continueId)
    {
        this.continueId = continueId;
    }

    public String getContinueId()
    {
        return continueId;
    }
    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    public String getOrderId()
    {
        return orderId;
    }
    public void setClientId(String clientId)
    {
        this.clientId = clientId;
    }

    public String getClientId()
    {
        return clientId;
    }
    public void setRoomCode(String roomCode)
    {
        this.roomCode = roomCode;
    }

    public String getRoomCode()
    {
        return roomCode;
    }
    public void setPrice(Long price)
    {
        this.price = price;
    }

    public Long getPrice()
    {
        return price;
    }
    public void setTotal(Long total)
    {
        this.total = total;
    }

    public Long getTotal()
    {
        return total;
    }
    public void setRoomNum(Long roomNum)
    {
        this.roomNum = roomNum;
    }

    public Long getRoomNum()
    {
        return roomNum;
    }
    public void setRoomType(Long roomType)
    {
        this.roomType = roomType;
    }

    public Long getRoomType()
    {
        return roomType;
    }
    public void setLiveTime(String liveTime)
    {
        this.liveTime = liveTime;
    }

    public String getLiveTime()
    {
        return liveTime;
    }
    public void setContinueTime(String continueTime)
    {
        this.continueTime = continueTime;
    }

    public String getContinueTime()
    {
        return continueTime;
    }
    public void setOutTime(String outTime)
    {
        this.outTime = outTime;
    }

    public String getOutTime()
    {
        return outTime;
    }
    public void setContinueName(String continueName)
    {
        this.continueName = continueName;
    }

    public String getContinueName()
    {
        return continueName;
    }
    public void setAddTime(String addTime)
    {
        this.addTime = addTime;
    }

    public String getAddTime()
    {
        return addTime;
    }
    public void setOperator(String operator)
    {
        this.operator = operator;
    }

    public String getOperator()
    {
        return operator;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("continueId", getContinueId())
                .append("orderId", getOrderId())
                .append("clientId", getClientId())
                .append("roomCode", getRoomCode())
                .append("price", getPrice())
                .append("total", getTotal())
                .append("roomNum", getRoomNum())
                .append("roomType", getRoomType())
                .append("liveTime", getLiveTime())
                .append("continueTime", getContinueTime())
                .append("outTime", getOutTime())
                .append("continueName", getContinueName())
                .append("addTime", getAddTime())
                .append("operator", getOperator())
                .toString();
    }
}