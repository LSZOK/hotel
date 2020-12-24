package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 退房信息对象 hotel_out
 * 
 * @author lusenzhu
 * @date 2020-10-22
 */
public class HotelOut
{
    private static final long serialVersionUID = 1L;

    /** 退房编号 */
    private String outId;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderId;

    /** 房间编号 */
    @Excel(name = "房间编号")
    private String roomCode;

    /** 房号 */
    @Excel(name = "房号")
    private Long roomNum;

    /** 客户编号 */
    @Excel(name = "客户编号")
    private String clientId;

    /** 价格 */
    @Excel(name = "价格")
    private Long price;

    /** 其他消费 */
    @Excel(name = "其他消费")
    private Long otherCost;

    /** 入住时间 */
    @Excel(name = "入住时间")
    private String liveTime;

    /** 预定人 */
    @Excel(name = "预定人")
    private String userName;

    /** 实际退房时间 */
    @Excel(name = "实际退房时间")
    private String actualOutTime;

    /** 房费 */
    @Excel(name = "房费")
    private Long roomCost;

    /** 总费用 */
    @Excel(name = "总费用")
    private Long totalCost;

    /** 添加时间 */
    @Excel(name = "添加时间")
    private String addTime;

    /** 经办人 */
    @Excel(name = "经办人")
    private String operator;

    public void setOutId(String outId) 
    {
        this.outId = outId;
    }

    public String getOutId() 
    {
        return outId;
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
    public void setClientId(String clientId) 
    {
        this.clientId = clientId;
    }

    public String getClientId() 
    {
        return clientId;
    }
    public void setPrice(Long price) 
    {
        this.price = price;
    }

    public Long getPrice() 
    {
        return price;
    }
    public void setOtherCost(Long otherCost) 
    {
        this.otherCost = otherCost;
    }

    public Long getOtherCost() 
    {
        return otherCost;
    }
    public void setLiveTime(String liveTime) 
    {
        this.liveTime = liveTime;
    }

    public String getLiveTime() 
    {
        return liveTime;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setActualOutTime(String actualOutTime) 
    {
        this.actualOutTime = actualOutTime;
    }

    public String getActualOutTime() 
    {
        return actualOutTime;
    }
    public void setRoomCost(Long roomCost) 
    {
        this.roomCost = roomCost;
    }

    public Long getRoomCost() 
    {
        return roomCost;
    }
    public void setTotalCost(Long totalCost) 
    {
        this.totalCost = totalCost;
    }

    public Long getTotalCost() 
    {
        return totalCost;
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
            .append("outId", getOutId())
            .append("orderId", getOrderId())
            .append("roomCode", getRoomCode())
            .append("roomNum", getRoomNum())
            .append("clientId", getClientId())
            .append("price", getPrice())
            .append("otherCost", getOtherCost())
            .append("liveTime", getLiveTime())
            .append("userName", getUserName())
            .append("actualOutTime", getActualOutTime())
            .append("roomCost", getRoomCost())
            .append("totalCost", getTotalCost())
            .append("addTime", getAddTime())
            .append("operator", getOperator())
            .toString();
    }
}
