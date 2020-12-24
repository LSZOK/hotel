package com.ruoyi.project.system.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 订单信息对象 hotel_order
 *
 * @author ruoyi
 * @date 2020-10-21
 */
public class HotelOrder {
    private static final long serialVersionUID = 1L;
     @JsonIgnore
    private String openId;
    private Client client;
    private RoomType roomTypeInfo;

    /**
     * 酒店预订编号
     */
    private String orderId;

    /**
     * 预订客户编号
     */
    @Excel(name = "预订人")
    private String clientId;

    /**
     * 房间编号
     */
    @Excel(name = "房间编号")
    private String roomCode;

    /**
     * 房号
     */
    @Excel(name = "房号")
    private Long roomNum;

    /**
     * 房间类型
     */
    @Excel(name = "房间类型")
    private Long roomType;

    /**
     * 订单状态,0 未入住，1已入住，2已续住，3以退房
     */
    @Excel(name = "订单状态,0 未入住，1已入住，2已续住，3以退房")
    private String status;

    /**
     * 价格
     */
    @Excel(name = "价格")
    private Long price;

    /**
     * 其他费用
     */
    @Excel(name = "其他费用")
    private Long otherCost;

    /**
     * 床型
     */
    @Excel(name = "床型")
    private String bedType;
    @JsonIgnore
    private String beginStatus;
    @JsonIgnore
    private  String EndStatus;



    /**
     * 入住时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "入住时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private String liveTime;

    /**
     * 退房时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "退房时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private String outTime;

    /**
     * 添加时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private String addTime;

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomNum(Long roomNum) {
        this.roomNum = roomNum;
    }

    public Long getRoomNum() {
        return roomNum;
    }

    public void setRoomType(Long roomType) {
        this.roomType = roomType;
    }

    public Long getRoomType() {
        return roomType;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getPrice() {
        return price;
    }

    public void setOtherCost(Long otherCost) {
        this.otherCost = otherCost;
    }

    public Long getOtherCost() {
        return otherCost;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public String getBedType() {
        return bedType;
    }

    public void setLiveTime(String liveTime) {
        this.liveTime = liveTime;
    }

    public String getLiveTime() {
        return liveTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getAddTime() {
        return addTime;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public RoomType getRoomTypeInfo() {
        return roomTypeInfo;
    }

    public void setRoomTypeInfo(RoomType roomTypeInfo) {
        this.roomTypeInfo = roomTypeInfo;
    }

    public String getBeginStatus() {
        return beginStatus;
    }

    public void setBeginStatus(String beginStatus) {
        this.beginStatus = beginStatus;
    }

    public String getEndStatus() {
        return EndStatus;
    }

    public void setEndStatus(String endStatus) {
        EndStatus = endStatus;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("orderId", getOrderId())
                .append("clientId", getClientId())
                .append("roomCode", getRoomCode())
                .append("roomNum", getRoomNum())
                .append("roomType", getRoomType())
                .append("status", getStatus())
                .append("price", getPrice())
                .append("otherCost", getOtherCost())
                .append("bedType", getBedType())
                .append("liveTime", getLiveTime())
                .append("outTime", getOutTime())
                .append("addTime", getAddTime())

                .toString();
    }
}
